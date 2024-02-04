package com.dash.navigation.common.config;

import com.dash.navigation.common.constants.TeamNavConstants;
import com.dash.navigation.common.util.StringExtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 * @author Jason.liu
 * @date 2024-02-04
 */
@Component
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceLocations 中的参数，必须以【/】结尾!!!
        registry.addResourceHandler("/ext-resources/**")
                .addResourceLocations(StringExtUtils.format("file:{}/ext-resources/",
                        TeamNavConstants.ROOT_DIR));

    }

}
