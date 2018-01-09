package com.divide2.dic.controller;

import com.divide2.constant.ReturnCoder;
import com.divide2.dic.model.Dic;
import com.divide2.dic.service.DicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.divide2.constant.ReturnCoder.ADD_SUCCESS;
import static com.divide2.constant.ReturnCoder.DELETE_SUCCESS;
import static com.divide2.constant.ReturnCoder.UPDATE_SUCCESS;

/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.controller
 */
@RestController
@RequestMapping("/v1/dic")
public class DicController {

    @Resource
    private DicService dicService;

    @GetMapping("/all")
    public ResponseEntity<List<Dic>> all() {
        return ResponseEntity.ok(dicService.all());
    }


    @GetMapping("{id}")
    public ResponseEntity<Dic> get(@PathVariable Integer id) {
        return ResponseEntity.ok(dicService.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ReturnCoder> delete(@PathVariable Integer id) {
        dicService.delete(id);
        return ResponseEntity.ok(DELETE_SUCCESS);
    }

    @PostMapping
    public ResponseEntity<ReturnCoder> add(@RequestBody Dic dic) {
        dicService.add(dic);
        return ResponseEntity.ok(ADD_SUCCESS);
    }

    @PatchMapping
    public ResponseEntity<ReturnCoder> update(@RequestBody Dic dic) {

        dicService.update(dic);
        return ResponseEntity.ok(UPDATE_SUCCESS);
    }


}
