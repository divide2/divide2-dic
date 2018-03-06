package com.divide2.label

import javax.persistence.*

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Table(name = "sys_label")
@Entity
class Label(
        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(name = "cn_label")
        var cnLabel: String = "",

        var code: String = ""
)
