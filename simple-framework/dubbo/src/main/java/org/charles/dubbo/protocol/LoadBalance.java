package org.charles.dubbo.protocol;

import org.charles.dubbo.Url;

import java.util.List;
import java.util.Random;

public class LoadBalance {
    public static Url random(List<Url> urls) {
        if (urls.size() > 0) {
            return urls.get(new Random().nextInt(urls.size()));
        } else {
            return urls.get(0);
        }
    }
}
