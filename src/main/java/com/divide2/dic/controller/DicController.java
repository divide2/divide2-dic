package com.divide2.dic.controller;

import com.divide2.constant.Responser;
import com.divide2.constant.ReturnCoder;
import com.divide2.dic.model.Dic;
import com.divide2.dic.service.DicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.controller
 */
@RestController
@RequestMapping("/v1/dic")
public class DicController {

    @Resource
    private DicService dicServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<Dic>> all() {
        return ResponseEntity.ok(dicServiceImpl.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<Dic> get(@PathVariable Integer id) {
        return ResponseEntity.ok(dicServiceImpl.get(id));
    }

    @DeleteMapping("${id")
    public ResponseEntity<ReturnCoder> delete(@PathVariable Integer id) {
        dicServiceImpl.delete(id);
        return Responser.delete();
    }

    @PostMapping
    public ResponseEntity<ReturnCoder> add(@RequestBody Dic dic) {
        dicServiceImpl.add(dic);
        return Responser.created();
    }

    @PatchMapping
    public ResponseEntity<ReturnCoder> update(@RequestBody Dic dic) {
        dicServiceImpl.update(dic);
        return Responser.update();
    }

}
