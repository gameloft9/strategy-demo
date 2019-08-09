package com.gameloft9.demo.paywallet;

import com.gameloft9.demo.core.StrategyFactory;
import com.gameloft9.demo.core.StrategyScan;

import java.lang.annotation.Annotation;

/**
 * 具体的业务策略工厂类
 * 1、添加@StrategyScan注解指定策略扫描包路径
 * 2、注入业务分类的策略注解class
 * 3、指定从何处获取策略类实例，spring容器或者反射实例化。默认反射实例化。
 * 3、实现具体策略的匹配逻辑
 * Created by gameloft9 on 2019/8/5.
 */
// 需要通过StrategyScan指定扫描策略包路径,包含子目录
@StrategyScan(value = "com.gameloft9.demo.paywallet")
public class WalletStrategyFactory extends StrategyFactory {

    @Override
    public Class<?> strategyAnnotationClass(){
        return Wallet.class;// 注入一个策略分类注解
    }

    @Override
    public boolean getStrategyFromSpringContext(){
        return false; // 从spring context中获取策略实例bean
    }

    @Override
    public boolean accept(Annotation annotation, Object... params) {
        String requestWalletName = params[0].toString();
        Double requestRate = (Double)params[1];

        Wallet wallet = (Wallet) annotation;

        String walletName = wallet.name();
        Double rate = Constant.walletRate.get(walletName); // 从别的地方去读策略类的配置，可以是配置文件，数据字典或者apollo等。

        if(walletName.equals(requestWalletName) && rate.equals(requestRate)){
            return true;
        }

        return false;
    }
}
