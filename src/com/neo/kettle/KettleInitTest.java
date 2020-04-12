package com.neo.kettle;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class KettleInitTest {

	public static void main(String[] args) {
		String transFileName = "F:\\Eclipse\\TestJava\\Neo\\Projects\\TestJava\\TEST\\testFiles\\testKettleInit.ktr";
		String[] params = null;
		try {
			KettleEnvironment.init();
			System.out.println("Kettle初始化成功！");
			// 初始化
            KettleEnvironment.init();
            // 转换元对象
            TransMeta transMeta = new TransMeta(transFileName);
            
            // 转换对象
            Trans trans = new Trans(transMeta);
            // 设置日志等级(debug非常详细，对于跟踪问题有帮助)
            trans.setLogLevel(LogLevel.DEBUG);
            trans.setLogLevel(LogLevel.ROWLEVEL);
            // 传递参数
            // 执行转换准备执行
            trans.prepareExecution(params);
            // 开启线程并执行
            trans.startThreads();
            // 直接执行（需要传入参数，如果使用该方法。可以不是用prepareExecution。）
            // trans.execute(params);

            Result result = trans.getResult();
            System.out.println(result.getXML());
            trans.execute(params);
            // 等待线程结束
            trans.waitUntilFinished();
            if (trans.getErrors() != 0) {
                    System.out.println("执行转换错误！");
            }
		} catch (KettleException e) {
			e.printStackTrace();
		}

	}

}
