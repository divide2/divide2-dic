package com.divide2.message.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer

/**
 * Created by bvvy on 2018/3/28.
 * com.divide2.auth.config
 */
@Configuration
class WebSocketSecurityConfig : AbstractSecurityWebSocketMessageBrokerConfigurer(){

    override fun configureInbound(messages: MessageSecurityMetadataSourceRegistry) {

        messages.simpSubscribeDestMatchers("/topic/**").permitAll()
                .simpDestMatchers("/app/**").permitAll()

    }

}