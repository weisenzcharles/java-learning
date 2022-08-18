package org.charles.dubbo.register;

import org.charles.dubbo.Url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteRegister {


    private static Map<String, List<Url>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, Url url) {
        Map register = getRegister();
        Object s = register.get("service");
        HashMap<String, String> u = (HashMap<String, String>) register.get("url");
        Url url1 = new Url(u.get("hostname"), Integer.valueOf(u.get("port")));

        List<Url> list = REGISTER.get(interfaceName);

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);

        REGISTER.put(interfaceName, list);
    }

    private static void setRegister() {
        Object serversHost = YamlReader.instance.getValueByKey("services");
        System.out.println(serversHost);
    }


    private static Map getRegister() {
        Map serversHost = (Map) YamlReader.instance.getValueByKey("services");
        System.out.println(serversHost);
        return serversHost;
    }

}
