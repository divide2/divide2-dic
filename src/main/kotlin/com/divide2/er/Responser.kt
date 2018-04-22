package com.divide2.er

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * Created by bvvy on 2018/1/9.
 * com.divide2.constant
 */
object Responser {

    private const val UPDATE_STATUE = 209
    private const val DELETE_STATUS = 210


    fun <T> ok(body: T): ResponseEntity<T> {
        return ResponseEntity.ok(body)
    }

    fun created(): ResponseEntity<Messager> {
        return ResponseEntity.status(HttpStatus.CREATED).body(Messager.of(ReturnCoder.ADD_SUCCESS))
    }

    fun update(): ResponseEntity<Messager> {
        return ResponseEntity.status(UPDATE_STATUE).body(Messager.of(ReturnCoder.UPDATE_SUCCESS))
    }

    fun delete(): ResponseEntity<Messager> {
        return ResponseEntity.status(DELETE_STATUS).body(Messager.of(ReturnCoder.DELETE_SUCCESS))
    }

    fun conflict(code: String): ResponseEntity<Messager> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Messager.of(code))
    }

    fun conflict(code: ReturnCoder): ResponseEntity<Messager> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Messager.of(code))
    }

}
