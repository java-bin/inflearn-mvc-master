package io.servlet.inflearnmvcmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class InflearnMvcMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(InflearnMvcMasterApplication.class, args);
    }

}
