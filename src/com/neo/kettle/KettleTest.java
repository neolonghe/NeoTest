package com.neo.kettle;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class KettleTest {

	public static void main(String[] args) {
		try {
			//初始化环境
			KettleEnvironment.init();
			//创建DB资源库
			KettleDatabaseRepository repository=new KettleDatabaseRepository();
			DatabaseMeta databaseMeta=new DatabaseMeta("Kettle_MySQL","mysql","jdbc","localhost","kettle_java","3306","name","password");
			//选择资源库
			KettleDatabaseRepositoryMeta kettleDatabaseRepositoryMeta=new KettleDatabaseRepositoryMeta("Kettle","Kettle","Transformation description",databaseMeta);
			repository.init(kettleDatabaseRepositoryMeta);
			//连接资源库
			repository.connect("admin","admin");
			RepositoryDirectoryInterface directoryInterface=repository.loadRepositoryDirectoryTree();
			//选择转换
			TransMeta transMeta=repository.loadTransformation("study05-01",directoryInterface,null,true,null);
			Trans trans=new Trans(transMeta);
			trans.execute(null);
			trans.waitUntilFinished(); //等待直到数据结束
			if(trans.getErrors()>0){
				System.out.println("transformation error!");
			}else{
				System.out.println("transformation successfully.");
			}
		} catch (KettleException e) {
			e.printStackTrace();
		}

	}

}
