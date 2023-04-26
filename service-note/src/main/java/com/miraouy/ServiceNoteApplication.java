package com.miraouy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication

public class ServiceNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceNoteApplication.class, args);
    }

}
