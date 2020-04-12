package com.neo.file.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ComX {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String filePath = "C:/Users/Neo/Desktop/test.txt";
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("文件存在，路径为：" + filePath);
			try {
				FileReader fe = new FileReader(filePath);
				char[] chars = new char[10];
				fe.read(chars,0,9); //先读取十个字符试试
				for(char ch:chars){
		            System.out.print(ch);
		        }
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
