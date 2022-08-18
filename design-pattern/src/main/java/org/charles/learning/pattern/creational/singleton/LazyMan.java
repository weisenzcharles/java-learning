package org.charles.learning.pattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 懒汉式单例。
 */
public class LazyMan {
    // 标识
    private static boolean flag = false;
    // volatile 防止指令重拍
    private volatile static LazyMan lazyMan;

    // 三重检测锁
    private LazyMan() {
        synchronized (LazyMan.class) {
            if (!flag) {
                flag = true;
            } else {
                throw new RuntimeException("lazyman instanced！");
            }
        }

        System.out.println(Thread.currentThread().getName() + "：instanced！");
    }

    // 双重检测锁
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10000; i++) {
//            Thread thread = new Thread(() -> LazyMan.getInstance());
//            thread.start();
//        }

        //        LazyMan lazyMan = LazyMan.getInstance();

        // 反射
        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();

        flag.set(instance1, false);
        LazyMan instance2 = declaredConstructor.newInstance();

//        System.out.println(lazyMan.hashCode());
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}
