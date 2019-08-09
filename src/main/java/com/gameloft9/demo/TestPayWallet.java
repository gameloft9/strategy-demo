package com.gameloft9.demo;

import com.gameloft9.demo.paywallet.IPay;
import com.gameloft9.demo.paywallet.WalletStrategyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试钱包付款
 * Created by gameloft9 on 2019/8/9.
 */
@Slf4j
public class TestPayWallet {
    public static void main(String[] args) {
        Double money = 100.0;
        String name = "alipay";
        Double rate = 0.8;

        IPay pay = (IPay) new WalletStrategyFactory().createStrategy(name,rate);

        pay.pay(money);
    }
}
