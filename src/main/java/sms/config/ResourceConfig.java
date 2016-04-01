package sms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by user on 09.03.16.
 */
@Configuration
@EnableWebMvc
public class ResourceConfig extends WebMvcConfigurerAdapter {

    @Value("${resourceRequest}")
    private String RESOURCE_REQUEST;
    @Value("${resourceLocation}")
    private String RESOURCE_LOCATION;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCE_REQUEST).addResourceLocations(RESOURCE_LOCATION);
    }

}