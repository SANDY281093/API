package com.pojo.address;

import java.util.ArrayList;

public class GetCityList_Output_Pojo {
	 private int status;
	 private String message;
	 private ArrayList<CityList> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<CityList> getData() {
		return data;
	}
	public void setData(ArrayList<CityList> data) {
		this.data = data;
	}
	 

}
