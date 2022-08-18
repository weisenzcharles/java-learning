package org.charles.learning.pattern.creational.factory.methodfactory;

public class Consumer {
    public static void main(String[] args) {
        Auto byd = new BYDFactory().getAuto();
        System.out.println(byd.name());


        Auto nio = new NioFactory().getAuto();
        System.out.println(nio.name());
    }
}
