package com.onemorethink.wewriteb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean // TODO: Spring Security를 통한 인증기능 수행시 수정 필요
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("fine");
    }
}
