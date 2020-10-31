package com.sloth.board.vo;

public class PicVO {
	private int PicNum;
	private String pic;
	private String firstYn;
	private int roomNum;
	public PicVO() {
		super();
	}
	public int getPicNum() {
		return PicNum;
	}
	public void setPicNum(int picNum) {
		PicNum = picNum;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getFirstYn() {
		return firstYn;
	}
	public void setFirstYn(String firstYn) {
		this.firstYn = firstYn;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	

}
