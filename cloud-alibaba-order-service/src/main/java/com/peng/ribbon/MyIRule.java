package com.peng.ribbon;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 手动调整ribbon的策略，有两种方式：[1]通过配置类，如本类 [2]通过在配置文件中配置
 * 方式一：  （1）新加配置类MyIRule，注意添加注解@Configuration ，在配置类中新建 iRule
 *           (2) 在启动类中添加注解@RibbonClient 或者 @RibbonClients
 * 方式二： 在yml文件中配置
 *         service名称:
 *              ribbon:
 *              NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
 *
 * 注意在使用方式一时，官方文档明确给出了警告：
 * 这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
 * @author pengxt
 * @version 1.0
 * @date 2021/9/15 11:56
 */
@Configuration
public class MyIRule {

    @Bean
    public IRule iRule(){ //注意名称必须为iRule
        return new NacosRule();//alinacos 权重策略,因为此处使用spingcloud alibaba版，重点测试NacosRule
        //return new RandomRule();//随机策略
    }
}
