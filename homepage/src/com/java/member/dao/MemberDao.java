package com.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.guest.dto.GuestDto;
import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;

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

	private MemberDao() {
	} // default 생성자를 private로 만듬

	public int insert(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;

		try {
			String sql = "insert into member values" + "(member_num_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // 13개의 ? 값

			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getJumin1());
			pstmt.setString(5, memberDto.getJumin2());

			pstmt.setString(6, memberDto.getEmail());
			pstmt.setString(7, memberDto.getZipcode());
			pstmt.setString(8, memberDto.getAddress());
			pstmt.setString(9, memberDto.getJob());
			pstmt.setString(10, memberDto.getMailing());

			pstmt.setString(11, memberDto.getInterest());
			pstmt.setString(12, memberDto.getMemberLevel());
			pstmt.setTimestamp(13, new Timestamp(memberDto.getRegisterDate().getTime())); // DB에서 SYSDATE로 처리해도되지만
																							// java에서 처리 setTimestamp
																							// 정확한시간은 DB가 정확한(SYSDATE)

			check = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return check;
	}

	public int idCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;

		try {
			String sql = "select id from member where id=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next())
				check = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}

	public ArrayList<ZipcodeDto> zipcodeReader(String checkDong) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDto> valueList = null;

		try {
			String sql = "select * from zipcode where dong=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkDong);

			rs = pstmt.executeQuery();

			valueList = new ArrayList<ZipcodeDto>();

			while (rs.next()) {
				ZipcodeDto address = new ZipcodeDto();
				address.setZipcode(rs.getString("zipcode"));
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setRi(rs.getString("ri"));
				address.setBunji(rs.getString("bunji"));

				valueList.add(address);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return valueList;
	}

	public String login(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String value = null;

		try {
			String sql = "select member_level from member where id=? and password=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();
			if (rs.next())
				value = rs.getString("member_level");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}

		return value;
	}

	public MemberDto update(String id) {// 나가는Dto 들어오는 String
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;

		try {
			String sql = "select * from member where id=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNum(rs.getInt("num")); // Dto에 있는 변수 셋팅 DB필드에있는 값 get
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));

				memberDto.setName(rs.getString("name"));
				memberDto.setJumin1(rs.getString("jumin1"));
				memberDto.setJumin2(rs.getString("jumin2"));
				memberDto.setEmail(rs.getString("email"));

				memberDto.setZipcode(rs.getString("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setJob(rs.getString("job"));
				memberDto.setMailing(rs.getString("mailing"));
				memberDto.setInterest(rs.getString("interest"));
				memberDto.setMemberLevel(rs.getString("member_level"));

				memberDto.setRegisterDate(new Date(rs.getTimestamp("register_date").getTime()));
				// pstmt.setTimestamp(13, new Timestamp(memberDto.getRegisterDate().getTime()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return memberDto;
	}

	public int updateOk(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;

		try {
			String sql = "update member set password=?,email=?,zipcode=?,address=?,job=?,mailing=?,interest=? where num=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getPassword());
			pstmt.setString(2, memberDto.getEmail());
			
			pstmt.setString(3, memberDto.getZipcode());
			pstmt.setString(4, memberDto.getAddress());
			pstmt.setString(5, memberDto.getJob());
			
			pstmt.setString(6, memberDto.getMailing());
			pstmt.setString(7, memberDto.getInterest());
			pstmt.setInt(8, memberDto.getNum());

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
	
	public int deleteOk(String id , String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check =0;
		
		try {
			String sql = "delete from member where id = ? and password = ?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			
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