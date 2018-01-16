package com.divide2.dic.query;

import java.lang.reflect.ParameterizedType;

/**
 * create by bvvy
 */
public class QueryerSupper<T> {


    @SuppressWarnings("unchecked")
    protected Class<T> getTClz() {
        return (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
