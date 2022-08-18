package org.charles.springboot.rocket;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

@ExtRocketMQTemplateConfiguration(nameServer = "${rocket.rocketmq.extNameServer}")
public class ExtRocketMQTemplate extends RocketMQTemplate {
}