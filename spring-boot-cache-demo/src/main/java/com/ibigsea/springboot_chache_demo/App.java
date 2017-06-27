
package com.ibigsea.springboot_chache_demo;

import com.ibigsea.springboot_chache_demo.config.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
@EnableCaching
public class App{

    @Autowired
    private DataCache dataCache;

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/put")
    public String put(Long id, String value){
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " + dataCache.put(id,value);
    }

    @RequestMapping("/get")
    public String query(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " : value is " + dataCache.query(id);
    }

    @RequestMapping("/remove")
    public String remove(Long id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataCache.remove(id);
        return sdf.format(new Date()) + " : success ";
    }

}