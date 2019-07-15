package cn.pluto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("cn.pluto.admin.mapper")
public class PlutoBlogApplication{

    public static void main(String[] args) {
        SpringApplication.run(PlutoBlogApplication.class, args);
    }
}
