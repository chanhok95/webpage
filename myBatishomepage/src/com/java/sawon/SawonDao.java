package com.java.sawon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.mybatis.SqlManager;

public class SawonDao {
	
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private SqlSession session;
	

	private static SawonDao instance = new SawonDao();
	
	public static SawonDao getInstance() { 

		return instance;
	}
	
	public List<SawonDto> select(String departmentName) {
		
		List<SawonDto> sawonList = null;
		
		try {
			session=sqlSessionFactory.openSession();
			sawonList=session.selectList("sawonList",departmentName);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return sawonList;
	}
	
}
