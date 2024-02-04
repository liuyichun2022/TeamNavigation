package com.dash.navigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动程序
 *
 * @author Jason.liu
 * @date 2024/02/4
 */
@SpringBootApplication
@EnableCaching
public class TeamNavApplication {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(TeamNavApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  TeamNavigation启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
