package com.barracuda.barracudabill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication(scanBasePackages = {"com.barracuda"}, exclude = {DataSourceAutoConfiguration.class})
public class BarracudaBillApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BarracudaBillApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        Integer serverPort = environment.getProperty("server.port", Integer.class);
        String contextPath = environment.getProperty("server.servlet.context-path", String.class);
        System.out.println("barracuda bill application started");
        System.out.printf("http://localhost:%d%s", serverPort, contextPath);

    }

}
