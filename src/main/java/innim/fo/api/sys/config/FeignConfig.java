package innim.fo.api.sys.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        // 모든 로그를 출력
        return Logger.Level.FULL;
    }
}