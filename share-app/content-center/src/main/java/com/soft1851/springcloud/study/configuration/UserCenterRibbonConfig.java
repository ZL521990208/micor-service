package com.soft1851.springcloud.study.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonconfig.RibbonConfiguration;

/**
 * @author ：zhengliang
 * @date ：2020/9/25 11:12
 * @description：TODO
 */
@Configuration
//@RibbonClient(name = "user-center",configuration = RibbonConfiguration.class)
public class UserCenterRibbonConfig {
}
