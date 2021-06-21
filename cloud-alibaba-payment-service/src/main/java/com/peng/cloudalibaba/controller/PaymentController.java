package com.peng.cloudalibaba.controller;

import com.peng.cloudalibaba.entity.Payment;
import com.peng.cloudalibaba.service.PaymentService;
import com.peng.cloudalibaba.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Descript 交费信息控制层类
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/add")
    public ServiceResult add(@RequestBody Payment payment){
        log.info("PaymentController======>add,the port is "+port);
        log.info("PaymentController======>add,the param:"+payment);
        if(payment==null){
            return new ServiceResult(300,"参数为空!");
        }
        int result = paymentService.add(payment);
        if(result>0){
            return new ServiceResult(200,"操作成功",null,port);
        }
        return new ServiceResult(400,"操作失败",null,port);
    }

    @GetMapping("/payment/nacos/{id}")
    public String nacos(@PathVariable("id") Integer id){
        log.info("PaymentController======>nacos,the port is "+port);
        log.info("PaymentController======>nacos,the param id:"+id);
        if(id==null){
            return "nacos-payment-service,the port="+port+",参数为空!";
        }
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return "nacos-payment-service,the port="+port+",the result ="+payment;
        }
        return "nacos-payment-service,the port="+port+",信息不存在";
    }


    @GetMapping("/payment/get/{id}")
    public ServiceResult<Payment> get(@PathVariable("id") Integer id){
        log.info("PaymentController======>get,the port is "+port);
        log.info("PaymentController======>get,the param id:"+id);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new ServiceResult(200,"操作成功",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }

    @GetMapping("/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id){
        log.info("PaymentController======>getOK,the port is "+port);
        log.info("PaymentController======>getOK,the param id:"+id);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new ServiceResult(200,"操作成功",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }

    @GetMapping("/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id, @PathVariable("timeout")Long timeout){
        log.info("PaymentController======>getTimeOut,the port is "+port);
        log.info("PaymentController======>getTimeOut,the param id:"+id+",timeout="+timeout);
        if(id==null){
            return new ServiceResult(300,"参数为空!");
        }
        if(timeout!=null && timeout>0){
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("PaymentController======>getTimeOut,the param id:"+id+",timeout="+timeout);
        Payment payment = paymentService.getPaymentById(id);
        log.info("PaymentController======>getTimeOut,the param id:"+id+",timeout="+timeout+"result:"+ payment);
        if(payment!=null){
            return new ServiceResult(200,"操作成功",payment,port);
        }
        return new ServiceResult(400,"信息不存在",null,port);
    }

    public ServiceResult<Payment> getTimeOutHystrix(@PathVariable("id") Integer id, @RequestParam("timeout")Long timeout){
        log.info("PaymentController======>getTimeOutHystrix,the port is "+port);
        log.info("PaymentController======>getTimeOutHystrix,the param id:"+id+",timeout="+timeout);
        return new ServiceResult(500,"超时时间"+timeout+"秒,调用容错方法",null,port);
    }
}
