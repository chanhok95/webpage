package com.java.fileboard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class WriteOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//보관할 클래스 선언
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//업로드할 클래스 선언
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> list = upload.parseRequest(request); //request객체가 fatory에 저장 
		Iterator<FileItem> iter = list.iterator();
		
		BoardDto boardDto = new BoardDto();
		
		
		while(iter.hasNext()) {
			FileItem fileItem=iter.next();
			
			if(fileItem.isFormField()) {	//text
				if(fileItem.getFieldName().equals("boardNumber")){
					boardDto.setBoardNumber(Integer.parseInt(fileItem.getString()));
					
				}
				if(fileItem.getFieldName().equals("groupNumber")){
					boardDto.setGroupNumber(Integer.parseInt(fileItem.getString()));
				}
				if(fileItem.getFieldName().equals("sequenceNumber")){
					boardDto.setSequenceNumber(Integer.parseInt(fileItem.getString()));
				}
				if(fileItem.getFieldName().equals("sequenceLevel")){
					boardDto.setSequenceLevel(Integer.parseInt(fileItem.getString()));
				}
				if(fileItem.getFieldName().equals("writer")){
					boardDto.setWriter(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("subject")){
					boardDto.setSubject(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("email")){
					boardDto.setEmail(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("content")){
					boardDto.setContent(fileItem.getString("utf-8"));
				}
				if(fileItem.getFieldName().equals("password")){
					boardDto.setPassword(fileItem.getString("utf-8"));
				}
				
			}else {		//binary
				if(fileItem.getFieldName().equals("file")) {
					
					if(fileItem.getName()==null || fileItem.getName().equals("")) continue;
					
					String fileName = Long.toString(System.currentTimeMillis())+"_"+fileItem.getName();	//파일명 (겹치지않는건 시간) 파일명이 겹치면 안되니까
					logger.info(logMsg+"파일명 ->"+fileName);
					
					upload.setFileSizeMax(1024*1024*10); // 10메가 까지 받겠다 
					long size = fileItem.getSize();	//파일사이즈
					
					String dir = "F:\\ch\\MVC\\workspace\\homepage\\WebContent\\ftp";	//경로
					File file=new File(dir,fileName);
					//Client out 서버 input
					
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;
					
					try {
						bis = new BufferedInputStream(fileItem.getInputStream());
						bos = new BufferedOutputStream(new FileOutputStream(file));
						
						while(true) {
							int data = bis.read();
							if(data==-1) break;
							bos.write(data);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(bos != null) bos.close();
						if(bis != null) bis.close();
					}
					
					
					boardDto.setFilename(fileName);
					boardDto.setFilesize(size);
					boardDto.setPath(file.getAbsolutePath());
				}
			}
		}
				boardDto.setWriteDate(new Date());
				boardDto.setReadCount(0);
				int check = BoardDao.getInstance().insert(boardDto);
				logger.info(logMsg+check);
				request.setAttribute("check", check);
			
		
		
		
	return "/WEB-INF/view/fileboard/writeOk.jsp";
	}

}
