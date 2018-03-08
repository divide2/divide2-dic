package com.divide2.config

import com.divide2.dic.DicHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route

/**
 * Created by bvvy on 2018/3/7.
 * com.divide2
 */
@Configuration
class RouteConfig {

    @Bean
    fun monoRouterFunction(dicHandler: DicHandler): RouterFunction<*> =
            route(GET("/v1/dic/{id}").and(accept(APPLICATION_JSON)), HandlerFunction { dicHandler.get(it) })
                    .and(route(GET("/v1/dic/all").and(accept(APPLICATION_JSON)), HandlerFunction { dicHandler.all(it) }))
                    .and(route(GET("/v1/dic/all").and(accept(APPLICATION_JSON)), HandlerFunction { dicHandler.all(it) }))
                    .and(route(GET("/v1/dic/all").and(accept(APPLICATION_JSON)), HandlerFunction { dicHandler.all(it) }))

}