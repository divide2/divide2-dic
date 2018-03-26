package com.divide2.auth

import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

/**
 * Created by bvvy on 2018/3/25.
 * com.divide2.auth
 */
@Entity
@Table(name="sys_role")
class Role(

        @Id
        @GeneratedValue
        var id: Int,

        @NotEmpty
        @Length(min = 5, max = 30)
        var name: String = "ROLE_USER"
)