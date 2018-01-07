package com.divide2.dic.runner;

import com.divide2.dic.service.DicService;
import com.divide2.dic.service.LabelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bvvy on 2018/1/7.
 * com.divide2.dic.runner
 */
@Component
public class DicRunner implements CommandLineRunner {

    @Resource
    private DicService dicServiceImpl;

    @Resource
    private LabelService labelServiceImpl;

    @Override
    public void run(String... args) throws Exception {

    }
}
