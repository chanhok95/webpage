package com.java.mybatis;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlManager {
	private static SqlSessionFactory sqlsSessionFactory;
	
	public static SqlSessionFactory getInstance() {
		
		try {
		
			String resource ="com/java/mybatis/SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlsSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
				
		
				
		return sqlsSessionFactory;
	}
}
