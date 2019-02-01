package jae.phones.JAEphones.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SEC = 3600;

    public void addCorsMappings(CorsRegistry registery) {
        registery.addMapping("/**").allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "PUT", "POST", "PATH", "DELETE").maxAge(this.MAX_AGE_SEC);
    }
}