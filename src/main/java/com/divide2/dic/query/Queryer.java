package com.divide2.dic.query;

import com.divide2.dic.model.Dic;
import com.divide2.search.annotation.Conditioner;
import com.divide2.search.annotation.SearchWay;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by bvvy on 2018/1/7.
 * com.divide2.search
 */
public class Queryer<T> {

    private Map<String, String> conditions;

    private Queryer() {
    }

    private Queryer(Map<String, String> conditions) {
        this.conditions = conditions;
    }

    public static <T> Queryer<T> wrap(Map<String, String> conditions, Class<T> tClass) {
        Queryer<T> queryer = new Queryer<>(conditions);
        Map<String, String> noNullMap = removeNullValue(conditions);
        List<String> conditionFields = mergeFields(tClass.getDeclaredFields());
        return queryer;
    }


    private static List<String> mergeFields(Field[] declaredFields) {
        List<String> allFields = new ArrayList<>();
        for (Field field : declaredFields) {
            Conditioner conditioner = field.getAnnotation(Conditioner.class);
            if (conditioner != null && conditioner.way() == SearchWay.RANGE) {
                allFields.add(conditioner.startName());
                allFields.add(conditioner.endName());
            } else {
                allFields.add(field.getName());
            }

        }
        return allFields;
    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("idStart", "1");
        map.put("idEnd", "2");
//        wrap(map, Dic.class);
        mergeFields(Dic.class.getDeclaredFields()).forEach(System.out::println);

    }

    private static Map<String, String> removeNullValue(Map<String, String> allMap) {
        Map<String, String> noneNullMap = new HashMap<>();
        allMap.forEach((k, v) -> {
            if (StringUtils.isNotEmpty(v)) {
                noneNullMap.put(k, v);
            }
        });
        return noneNullMap;
    }


}
