package com.gameloft9.demo.discount;

import com.gameloft9.demo.core.StrategyComponent;

/**
 * 打八折策略
 * Created by gameloft9 on 2019/8/8.
 */
@StrategyComponent
@PriceRange(min = 500,max = 1000)
public class EightPriceCalc extends AbstractPriceCalc implements IPriceCalc {

    public EightPriceCalc(){
        this.discount = 0.8;
    }

}
