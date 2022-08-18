package org.charles.springcloud.gateway.test;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class SpringCloudGatewayApplicationTest {
    public static void main(String[] args) {
        // 加密
        String salt = BCrypt.gensalt();
        System.out.println("生成的盐：" + salt);
        // 使用盐加密
        String hashpw = BCrypt.hashpw("123456", salt);
        System.out.println("加密结果：" + hashpw);

        // 验证
        boolean checkpw = BCrypt.checkpw("123456", "$2a$10$x5PSDqwY3OqCjm7fge/LGeHRuwlSubfxNDP3Mej6eUQieKQYmMR/S");
        System.out.println("校验结果：" + checkpw);
    }
}
