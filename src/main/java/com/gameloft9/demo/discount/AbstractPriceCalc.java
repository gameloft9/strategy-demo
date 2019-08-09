package com.gameloft9.demo.discount;

/**
 * 价格计算抽象类
 * Created by gameloft9 on 2019/8/8.
 */
public abstract class AbstractPriceCalc implements IPriceCalc{

    protected double discount;


    @Override
    public double calcPrice(double price) {
        return price * this.discount;
    }
}
