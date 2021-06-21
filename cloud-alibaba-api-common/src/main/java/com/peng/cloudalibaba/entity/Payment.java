package com.peng.cloudalibaba.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Descript 交费信息实体类类
 *
 * @author sdbzpxt
 * @date 2021/6/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    //主键
    private Integer id;
    //订单号
    private Integer order_id;
    //交费金额
    private BigDecimal pay_money;
    //交费日期
    private Date pay_time;
}
