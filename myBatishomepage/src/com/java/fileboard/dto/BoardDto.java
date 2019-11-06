package com.java.fileboard.dto;

import java.util.Date;
import java.util.HashMap;

public class BoardDto {
	
	private int boardNumber;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String password;
	
	private Date writeDate;
	private int readCount;
	private int groupNumber;
	private int sequenceNumber;
	private int sequenceLevel;
	
	private String filename;
	private String path;
	private long filesize;
	
	
	public BoardDto() {}

	
	private HashMap<String, String> dataMap;

	


	public BoardDto(int boardNumber, String writer, String subject, String email, String content, String password,
			Date writeDate, int readCount, int groupNumber, int sequenceNumber, int sequenceLevel, String filename,
			String path, long filesize) {
		super();
		this.boardNumber = boardNumber;
		this.writer = writer;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.groupNumber = groupNumber;
		this.sequenceNumber = sequenceNumber;
		this.sequenceLevel = sequenceLevel;
		this.filename = filename;
		this.path = path;
		this.filesize = filesize;
	}






	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getSequenceLevel() {
		return sequenceLevel;
	}

	public void setSequenceLevel(int sequenceLevel) {
		this.sequenceLevel = sequenceLevel;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public long getFilesize() {
		return filesize;
	}


	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}



	
	  public HashMap<String, String> getDataMap() { return dataMap; }
	 






	
	  public void setDataMap(HashMap<String, String> dataMap) {
		  
		/*
		 * if(dataMap.get("groupNumber") != null) {
		 * setBoardNumber(Integer.parseInt(dataMap.get("boardNumber")));
		 * setGroupNumber(Integer.parseInt(dataMap.get("groupNumber")));
		 * setSequenceNumber(Integer.parseInt(dataMap.get("sequenceNumber")));
		 * setSequenceLevel(Integer.parseInt(dataMap.get("sequenceLevel")));
		 * 
		 * }
		 */
		  
	  setBoardNumber(Integer.parseInt(dataMap.get("boardNumber")));
	  setGroupNumber(Integer.parseInt(dataMap.get("groupNumber")));
	  setSequenceNumber(Integer.parseInt(dataMap.get("sequenceNumber")));
	  setSequenceLevel(Integer.parseInt(dataMap.get("sequenceLevel")));
	  
	  setWriter(dataMap.get("writer")); setSubject(dataMap.get("subject"));
	  setEmail(dataMap.get("email")); setContent(dataMap.get("content"));
	  setPassword(dataMap.get("password")); }
	 






	@Override
	public String toString() {
		return "BoardDto [boardNumber=" + boardNumber + ", writer=" + writer + ", subject=" + subject + ", email="
				+ email + ", content=" + content + ", password=" + password + ", writeDate=" + writeDate
				+ ", readCount=" + readCount + ", groupNumber=" + groupNumber + ", sequenceNumber=" + sequenceNumber
				+ ", sequenceLevel=" + sequenceLevel + ", filename=" + filename + ", path=" + path + ", filesize="
				+ filesize + "]";
	}

	

	
	
	
	
	
}
