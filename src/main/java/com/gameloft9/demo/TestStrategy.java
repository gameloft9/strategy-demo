package com.gameloft9.demo;

import com.gameloft9.demo.core.ContextUtil;
import com.gameloft9.demo.sign.ISigner;
import com.gameloft9.demo.sign.SignerStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * 测试代码，通过spring容器获取策略实例
 * Created by gameloft9 on 2018/8/7.
 */
@Controller
@EnableAutoConfiguration
@Slf4j
@ComponentScan(basePackages="com.gameloft9.demo")
public class TestStrategy {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestStrategy.class, args);

        String input = "GAMELOFT9";
        String type = "RSA";

        ISigner signer = (ISigner) ContextUtil.getBean(SignerStrategyFactory.class).createStrategy(type);

        signer.doSign(input);
    }
}
