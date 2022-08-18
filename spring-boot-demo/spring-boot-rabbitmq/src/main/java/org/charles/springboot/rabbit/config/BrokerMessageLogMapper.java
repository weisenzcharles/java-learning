package org.charles.springboot.rabbit.config;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;



import org.charles.springboot.rabbit.entity.BrokerMessageLog;

public interface BrokerMessageLogMapper {
    /**
     * 查询消息状态为 0 (发送中) 且已经超时的消息集合
     *
     * @return
     */
    List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    /**
     * 重新发送统计 count 发送次数 +1
     *
     * @param messageId
     * @param updateTime
     */
    void updateToReSend(@Param("messageId") String messageId, @Param("updateTime") Date updateTime);

    /**
     * 更新最终消息发送结果 成功 or 失败
     *
     * @param messageId
     * @param status
     * @param updateTime
     */
    void changeBrokerMessageLogStatus(@Param("messageId") String messageId, @Param("status") String status, @Param("updateTime") Date updateTime);

}

