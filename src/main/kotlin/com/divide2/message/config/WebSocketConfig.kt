package com.divide2.message.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor


/**
 * Created by bvvy on 2018/3/26.
 * com.divide2.sms.config
 */

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(myHandler(), "/myHandler")
                .setAllowedOrigins("http://localhost:3000")
    }

    @Bean
    fun myHandler(): WebSocketHandler {
        return MyHandler()
    }
}

class MyHandler : TextWebSocketHandler() {
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(session)
        println(message)
    }

}