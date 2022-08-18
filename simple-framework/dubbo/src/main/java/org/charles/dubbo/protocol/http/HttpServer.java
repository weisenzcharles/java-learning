package org.charles.dubbo.protocol.http;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.charles.dubbo.Url;

public class HttpServer {

    public void start(Url url) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(url.getPort());

        StandardEngine standardEngine = new StandardEngine();
        standardEngine.setDefaultHost(url.getHostname());

        StandardHost standardHost = new StandardHost();
        standardHost.setName(url.getHostname());

        String contextPath = "";
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(contextPath);
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());

        standardHost.addChild(standardContext);
        standardEngine.addChild(standardHost);

        service.setContainer(standardEngine);
        service.addConnector(connector);

        service.setServer(server);

        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet());
        standardContext.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
