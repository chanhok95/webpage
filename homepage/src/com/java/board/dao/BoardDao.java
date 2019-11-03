package com.java.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.board.dto.BoardDto;
import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.guest.dto.GuestDto;
import com.sun.media.jfxmedia.logging.Logger;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {

		return instance;
	}

	private BoardDao() {
	}

	public int insert(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;

		writeNumber(conn, boardDto);

		try {
			String sql = "insert into board values(board_board_number_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardDto.getWriter());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getContent().replace("\r\n", "<br/>"));  // java 줄바꿈 \r\n
			pstmt.setString(5, boardDto.getPassword());

			pstmt.setTimestamp(6, new Timestamp(boardDto.getWriteDate().getTime()));
			pstmt.setInt(7, boardDto.getReadCount());
			pstmt.setInt(8, boardDto.getGroupNumber());
			pstmt.setInt(9, boardDto.getSequenceNumber());
			pstmt.setInt(10, boardDto.getSequenceLevel());

			value = pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);

		}

		return value;
	}

	public void writeNumber(Connection conn, BoardDto boardDto) {
		System.out.println(boardDto.toString());
		
		int boardNumber = boardDto.getBoardNumber(); // 0
		int groupNumber = boardDto.getGroupNumber(); // 1
		int sequenceNumber = boardDto.getSequenceNumber(); // 0
		int sequenceLevel = boardDto.getSequenceLevel(); // 0

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {

			if (boardNumber == 0) { // Root-그룹번호
				sql = "select max(group_number)from board";
				conn = ConnetionProvider.getConnetion();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next())
					boardDto.setGroupNumber(rs.getInt(1) + 1);

			} else { 	// 답글 -글순서,글레벨
				
				//그룹 번호가 같으면서 현재 본인 글순서보다 큰번호는 +1 한다.
				sql="update board set sequence_number=sequence_number+1 where group_number=? and sequence_number > ? ";
				conn=ConnetionProvider.getConnetion();
				pstmt=conn.prepareStatement(sql);

				pstmt.setInt(1, groupNumber);
				pstmt.setInt(2, sequenceNumber);
				pstmt.executeUpdate();
				
				boardDto.setSequenceNumber(sequenceNumber+1); //1
				boardDto.setSequenceLevel(sequenceLevel+1);	//1
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

	}

	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			String sql = "select count(*) from board";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return count;
	}

	public ArrayList<BoardDto> getBoardList(int startRow,int endRow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDto> boardList=null;
		
		try {
			
			String sql = "select * from "
					+ "(select rownum rnum,a.*from"
					+ "(select * from board order by  group_number desc, sequence_number asc)a) where rnum >=? and rnum <= ?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
				
				boardList.add(boardDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return boardList;
	}
	
	
	public BoardDto read(int boardNumber) {
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto boardDto = null;
		try {
			conn=ConnetionProvider.getConnetion();
			conn.setAutoCommit(false);   // 선언
			//update
			String sqlUp="update board set read_count=read_count+1 where board_number=?";
			pstmt=conn.prepareStatement(sqlUp);
			pstmt.setInt(1, boardNumber);
			pstmt.executeUpdate();
			if(pstmt !=null) pstmt.close();			// pstmt가 2번 사용되어서 (사용자제뜸)  사용한거 닫고		
					
			
			//select
			String sqlSelect="select * from board where board_number=?";		// java상 오류여도 view 에서 클릭하면 DB에서 조회수가 올라감
			pstmt=conn.prepareStatement(sqlSelect);								// 그러므로 트랜젝션 처리 해줘야됨(오토커밋안되게)db오토커밋 자동체크
			pstmt.setInt(1, boardNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDto =new BoardDto();
				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
			}
				
			conn.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JdbcUtil.rollBack(conn);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		
		return boardDto;
		
	}
	
	public BoardDto update(int boardNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		BoardDto boardDto = null;
		
		try {
			String sql ="select * from board where board_number = ?";
			conn= ConnetionProvider.getConnetion();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return boardDto;
	}
	
	public int updateOk(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check =0;
		
		try {
			String sql="update board set subject=?,email=?,content=? where board_number=?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getEmail());
			pstmt.setString(3, boardDto.getContent());
			pstmt.setInt(4, boardDto.getBoardNumber());
			
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		
		return check;
	}
	
	
	public int delete(int boardNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check= 0;
		
		try {
			String sql = "delete from board where board_number =?";
			conn = ConnetionProvider.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);

			check= pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		
		
		return check;
	}
	
	
}
