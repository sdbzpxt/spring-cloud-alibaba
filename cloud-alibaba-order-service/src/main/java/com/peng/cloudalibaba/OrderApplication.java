package com.peng.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Descript 订单服务启动类类
 *
 * @author sdbzpxt
 * @date 2021/6/20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@RibbonClients(value="nacos-payment-service",Configuration = MyIRule.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
