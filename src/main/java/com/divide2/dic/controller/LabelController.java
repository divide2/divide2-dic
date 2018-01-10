package com.divide2.dic.controller;

import com.divide2.constant.Responser;
import com.divide2.constant.ReturnCoder;
import com.divide2.dic.model.Label;
import com.divide2.dic.service.LabelService;
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
        return Responser.ok(labelServiceImpl.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<Label> get(@PathVariable Integer id) {
        return Responser.ok(labelServiceImpl.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ReturnCoder> delete(@PathVariable Integer id) {
        labelServiceImpl.delete(id);
        return Responser.delete();
    }

    @PostMapping
    public ResponseEntity<ReturnCoder> add(@RequestBody Label label) {
        labelServiceImpl.add(label);
        return Responser.created();
    }
    @PatchMapping
    public ResponseEntity<ReturnCoder> update(@RequestBody Label label) {
        labelServiceImpl.update(label);
        return Responser.update();
    }
    
}
