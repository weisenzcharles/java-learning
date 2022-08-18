package org.charles.mall.api.client;

import org.charles.mall.api.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("goods-service")
public interface GoodsClient {
    @GetMapping("/order/{id}")
    Goods findById(@PathVariable("id") Long id);
}
