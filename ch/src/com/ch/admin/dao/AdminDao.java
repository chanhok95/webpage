package com.ch.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ch.admin.dto.AdminDto;
import com.ch.mybatis.SqlManager;

public class AdminDao {
	private static AdminDao instance = new AdminDao();
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private SqlSession session;
	
	
	public static AdminDao getInstance() {
	
		return instance;
	}
	
	private AdminDao() {}
	
	public int insert(AdminDto adminDto) {
		int check = 0;
		try {
			session = sqlSessionFactory.openSession();
			check = session.insert("admininsert",adminDto);
			session.commit();
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return check;
	}
	
	public int getCount() {
		
		int count = 0;

		try {
			session= sqlSessionFactory.openSession();
			count = session.selectOne("adminCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return count;
	}
	
	public List<AdminDto> getBoardList(int startRow,int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<AdminDto> boardList=null;
		
		try {
			session = sqlSessionFactory.openSession();
			boardList = session.selectList("adminboardList",map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return boardList;
	}
	
	
	
}
