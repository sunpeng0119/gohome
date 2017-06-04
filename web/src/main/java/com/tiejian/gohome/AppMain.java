package com.tiejian.gohome;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by sunpeng on 2017/6/4.
 */
@EnableAutoConfiguration
@SpringBootApplication()
@ImportResource(locations = { "classpath:/app.xml" })
public class AppMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppMain.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppMain.class, args);
    }
}
