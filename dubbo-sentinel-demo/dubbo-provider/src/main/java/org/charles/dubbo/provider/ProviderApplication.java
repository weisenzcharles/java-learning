package org.charles.dubbo.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

@EnableDubbo
@DubboComponentScan(basePackages = "org.charles.dubbo")
@SpringBootApplication
public class ProviderApplication {

    private final static Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        initFlowRules();
        SpringApplication.run(ProviderApplication.class, args);
        logger.info("服务启动成功！");
    }

    // 初始化规则
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>(); // 限流规则的集合
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("org.charles.dubbo.api.service.UserService:getUserById(java.lang.Long)");// 资源(方法名称、接口）
        flowRule.setCount(10);// 限流阈值 qps=10
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);// 限流阈值类型（QPS 或并发线程数）
        // 流量控制手段（直接拒绝、Warm Up、匀速排队）
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        flowRule.setLimitApp("dubbo-consumer");// 流控针对的调用来源，若为 default 则不区分调用来源
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }
}
