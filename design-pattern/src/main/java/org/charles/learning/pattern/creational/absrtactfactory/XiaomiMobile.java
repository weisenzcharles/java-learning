package org.charles.learning.pattern.creational.absrtactfactory;

public class XiaomiMobile implements Mobile{

    @Override
    public void call() {
        System.out.println("使用小米手机打电话！");
    }

    @Override
    public void send() {
        System.out.println("使用小米手机发短信！");
    }

    @Override
    public void shot() {
        System.out.println("使用小米手机拍照！");
    }

    @Override
    public void player() {
        System.out.println("使用小米手机玩游戏！");
    }
}
