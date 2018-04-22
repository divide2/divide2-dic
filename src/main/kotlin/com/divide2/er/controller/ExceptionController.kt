package com.divide2.er.controller

import com.divide2.er.Messager
import com.divide2.er.Responser
import com.divide2.er.ReturnCoder
import com.divide2.er.exception.AlreadyExistsException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

/**
 * @author bvvy
 * @date 2018/4/22
 */
@RestController
@ControllerAdvice
class ExceptionController {

    @ExceptionHandler(AlreadyExistsException::class)
    fun alreadyExistsExceptionHandler():ResponseEntity<Messager> {
        return Responser.conflict(ReturnCoder.ALREADY_EXISTS)
    }

}