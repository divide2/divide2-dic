package com.divide2.dic.controller;

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
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        dicServiceImpl.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Dic dic) {
        dicServiceImpl.add(dic);
        return ResponseEntity.ok("添加成功");
    }

    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Dic dic) {

        dicServiceImpl.update(dic);
        return ResponseEntity.ok("修改成功");
    }


}
