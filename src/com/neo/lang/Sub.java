package com.neo.lang;
/**
 * @version 1.0
 * @author Neo
 *
 */
public class Sub {

	public static void main(String[] args) {
		String str = "0123456789";
		String rlt = null;
		rlt = str.substring(0);
		System.out.println("截取的结果是：" + rlt); // 可以从0位开始截取的
		rlt = str.substring(2, 6);
		System.out.println("截取的结果是：" + rlt);
	}

}
