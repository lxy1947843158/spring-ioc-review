package com.etoak.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> {
private int pageNum;//当前页
private int pageSize;//每页显示记录数
private List<T> rows;//记录
private long total;//总记录数
private int pageCount;//总页数
private boolean isfirst;//是否是第一页
private boolean islast;//是否是第二页
	
}
