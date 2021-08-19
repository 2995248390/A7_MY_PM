package com.cmm.domain;

import java.util.HashMap;

//文件回调的格式对象
public class ImgInfo {
	private String code;
	private String msg;
	private HashMap<?,?> data;
	public ImgInfo(String code, String msg, HashMap<?, ?> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ImgInfo(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public ImgInfo() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HashMap<?, ?> getData() {
		return data;
	}
	public void setData(HashMap<?, ?> data) {
		this.data = data;
	}
	

}
