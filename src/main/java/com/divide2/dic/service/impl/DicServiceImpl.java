package com.divide2.dic.service.impl;

import com.divide2.dic.model.Dic;
import com.divide2.dic.repository.DicRepository;
import com.divide2.dic.service.DicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.service.impl
 */
@Service
public class DicServiceImpl implements DicService {

    @Resource
    private DicRepository dicRepository;

    @Override
    public Dic save(Dic dic) {
        return dicRepository.save(dic);
    }

    @Override
    public void delete(Long id) {
        dicRepository.delete(id);
    }

    @Override
    public List<Dic> findAll() {
        return dicRepository.findAll();
    }
    @Override
    public Dic get(Long id) {
        return dicRepository.findOne(id);
    }
}
