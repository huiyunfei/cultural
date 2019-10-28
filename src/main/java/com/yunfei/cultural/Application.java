package com.yunfei.cultural;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by huiyunfei on 2019/10/11.
 */


@MapperScan("com.yunfei.cultural.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(com.yunfei.cultural.Application.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(true);
        // 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080
        // ,以降低安全风险。。
        config.addAllowedOrigin("*");
        // 允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(18000L);
        // 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
        config.addAllowedMethod("*");

        /*
         * config.addAllowedMethod("HEAD"); config.addAllowedMethod("GET");//
         * 允许Get的请求方法 config.addAllowedMethod("PUT");
         * config.addAllowedMethod("POST"); config.addAllowedMethod("DELETE");
         * config.addAllowedMethod("PATCH");
         */
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
