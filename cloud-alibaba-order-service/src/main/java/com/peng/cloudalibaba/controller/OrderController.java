package com.peng.cloudalibaba.controller;

import com.peng.cloudalibaba.entity.Payment;
import com.peng.cloudalibaba.service.PaymentFeignService;
import com.peng.cloudalibaba.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Descript 订单控制层类
 *
 * @author sdbzpxt
 * @date 2021/5/25
 */
@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Value("${nacos.payment.service-url}")
    private String paymentServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/order/payment/nacos/{id}")
    public String nacos(@PathVariable("id") Integer id){
        log.info("PaymentController======>nacos the port is "+port);
        String result = restTemplate.getForObject("http://"+paymentServiceUrl+"/payment/nacos/"+id,String.class);
        log.info("/order/payment/nacos/"+id+"--"+result);
        return result;
    }

    @GetMapping("/order/payment/get/{id}")
    public ServiceResult<Payment> get(@PathVariable("id") Integer id){
        log.info("PaymentController======>add the port is "+port);
        ServiceResult<Payment> result = paymentFeignService.get(id);
        log.info("/order/payment/get/"+id+"--"+result);
        return result;
    }

    @GetMapping("/order/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id){
        log.info("PaymentController======>getOK,the port is "+port);
        int a = 10/0;
        ServiceResult<Payment> result = paymentFeignService.getOK(id);
        log.info("/order/payment/getOK/"+id+"--"+result);
        return result;
    }

    @GetMapping("/order/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id, @PathVariable("timeout")Long timeout){
        log.info("PaymentController======>getTimeOut,the port is "+port+" timeout="+timeout);
        //int a = 10/0;
        ServiceResult<Payment> result = paymentFeignService.getTimeOut(id,timeout==null?0L:timeout);
        log.info("/order/payment/getTimeOut/"+id+"--"+result);
        return result;
    }
}
