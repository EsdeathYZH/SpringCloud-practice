package com.esdeath.serviceconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/consumer")
    @HystrixCommand(fallbackMethod = "error")
    public String info() {
        logger.info("消费者访问服务！");
        return restTemplate.getForObject("http://eureka-client/service-info", String.class);
    }

    public String error(){
        return "Sorry,Service has broken!";
    }
}
