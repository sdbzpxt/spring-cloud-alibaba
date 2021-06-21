package com.peng.cloudalibaba.mapper;

import com.peng.cloudalibaba.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Descript 接口
 *
 * @author sdbzpxt
 * @date 2021/5/16
 */
@Mapper
public interface PaymentMapper {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
