package org.charles.dubbo.protocol;

import org.charles.dubbo.Invocation;
import org.charles.dubbo.protocol.http.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass) {
        Object instance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                String result = httpClient.send("localhost", 8099, invocation);
                return result;
            }
        });
        return (T) instance;
    }
}
