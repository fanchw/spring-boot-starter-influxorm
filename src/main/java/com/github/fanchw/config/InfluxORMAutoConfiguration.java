package com.github.fanchw.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 导入我们自定义的配置类,供当前类使用
@EnableConfigurationProperties(InfluxConfigProperties.class)
// 当存在某个类时，此自动配置类才会生效,这里可以使用外部的String类名
@ConditionalOnClass(InfluxDB.class)
// 只有web应用程序时此自动配置类才会生效
@ConditionalOnWebApplication
public class InfluxORMAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "influx.orm", name = "enable", havingValue = "true")
    public InfluxDB defaultStudent(InfluxConfigProperties influxConfigProperties) {
        return InfluxDBFactory.connect(influxConfigProperties.getUrl(),
                influxConfigProperties.getUserName(), influxConfigProperties.getPassword());
    }
}
