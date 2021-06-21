package com.peng.cloudalibaba.service;

import com.peng.cloudalibaba.entity.Payment;
import com.peng.cloudalibaba.util.ServiceResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Descript 交费记录feign调用接口接口
 *
 * @author sdbzpxt
 * @date 2021/5/25
 */
@FeignClient(value = "nacos-payment-service" ,fallback = PaymentFeignFallBack.class)
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public ServiceResult<Payment> get(@PathVariable("id") Integer id);

    @GetMapping("/payment/getOK/{id}")
    public ServiceResult<Payment> getOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/getTimeOut/{id}/{timeout}")
    public ServiceResult<Payment> getTimeOut(@PathVariable("id") Integer id, @PathVariable("timeout") Long timeout);
}
