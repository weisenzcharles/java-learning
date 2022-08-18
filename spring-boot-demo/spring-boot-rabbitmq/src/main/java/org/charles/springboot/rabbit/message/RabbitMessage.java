package org.charles.springboot.rabbit.message;

import java.io.Serializable;

public class RabbitMessage implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_";

    public static final String EXCHANGE = "EXCHANGE_DEMO_";

    public static final String ROUTING_KEY = "ROUTING_KEY_";

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 编号
     */
    private Integer id;

    public RabbitMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public RabbitMessage() {
    }

    public RabbitMessage(Integer id,String message) {
        this.message = message;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RabbitMessage : { " +
                "message = '" + message + '\'' +
                ", id = " + id +
                " }";
    }
}