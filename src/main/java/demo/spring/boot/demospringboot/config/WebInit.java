package demo.spring.boot.demospringboot.config;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.default", "dev");
    }
}
