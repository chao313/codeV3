package demo.spring.boot.demospringboot.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
/**
 * 通过@EnableWebSocketMessageBroker来开启STOMP协议
 * --> 开启之后，就支持@MessageMapping 就像@RequestMapping
 *
 */
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册Stomp协议的节点(Endpoint),并映射指定的URL
     * Endpoint是用户订阅主题时，指定接收消息的终端地址
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry
                .addEndpoint("/endPoint") //注册一个endPoint
                .withSockJS();//指定使用SocketJs协议

    }

    /**
     * Configure message broker options
     * 配置消息broker的广播参数
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {

        /**
         * Enable a simple message broker and configure one or more prefixes to filter
         * destinations targeting the broker (e.g. destinations prefixed with "/topic").
         * 启用简单消息broker，并且配置一个或者多个前置去过滤到目标的broker
         */
        messageBrokerRegistry.enableSimpleBroker("/simpleBroker", "/topic", "");
    }


    @Controller
    public class WebSocketController {


        /**
         * 这里改成同样的，方便理解，订阅-发布
         *
         * @param requestMessage
         * @return
         */
        @MessageMapping("/topic")
        @SendTo("/topic")
        public ResponseMessage getTopicResponseMessage(RequestMessage requestMessage) {
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMsg("请求是/topic，响应是/topic");
            return responseMessage;
        }

        /**
         * MessageMapping是 由浏览器向服务端发送消息 url
         */
        @MessageMapping("/topic/MessageMapping")
        /**
         * SendTo 由服务器向浏览器发送消息的 url
         * 当服务器有响应的时候，就会通过这个url发送给浏览器
         */
        @SendTo("/topic/sendTo")
        public ResponseMessage getResponseMessage(RequestMessage requestMessage) {
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMsg("请求是/topic/MessageMapping，响应是/topic/sendTo");
            return responseMessage;
        }

        @MessageMapping("/simpleBroker/MessageMapping")
        @SendTo("/simpleBroker/sendTo")
        public ResponseMessage getSimpleBrokerResponseMessage(RequestMessage requestMessage) {
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMsg("请求是/simpleBroker/MessageMapping，响应是/simpleBroker/sendTo");
            return responseMessage;
        }


    }

}

/**
 * 请求消息体
 */
@Data
class RequestMessage {
    private String msg;
}

/**
 * 响应消息体
 */
@Data
class ResponseMessage {
    private String msg;
}