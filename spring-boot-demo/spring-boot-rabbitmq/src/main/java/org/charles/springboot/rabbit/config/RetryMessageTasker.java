package org.charles.springboot.rabbit.config;

import java.util.Date;
import java.util.List;

import org.charles.springboot.rabbit.FastJsonConvertUtil;
import org.charles.springboot.rabbit.constant.Constants;
import org.charles.springboot.rabbit.entity.BrokerMessageLog;
import org.charles.springboot.rabbit.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class RetryMessageTasker {


    @Autowired
    private RabbitSender rabbitOrderSender;

//    @Autowired
//    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void reSend(){
        System.out.println("重试中...");
        //pull status = 0 and timeout message
//        List<BrokerMessageLog> list = brokerMessageLogMapper.query4StatusAndTimeoutMessage();
//        list.forEach(messageLog -> {
//            if(messageLog.getTryCount() >= 3){
//                //update fail message
//                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLog.getMessageId(), Constants.ORDER_SEND_FAILURE, new Date());
//            } else {
//                // resend
//                brokerMessageLogMapper.updateToReSend(messageLog.getMessageId(),  new Date());
//                Order reSendOrder = FastJsonConvertUtil.convertJSONToObject(messageLog.getMessage(), Order.class);
//                try {
//                    rabbitOrderSender.sendOrder(reSendOrder);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.err.println("-----------异常处理-----------");
//                }
//            }
//        });
    }
}
