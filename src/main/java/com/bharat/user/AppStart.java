package com.bharat.user;

import com.bharat.user.repo.UserCustomRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by BharatBh on 2/1/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@PropertySource({"classpath:application.properties" })
public class AppStart {
    public static void main(String[] args){
        SpringApplication.run(AppStart.class, args);
    }

    @Bean
    public UserCustomRepositoryImpl getUserCustomRepository(){
        return new UserCustomRepositoryImpl();
    }
}
