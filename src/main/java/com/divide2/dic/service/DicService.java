package com.divide2.dic.service;

import com.divide2.dic.model.Dic;

import java.util.List;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.service
 */
public interface DicService {

    Dic save(Dic dic);

    void delete(Long id);

    List<Dic> findAll();

}
