package com.neo.lang;

public class Len {

	public static void main(String[] args) {
		String str = "123.45"; //12345
		str = str.trim();
		System.out.println("小数点后面有" + (str.length()-1-str.indexOf(".")) + "位");
	}

}
