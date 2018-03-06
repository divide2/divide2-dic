package com.divide2.dic


import javax.persistence.*

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Entity
@Table(name = "sys_dic")
data class Dic(
        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(name = "group_name")
        var groupName: String = "",

        @Column(name = "group_code")
        var groupCode: String = "",

        @Column(name = "cn_label")
        var cnLabel: String = "",

        @Column(name = "en_label")
        var enLabel: String = "",

        @Column(name = "order_num")
        var orderNum: Int = 0,

        var code: String = ""
)

