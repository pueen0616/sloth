package com.sloth.board.vo;

import java.sql.Date;

public class HostVO {
	private int roomNum;
	private String roomName;
	private String roomAddress;
	private int roomMax;
	private String roomPrice;
	
	private Date roomCheckIn;
	private Date roomCheckOut;
	private String roomInfo;
	private String id;
	private String location;
	
	@Override
	public String toString() {
		return "HostVO [roomNum=" + roomNum + ", roomName=" + roomName + ", roomAddress=" + roomAddress + ", roomMax="
				+ roomMax + ", roomPrice=" + roomPrice + ", roomCheckIn=" + roomCheckIn + ", roomCheckOut="
				+ roomCheckOut + ", roomInfo=" + roomInfo + ", id=" + id + ", location=" + location + "]";
	}

	public HostVO() {
		super();
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public int getRoomMax() {
		return roomMax;
	}

	public void setRoomMax(int roomMax) {
		this.roomMax = roomMax;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Date getRoomCheckIn() {
		return roomCheckIn;
	}

	public void setRoomCheckIn(Date roomCheckIn) {
		this.roomCheckIn = roomCheckIn;
	}

	public Date getRoomCheckOut() {
		return roomCheckOut;
	}

	public void setRoomCheckOut(Date roomCheckOut) {
		this.roomCheckOut = roomCheckOut;
	}

	public String getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
