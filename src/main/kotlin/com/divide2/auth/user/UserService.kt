package com.divide2.auth.user

import com.divide2.auth.User
import com.divide2.er.exception.AlreadyExistsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * Created by bvvy on 2018/4/22.
 * com.divide2.auth.user
 */
interface UserService {
    fun save(user: User)
    fun loadByPhone(phone: String): User?
}

@Service
class UserServiceImpl(val userRepository: UserRepository,val passwordEncoder: PasswordEncoder) : UserService {
    override fun save(user: User) {
        val existsUser: User? = loadByPhone(user.phone)
        if (existsUser != null) {
            throw AlreadyExistsException()
        }
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }

    override fun loadByPhone(phone: String): User? {
        return userRepository.findByPhone(phone)
    }
}
