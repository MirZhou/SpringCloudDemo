package cn.eros.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * <p>create time：2020-08-24 11:50
 *
 * @author Eros
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;

    public HelloController(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.restTemplate.getForEntity(
                "http://SERVICE-HELLO/hello",
                String.class
        )
                .getBody();
    }

    @GetMapping("/hello/ex")
    public String helloEx() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("SERVICE-HELLO");

        URI uri = URI.create(String.format("http://%s:%s/hello", serviceInstance.getHost(), serviceInstance.getPort()));

        this.logger.info("target service uri: {}", uri.toString());

        /* 若注入的restTemplate存在 {code @LoadBalanced}，则不可使用此方式进行负载均衡调用
         * {code return this.restTemplate.getForEntity(uri, String.class).getBody(); }
         */
        return new RestTemplate().getForEntity(uri, String.class).getBody();
    }
}
