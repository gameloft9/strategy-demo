package com.gameloft9.demo;

import com.gameloft9.demo.sign.ISigner;
import com.gameloft9.demo.sign.SignerStrategyFactory;

/**
 * 测试代码,getStrategyFromSpringContext必须return false才能测
 * Created by gameloft9 on 2019/8/5.
 */
public class TestSiger {

    public static void main(String[] args) {

        String input = "GAMELOFT9";
        String type = "RSA";

        ISigner signer = (ISigner) new SignerStrategyFactory().createStrategy(type);

        signer.doSign(input);
    }
}
