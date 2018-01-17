package com.divide2.dic.repository;

import com.divide2.base.repository.BaseRepository;
import com.divide2.dic.model.Dic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.repository
 */

public interface DicRepository extends BaseRepository<Dic,Integer> {


}
