package com.gameloft9.demo.sign;

import com.gameloft9.demo.core.StrategyComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by gameloft9 on 2019/8/5.
 */
@Slf4j
@StrategyComponent // 通过该注解标记该类是策略类
@SignType(type = SignTypeName.BASE64)
@Component
public class BASE64Signer implements ISigner {

    public String doSign(String input) {
        log.info("进行BASE64加密");
        return "";
    }
}
