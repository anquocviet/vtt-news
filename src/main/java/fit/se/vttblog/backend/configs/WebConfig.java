package fit.se.vttblog.backend.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Override
   public void configurePathMatch(PathMatchConfigurer configurer) {
      configurer.setPatternParser(new PathPatternParser());
      configurer.addPathPrefix("/api/v1", c -> c.isAnnotationPresent(RestController.class));
   }

   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("forward:posts/");
   }
}
