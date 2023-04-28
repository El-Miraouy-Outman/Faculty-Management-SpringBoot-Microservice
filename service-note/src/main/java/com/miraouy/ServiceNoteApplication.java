package com.miraouy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNoteApplication.class, args);
    }

}
