package org.charles.learning.pattern.creational.absrtactfactory;

public class HuaweiRouter implements Router {
    @Override
    public void boot() {
        System.out.println("启动华为路由器！");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器！");
    }

    @Override
    public void setting() {
        System.out.println("设置华为路由器！");
    }

    @Override
    public void openWiFi() {
        System.out.println("打开华为路由器 WiFi！");
    }
}
