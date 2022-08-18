package org.charles.dubbo;

import java.io.Serializable;

public class Url implements Serializable {
    private String hostname;
    private Integer port;

    public Url() {
    }

    public Url(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
