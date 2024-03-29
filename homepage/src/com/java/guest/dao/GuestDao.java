package com.java.guest.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.guest.dto.GuestDto;
import com.java.member.dto.MemberDto;

public class GuestDao {

	private static GuestDao instance = new GuestDao();

	public static GuestDao getInstance() {
		return instance;
	}

	private GuestDao() {
	}

	public int insert(GuestDto guestDto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;

		try {
			String sql = "insert into guest values(guest_num_seq.nextval,?,?,?,?)";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, guestDto.getName());
			pstmt.setString(2, guestDto.getPassword());
			pstmt.setString(3, guestDto.getMessage());
			pstmt.setTimestamp(4, new Timestamp(guestDto.getWriteDate().getTime()));

			/*
			 * Date d =guestDto.getWriteDate(); long a = d.getTime();
			 * 
			 * Timestamp t = new Timestamp(a); pstmt.setTime(4, t);
			 */
			check = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return check;

	}

	public ArrayList<GuestDto> guestList(int starRow, int endRow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GuestDto> arrayList = null;

		try {
			String sql = " select * from (select rownum as rnum,a.* from(select * from guest order by num desc) a)b where b.rnum >=? and b.rnum <=?";

			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, starRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			arrayList = new ArrayList<GuestDto>();

			while (rs.next()) {
				GuestDto guestDto = new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message"));
				guestDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));

				arrayList.add(guestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return arrayList;
	}

	
	
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count =0;
		
		try {
			String sql = "select count(*) from guest";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1); // count(*) db에 없는 필드이기 때문에 1
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return count;
	}
	
	
	public int delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check= 0;
		
		
		try {
			String sql = "delete from guest where num =?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			check= pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
		
	}
	
	public GuestDto update(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		GuestDto guestDto = null;
		try {
			String sql ="select * from guest where num=?";
			conn= ConnetionProvider.getConnetion();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {		//행많이가져갈때 while문
				guestDto = new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message"));
				guestDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return guestDto;
	}
	
	public int updateOk(GuestDto guestDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check =0;
		try {
			String sql = "update guest set password=?,message=? where num=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, guestDto.getPassword());
			pstmt.setString(2, guestDto.getMessage());
			pstmt.setInt(3, guestDto.getNum());
			check = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}
		return check;
	}
	
}
