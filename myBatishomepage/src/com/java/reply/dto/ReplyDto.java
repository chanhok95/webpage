package com.java.reply.dto;

public class ReplyDto {

	private int bunho;
	private String line_reply;
	
	
	public ReplyDto() {}

	public ReplyDto(int bunho, String line_reply) {
		super();
		this.bunho = bunho;
		this.line_reply = line_reply;
	}
	
	
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public String getLine_reply() {
		return line_reply;
	}
	public void setLine_reply(String line_reply) {
		this.line_reply = line_reply;
	}
	@Override
	public String toString() {
		return "ReplyDto [bunho=" + bunho + ", line_reply=" + line_reply + "]";
	}
	
	
	
}
