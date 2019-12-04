package com.hanshan.h2sj.blog.domain.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://192.168.195.133:3306/h2sj?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dataSourceBuilder.username("hanshan");
        dataSourceBuilder.password("123456");
        dataSourceBuilder.type(DruidDataSource.class);
        return dataSourceBuilder.build();
    }


}
