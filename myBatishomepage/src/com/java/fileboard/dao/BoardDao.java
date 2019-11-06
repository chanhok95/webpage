package com.java.fileboard.dao;

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

import com.java.fileboard.dto.BoardDto;
import com.java.mybatis.SqlManager;
import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static BoardDao getInstance() {

		return instance;
	}

	private BoardDao() {
	}

	public int insert(BoardDto boardDto) {
		int value = 0;

		writeNumber(boardDto);

		try {
			
			if(boardDto.getFilesize() == 0) {
			session = sqlSessionFactory.openSession();
			value = session.insert("fireboardinsert",boardDto);
			boardDto.getContent().replace("\r\n", "</br>");
			session.commit();
			
//				String sql = "insert into board(board_number,writer,subject,email,content,password,write_date,read_count,group_number,sequence_number,sequence_level)" // 테이블 중간에 값이 추가될경우 명시 
//						+ "values(board_board_number_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
//				conn = ConnetionProvider.getConnetion();
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, boardDto.getWriter());
//				pstmt.setString(2, boardDto.getSubject());
//				pstmt.setString(3, boardDto.getEmail());
//				pstmt.setString(4, boardDto.getContent().replace("\r\n" , "<br/>"));  // java 줄바꿈 \r\n
//				pstmt.setString(5, boardDto.getPassword());
//
//				pstmt.setTimestamp(6, new Timestamp(boardDto.getWriteDate().getTime()));
//				pstmt.setInt(7, boardDto.getReadCount());
//				pstmt.setInt(8, boardDto.getGroupNumber());
//				pstmt.setInt(9, boardDto.getSequenceNumber());
//				pstmt.setInt(10, boardDto.getSequenceLevel());
				
				

			}else {
				session= sqlSessionFactory.openSession();
				value = session.insert("fireboardinser",boardDto);
				session.commit();
				/*
				 * String sql =
				 * "insert into board(board_number,writer,subject,email,content,password,write_date,read_count,group_number,sequence_number,sequence_level,file_name,path,file_size)"
				 * // 테이블 중간에 값이 추가될경우 명시 +
				 * "values(board_board_number_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //insert
				 * into board values(board_board_number_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?,
				 * ?, ?, ?, ?) conn = ConnetionProvider.getConnetion(); pstmt =
				 * conn.prepareStatement(sql);
				 * 
				 * pstmt.setString(1, boardDto.getWriter()); pstmt.setString(2,
				 * boardDto.getSubject()); pstmt.setString(3, boardDto.getEmail());
				 * pstmt.setString(4, boardDto.getContent().replace("\r\n", "<br/>")); // java
				 * 줄바꿈 \r\n pstmt.setString(5, boardDto.getPassword());
				 * 
				 * pstmt.setTimestamp(6, new Timestamp(boardDto.getWriteDate().getTime()));
				 * pstmt.setInt(7, boardDto.getReadCount()); pstmt.setInt(8,
				 * boardDto.getGroupNumber()); pstmt.setInt(9, boardDto.getSequenceNumber());
				 * pstmt.setInt(10, boardDto.getSequenceLevel());
				 * 
				 * pstmt.setString(11, boardDto.getFilename()); pstmt.setString(12,
				 * boardDto.getPath()); pstmt.setLong(13, boardDto.getFilesize());
				 */
			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}

		return value;
	}

	public void writeNumber( BoardDto boardDto) {
//		System.out.println(boardDto.toString());
		
		int boardNumber = boardDto.getBoardNumber(); // 0
		int groupNumber = boardDto.getGroupNumber(); // 1
		int sequenceNumber = boardDto.getSequenceNumber(); // 0
		int sequenceLevel = boardDto.getSequenceLevel(); // 0
	
		
		try {
			if (boardNumber == 0) {
			session = sqlSessionFactory.openSession();
			int max=session.selectOne("fileboardWriteNumber");
				if(max != 0 ){
					boardDto.setGroupNumber(max+1);
				}
			/*
			 * 
			 * if (boardNumber == 0) { // Root-그룹번호 sql =
			 * "select max(group_number)from board"; conn =
			 * ConnetionProvider.getConnetion(); pstmt = conn.prepareStatement(sql); rs =
			 * pstmt.executeQuery(); if (rs.next()) boardDto.setGroupNumber(rs.getInt(1) +
			 * 1);
			 * 
			 * } else { // 답글 -글순서,글레벨
			 * 
			 * //그룹 번호가 같으면서 현재 본인 글순서보다 큰번호는 +1 한다.
			 * sql="update board set sequence_number=sequence_number+1 where group_number=? and sequence_number > ? "
			 * ; conn=ConnetionProvider.getConnetion(); pstmt=conn.prepareStatement(sql);
			 * 
			 * pstmt.setInt(1, groupNumber); pstmt.setInt(2, sequenceNumber);
			 * pstmt.executeUpdate();
			 * 
			 * boardDto.setSequenceNumber(sequenceNumber+1); //1
			 * boardDto.setSequenceLevel(sequenceLevel+1); //1
			 * 
			 * }
			 * 
			 */
			}else {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("groupNumber", groupNumber);
				map.put("sequenceNumber", sequenceNumber);
				session = sqlSessionFactory.openSession();
				session.update("fileboardupdateNumber",map);
				session.commit();
				boardDto.setSequenceNumber(sequenceNumber+1);
				boardDto.setSequenceLevel(sequenceLevel+1);
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			/*
			 * JdbcUtil.close(rs); JdbcUtil.close(pstmt); JdbcUtil.close(conn);
			 */}

	}

	public int getCount() {
	
		int count = 0;

		try {
			session= sqlSessionFactory.openSession();
			count = session.selectOne("fileboardCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return count;
	}

	public List<BoardDto> getBoardList(int startRow,int endRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<BoardDto> boardList=null;
		
		try {
			session = sqlSessionFactory.openSession();
			boardList = session.selectList("fireboardList",map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return boardList;
	}
	
	
	public BoardDto read(int boardNumber) {
		BoardDto boardDto = null;
		try {
			session = sqlSessionFactory.openSession();
			session.update("fileboardreadupdate",boardNumber);
			session.commit();
			
		boardDto = session.selectOne("fileboardreadselect", boardNumber);
			
//			conn=ConnetionProvider.getConnetion();
//			conn.setAutoCommit(false);   // 선언
//			//update
//			String sqlUp="update board set read_count=read_count+1 where board_number=?";
//			pstmt=conn.prepareStatement(sqlUp);
//			pstmt.setInt(1, boardNumber);
//			pstmt.executeUpdate();
//			if(pstmt !=null) pstmt.close();			// pstmt가 2번 사용되어서 (사용자제뜸)  사용한거 닫고		
//					
//			
//			//select
//			String sqlSelect="select * from board where board_number=?";		// java상 오류여도 view 에서 클릭하면 DB에서 조회수가 올라감
//			pstmt=conn.prepareStatement(sqlSelect);								// 그러므로 트랜젝션 처리 해줘야됨(오토커밋안되게)db오토커밋 자동체크
//			pstmt.setInt(1, boardNumber);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				boardDto =new BoardDto();
//				boardDto.setBoardNumber(rs.getInt("board_number"));
//				boardDto.setWriter(rs.getString("writer"));
//				boardDto.setSubject(rs.getString("subject"));
//				boardDto.setEmail(rs.getString("email"));
//				boardDto.setContent(rs.getString("content"));
//				
//				boardDto.setPassword(rs.getString("password"));
//				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
//				boardDto.setReadCount(rs.getInt("read_count"));
//				boardDto.setGroupNumber(rs.getInt("group_number"));
//				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
//				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
//				
//				boardDto.setFilename(rs.getString("file_name"));
//				boardDto.setPath(rs.getString("path"));
//				boardDto.setFilesize(rs.getLong("file_size"));
//			}
//				
//			conn.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		
		return boardDto;
		
	}
	
	public BoardDto update(int boardNumber) {
		
		BoardDto boardDto = null;
		
		try {
			session= sqlSessionFactory.openSession();
			boardDto = session.selectOne("fileboardupdate",boardNumber);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		return boardDto;
	}
	
	public int updateOk(BoardDto boardDto) {
		int check = 0;
		try {
			
			

			if (boardDto.getFilename() == null) { 
				session=sqlSessionFactory.openSession();
				check = session.update("fileupdate",boardDto);
				session.commit();
			}else {
				session=sqlSessionFactory.openSession();
				check = session.update("fileupto",boardDto);
				session.commit();
			}
//				String sql = "update board set subject=?,email=?,content=? where board_number=?";
//				conn = ConnetionProvider.getConnetion();
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, boardDto.getSubject());
//				pstmt.setString(2, boardDto.getEmail());
//				pstmt.setString(3, boardDto.getContent());
//				pstmt.setInt(4, boardDto.getBoardNumber());
//				check = pstmt.executeUpdate();
//
//			} else {
//				String sql = "update board set subject=?,email=?,content=?, file_name=?, path=?, file_size=? where board_number=?";
//				conn = ConnetionProvider.getConnetion();
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, boardDto.getSubject());
//				pstmt.setString(2, boardDto.getEmail());
//				pstmt.setString(3, boardDto.getContent());
//				pstmt.setString(4, boardDto.getFilename());
//				pstmt.setString(5, boardDto.getPath());
//
//				pstmt.setLong(6, boardDto.getFilesize());
//
//				pstmt.setInt(7, boardDto.getBoardNumber());
//
//				check = pstmt.executeUpdate();
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}

		return check;
	}
	
	
	public int delete(int boardNumber) {
	
		int check= 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.delete("filedelete",boardNumber);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
		
		
		return check;
	}
	
	
}
