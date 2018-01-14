package com.divide2.dic.es.repo;

import com.divide2.dic.model.Dic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by bvvy on 2018/1/14.
 * com.divide2.dic.es.repo
 */
public interface DicEsRepository  extends ElasticsearchRepository<Dic,Integer>{

}
