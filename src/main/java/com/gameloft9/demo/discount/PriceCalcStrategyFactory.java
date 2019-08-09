package com.gameloft9.demo.discount;

import com.gameloft9.demo.core.StrategyFactory;
import com.gameloft9.demo.core.StrategyScan;
import com.gameloft9.demo.sign.SignType;
import org.apache.commons.lang3.StringUtils;

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
@StrategyScan(value = "com.gameloft9.demo.discount")
public class PriceCalcStrategyFactory extends StrategyFactory {

    @Override
    public Class<?> strategyAnnotationClass(){
        return PriceRange.class;// 注入一个策略分类注解
    }

    @Override
    public boolean getStrategyFromSpringContext(){
        return false; // 从spring context中获取策略实例bean
    }

    @Override
    public boolean accept(Annotation annotation, Object... params) {
        Double price = (Double) params[0];
        PriceRange priceRange = (PriceRange)annotation;

        double min = priceRange.min();
        double max = priceRange.max();

        if(min < price && max > price){
            return true;
        }

        return false;
    }
}

