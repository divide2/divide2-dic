package com.divide2.auth.user


import javax.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "sys_user")
class User(
        @Id
        @GeneratedValue
        var id: Int = 0,

        var username: String = "",

        var password: String = "",

        var phone: String = "",

        var email: String = "",

        var gender: String = "",

        var enabled: Boolean = false,

        @Column(name = "create_date_time")
//    @JsonFormat(pattern = DateConst.DATETIME_FORMATTER)
        var createDateTime: LocalDateTime = LocalDateTime.now(),

        @Column(name = "update_date_time")
//    @JsonFormat(pattern = DateConst.DATETIME_FORMATTER)
        var updateDateTime: LocalDateTime = LocalDateTime.now()
)