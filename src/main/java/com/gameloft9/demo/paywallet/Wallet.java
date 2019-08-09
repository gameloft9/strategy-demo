package com.gameloft9.demo.paywallet;

import java.lang.annotation.*;

/**
 * 1、策略分类注解，根据它区分不同的策略实现类，他是实现if-else消除的关键
 * 2、如果策略不稳定，数目较多，可能变化。那么建议将策略的定义放入数据字典，
 *    然后注解提供一个key值，在工厂类的accept方法里读取数据字典，再执行选择逻辑。
 * Created by gameloft9 on 2019/8/5.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Wallet {

    String name(); // 钱包名称

    double rate() default 1; // 扣率
}
