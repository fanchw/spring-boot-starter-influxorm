package com.github.fanchw.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "influx.orm")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InfluxConfigProperties {
    private String url;

    private String database;

    private String userName;

    private String password;

    private String retentionPolicy;
}
