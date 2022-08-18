package org.charles.dubbo.protocol.http;


import org.apache.commons.io.IOUtils;
import org.charles.dubbo.Invocation;
import org.charles.dubbo.register.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            try {
                Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
                Class clazz = LocalRegister.getClass(invocation.getInterfaceName());

                Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamType());
                String invoke = (String) method.invoke(clazz.newInstance(), invocation.getParams());

                IOUtils.write(invoke, resp.getOutputStream());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
