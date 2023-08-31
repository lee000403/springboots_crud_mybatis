package com.example.test_mysql_crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test_mysql_crud.service.MysqlService;

@Controller
public class MysqlController {
    @Autowired
    MysqlService mysqlService;

    @GetMapping("/mysql/Search")
    public String selectSearch(@RequestParam Map paramMap, Model model) {
        Object result = mysqlService.selectSearch(paramMap);
        model.addAttribute("result", result);
        return "main";
    }
    
    @GetMapping("/mysql/SearchAll")
    public String selectAll(Model model) {
        Object result = mysqlService.selectAll();
        model.addAttribute("result", result);
        return "main";
    }

    @GetMapping("/mysql/selectDetail")
    public String selectDetail(@RequestParam Map paramMap, Model model) {
        Object result = mysqlService.selectDetail(paramMap);
        model.addAttribute("result", result);
        return "main_detail";
    }

    @GetMapping("/mysql/insert")
    public String insert(Model model) {
        return "main_insert";
    }

    @PostMapping("/mysql/insertandSelect")
    public String insertandSelect(@RequestParam Map paramMap, Model model) {
        Object result = mysqlService.insertandSelect(paramMap);
        model.addAttribute("result", result);
        return "main_select";
    }
    
    @PostMapping("/mysql/update/{language_id}")
    public String update(@PathVariable String language_id, Model model) {
        HashMap result = new HashMap<>();
        result.put("language_id", language_id);
        model.addAttribute("result", result);
        return "main_update";
    }

    @PostMapping("/mysql/updateandSelect")
    public String updateandSelect(@RequestParam Map paramMap, Model model) {
        Object result = mysqlService.updateandSelect(paramMap);
        model.addAttribute("result", result);
        return "main_select";
    }

    @PostMapping("/mysql/deleteandSelect/{language_id}")
    public String deleteandSelect(@PathVariable String language_id, @RequestParam Map paramMap, Model model) {
        Object result = mysqlService.deleteandSelect(paramMap, language_id);
        model.addAttribute("result", result);
        return "main_select";
    }
}
