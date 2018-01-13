package com.divide2.dic.aspect;

import com.divide2.search.Queryer;
import com.divide2.search.annotation.Conditioner;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by bvvy on 2018/1/11.
 * com.divide2.dic
 */
@Aspect
@Component
public class SearchAspect {
    private Logger logger = LoggerFactory.getLogger(SearchAspect.class);

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Pointcut(value = "execution(* com.divide2.base.service.BaseService.search(..)) && args(queryer)")
    public void searcher(Queryer queryer) {

    }


    @Before(value = "searcher(queryer)",argNames = "queryer")
    public void beforeSearch(Queryer queryer) {
        Field fields[] = queryer.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            Conditioner conditioner = field.getAnnotation(Conditioner.class);
            BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
            switch (conditioner.way()) {
                case EQ: {
//                    queryBuilder.must()
                }
                case LIKE:{

                }
                case RANGE: {

                }

            }
            SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        });
    }


}
