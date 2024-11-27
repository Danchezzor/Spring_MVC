package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
    public class WebConfig {

        @Bean
        public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
            final  var bean = new RequestMappingHandlerAdapter();
            bean.getMessageConverters().add(new GsonHttpMessageConverter());
            return bean;

        }
}
