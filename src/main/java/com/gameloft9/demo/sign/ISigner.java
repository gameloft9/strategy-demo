package com.gameloft9.demo.sign;

/**
 * 业务策略接口
 * Created by gameloft9 on 2019/8/5.
 */
public interface ISigner{
    /**
     * 计算签名
     * */
    String doSign(String input);
}
