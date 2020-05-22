package com.etoak.bean;

import lombok.Data;

@Data
public class Car {
private Integer id;
private String brand;//品牌
private String series;//车系
private Integer price;
private String licensingTime;//上牌时间
private String level;
private String bsbox;
private String output;
private Integer mileage;//里程
private String location;//归属地
private String pic;
private String summary;
private String create_time;
}
