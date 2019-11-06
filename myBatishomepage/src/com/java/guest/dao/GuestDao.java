package com.java.guest.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.guest.dto.GuestDto;
import com.java.member.dto.MemberDto;
import com.java.mybatis.SqlManager;

public class GuestDao {

	private static GuestDao instance = new GuestDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static GuestDao getInstance() {
		return instance;
	}

	private GuestDao() {
	}

	public int insert(GuestDto guestDto) {

		int check = 0;

		try {
			session =sqlSessionFactory.openSession();
			check = session.insert("guestinsert",guestDto);
			session.commit();
			
//			String sql = "insert into guest values(guest_num_seq.nextval,?,?,?,?)";
//			conn = ConnetionProvider.getConnetion();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, guestDto.getName());
//			pstmt.setString(2, guestDto.getPassword());
//			pstmt.setString(3, guestDto.getMessage());
//			pstmt.setTimestamp(4, new Timestamp(guestDto.getWriteDate().getTime()));
//
//			/*
//			 * Date d =guestDto.getWriteDate(); long a = d.getTime();
//			 * 
//			 * Timestamp t = new Timestamp(a); pstmt.setTime(4, t);
//			 */
//			check = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		session.close();
		}

		return check;

	}

	public List<GuestDto> guestList(int starRow, int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("starRow", starRow);
		map.put("endRow",endRow );
		
		List<GuestDto> arrayList = null;

		try {
			session = sqlSessionFactory.openSession();
			arrayList = session.selectList("guestList",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return arrayList;
	}

	
	
	public int getCount() {
	
		int count =0;
		
		try {
			session = sqlSessionFactory.openSession();
			count = session.selectOne("guestCount");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
			
		}

		return count;
	}
	
	
	public int delete(int num) {
	
		int check= 0;
		
		
		try {
			session = sqlSessionFactory.openSession();
			check= session.delete("guestDelete",num);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
		return check;
		
	}
	
	public GuestDto update(int num) {
	
		GuestDto guestDto = null;
		try {
			session = sqlSessionFactory.openSession();
			guestDto = session.selectOne("guestselectUp",num);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return guestDto;
	}
	
	public int updateOk(GuestDto guestDto) {
		int check =0;
		try {
			session = sqlSessionFactory.openSession();
			check = session.update("guestUpdatesel",guestDto);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return check;
	}
	
}
