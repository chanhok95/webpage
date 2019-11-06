package com.java.board.dao;

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

import com.java.board.dto.BoardDto;
import com.java.db.ConnetionProvider;
import com.java.db.JdbcUtil;
import com.java.mybatis.SqlManager;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
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
			session=sqlSessionFactory.openSession();
			value=session.insert("boardInsert",boardDto);
			session.commit();
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
			
		}

		return value;
	}

	public void writeNumber(BoardDto boardDto) {
		System.out.println(boardDto.toString());
		
		int boardNumber = boardDto.getBoardNumber(); // 0
		int groupNumber = boardDto.getGroupNumber(); // 1
		int sequenceNumber = boardDto.getSequenceNumber(); // 0
		int sequenceLevel = boardDto.getSequenceLevel(); // 0

		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		String sql = null;

		try {

			if (boardNumber == 0) { // Root-그룹번호
				session=sqlSessionFactory.openSession();
				int max= session.selectOne("boardGroupNumberMax");
				
				if(max !=0 ) {
					boardDto.setGroupNumber(max+1);
				}
				
			} else { 	// 답글 -글순서,글레벨
				Map<String,Integer> map = new HashMap<String, Integer>();
				map.put("groupNumber",groupNumber);
				map.put("sequenceNumber",sequenceNumber);

				session=sqlSessionFactory.openSession();
				session.update("boardWriteNumber",map);
				session.commit();
				  //그룹 번호가 같으면서 현재 본인 글순서보다 큰번호는 +1 한다.
				/*
				 * sql="update board set sequence_number=sequence_number+1 where group_number=? and sequence_number > ? "
				 * ; conn=ConnetionProvider.getConnetion(); pstmt=conn.prepareStatement(sql);
				 * 
				 * pstmt.setInt(1, groupNumber); pstmt.setInt(2, sequenceNumber);
				 * pstmt.executeUpdate();
				 * 
				 * boardDto.setSequenceNumber(sequenceNumber+1); //1
				 * boardDto.setSequenceLevel(sequenceLevel+1); //1
				 */		
				boardDto.setSequenceNumber(sequenceNumber+1);
				boardDto.setSequenceLevel(sequenceLevel+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}

	}

	public int getCount() {

		int count = 0;

		try {
			session=sqlSessionFactory.openSession();
			count = session.selectOne("boardCount");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return count;
	}

	public List<BoardDto> getBoardList(int startRow,int endRow) {
		Map<String,Integer> map =new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<BoardDto> boardList=null;
		
		try {
			session=sqlSessionFactory.openSession();
			boardList = session.selectList("boardList",map);
			
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
			
			session=sqlSessionFactory.openSession();
			session.update("updateread",boardNumber);
			session.commit();
		
			
			boardDto = session.selectOne("boardread",boardNumber);
			
			// pstmt가 2번 사용되어서 (사용자제뜸)  사용한거 닫고		
					
			
			//select
			/*String sqlSelect="select * from board where board_number=?";		// java상 오류여도 view 에서 클릭하면 DB에서 조회수가 올라감
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
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));*/
			//}
				
			
			
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
			session = sqlSessionFactory.openSession();
			boardDto =  session.selectOne("selectUpdate",boardNumber); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return boardDto;
	}
	
	
	public int updateOk(BoardDto boardDto) {
		
		int check =0;
		
		try {
			session=sqlSessionFactory.openSession();
			check = session.update("BoardMapperUpdata",boardDto);
			session.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return check;
	}
	
	
	public int delete(int boardNumber) {
		int check= 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.delete("BoardMapperDelete",boardNumber);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		
		
		
		return check;
	}
	
	
}
