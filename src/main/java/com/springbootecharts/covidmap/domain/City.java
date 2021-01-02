package com.springbootecharts.covidmap.domain;

import lombok.Data;
//各地疫情信息
@Data
public class City {
    private String cityName;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;

}
