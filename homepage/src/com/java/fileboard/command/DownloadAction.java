package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;

public class DownloadAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		logger.info(logMsg+boardNumber);
		
		BoardDto boardDto = BoardDao.getInstance().update(boardNumber);	//필드가 많으면 jsp에서 그값만 따로 빼와야됨
		logger.info(logMsg+boardDto);
		int index = boardDto.getFilename().indexOf("_")+1;
		String dbName = boardDto.getFilename().substring(index);
		String fileName = new String (dbName.getBytes("utf-8"),"ISO-8859-1");	// 한글처리 ISO~ 를 utf-8로
		
		response.setHeader("content-Disposition","attachment;filename="+fileName); 	//(다운로드창밑에,파일명) 
		response.setContentType("application/octet-stream");		//이진파일을 위한 기본값
		response.setContentLength((int) boardDto.getFilesize());
		
		
		//다운로드 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(boardDto.getPath()));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			while(true) {
				int data=bis.read();
				if(data==-1) break;
				bos.write(data);
						
			}
			bos.flush(); //현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다 (반드시 해주는게 좋음) stream에 남아있는 데이터를 강제로 내보내는 역활 

			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(bos != null) bos.close();
			if(bis != null) bis.close();
		}
		
		
		
		return null;
	}

}
