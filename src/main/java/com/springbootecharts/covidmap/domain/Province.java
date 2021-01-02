package com.springbootecharts.covidmap.domain;

import lombok.Data;

import java.util.List;

@Data
public class Province {
    private String provinceName;
    private String provinceShortName;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String comment;
    private List<City> cities;

}
