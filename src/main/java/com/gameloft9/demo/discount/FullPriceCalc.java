package com.gameloft9.demo.discount;

import com.gameloft9.demo.core.StrategyComponent;

/**
 * 不打折策略
 * Created by gameloft9 on 2019/8/8.
 */
@StrategyComponent
@PriceRange(max = 100)
public class FullPriceCalc  extends AbstractPriceCalc implements IPriceCalc {

    public FullPriceCalc(){
        this.discount = 1;
    }

}
