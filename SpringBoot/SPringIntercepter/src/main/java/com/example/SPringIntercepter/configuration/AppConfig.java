package com.example.SPringIntercepter.configuration;

import com.example.SPringIntercepter.interceptors.AuthenticationInterceptor;
import com.example.SPringIntercepter.interceptors.LoggingInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan()
public class AppConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;

    private final AuthenticationInterceptor authenticationInterceptor;

    AppConfig(LoggingInterceptor loggingInterceptor,
              AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
        registry.addInterceptor(authenticationInterceptor);
    }
}
