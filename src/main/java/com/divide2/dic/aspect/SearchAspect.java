package com.divide2.dic.aspect;

import com.divide2.search.Queryer;
import com.divide2.search.annotation.Conditioner;
import com.divide2.search.annotation.Searcher;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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

    @Pointcut("execution(* com.divide2.base.service.BaseService.search(..)) ")
    public void mapSearch() {
    }

    @Around(value = "mapSearch()")
    public Object forMapSearch(ProceedingJoinPoint pjp) throws Throwable {
        pjp.getArgs();
        return pjp.proceed();
    }

    @Before(value = "searcher(queryer)", argNames = "queryer")
    public void beforeSearch(Queryer queryer) {
        try {
            Class<? extends Queryer> queryerClass = queryer.getClass();
            Searcher searcher = queryerClass.getAnnotation(Searcher.class);
            BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
            Map<String, String> fieldMap = BeanUtils.describe(queryer);
            fieldMap.entrySet().stream();
            fieldMap.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() != null && !entry.getKey().equals("class"))
                    .forEach(entry -> {
                        try {
                            Field field = queryer.getClass().getDeclaredField(entry.getKey());
                            Conditioner conditioner = field.getAnnotation(Conditioner.class);
                            switch (conditioner.way()) {
                                case EQ: {
                                    queryBuilder.must(QueryBuilders.termQuery(field.getName(), entry.getValue()));
                                }
                                case LIKE: {
                                    queryBuilder.must(QueryBuilders.queryStringQuery(entry.getValue()).field(field.getName()));
                                }
                                case RANGE: {
                                   /* if (conditioner.start()) {
                                        queryBuilder.must(QueryBuilders.rangeQuery(conditioner.ref()).gte(entry.getValue()));
                                    }
                                    if (conditioner.end()) {
                                        queryBuilder.must(QueryBuilders.rangeQuery(conditioner.ref()).lte(entry.getValue()));
                                    }*/
                                }
                            }
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    });
            SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
            searchQuery.setPageable(new PageRequest(0, 1));
            Page<?> pages = elasticsearchTemplate.queryForPage(searchQuery, searcher.indexClass());
            pages.forEach(System.out::println);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
