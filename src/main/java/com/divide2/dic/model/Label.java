package com.divide2.dic.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Table(name = "sys_label")
@Entity
@Data
@Document(indexName = "labels",type = "label",refreshInterval = "-1")
public class Label {

    @Id
    @GeneratedValue
    @org.springframework.data.annotation.Id
    private Integer id;

    @Column(name = "cn_label")
    private String cnLabel;

    private String code;

}
