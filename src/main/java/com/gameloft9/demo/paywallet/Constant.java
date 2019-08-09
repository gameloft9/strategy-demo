package com.gameloft9.demo.paywallet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gameloft9 on 2019/8/9.
 */
public class Constant {

    public static Map<String, Double> walletRate ;

    static { // 初始化扣率，可以将不同的策略配置放入配置文件，apollo，数据字典等地方。
        walletRate = new HashMap<String, Double>();

        walletRate.put("alipay",0.8);
        walletRate.put("wxpay",0.9);
    }

}
