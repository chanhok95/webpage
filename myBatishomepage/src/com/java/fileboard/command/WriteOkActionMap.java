package com.java.fileboard.command;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
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

public class WriteOkActionMap implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 보관할 클래스 선언
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 업로드할 클래스 선언
		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> list = upload.parseRequest(request); // request객체가 fatory에 저장
		Iterator<FileItem> iter = list.iterator();

		BoardDto boardDto = new BoardDto();
		
		HashMap<String, String> dataMap = new HashMap<String, String>();
		

		while (iter.hasNext()) {
			FileItem fileItem = iter.next();

			if (fileItem.isFormField()) { // text
				
				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");
				dataMap.put(name, value);
				
			} else { // binary
				if (fileItem.getFieldName().equals("file")) {

					if (fileItem.getName() == null || fileItem.getName().equals("")) {
						continue;
					}
						

					String fileName = Long.toString(System.currentTimeMillis()) + "_" + fileItem.getName(); // 파일명
																											// (겹치지않는건
																											// 시간) 파일명이
																											// 겹치면 안되니까
					logger.info(logMsg + "파일명 ->" + fileName);

					upload.setFileSizeMax(1024 * 1024 * 10); // 10메가 까지 받겠다
					long size = fileItem.getSize(); // 파일사이즈

					String dir = "F:\\ch\\MVC\\workspace\\myBatishomepage\\WebContent\\ftp"; // 경로
					File file = new File(dir, fileName);
					
					fileItem.write(file);	//파일 입출력 (파일업로드 라이브러리를 이용해서 한줄로 가능) 
					
					boardDto.setFilename(fileName);
					boardDto.setFilesize(size);
					boardDto.setPath(file.getAbsolutePath());
					}
				}
			}
				
				boardDto.setDataMap(dataMap);
				logger.info(logMsg + boardDto.toString());
				boardDto.setWriteDate(new Date());
				boardDto.setReadCount(0);
				int check = BoardDao.getInstance().insert(boardDto);
				logger.info(logMsg + check);
				request.setAttribute("check", check);
	
			
		


		return "/WEB-INF/view/fileboard/writeOk.jsp";
	}

}
