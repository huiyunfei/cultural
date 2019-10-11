package com.yunfei.cultural;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

}
