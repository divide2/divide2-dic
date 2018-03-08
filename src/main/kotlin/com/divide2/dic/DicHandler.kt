package com.divide2.dic

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.controller
 */

@Component
class DicHandler(private val dicRepository: DicRepository) {

    fun all(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(dicRepository.findAll()), Dic::class.java)


    fun get(serverRequest: ServerRequest): Mono<ServerResponse> = ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(dicRepository.findAll()), Dic::class.java)


    fun delete(@PathVariable id: Int?): Mono<Dic> = Mono.empty()

    fun add(@RequestBody dic: Dic) {
        dicRepository.save(dic)
    }

    fun update(@RequestBody dic: Dic) {
        dicRepository.save(dic)
    }

    fun page(params: Map<String, String>) {
        //        return Responser.ok(dicRepository.page.of(1, 3)));
    }
}
