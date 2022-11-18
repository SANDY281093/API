package com.pojo.address;

import java.util.ArrayList;

public class GetStateList_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<StateList> data;
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
	public ArrayList<StateList> getData() {
		return data;
	}
	public void setData(ArrayList<StateList> data) {
		this.data = data;
	}
	

}
