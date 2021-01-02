package com.springbootecharts.covidmap.controller;

import com.springbootecharts.covidmap.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController表示不会进行页面的跳转，直接返回数据
//@RestController包含两个注解@Controller表示是一个控制器，@ResponseBody表示返回数据

@RestController
//避免跨域无法进行访问
@CrossOrigin("*")
public class CovidController {
    //controller需要根据前端提供的接口文档来写

    @Autowired
    private CovidService covidService;
    //也可写成这种形式
//    @GetMapping("/findAll")表示只有get请求可以访问，其他方式不可以访问
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(){
        return covidService.findAll();
    }

//    @RequestMapping(value="/findAll")
    @GetMapping("/findProvinceByShortName")
    public String findProvinceByShortName(String provicneShortName){
        return covidService.findProviceByShortName(provicneShortName);
    }
}
