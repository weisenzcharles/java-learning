package org.charles.springboot.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson 配置类。
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        SingleServerConfig singleServerConfig = config.useSingleServer();
        // 可以用 `rediss://` 来启用 SSL 连接
        singleServerConfig.setAddress("redis://192.168.0.123:6379");
//        singleServerConfig.setPassword("123456");
        RedissonClient redisson = Redisson.create(config);

        return redisson;
    }



}