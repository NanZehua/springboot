package com.zehua.asj;

import com.zehua.asj.utils.ProperUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    protected static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        logger.error("Start");
        ProperUtil.getInstance().SetConfInfo();
        SpringApplication.run(Application.class, args);
    }
}
