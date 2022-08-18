package org.charles.learning.pattern.creational.absrtactfactory;

public class XiaomiRouter implements Router{
    @Override
    public void boot() {
        System.out.println("启动小米路由器！");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器！");
    }

    @Override
    public void setting() {
        System.out.println("设置小米路由器！");
    }

    @Override
    public void openWiFi() {
        System.out.println("打开小米路由器 WiFi！");
    }
}
