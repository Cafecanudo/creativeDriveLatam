package com.creativedrive.cora.messageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableWebFlux
@EnableDiscoveryClient
@SpringBootApplication
public class MessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);
    }
}
