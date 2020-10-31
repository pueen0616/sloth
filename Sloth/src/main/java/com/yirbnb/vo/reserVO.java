package com.yirbnb.vo;

import java.util.Date;

public class reserVO {
private int reserNum; 
private Date reserCheckIn;
private Date reserCheckOut;
private String reserPrice;
private String reserMax;
private String id;
private int roomNum;
private String reserToday;
public reserVO() {
	// TODO Auto-generated constructor stub
}
public int getReserNum() {
	return reserNum;
}
public void setReserNum(int reserNum) {
	this.reserNum = reserNum;
}
public Date getReserCheckIn() {
	return reserCheckIn;
}
public void setReserCheckIn(Date reserCheckIn) {
	this.reserCheckIn = reserCheckIn;
}
public Date getReserCheckOut() {
	return reserCheckOut;
}
public void setReserCheckOut(Date reserCheckOut) {
	this.reserCheckOut = reserCheckOut;
}
public String getReserPrice() {
	return reserPrice;
}
public void setReserPrice(String reserPrice) {
	this.reserPrice = reserPrice;
}
public String getReserMax() {
	return reserMax;
}
public void setReserMax(String reserMax) {
	this.reserMax = reserMax;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getRoomNum() {
	return roomNum;
}
public void setRoomNum(int roomNum) {
	this.roomNum = roomNum;
}
public String getReserToday() {
	return reserToday;
}
public void setReserToday(String reserToday) {
	this.reserToday = reserToday;
}


}
