package com.neo.lang;

import java.util.HashMap;
import java.util.Map;

public class ArrayTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("key1", "val1");
		System.out.println(map);
		printMap(map);
		System.out.println(map);
		return;
	}

	public static void printMap(Map map) {
		map.put("key2", "var2");
		System.out.println(map);
		return ;
	}

}
