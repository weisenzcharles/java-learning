package org.charles.learning.pattern.creational.singleton;

/**
 * 饿汉式单例。
 */
public class Hungry {
    private Hungry() {
        System.out.println(Thread.currentThread().getName() + "：instanced！");
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            Thread thread = new Thread(() -> Hungry.getInstance());
            thread.start();
        }
    }
}
