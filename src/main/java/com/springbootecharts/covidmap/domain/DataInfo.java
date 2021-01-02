package com.springbootecharts.covidmap.domain;

import lombok.Data;

import java.util.List;

@Data
public class DataInfo {
    private Integer code;
    private String msg;
    private List<Province> newslist;
}
