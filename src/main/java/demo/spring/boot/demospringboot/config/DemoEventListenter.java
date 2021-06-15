package demo.spring.boot.demospringboot.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义的监听器
 */
@Slf4j
@Component
public class DemoEventListenter implements ApplicationListener<DemoEventListenter.DemoEvent> {
    /**
     * 自定义的事件
     */
    @Data
    public class DemoEvent extends ApplicationEvent {
        private String msg;
        private Object source;

        public DemoEvent(Object source, String msg) {
            super(source);
            this.source = source;
            this.msg = msg;
        }
    }

    @Override
    public void onApplicationEvent(DemoEvent event) {
        log.info("接收到事件:{}", event.toString());
    }
}


