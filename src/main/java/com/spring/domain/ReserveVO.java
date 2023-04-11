package com.spring.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class ReserveVO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reserve_id;
	private int loc_id;
	private String loc_name;
	private String address;
	private String user_name;
	private String user_phone;
	private String charge_type;
	private LocalDateTime reserve_time;

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

	public String getCharge_type() {
		return charge_type;
	}

	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	public LocalDateTime getReserve_time() {
		return reserve_time;
	}

	public void setReserve_time(LocalDateTime reserve_time) {
		this.reserve_time = reserve_time;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserve_id=" + reserve_id + ", loc_id=" + loc_id + ", loc_name=" + loc_name + ", address="
				+ address + ", user_name=" + user_name + ", user_phone=" + user_phone + ", charge_type=" + charge_type
				+ ", reserve_time=" + reserve_time + "]";
	}

}
