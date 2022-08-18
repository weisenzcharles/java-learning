package org.charles.learning.pattern.creational.singleton;

import java.lang.reflect.Constructor;

// 单例枚举
public enum SingleEnum {
    INSTANCE;

    public SingleEnum getInstence() {
        return INSTANCE;
    }
}

class SingleTest {
    public static void main(String[] args) throws Exception {
        SingleEnum instance = SingleEnum.INSTANCE;
        Constructor<SingleEnum> declaredConstructor = SingleEnum.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        SingleEnum singleEnum = declaredConstructor.newInstance();

        System.out.println(instance.hashCode());
        System.out.println(singleEnum.hashCode());
    }
}