package com.gameloft9.demo.paywallet;

import com.gameloft9.demo.core.StrategyComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gameloft9 on 2019/8/9.
 */
@Slf4j
@StrategyComponent
@Wallet(name = AliPay.ALIPAY)
public class AliPay implements IPay {

    public static final String ALIPAY = "alipay";

    @Override
    public void pay(double money) {
        double rate = Constant.walletRate.get(ALIPAY);
        log.info("通过支付宝{}扣率渠道，付款:{}元",rate,money);
    }
}
