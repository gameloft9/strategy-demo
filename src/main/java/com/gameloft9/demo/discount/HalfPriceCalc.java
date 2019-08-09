package com.gameloft9.demo.discount;

import com.gameloft9.demo.core.StrategyComponent;

/**
 * 半价策略
 * Created by gameloft9 on 2019/8/8.
 */
@StrategyComponent
@PriceRange(min = 1000)
public class HalfPriceCalc  extends AbstractPriceCalc implements IPriceCalc {

    public HalfPriceCalc(){
        this.discount = 0.5;
    }

}
