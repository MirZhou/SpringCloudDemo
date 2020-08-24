package cn.eros.cloud.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>create time：2020-08-21 17:10
 *
 * @author Eros
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final EurekaInstanceConfig eurekaInstanceConfig;

    @Value("${server.port}")
    private int serverPort;

    public HelloController(EurekaInstanceConfig eurekaInstanceConfig) {
        this.eurekaInstanceConfig = eurekaInstanceConfig;
    }

    @GetMapping("/hello")
    public String hello() {
        this.logger.info("/hello, instanceId:{}, host:{}",
                this.eurekaInstanceConfig.getInstanceId(),
                this.eurekaInstanceConfig.getHostName(false));

        return "Hello, Spring Cloud! My port is " + serverPort;
    }
}
