package pl.mzuchnik.springpracadomowa8b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringPracaDomowa8bApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracaDomowa8bApplication.class, args);
    }

    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


}
