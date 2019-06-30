package com.bob.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-29 17:45
 * @Description:
 */
@Component
@ConfigurationProperties("girl")
@Data
@RefreshScope
public class GirlConfig {

    private String name;

    private Integer age;
}
