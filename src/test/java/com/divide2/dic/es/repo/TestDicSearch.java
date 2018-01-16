package com.divide2.dic.es.repo;

import com.divide2.dic.model.Dic;
import com.divide2.dic.service.DicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bvvy on 2018/1/14.
 * com.divide2.dic.es.repo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDicSearch {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private DicService dicService;

    @Test
    public void testAdd()  {
        IndexQuery indexQuery = new IndexQuery();
        for (Dic dic : dicService.all()) {
            indexQuery.setObject(dic);
            System.out.println(elasticsearchTemplate.index(indexQuery));
        }
    }

    @Test
    public void testSearch() {
        Map<String, String> map = new HashMap<>();
        map.put("page", "0");
        map.put("size", "10");
        map.put("groupCode", "gen");
        dicService.search(map).forEach(System.out::println);

    }
}
