package com.divide2.dic.model;

import com.divide2.search.annotation.Conditioner;
import com.divide2.search.annotation.SearchWay;
import com.divide2.search.annotation.Searcher;
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
@Document(indexName = "sys_dic")
@Searcher
public class Dic {

    @Id
    @GeneratedValue
    @Conditioner(way = SearchWay.RANGE,startName = "id_start",endName = "id_end")
    private Integer id;

    @Column(name = "group_name")
    @Conditioner(way = SearchWay.LIKE)
    private String groupName;

    @Column(name = "group_code")
    @Conditioner(way = SearchWay.LIKE)
    private String groupCode;

    @Column(name = "cn_label")
    @Conditioner(way = SearchWay.LIKE)
    private String cnLabel;

    @Column(name = "en_label")
    @Conditioner(way = SearchWay.LIKE)
    private String enLabel;

    @Column(name = "order_num")
    @Conditioner(way = SearchWay.LIKE)
    private Integer orderNum;

    @Conditioner(way = SearchWay.LIKE)
    private String code;
}
