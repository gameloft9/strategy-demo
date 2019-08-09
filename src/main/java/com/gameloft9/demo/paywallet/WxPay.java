package com.gameloft9.demo.paywallet;

import com.gameloft9.demo.core.StrategyComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by gameloft9 on 2019/8/9.
 */
@Slf4j
@StrategyComponent
@Wallet(name =WxPay.WXPAY)
public class WxPay implements IPay{

    public static final String WXPAY = "wxpay";

    @Override
    public void pay(double money) {
        double rate = Constant.walletRate.get(WXPAY);

        log.info("通过微信{}扣率渠道，支付:{}元",rate,money);
    }
}
