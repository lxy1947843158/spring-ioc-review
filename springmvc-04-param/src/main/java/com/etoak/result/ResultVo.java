package com.etoak.result;

import com.etoak.bean.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
	private Integer code;
	private String msg;
}
