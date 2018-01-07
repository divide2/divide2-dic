package com.divide2.dic.controller;

import com.divide2.dic.model.Label;
import com.divide2.dic.service.LabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by bvvy
 */
@Controller
@RequestMapping("/v1/label")
public class LabelController {

    @Resource
    private LabelService labelServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<Label>> all() {
        return ResponseEntity.ok(labelServiceImpl.all());
    }


    @GetMapping("{id}")
    public ResponseEntity<Label> get(@PathVariable Integer id) {
        return ResponseEntity.ok(labelServiceImpl.get(id));
    }

    @DeleteMapping("${id")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        labelServiceImpl.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Label label) {
        labelServiceImpl.add(label);
        return ResponseEntity.status(HttpStatus.CREATED).body("添加成功");
    }
    @PatchMapping
    public ResponseEntity<String> update(@RequestBody Label label) {

        labelServiceImpl.update(label);
        return ResponseEntity.ok("修改成功");
    }
    
}
