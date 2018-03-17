package com.divide2.module.label

import com.divide2.er.COMMA
import com.divide2.er.Messager
import com.divide2.er.Responser
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * create by bvvy
 */

@RestController
@RequestMapping("/v1/label")
class LabelController(val labelRepository: LabelRepository) {

    @GetMapping("/all")
    fun all() = Responser.ok(labelRepository.findAll())

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = Responser.ok(labelRepository.getOne(id))

    @DeleteMapping("/{ids}")
    fun delete(@PathVariable ids: String): ResponseEntity<Messager> {
        ids.split(COMMA).forEach { labelRepository.deleteById(it.toInt()) }
        return Responser.delete()
    }

    @PostMapping
    fun add(@RequestBody label: Label): ResponseEntity<Messager> {
        labelRepository.save(label)
        return Responser.created()
    }

    @PatchMapping
    fun update(@RequestBody label: Label): ResponseEntity<Messager> {
        labelRepository.save(label)
        return Responser.update()
    }

    @GetMapping("/list")
    fun page(pageable: Pageable) = labelRepository.findAll(pageable)



}

