package com.divide2.dic.es.repo;

import com.divide2.dic.model.Dic;
import com.divide2.dic.service.DicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bvvy on 2018/1/14.
 * com.divide2.dic.es.repo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDicSearch {

    @Autowired
    private DicEsRepository dicEsRepository;

    @Autowired
    private DicService dicService;

    @Test
    public void testAdd() {
        Dic dic = dicService.get(1);
        dicEsRepository.save(dic);
    }
}
