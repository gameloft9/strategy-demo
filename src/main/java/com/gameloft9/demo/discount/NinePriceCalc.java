package com.gameloft9.demo.discount;

import com.gameloft9.demo.core.StrategyComponent;

/**
 * 打九折策略
 * Created by gameloft9 on 2019/8/8.
 */
@StrategyComponent
@PriceRange(min = 100,max = 500)
public class NinePriceCalc extends AbstractPriceCalc implements IPriceCalc {

    public NinePriceCalc(){
        this.discount = 0.9;
    }
}
