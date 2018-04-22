package com.divide2.auth.user

import com.divide2.auth.User
import org.hibernate.validator.constraints.Length
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotEmpty

/**
 * @author bvvy
 */
@RestController
class FrontController(val userService: UserService) {


    @PostMapping("/v1/join")
    fun join(@RequestBody joinDto: JoinDto) {

        val user = User(
                password = joinDto.password,
                nickname = joinDto.account,
                phone = joinDto.account,
                enabled = true)
        userService.save(user)
    }
  }

class JoinDto(
        @NotEmpty
        val account: String,

        @NotEmpty
        @Length(min = 8, max = 30)
        val password: String

)
