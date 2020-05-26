package com.etoak.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Car {
private Integer id;
@NotNull(message = "brand not empty")
@NotEmpty(message = "brand not empty")
private String brand;//品牌
@NotNull(message = "车系不能为空")
private String series;//车系
@NotNull(message = "价格不能为空")
@Min(value = 1,message = "价格最小是1")
@Max(value = 100,message = "价格最大是100")
private Integer price;
private String licensingTime;//上牌时间
private String level;
private String bsbox;
private String output;
private Integer mileage;//里程
private String location;//归属地
private String pic;
@Size(min = 2,max=50,message = "概述只能在2-50个字符")
private String summary;
private String createTime;


}
