package com.divide2.dic.controller;

import com.divide2.constant.ReturnCoder;
import com.divide2.dic.model.Label;
import com.divide2.dic.service.LabelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.divide2.constant.ReturnCoder.ADD_SUCCESS;
import static com.divide2.constant.ReturnCoder.DELETE_SUCCESS;
import static com.divide2.constant.ReturnCoder.UPDATE_SUCCESS;

/**
 * create by bvvy
 */
@Controller
@RequestMapping("/v1/label")
public class LabelController {

    @Resource
    private LabelService labelService;

    @GetMapping("/all")
    public ResponseEntity<List<Label>> all() {
        return ResponseEntity.ok(labelService.all());
    }


    @GetMapping("{id}")
    public ResponseEntity<Label> get(@PathVariable Integer id) {
        return ResponseEntity.ok(labelService.get(id));
    }

    @DeleteMapping("${id")
    public ResponseEntity<ReturnCoder> delete(@PathVariable Integer id) {
        labelService.delete(id);
        return ResponseEntity.ok(DELETE_SUCCESS);
    }

    @PostMapping
    public ResponseEntity<ReturnCoder> add(@RequestBody Label label) {
        labelService.add(label);
        return ResponseEntity.status(HttpStatus.CREATED).body(ADD_SUCCESS);
    }

    @PatchMapping
    public ResponseEntity<ReturnCoder> update(@RequestBody Label label) {
        labelService.update(label);
        return ResponseEntity.ok(UPDATE_SUCCESS);
    }
    
}
