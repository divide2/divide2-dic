package com.divide2.dic.service.impl;

import com.divide2.base.service.impl.BaseServiceImpl;
import com.divide2.dic.model.Dic;
import com.divide2.dic.repository.DicRepository;
import com.divide2.dic.service.DicService;
import org.springframework.stereotype.Service;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.service.impl
 */
@Service("dicService")
public class DicServiceImpl extends BaseServiceImpl<Dic,Integer,DicRepository> implements DicService {


}
