package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

import java.net.http.HttpClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRouter(ReactiveDiscoveryClient rdc,
                                                        DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
//    @Bean
//    public HttpClient httpClient() {
//        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//    }
}
