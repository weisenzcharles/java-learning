package org.charles.dubbo.register;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {
    private static Map<String, Class> map = new HashMap<>();

    public static void register(String interfaceName, Class clazz) {

        map.put(interfaceName, clazz);

    }

    public static Class getClass(String interfaceName) {
        return map.get(interfaceName);
    }
}
