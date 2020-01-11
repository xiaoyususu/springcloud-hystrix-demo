package com.springcloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

/**
 * @ClassName ConsummerController
 * @Description TODO
 * @Author boy
 * @Date 2020/1/11 5:21 PM
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {

        HelloServiceCommand command = new HelloServiceCommand("helloprovider",restTemplate);
        String result = command.execute();
        return result;
    }
}
