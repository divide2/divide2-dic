package com.divide2.dic;

import com.divide2.search.Queryer;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by bvvy on 2018/1/11.
 * com.divide2.dic
 */
@Aspect
@Component
public aspect SearcherAspect {

    pointcut searcher(Queryer queryer) : @annotation(com.divide2.search.annotation.Searcher) && args(queryer);

    before(Queryer queryer) : searcher(queryer) {

    }


}
