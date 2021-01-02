package com.springbootecharts.covidmap.service;

public interface CovidService {
    //获取所有的疫情数据,直接把redis中的字符串返回就可以了
    public String findAll();
    //根据省份名字获取对应的省份信息
    public String findProviceByShortName(String provinceShortName);

}
