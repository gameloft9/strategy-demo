package com.gameloft9.demo.sign;

import com.gameloft9.demo.core.StrategyComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by gameloft9 on 2019/8/5.
 */
@Slf4j
@StrategyComponent
@SignType(type = SignTypeName.RSA)
@Component
public class RSASigner implements ISigner {
    public String doSign(String input) {
        log.info("进行RSA加密");
        return "";
    }
}
