package demo.spring.boot.demospringboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

/**
 * 用于读取配置文件中的数据
 * <p>
 * {@link SpringContext}
 */
public class PropertiesUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);

    private static Environment ENV = SpringContext.getBean("environment", Environment.class);

    private PropertiesUtils() {
        LOGGER.info("PropertiesUtils init");
    }

    public static String getProperty(String properties) {
        return ENV.getProperty(properties);
    }
}