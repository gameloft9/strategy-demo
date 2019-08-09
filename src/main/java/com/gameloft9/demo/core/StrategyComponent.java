package com.gameloft9.demo.core;

import java.lang.annotation.*;

/**
 * 策略类标记注解
 * Created by gameloft9 on 2019/8/6.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyComponent {
}
