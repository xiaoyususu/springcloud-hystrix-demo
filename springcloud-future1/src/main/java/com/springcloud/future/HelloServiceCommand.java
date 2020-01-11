package com.springcloud.future;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloServiceCommand
 * @Description TODO
 * @Author boy
 * @Date 2020/1/11 6:45 PM
 */
public class HelloServiceCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    protected HelloServiceCommand(String commandGroupKey, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://HELLO-SERVICE/helloprovider",String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
