package com.sloth.board.vo;

import java.sql.Date;

public class HostPicVO {
   private int room_num;
   private String room_name;
   private String room_address;
   private String room_max;
   private String room_price;
   private Date room_checkin;
   private Date room_checkout;
   private String room_info;
   private String id;
   private String location;
   private int pic_num;   
   private String pic;
   private String first_yn;
   
@Override
public String toString() {
	return "HostPicVO [room_num=" + room_num + ", room_name=" + room_name + ", room_address=" + room_address
			+ ", room_max=" + room_max + ", room_price=" + room_price + ", room_checkin=" + room_checkin
			+ ", room_checkout=" + room_checkout + ", room_info=" + room_info + ", id=" + id + ", location=" + location
			+ ", pic_num=" + pic_num + ", pic=" + pic + ", first_yn=" + first_yn + "]";
}
public int getRoom_num() {
	return room_num;
}
public void setRoom_num(int room_num) {
	this.room_num = room_num;
}
public String getRoom_name() {
	return room_name;
}
public void setRoom_name(String room_name) {
	this.room_name = room_name;
}
public String getRoom_address() {
	return room_address;
}
public void setRoom_address(String room_address) {
	this.room_address = room_address;
}
public String getRoom_max() {
	return room_max;
}
public void setRoom_max(String room_max) {
	this.room_max = room_max;
}
public String getRoom_price() {
	return room_price;
}
public void setRoom_price(String room_price) {
	this.room_price = room_price;
}
public Date getRoom_checkin() {
	return room_checkin;
}
public void setRoom_checkin(Date room_checkin) {
	this.room_checkin = room_checkin;
}
public Date getRoom_checkout() {
	return room_checkout;
}
public void setRoom_checkout(Date room_checkout) {
	this.room_checkout = room_checkout;
}
public String getRoom_info() {
	return room_info;
}
public void setRoom_info(String room_info) {
	this.room_info = room_info;
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
public int getPic_num() {
	return pic_num;
}
public void setPic_num(int pic_num) {
	this.pic_num = pic_num;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public String getFirst_yn() {
	return first_yn;
}
public void setFirst_yn(String first_yn) {
	this.first_yn = first_yn;
}
   
   
   
}