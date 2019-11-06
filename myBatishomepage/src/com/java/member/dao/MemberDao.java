package com.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.guest.dto.GuestDto;
import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;
import com.java.mybatis.SqlManager;

/**
 * @개발자 : 길찬호
 * @작성일 : 2019. 10. 25.
 * @설명 :Data Access object
 */

public class MemberDao {
	// Singleton : 단 한개의 객체만을가지고 구현한다

	private static MemberDao instance = new MemberDao(); // static contance영역에 들어가짐
	
	public static MemberDao getInstance() { // memberDao.getinstance() constance영역에넣어 공유해서 씀 싱글턴 패턴

		return instance;
	}
	
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private SqlSession session; //SqlSessionFactoryBuilder ->sqlsSessionFactory ->  SqlSession
	
	private MemberDao() {
	} // default 생성자를 private로 만듬

	public int insert(MemberDto memberDto) {
	
		int check = 0;

		try {
			session= sqlSessionFactory.openSession();
			check=session.insert("insert",memberDto);
			session.commit(); // 오토커밋이안됨
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return check;
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

	public List<ZipcodeDto> zipcodeReader(String Dong) {

	
		List<ZipcodeDto> valueList = null;

		try {
			
			session=sqlSessionFactory.openSession();
			valueList=session.selectList("zipcode",Dong);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		session.close();
		}

		return valueList;
	}

	public String login(String id, String pwd) {	// String 2개 파라메터 타입 -> Map
		String value = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			map.put("id", id);
			map.put("pwd", pwd);
			
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

	public MemberDto update(String id) {// 나가는Dto 들어오는 String
		MemberDto memberDto = null;

		try {
			session=sqlSessionFactory.openSession();
			memberDto=session.selectOne("select",id);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
			
		}

		return memberDto;
	}

	public int updateOk(MemberDto memberDto) {
	
		int check = 0;
		
		
		try {
		session=sqlSessionFactory.openSession();
		check=session.update("memberUp",memberDto);
		session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}

		return check;
	}
	
	public int deleteOk(String id , String pwd) {
		int check =0;
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			map.put("id", id);
			map.put("pwd", pwd);
			session=sqlSessionFactory.openSession();
			check = session.delete("memberdel",map);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
			
		}

		return check;
	}
	

	
}