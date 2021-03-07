package com.sdicloud.security.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan(basePackages= {"com.validtest"})
public class AppConfig {

    private final RequestMappingHandlerMapping mapping;

    public AppConfig(RequestMappingHandlerMapping mapping) {
        this.mapping = mapping;
    }

    @Bean
    public CloseableHttpClient httpclient() { return HttpClients.createDefault(); }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
