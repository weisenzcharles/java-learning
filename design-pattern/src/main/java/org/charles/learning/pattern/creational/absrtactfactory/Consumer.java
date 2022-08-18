package org.charles.learning.pattern.creational.absrtactfactory;

public class Consumer {
    public static void main(String[] args) {
        System.out.println("============小米产品============");

        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        Mobile xiaomiMobile = xiaomiFactory.produceMobile();
        xiaomiMobile.call();
        xiaomiMobile.send();
        xiaomiMobile.shot();
        xiaomiMobile.player();

        Router xiaomiRouter = xiaomiFactory.produceRouter();
        xiaomiRouter.boot();
        xiaomiRouter.openWiFi();
        xiaomiRouter.setting();
        xiaomiRouter.shutdown();


        System.out.println("============华为产品============");

        HuaweiFactory huaweiFactory = new HuaweiFactory();
        Mobile huaweiMobile = huaweiFactory.produceMobile();
        huaweiMobile.call();
        huaweiMobile.send();
        huaweiMobile.shot();
        huaweiMobile.player();

        Router huaweiRouter = huaweiFactory.produceRouter();
        huaweiRouter.boot();
        huaweiRouter.openWiFi();
        huaweiRouter.setting();
        huaweiRouter.shutdown();
    }
}
