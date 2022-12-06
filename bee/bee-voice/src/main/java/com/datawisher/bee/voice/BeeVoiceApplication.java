package com.datawisher.bee.voice;

import com.datawisher.bee.voice.ui.home.HomeController;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class BeeVoiceApplication {


    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BeeVoiceApplication.class);
        ConfigurableApplicationContext context = builder.headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

        EventQueue.invokeLater(() -> {
            HomeController homeController = context.getBean(HomeController.class);
            homeController.prepareAndOpenFrame();
        });
    }
}
