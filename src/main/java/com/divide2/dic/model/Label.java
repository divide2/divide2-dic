package com.divide2.dic.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Table(name = "sys_label")
@Entity
@Data
public class Label {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "cn_label")
    private String cnLabel;

    private String code;

}
