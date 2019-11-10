package com.ch.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ch.member.dto.MemberDto;
import com.ch.mybatis.SqlManager;

public class MemberDao {

	private static MemberDao instance = new MemberDao();
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private SqlSession session;
	
	
	public static MemberDao getInstance() {
	
		return instance;
	}
	
	private MemberDao() {}
	
	
	public int insert(MemberDto memberDto) {
		int check = 0;
		try {
			session = sqlSessionFactory.openSession();
			check = session.insert("insert",memberDto);
			session.commit();
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return check;
	}
	
	public String login(String id, String password) {	// String 2개 파라메터 타입 -> Map
		String value = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			map.put("id", id);
			map.put("password", password);
			
			session=sqlSessionFactory.openSession();
			value=session.selectOne("login", map);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}

		return value;
	}
	
	public int idCheck(String id) {
		int check = 0;

		try {
			session=sqlSessionFactory.openSession();
			String checkId = session.selectOne("idcheck",id);
			
			if (checkId != null)
				check = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return check;
	}
	
	
	
}
