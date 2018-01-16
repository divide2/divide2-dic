package com.divide2.dic.query;

import com.divide2.dic.model.Dic;
import com.divide2.search.Queryer;
import com.divide2.search.annotation.Conditioner;
import com.divide2.search.annotation.SearchWay;
import com.divide2.search.annotation.Searcher;
import lombok.Data;

/**
 * Created by bvvy on 2018/1/10.
 * com.divide2.dic.query
 */
@Data
@Searcher(indexClass = Dic.class)
public class DicQuery  {

    private Integer idStart;

    private Integer idEnd;

    @Conditioner(way = SearchWay.LIKE)
    private String groupName;

    @Conditioner(way = SearchWay.LIKE)
    private String groupCode;

    @Conditioner(way = SearchWay.LIKE)
    private String cnLabel;

    @Conditioner(way = SearchWay.LIKE)
    private String enLabel;

    @Conditioner(way = SearchWay.LIKE)
    private String code;

}
