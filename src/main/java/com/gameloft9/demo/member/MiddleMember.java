package com.gameloft9.demo.member;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gameloft9 on 2019/8/9.
 */
@Slf4j
public class MiddleMember implements IMember{
    @Override
    public void charge(double money) {
        log.info("高级会员充值享受1.5倍,充值{}",money * 1.5);
    }
}
