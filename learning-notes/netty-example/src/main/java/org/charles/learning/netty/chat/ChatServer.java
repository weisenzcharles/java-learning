package org.charles.learning.netty.chat;

import java.net.InetSocketAddress;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 设置 EventLoopGroup 对象
        serverBootstrap.group(bossGroup, workerGroup);
        // 设置端口
        serverBootstrap.localAddress(inetSocketAddress);
        // 指定 Channel 为服务端 NioServerSocketChannel
        serverBootstrap.channel(NioServerSocketChannel.class);
        // 指定阻塞队列
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        // TCP Keepalive 机制，实现 TCP 级别的心跳
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        // 允许发送较小的数据包，降低延迟
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);
        // 设置处理器
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                // 加入解码器
                pipeline.addLast("decoder", new StringDecoder());
                // 加入编码器
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast(new ChatServerHandler());
            }
        });

        serverBootstrap.childHandler(new ChatServerHandler());

        // 启动并监听端口
        ChannelFuture channelFuture = serverBootstrap.bind().sync();
        if (channelFuture.isSuccess()) {

            System.out.println("聊天服务器启动成功！");
        } else {
            System.out.println("聊天服务器启动失败！");
            if (channelFuture != null) {
                channelFuture.channel().close();
            }
            bossGroup.shutdownGracefully();

            workerGroup.shutdownGracefully();

        }
    }
}
