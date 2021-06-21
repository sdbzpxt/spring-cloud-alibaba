package com.peng.cloudalibaba.service;

import com.peng.cloudalibaba.entity.Payment;
import com.peng.cloudalibaba.util.ServiceResult;
import org.springframework.stereotype.Component;

/**
 * Descript 交费服务降级处理类
 *
 * @author sdbzpxt
 * @date 2021/6/5
 */
@Component
public class PaymentFeignFallBack implements PaymentFeignService{
    @Override
    public ServiceResult<Payment> get(Integer id) {
        return new ServiceResult<Payment>(500,"get服务降级处理");
    }

    @Override
    public ServiceResult<Payment> getOK(Integer id) {
        return new ServiceResult<Payment>(500,"getOK服务降级处理");
    }

    @Override
    public ServiceResult<Payment> getTimeOut(Integer id, Long timeout) {
        return new ServiceResult<Payment>(500,"getTimeOut服务降级处理");
    }
}
