package com.neo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 * @author Neo
 *
 */
public class TestRegularExpression {
	/*
	 * \n代表换行符，\t代表制表符，\\代表\本身。
	 * \^, \$, \., \(, \), \{, \}, \?, \+, \*, \|, \[, \] 匹配字符本身
	 * \d：任意一个数组字符，0-9中的任意一个。
	 * \w：任意一个字母数字下划线，也就是a-z,A-Z,0-9,_中的任意一个。
	 * \s：匹配空白符，即空格、制表符、换行符等。
	 * .：可以匹配任意一个字符（除换行符）， 一般用[\s\S]匹配任意字符。
	 * \d, \w, \s, . 注意区分大小写，大写的字母表示取反的意思。
	 * 
	 * []是自定义正则表达式，在[]中^表示取反的意思，-表示范围的意思。
	 * {}表示匹配出现的次数，{2}2次，{2,4}2-4次，{3，}最小3次(没有最多3次的写法)。
	 *   默认是贪婪模式，量词后加?表示非贪婪模式，eg:\d{3,8}?
	 *   ？表示匹配表达式0或者1次，即{0,1}；+表示至少出现次数，即{3,}；*表示表达之不出现或者出现任意次数，即{0,}
	 * 
	 * 字符边界：^表示与字符串开始的地方匹配，$表示结尾。\b表示匹配一个单词的边界，即该表达式的前后不全是\w。
	 * 表示匹配的位置，而不是字符本身。
	 * 
	 * (0\d{2,3}-\d{7,9})|1[35789]\d{9} // 固话或手机号码的正则表达式
	 * [\w\-]+@[a-zA-Z0-9]+(\.[a-zA-Z]{2,4}){1,2} // 邮箱的正则表达式
	 * [\u4e00-\u9fa5] // 匹配中文
	 * 
	 */
	
	public static void main(String[] args) {
		testFind();
		testReplace();
		testArrSplit();
		testWebSpider();
		return;
	}
	
	/**
	 * 测试网络爬虫获取链接
	 */
	private static void testWebSpider() {
		String urlStr = getWebStr("http://www.163.com", "gbk");
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");
		Pattern p = Pattern.compile("href=\"([\\w\\s./:]+?)\""); // 获取url
		Matcher m = p.matcher(urlStr);
		List<String> result = new ArrayList<>();
		while(m.find()){
			result.add(m.group(1).trim());
		}
		
		for (String temp:result) {
			System.out.println(temp);
		}
		
	}
	
	/**
	 * 获取网页源码字符串
	 * @param charset 
	 * @return 
	 */
	private static String getWebStr(String urlStr, String charsetName) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(url.openStream(), Charset.forName(charsetName)));
			String temp = "";
			while(null != (temp = br.readLine())) {
				sb.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 测试分割
	 */
	private static void testArrSplit() {
		String str = "1q2w3e4r";
		String[] strArrs = str.split("\\d+");
		System.out.println(Arrays.toString(strArrs));
		return;
	}

	/**
	 * 测试替换
	 */
	private static void testReplace() {
		String str = "1q2w3e4r";
		// 表达式对象
		Pattern ptn = Pattern.compile("[0-9]");
		// 创建 Matcher对象
		Matcher mth = ptn.matcher(str); // 尝试将整个字符串与该模式匹配
		System.out.println(mth.replaceAll("#"));
		return;
	}

	/**
	 * 测试查找
	 */
	private static void testFind() {
		String str = "qw12@@er34##ty56"; // 测试分组处理
		// 表达式对象
		Pattern ptn = Pattern.compile("([a-zA-Z]+)(\\d+)");
		// 创建 Matcher对象
		Matcher mth = ptn.matcher(str); // 尝试将整个字符串与该模式匹配
		System.out.println(mth.matches());
		// 查找
		while(mth.find()) {
			System.out.println(mth.group());
			// 分组处理
			System.out.println(mth.group(1));
			System.out.println(mth.group(2));
		}
		return;
	}

}
