package com.gameloft9.demo.sign;

/**
 * 签名类型枚举
 * Created by gameloft9 on 2019/8/5.
 */
public enum SignTypeName {

    BASE64("BASE64"),
    MD5("MD5"),
    RSA("RSA");

    private String name;

    private SignTypeName(String name){
        this.name = name;
    }
}
