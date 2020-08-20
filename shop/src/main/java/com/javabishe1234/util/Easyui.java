package com.javabishe1234.util;

import java.util.HashMap;
import java.util.List;

public class Easyui extends HashMap<String, Object> {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public static Easyui data(Long count, List<?> data) {
		Easyui r = new Easyui();
		r.put("total", count);
		r.put("rows", data);
		return r;
	}
}
