package com.ibigsea.springboot_chache_demo.config;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenweiqiang on 2017/6/27.
 * 参考页面：http://blog.csdn.net/a67474506/article/details/52608855
 */

@Component
public class DataCache {
    private Map<Long,String> dataMap = new HashMap<>();


    @PostConstruct
    public void init(){
        dataMap.put(1L, "张三");
        dataMap.put(2L, "李四");
        dataMap.put(3L, "王五");
    }

    @Cacheable(value="guavaDemo", key="#id + 'dataMap'")
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : query id is " + id);
        return dataMap.get(id);
    }

    @CachePut(value="guavaDemo", key="#id + 'dataMap'")
    public String put(Long id, String value){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : add data, id is " +id);
        dataMap.put(id, value);
        return value;
    }

    @CacheEvict(value="guavaDemo", key="#id + 'dataMap'")
    public void remove(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : remove id is " + id + " data");
        dataMap.remove(id);
    }




}
