package com.divide2.dic.model;

import com.divide2.search.annotation.Conditioner;
import com.divide2.search.annotation.SearchWay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

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
@Document(indexName = "dics",type = "dic",refreshInterval = "-1")
public class Dic {

    @Id
    @GeneratedValue
    @org.springframework.data.annotation.Id
    @Conditioner(way = SearchWay.RANGE,startName = "idStart",endName = "idEnd")
    private Integer id;

    @Column(name = "group_name")
    private String groupName;


    @Column(name = "group_code")
    @Conditioner(way = SearchWay.LIKE)
    private String groupCode;

    @Column(name = "cn_label")
    private String cnLabel;

    @Column(name = "en_label")
    private String enLabel;

    @Column(name = "order_num")
    private Integer orderNum;

    private String code;
}
