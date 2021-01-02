package com.springbootecharts.covidmap.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootecharts.covidmap.constant.Constant;
import com.springbootecharts.covidmap.domain.City;
import com.springbootecharts.covidmap.domain.DataInfo;
import com.springbootecharts.covidmap.domain.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//获取天行的数据
@Component
public class DataInfoHandler {

    @Value("${covid.url}")
    public String url;
    @Value("${covid.key}")
    public String key;

    @Autowired
    private RestTemplate restTemplate;

    //要使用redis，首先将redis组件注入进来
    @Autowired
    private StringRedisTemplate redisTemplate;//然后将数据放入该redis中redisTemplate
    //注入jackson对象
    @Autowired
    private ObjectMapper objectMapper;

    public void synCovidData() throws JsonProcessingException {

        //http://api.tianapi.com/txapi/ncovcity/index?key=2b783742af57999eae6093b4a6b47978
        String covidUrl=url+"?key="+key;

        DataInfo dataInfo=restTemplate.getForObject(covidUrl, DataInfo.class);

        if(dataInfo==null){
            return;
        }

        //第一个接口获取省份信息，省份信息放在redis
        //jackson进行对象到json字符串的转换   因为对象是没有办法存放在redis中的
        String provinceString=objectMapper.writeValueAsString(dataInfo);
        redisTemplate.opsForValue().set(Constant.REDIS_KEY_EPIDEMIC_JSON,provinceString);
        //第二个接口获取某个省份下的城市数据，hash   field河南省 value具体数据
        for(Province province:dataInfo.getNewslist()){
            String proString=objectMapper.writeValueAsString(province);
            redisTemplate.opsForHash().put(Constant.REDIS_KEY_EPIDEMIC_PROVINCE,province.getProvinceName().substring(0,2),proString);

        }

        System.out.println(dataInfo);
    }
}
