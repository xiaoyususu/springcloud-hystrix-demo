package com.springcloud.future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author boy
 * @Date 2020/1/11 6:44 PM
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {
        HelloServiceCommand command = new HelloServiceCommand("helloprovider",restTemplate);
        Future<String> queue = command.queue();
        return queue.get();
    }
}
