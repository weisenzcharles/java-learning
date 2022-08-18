package org.charles.learning.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import java.util.Scanner;

public class ChatClient {

    private static String serverHost = "127.0.0.1";

    private static int serverPort = 8888;

    public static void main(String[] args) {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(workerGroup);

        bootstrap.channel(NioSocketChannel.class);

        bootstrap.remoteAddress(serverHost, serverPort);

        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);

        bootstrap.option(ChannelOption.TCP_NODELAY, true);

        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                // 加入解码器
                pipeline.addLast("decoder", new StringDecoder());
                // 加入编码器
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast(new ChatClientHandler());
            }
        });
        try {

            // 启动客户端连接服务器，并异步等待成功
            ChannelFuture channelFuture = bootstrap.connect().sync();

            channelFuture.addListener(new ChannelFutureListener() {

                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    // 连接失败
                    if (!future.isSuccess()) {
                        System.out.printf("连接服务器 [" + serverHost + ":" + serverPort + "] 失败！");
                        return;
                    }
                    // 连接成功
                    System.out.printf("连接服务器 [" + serverHost + ":" + serverPort + "] 成功！");
                    Channel channel = future.channel();
                    Scanner scanner = new Scanner(System.in);
                    while (scanner.hasNextLine()) {
                        String msg = scanner.nextLine();
                        channel.writeAndFlush(msg.getBytes(CharsetUtil.UTF_8));
                    }

                }

            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }
}
