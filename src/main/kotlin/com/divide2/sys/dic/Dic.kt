package com.divide2.sys.dic


import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.module.dic.model
 */
@Entity
@Table(name = "sys_dic")
data class Dic(
        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(name = "group_name")
        @NotEmpty
        var groupName: String = "",

        @Column(name = "group_code")
        @NotEmpty
        var groupCode: String = "",

        @Column(name = "cn_label")
        @NotEmpty
        var cnLabel: String = "",

        @Column(name = "en_label")
        @NotEmpty
        var enLabel: String = "",

        @Column(name = "order_num")
        @NotNull
        var orderNum: Int = 0,

        @NotEmpty
        var code: String = ""
)

