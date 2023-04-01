package com.spring.domain;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class SearchVO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loc_id;
	private String loc_name;
	private String address;
	private float loc_lat;
	private float loc_lng;
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
	public float getLoc_lat() {
		return loc_lat;
	}
	public void setLoc_lat(float loc_lat) {
		this.loc_lat = loc_lat;
	}
	public float getLoc_lng() {
		return loc_lng;
	}
	public void setLoc_lng(float loc_lng) {
		this.loc_lng = loc_lng;
	}
	
	@Override
	public String toString() {
		return "SearchVO [loc_id=" + loc_id + ", loc_name=" + loc_name + ", address=" + address + ", loc_lat=" + loc_lat
				+ ", loc_lng=" + loc_lng + "]";
	}
	
	

}
