package com.divide2.sys.dic

import com.divide2.er.COMMA
import com.divide2.er.Messager
import com.divide2.er.Responser
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.module.dic.controller
 */

@RestController
@RequestMapping("/v1/dic")
class DicController(val dicRepository: DicRepository) {

    @GetMapping("/all")
    fun all() = Responser.ok(dicRepository.findAll())

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = Responser.ok(dicRepository.getOne(id))

    @DeleteMapping("/{ids}")
    fun delete(@PathVariable ids: String): ResponseEntity<Messager> {
        ids.split(COMMA).forEach { dicRepository.deleteById(it.toInt()) }
        return Responser.delete()
    }

    @PostMapping
    fun add(@RequestBody dic: Dic): ResponseEntity<Messager> {
        dicRepository.save(dic)
        return Responser.created()
    }

    @PatchMapping
    fun update(@RequestBody dic: Dic): ResponseEntity<Messager> {
        dicRepository.save(dic)
        return Responser.update()
    }

    @GetMapping("/list")
    fun page(pageable: Pageable) = dicRepository.findAll(pageable)


}
