package com.divide2.auth.user

import com.divide2.auth.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by bvvy on 2018/4/21.
 * com.divide2.auth.user
 */

interface UserRepository : JpaRepository<User, Int> {

    fun findByPhone(phone: String): User?
}