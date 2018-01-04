package com.divide2.dic.model;

import javax.persistence.*;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Table(name = "sys_label")
@Entity
public class Label {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cn_label")
    private String cnLabel;

    private String code;

}
