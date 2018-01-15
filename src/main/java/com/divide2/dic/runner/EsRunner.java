package com.divide2.dic.runner;

import com.divide2.dic.model.Dic;
import com.divide2.dic.model.Label;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bvvy on 2018/1/15.
 * com.divide2.dic.runner
 */
@Component
public class EsRunner implements CommandLineRunner {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void run(String... strings) throws Exception {
        elasticsearchTemplate.createIndex(Dic.class);
        elasticsearchTemplate.createIndex(Label.class);
    }
}
