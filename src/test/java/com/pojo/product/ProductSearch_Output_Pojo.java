package com.pojo.product;

import java.util.ArrayList;

public class ProductSearch_Output_Pojo {
	 private int status;
	    private String message;
	    private ArrayList<ProductSearch> data;
	    private String currency;
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
		public ArrayList<ProductSearch> getData() {
			return data;
		}
		public void setData(ArrayList<ProductSearch> data) {
			this.data = data;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
	    
}
