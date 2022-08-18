package org.charles.mall.api.client;

import org.charles.mall.api.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/order/{id}")
    Order findById(@PathVariable("id") Long id);
}
