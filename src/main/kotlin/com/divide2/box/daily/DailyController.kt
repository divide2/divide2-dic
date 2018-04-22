package com.divide2.box.daily

import com.divide2.er.COMMA
import com.divide2.er.Messager
import com.divide2.er.Responser
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author bvvy
 * @date 2018/4/22
 */
@RestController
@RequestMapping("/v1/daily")
class DailyController(val dailyRepository: DailyRepository) {

    @GetMapping("/all")
    fun all() = Responser.ok(dailyRepository.findAll())

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = Responser.ok(dailyRepository.getOne(id))

    @DeleteMapping("/{ids}")
    fun delete(@PathVariable ids: String): ResponseEntity<Messager> {
        ids.split(COMMA).forEach { dailyRepository.deleteById(it.toInt()) }
        return Responser.delete()
    }

    @PostMapping
    fun add(@RequestBody daily: Daily): ResponseEntity<Messager> {
        dailyRepository.save(daily)
        return Responser.created()
    }

    @PatchMapping
    fun update(@RequestBody daily: Daily): ResponseEntity<Messager> {
        dailyRepository.save(daily)
        return Responser.update()
    }

    @GetMapping("/list")
    fun page(pageable: Pageable) = dailyRepository.findAll(pageable)
}

