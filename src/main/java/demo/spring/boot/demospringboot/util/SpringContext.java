package demo.spring.boot.demospringboot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    public SpringContext() {
        log.info("init SpringContext");
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        context = ctx;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        log.info("use SpringContext get bean name={}", name);
        return context.getBean(name, clazz);
    }

}