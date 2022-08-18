package org.charles.springcloud.api.service;

import feign.hystrix.FallbackFactory;
import org.charles.springcloud.api.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public boolean delete(Integer id) {
                return false;
            }

            @Override
            public boolean update(User user) {
                return false;
            }

            @Override
            public User queryById(Integer id) {
                return new User()
                        .setId(id)
                        .setName("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭！")
                        .setAge(0)
                        .setSex(false);
            }

            @Override
            public List<User> queryList() {
                return null;
            }
        };
    }
}
