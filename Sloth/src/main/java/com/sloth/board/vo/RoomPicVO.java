package com.sloth.board.vo;

import java.sql.Date;

public class RoomPicVO {
   private int lroom_num;
   private String lroom_name;
   private String lroom_address;
   private String lroom_max;
   private String lprice;
   private Date lroom_checkin;
   private Date lroom_checkout;
   private String lroom_info;
   private String lid;
   private String llocation;
   private int lpic_num;   
   private String lpic;
   private String lfirst_yn;
   
   
   public int getLroom_num() {
      return lroom_num;
   }
   public void setLroom_num(int lroom_num) {
      this.lroom_num = lroom_num;
   }
   public String getLroom_name() {
      return lroom_name;
   }
   public void setLroom_name(String lroom_name) {
      this.lroom_name = lroom_name;
   }
   public String getLroom_address() {
      return lroom_address;
   }
   public void setLroom_address(String lroom_address) {
      this.lroom_address = lroom_address;
   }
   public String getLroom_max() {
      return lroom_max;
   }
   public void setLroom_max(String lroom_max) {
      this.lroom_max = lroom_max;
   }
   public String getLprice() {
      return lprice;
   }
   public void setLprice(String lprice) {
      this.lprice = lprice;
   }
   public Date getLroom_checkin() {
      return lroom_checkin;
   }
   public void setLroom_checkin(Date lroom_checkin) {
      this.lroom_checkin = lroom_checkin;
   }
   public Date getLroom_checkout() {
      return lroom_checkout;
   }
   public void setLroom_checkout(Date lroom_checkout) {
      this.lroom_checkout = lroom_checkout;
   }
   public String getLroom_info() {
      return lroom_info;
   }
   public void setLroom_info(String lroom_info) {
      this.lroom_info = lroom_info;
   }
   public String getLid() {
      return lid;
   }
   public void setLid(String lid) {
      this.lid = lid;
   }
   public String getLlocation() {
      return llocation;
   }
   public void setLlocation(String llocation) {
      this.llocation = llocation;
   }
   public int getLpic_num() {
      return lpic_num;
   }
   public void setLpic_num(int lpic_num) {
      this.lpic_num = lpic_num;
   }
   public String getLpic() {
      return lpic;
   }
   public void setLpic(String lpic) {
      this.lpic = lpic;
   }
   public String getLfirst_yn() {
      return lfirst_yn;
   }
   public void setLfirst_yn(String lfirst_yn) {
      this.lfirst_yn = lfirst_yn;
   }
   
   
   
}