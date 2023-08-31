package com.example.test_mysql_crud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test_mysql_crud.dao.SharedDao;

@Service
@Transactional
public class MysqlService {
    @Autowired
    SharedDao sharedDao;

    public Object selectSearch(Map dataMap) {
        String sqlMapId = "Mysql.Search";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectAll() {
        String sqlMapId = "Mysql.SearchAll";
        Map<String, Object> dataMap = new HashMap<>();
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(Map dataMap) {
        String sqlMapId = "Mysql.selectDetail";
        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap) {
        String sqlMapId = "Mysql.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertandSelect(Map dataMap) {
        this.insert(dataMap);
        Map<String, Object> result = new HashMap<>();
        result.put("resultList", this.selectAll());
        return result;
    }

    public Object update(Map dataMap) {
        String sqlMapId = "Mysql.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object updateandSelect(Map dataMap) {
        this.update(dataMap);
    
        HashMap result = new HashMap<>();
        result.put("resultList", this.selectAll());

        return result;
    }

    public Object delete(String language_id) {
        String sqlMapId = "Mysql.delete";
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("language_id", language_id);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object deleteandSelect(Map dataMap, String language_id) {
        this.delete(language_id);
    
        HashMap result = new HashMap<>();
        result.put("resultList", this.selectAll());

        return result;
    }
}
