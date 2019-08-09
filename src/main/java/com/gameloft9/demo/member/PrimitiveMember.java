package com.gameloft9.demo.member;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by gameloft9 on 2019/8/9.
 */
@Slf4j
public class PrimitiveMember implements IMember {
    @Override
    public void charge(double money) {
        log.info("初级会员充值不享受优惠,充值{}",money);
    }
}
