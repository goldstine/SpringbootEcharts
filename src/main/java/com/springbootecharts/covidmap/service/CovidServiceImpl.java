package com.springbootecharts.covidmap.service;

import com.springbootecharts.covidmap.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CovidServiceImpl implements CovidService{

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @Override
    public String findAll() {
        return stringRedisTemplate.opsForValue().get(Constant.REDIS_KEY_EPIDEMIC_JSON);
    }

    @Override
    public String findProviceByShortName(String provinceShortName) {
        return (String)stringRedisTemplate.opsForHash().get(Constant.REDIS_KEY_EPIDEMIC_PROVINCE,provinceShortName);
        //该方法返回的是object数据类型的，需要强制类型转换
    }
}
