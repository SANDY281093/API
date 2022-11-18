package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.profilepic.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC6_ChangeProfilePicStep extends BaseClass {

	Response response;
	

	@Given("User add header and bearer authorization accessing for changeProfilePic endpoint")
	public void userAddHeaderAndBearerAuthorizationAccessingForChangeProfilePicEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","multipart/form-data");
		Header h3=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		listHeader.add(h1);
		listHeader.add(h2);	
		listHeader.add(h3);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);

	 
	}
	@When("User add form data for change profile picture")
	public void userAddFormDataForChangeProfilePicture() {
		addForm("profile_picture", new File("C:\\Users\\PRADEEP KUMAR\\eclipse-workspace\\Api\\Images\\god-vinayagar-png-images-4593005.png"));
	 
	}
	@When("User send {string} request for changeProfilePic endpoint")
	public void userSendRequestForChangeProfilePicEndpoint(String type) {
		response=requestType(type, Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	    
	}
	@Then("User verify should the changeProfilePic response message matches {string}")
	public void userVerifyShouldTheChangeProfilePicResponseMessageMatches(String expMessage) {
		
		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo=response.as(ChangeProfilePic_Output_Pojo.class);
		String message = changeProfilePic_Output_Pojo.getMessage();
		
		Assert.assertEquals("verify Profile updated Successfully",expMessage,message);


	}






}
