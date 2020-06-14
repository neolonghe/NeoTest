package com.neo.kettle;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class CvtTxt2ExlPlus {
	public static final String HOME_PATH = "C:\\Users\\83960\\Desktop\\2007\\";
	public static final String KTR_PATH = "F:\\Eclipse\\NeoTest\\NeoTest\\ktr\\2007Plus.ktr";
	public static final String EXCLE_PATH = HOME_PATH + "Excles\\" + "2017Plus";
	public static void main(String[] args) {
		System.out.println("执行转换[" + KTR_PATH + "]。");
		for (int i = 1; i < 32; i++) {
			String fileName = "2017_" + i;
			String txtPath = HOME_PATH + "Files\\" + fileName + ".txt";
			String sheetName = "Sheet" + i;
			System.out.println("开始解析文件[" + txtPath + "]到[" + sheetName + "]。");
			cvt(txtPath, sheetName);
		}

	}
	
	
	public static void cvt(String txtPath, String sheetName) {
		Trans trans = null;
		try {
			KettleEnvironment.init();
			// 初始化
			EnvUtil.environmentInit();
			TransMeta transMeta = new TransMeta(KTR_PATH);
			// 转换
			trans = new Trans(transMeta);
			trans.getLogChannel().setLogLevel(LogLevel.DEBUG);
			// 设置参数
			trans.setParameterValue("FILE_PATH", txtPath);
			trans.setParameterValue("EXCLE_PATH", EXCLE_PATH);
			trans.setParameterValue("SHEET_NAME", sheetName);
			// 执行转换
			trans.execute(null);
			// 等待转换执行结束
			trans.waitUntilFinished();
			// 抛出异常
			Boolean jobResult = !(trans.getErrors() > 0);
			System.out.println("转换执行" + (jobResult ? "[成功]" : "[失败]"));
			trans.stopAll();
			if (!jobResult) {
				System.err.println("转换执行失败！");
				throw new RuntimeException("转换执行失败！");
			}
		} catch (Exception e){
			System.err.println("执行异常\n" + e);
			throw new RuntimeException(e);
		}
		
	}

}
