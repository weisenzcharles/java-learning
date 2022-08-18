package org.charles.learning.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatServerHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static List<Channel> channels = new ArrayList<>();

    /*
     * 通道就绪。
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
        channelGroup.writeAndFlush("客户端 [" + channel.remoteAddress().toString().replace("/", "") + "] 上线了"
                + dateFormat.format(new Date()) + "\n");
        channelGroup.add(channel);
        System.out.println("客户端 [" + channel.remoteAddress().toString().replace("/", "") + "] 上线了");
    }

    /*
     * 通道不活跃。
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.remove(channel);
        System.out.println("客户端 [" + channel.remoteAddress().toString().substring(1) + "] 下线了");
    }

    /*
     * 读取消息。
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // Channel channel = ctx.channel();
        ByteBuf buf = (ByteBuf) msg;
        for (Channel channel : channelGroup) {
            if (ctx.channel() != channel) {
                System.out.println("客户端 [" + channel.remoteAddress().toString().substring(1) + "] 发送了消息："
                        + buf.toString(CharsetUtil.UTF_8));
            }
        }
        System.out.println("接收到客户端消息：" + buf.toString(CharsetUtil.UTF_8));
    }

    /*
     * 读取消息完成。
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("消息接收完成！");
    }

    /*
     * 发生异常。
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常：" + cause.getMessage());
        logger.error("发生异常：{}", cause.getMessage());
    }
}
