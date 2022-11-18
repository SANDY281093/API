package com.pojo.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAddress {
	private int id;
	private String address_code;
	private int user_id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String apartment;
	private String address;
	private int country_id;
	private int state_id;
	private int city_id;
	private String zipcode;
	private Object lat;
	private Object lng;
	@JsonProperty("default")
	private int mydefault;
	private String status;
	private String address_type;
	private String created_at;
	private String updated_at;
	private String city;
	private String state;
	private String country;
	private int is_selected;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress_code() {
		return address_code;
	}
	public void setAddress_code(String address_code) {
		this.address_code = address_code;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Object getLat() {
		return lat;
	}
	public void setLat(Object lat) {
		this.lat = lat;
	}
	public Object getLng() {
		return lng;
	}
	public void setLng(Object lng) {
		this.lng = lng;
	}
	public int getMydefault() {
		return mydefault;
	}
	public void setMydefault(int mydefault) {
		this.mydefault = mydefault;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getIs_selected() {
		return is_selected;
	}
	public void setIs_selected(int is_selected) {
		this.is_selected = is_selected;
	}

}
