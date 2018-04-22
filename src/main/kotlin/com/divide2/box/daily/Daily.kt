package com.divide2.box.daily

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author bvvy
 * @date 2018/4/22
 */
@Entity
@Table(name = "box_daily")
class Daily(
        @Id
        @GeneratedValue
        var id: Int,

        var content: String,

        @Column(name = "create_date_time")
        var createDateTime: LocalDateTime = LocalDateTime.now(),

        @Column(name = "complete_date")
        var completeDate: LocalDate = LocalDate.now()

)