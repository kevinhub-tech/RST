package lithan.rst.project.carportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lithan.rst.project.carportal"})
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    	/* if (!registry.hasMappingForPattern("/mytest/**")) {
    		 System.out.println("/////////////////// Resources Handlers //////////////////");
    		 registry.addResourceHandler("/**").addResourceLocations("classpath:/mytest/");
    	 }*/
    	

        if (!registry.hasMappingForPattern("/static/**")) {
        	System.out.println("/////////////////// Resources Handlers 2 //////////////////");
        	registry.addResourceHandler(
                    "/images/**",
                    "/css/**",
                    "/js/**")
                    .addResourceLocations(
                            "classpath:/static/images/",
                            "classpath:/static/css/",
                            "classpath:/static/js/");
        	
        }

    
    }
    
}
