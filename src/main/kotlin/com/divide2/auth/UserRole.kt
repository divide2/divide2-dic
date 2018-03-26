package com.divide2.auth

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by bvvy on 2018/3/25.
 * com.divide2.auth.config
 */
@Entity
@Table(name = "sys_user_role")
class UserRole(
        @Id
        @GeneratedValue
        var id: Int,

        var userId: Int,

        var roleId: Int
)