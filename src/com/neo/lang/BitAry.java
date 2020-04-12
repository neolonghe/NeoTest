package com.neo.lang;
/*
 * 测试 equals方法和==的区别
 */
public class BitAry {

	@SuppressWarnings("unlikely-arg-type") // 这个警告需要处理的，不应该压制掉
	public static void main(String[] args) {
		String str = "0010000000";
		char [] strAry = str.toCharArray();
		for (int i = 0; i < strAry.length; i++) {
//			System.out.println("strAry[" + i + "]=" + strAry[i]);
			if ("1".equals(strAry[i])) { // equals方法并不能判断出是否相等
				System.out.println("strAry[" + i + "]equals \"1\"");
			}
			if ('1' == strAry[i]) {
				System.out.println("strAry[" + i + "]=='1'");
			}
			
		}

	}

}
