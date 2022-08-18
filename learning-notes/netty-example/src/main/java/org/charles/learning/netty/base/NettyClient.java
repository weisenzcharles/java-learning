package org.charles.learning.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        // 创建工作组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 创建客户端 Bootstrap 对象
        Bootstrap bootstrap = new Bootstrap();
        try {
            // 配置参数
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    // 设置当设置为 true 的时候，TCP 会实现监控连接是否有效
                    .option(ChannelOption.SO_KEEPALIVE, true)

                    .handler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // 加入处理器
                            channel.pipeline().addLast(new NettyClientHandler());
                        }

                    });
            System.out.println("Netty Client Start...");
            // 启动客户端连接到服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999);
            // 对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
