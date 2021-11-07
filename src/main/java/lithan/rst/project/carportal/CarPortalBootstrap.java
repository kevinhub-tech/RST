package lithan.rst.project.carportal;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lithan.rst.project.carportal.config.JPAConfig;
import lithan.rst.project.carportal.config.SecurityConfig;
import lithan.rst.project.carportal.config.WebMvcConfig;

//web.xml
public class CarPortalBootstrap extends AbstractAnnotationConfigDispatcherServletInitializer {
	
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JPAConfig.class, SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
