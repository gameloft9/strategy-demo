package com.gameloft9.demo;

import com.gameloft9.demo.discount.IPriceCalc;
import com.gameloft9.demo.discount.PriceCalcStrategyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 打折测试例子
 * Created by gameloft9 on 2019/8/8.
 */
@Slf4j
public class TestDiscount {

    public static void main(String[] args) {
        double price = 200;

        IPriceCalc priceCalc = (IPriceCalc) new PriceCalcStrategyFactory().createStrategy(price);
        double res = priceCalc.calcPrice(price);

        log.info("打完折后价格是:{}",res);
    }
}
