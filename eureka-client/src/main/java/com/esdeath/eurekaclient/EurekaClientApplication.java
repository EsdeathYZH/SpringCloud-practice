package com.esdeath.eurekaclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {

    @Autowired
    DiscoveryClient discoveryClient;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/service-info")
    public String dc(HttpServletRequest request) {
        String address = "";
        if (request.getHeader("x-forwarded-for") == null){
            address = request.getRemoteAddr();
        }else address = request.getHeader("x-forwarded-for");
        logger.info(address+"访问info接口！");
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
