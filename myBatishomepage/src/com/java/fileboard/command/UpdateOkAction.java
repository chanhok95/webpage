package com.java.fileboard.command;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		/*
		 * request.setCharacterEncoding("utf-8"); BoardDto boardDto = new BoardDto();
		 * logger.info(logMsg+request.getParameter("boardNumber"));
		 * 
		 * boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber"))
		 * ); boardDto.setEmail(request.getParameter("email"));
		 * boardDto.setContent(request.getParameter("content"));
		 * boardDto.setSubject(request.getParameter("subject"));
		 * 
		 * logger.info(logMsg+boardDto.toString());
		 * 
		 * int check = BoardDao.getInstance().updateOk(boardDto);
		 * 
		 * logger.info(logMsg+check);
		 * 
		 * request.setAttribute("check", check);
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> list = upload.parseRequest(request);  // 
		
		Iterator<FileItem> iter = list.iterator();
		
		HashMap<String, String> dataMap = new HashMap<String, String>();
		BoardDto boardDto =new BoardDto();
		while(iter.hasNext()) {
			FileItem fileItem=iter.next();
			if(fileItem.isFormField()) {
				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");
				dataMap.put(name, value);
			}else {
				
				if(fileItem.getFieldName().equals("file")) {
					String fileName = fileItem.getName();
					
					if(fileName==null || fileName.equals("")) continue;
					String timeName=Long.toString(System.currentTimeMillis())+"_"+fileName;
					upload.setFileSizeMax(1024*1024*10);
					//절대경로
//					String path = "F:\\ch\\MVC\\workspace\\homepage\\WebContent\\ftp";
					
					//상대경로
					File path=new File("c:/pds/");
					path.mkdir();
					
					//if(path.exists() && path.isDirectory()) {
						File file = new File(path,timeName);
						
						fileItem.write(file);
						
						boardDto.setFilename(timeName);
						boardDto.setFilesize(fileItem.getSize());	
						boardDto.setPath(file.getAbsolutePath());
					
//					String path=request.getServletContext().getRealPath("");
						BoardDto readBoard = BoardDao.getInstance().update(Integer.parseInt(dataMap.get("boardNumber")));
						if(readBoard.getFilename() != null) {
								File oldfile = new File(readBoard.getPath());
								if(oldfile.exists() && oldfile.isFile()) {
									oldfile.delete();
								}
							
							}
						}
					}
					
					
				}
		boardDto.setWriteDate(new Date());
		boardDto.setDataMap(dataMap);
		
		int check = BoardDao.getInstance().updateOk(boardDto);
		request.setAttribute("check", check);
		
		
		
		return "/WEB-INF/view/fileboard/updateOk.jsp";
	}

}
