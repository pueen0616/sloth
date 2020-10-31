package com.sloth.board.vo;

import java.sql.Date;

public class PayVO {
	private int roomNum;
	private Date cardNow;
	private int cardNum;
	public PayVO() {
		super();
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public Date getCardNow() {
		return cardNow;
	}
	public void setCardNow(Date cardNow) {
		this.cardNow = cardNow;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
