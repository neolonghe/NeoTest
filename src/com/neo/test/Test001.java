package com.neo.test;

import java.util.HashMap;
import java.util.List;
/**
 * @version 1.0
 * @author Neo
 *
 */
public class Test001 {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		List<HashMap<String, Object>> list = null;
		if (list.isEmpty()) { // Exception in thread "main" java.lang.NullPointerException
			System.out.println("list是空！！！");
		} else {
			System.out.println("list的大小是[" + list.size() + "]。");
		}

	}

}
