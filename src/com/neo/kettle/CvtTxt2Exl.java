package com.neo.kettle;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class CvtTxt2Exl {
	public static final String HOME_PATH = "C:\\Users\\83960\\Desktop\\2007\\";
	public static void main(String[] args) {
		for (int i = 1; i < 32; i++) {
			String ktrPath = HOME_PATH + "2007_" + i + ".ktr";
			System.out.println("开始执行转换[" + ktrPath + "]。");
			cvt(ktrPath);
		}

	}
	
	/**
	 * 调起Ktr去执行转换
	 * @param ktrPath
	 */
	public static void cvt(String ktrPath) {
		Trans trans = null;
		try {
			KettleEnvironment.init(false);
			// 初始化
			EnvUtil.environmentInit();
			TransMeta transMeta = new TransMeta(ktrPath);
			// 转换
			trans = new Trans(transMeta);
			trans.getLogChannel().setLogLevel(LogLevel.ERROR);
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
