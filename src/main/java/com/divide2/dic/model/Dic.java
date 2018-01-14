package com.divide2.dic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.model
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_dic")
@Document(indexName = "dics",type = "dic")
public class Dic {

    @Id
    @GeneratedValue
    @org.springframework.data.annotation.Id
    private Integer id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "cn_label")
    private String cnLabel;

    @Column(name = "en_label")
    private String enLabel;

    @Column(name = "order_num")
    private Integer orderNum;

    private String code;
}
