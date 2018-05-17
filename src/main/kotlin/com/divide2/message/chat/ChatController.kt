package com.divide2.message.chat

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

/**
 * Created by bvvy on 2018/3/26.
 * com.divide2.message.chat
 */
@Controller
class ChatController {


//    @MessageMapping("/greeting")
//    @SendTo("/topic/greetings")
    fun greeting(): Chat {
        Thread.sleep(1000)
        return Chat("fred", "hello")
    }



}