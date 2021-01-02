package com.springbootecharts.covidmap.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//开启定时功能
@EnableScheduling
public class CovidTask {

    @Autowired
    private DataInfoHandler dataInfoHandler;
    @Scheduled(fixedDelay = 1000*60*60)
    public void initData() throws JsonProcessingException {
        System.out.println("定时同步开始......");
        dataInfoHandler.synCovidData();
    }
}
