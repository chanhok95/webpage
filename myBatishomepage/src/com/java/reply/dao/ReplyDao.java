package com.java.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.mybatis.SqlManager;
import com.java.reply.dto.ReplyDto;

public class ReplyDao {

	private static ReplyDao instance = new ReplyDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static ReplyDao getInstance() {
		return instance;
	}
	
	private ReplyDao() { //기본 default생성자 막아줌
		
	}

	public int insert(ReplyDto replyDto) {
		int check = 0;

		try {
			session=sqlSessionFactory.openSession();
			check = session.insert("replyWrite",replyDto);
			session.commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return check;
		
	}
	
	public int getBunho() {
		int bunho=0;
		
		try {
			session=sqlSessionFactory.openSession();
			bunho = session.selectOne("replyGetBunho");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bunho;
	}
	public List<ReplyDto> getList() {
		List<ReplyDto> replyList = null;
		
		try {
			session=sqlSessionFactory.openSession();
			replyList=session.selectList("replyList");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return replyList;
	}
	
	public int delete(int bunho) {
		int check=0;
		try {
			session=sqlSessionFactory.openSession();
			check=session.delete("replyDelete",bunho);
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return check;
	}
	
	public ReplyDto update(int bunho) {
		ReplyDto replyDto = null;
		try {
			session=sqlSessionFactory.openSession();
			replyDto=session.selectOne("replySelect",bunho);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			
			
		}

		
		
		return replyDto;
	}
	public int updateOk(ReplyDto replyDto) {
	
		int check =0;
		try {
			session=sqlSessionFactory.openSession();
			check=session.update("replyUpdateOk",replyDto);
			session.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				
			}
		
		return  check;
	}
	
}
