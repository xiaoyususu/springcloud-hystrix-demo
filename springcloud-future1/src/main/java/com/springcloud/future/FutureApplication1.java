package com.springcloud.future;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName FutureApplication1
 * @Description TODO
 * @Author boy
 * @Date 2020/1/11 9:46 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker//允许断路器
public class FutureApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(FutureApplication1.class, args);
    }

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
