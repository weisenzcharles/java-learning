package org.charles.springcloud.api.service;

import feign.hystrix.FallbackFactory;
import org.charles.springcloud.api.entity.Dept;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Integer id) {
                return new Dept()
                        .setId(id)
                        .setName("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭！")
                        .setRemark("没有数据！");
            }

            @Override
            public List<Dept> queryList() {
                return new LinkedList<Dept>();
            }
        };
    }
}
