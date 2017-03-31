package com.softgroup.common.datamapper.configuration;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.softgroup.common.datamapper")
public class DataMapperAppCfg {
    @Bean
    public DataMapper dataMapper() {
        return new JacksonDataMapper();
    }

}
