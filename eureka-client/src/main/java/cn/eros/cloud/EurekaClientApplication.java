package cn.eros.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>create time：2020-08-21 17:09
 * <p>
 * {@code EnableDiscoveryClient 表示这是一个Eureka客户端，同时也可以获取到Eureka服务器中所注册的服务列表}
 *
 * @author Eros
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
