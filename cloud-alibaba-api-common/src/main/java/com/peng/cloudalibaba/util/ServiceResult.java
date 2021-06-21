package com.peng.cloudalibaba.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Descript 服务返回信息公共工具类类
 *
 * @author sdbzpxt
 * @date 2021/6/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private Integer port;

    public ServiceResult(Integer code, String msg){
        this(code,msg,null,null);
    }
}
