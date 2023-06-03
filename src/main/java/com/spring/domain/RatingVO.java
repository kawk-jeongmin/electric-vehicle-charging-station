package com.spring.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class RatingVO {
	
	private int rate_id;
	private String rate_score;
	private String rate_content;
	private String rate_img;
	private Date rate_date;
	private int reserve_id;
	private int loc_id;
	private String loc_name;
	private String address;
	private String charge_type;
	private String user_name;
	private String user_phone;
	public int getRate_id() {
		return rate_id;
	}
	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
	}
	public String getRate_score() {
		return rate_score;
	}
	public void setRate_score(String rate_score) {
		this.rate_score = rate_score;
	}
	public String getRate_content() {
		return rate_content;
	}
	public void setRate_content(String rate_content) {
		this.rate_content = rate_content;
	}
	public String getRate_img() {
		return rate_img;
	}
	public void setRate_img(String rate_img) {
		this.rate_img = rate_img;
	}
	public Date getRate_date() {
		return rate_date;
	}
	public void setRate_date(Date rate_date) {
		this.rate_date = rate_date;
	}
	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}
	public int getLoc_id() {
		return loc_id;
	}
	public void setLoc_id(int loc_id) {
		this.loc_id = loc_id;
	}
	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "RatingVO [rate_id=" + rate_id + ", rate_score=" + rate_score + ", rate_content=" + rate_content
				+ ", rate_img=" + rate_img + ", rate_date=" + rate_date + ", reserve_id=" + reserve_id + ", loc_id="
				+ loc_id + ", loc_name=" + loc_name + ", address=" + address + ", charge_type=" + charge_type
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + "]";
	}
	
	
}
