package sms.config;

import org.lightadmin.api.config.LightAdmin;
import org.lightadmin.core.config.LightAdminWebApplicationInitializer;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by user on 29.03.16.
 */
@Configuration
public class AdministrationConfig extends SpringBootServletInitializer {

    /* Used for running in "embedded" mode */
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            LightAdmin.configure(servletContext)
                    .basePackage("sms.administration")
                    .baseUrl("/admin")
                    .security(false)
                    .backToSiteUrl("/")
                    .helpUrl("/");

            new LightAdminWebApplicationInitializer().onStartup(servletContext);
        };
    }

}
