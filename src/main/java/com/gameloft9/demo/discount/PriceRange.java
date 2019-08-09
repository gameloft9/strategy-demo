package com.gameloft9.demo.discount;

import java.lang.annotation.*;

/**
 * 价格范围
 * Created by gameloft9 on 2019/8/8.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceRange {

    double min() default  0;

    double max() default 1000000;
}
