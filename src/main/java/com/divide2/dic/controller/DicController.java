package com.divide2.dic.controller;

import com.divide2.dic.model.Dic;
import com.divide2.dic.service.DicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private DicService dicService;

    @GetMapping("/list")
    @PutMapping
    public ResponseEntity<List<Dic>> list() {
        return ResponseEntity.ok(dicService.findAll());
    }


}
