package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateuserAddress_Output_Pojo;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {

	Response response;
	@Given("User add header and bearer authorization for accessing addUserAddress endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddUserAddressEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	  
	}
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string} and {string},{string},{string}")
	public void userAddRequestBodyForAddNewAddressAnd(String string, String string2, String string3, String string4, String state_id, String cityId, String string7, String string8, String string9, String string10) {
		AddUserAddress_Input_Pojo  addUserAddress_Input_Pojo=new AddUserAddress_Input_Pojo("SANTHOSH KUMAR","S","9489689561","MS",TC1_LoginStep.globalDatas.getStateId(),TC1_LoginStep.globalDatas.getCityId(),103,"TRICHY","621211","Home");
		addBody(addUserAddress_Input_Pojo);
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String type) {
		response=requestType(type, Endpoints.ADDADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);
    
	}
	@Then("User verify should the addUserAddress response message matches {string} and get the addressId")
	public void userVerifyShouldTheAddUserAddressResponseMessageMatchesAndGetTheAddressId(String expMessage) {
		AddUserAddress_Output_Pojo 	addUserAddress_Output_Pojo =response.as(AddUserAddress_Output_Pojo.class ); 
		String message = addUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		int id = addUserAddress_Output_Pojo.getAddress_id();
		String address_id = String.valueOf(id);	
		System.out.println(id);
		TC1_LoginStep.globalDatas.setAddress_id(address_id);
Assert.assertEquals("verify Address added successfully", expMessage,message);
	}

	@Given("User add header and bearer authorization  for accessing  updateUserAddress endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingUpdateUserAddressEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);

	}
	@When("User add request body for update existing address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateExistingAddressAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Poj=new UpdateUserAddress_Input_Pojo(TC1_LoginStep.globalDatas.getAddress_id(),"SANDY","S","9489689561","MS",TC1_LoginStep.globalDatas.getStateId(),TC1_LoginStep.globalDatas.getCityId(),103,"621211","TRICHY","Home");
		addBody(updateUserAddress_Input_Poj);
	}
	@When("User send {string} request for updateUserAddress endpoint")
	public void userSendRequestForUpdateUserAddressEndpoint(String type) {
		response=requestType(type, Endpoints.UPDATEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User verify should the updateUserAddress response message matches {string}")
	public void userVerifyShouldTheUpdateUserAddressResponseMessageMatches(String expMessage) {
		UpdateuserAddress_Output_Pojo updateuserAddress_Output_Pojo=response.as(UpdateuserAddress_Output_Pojo.class);
		String message = updateuserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		
		Assert.assertEquals("verify Address updated successfully",expMessage,message);

	}

	

	@Given("User add header and bearer authorization for accessing getUserAddress endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetUserAddressEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	   
	}
	@When("User send {string} request for getUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String type) {
		response=requestType(type, Endpoints.GETADDRESS);  
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	
	}
	@Then("User verify should the getUserAddress response message matches {string}")
	public void userVerifyShouldTheGetUserAddressResponseMessageMatches(String expMessage) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo=response.as(GetUserAddress_Output_Pojo.class);
	    String message = getUserAddress_Output_Pojo.getMessage();
	    System.out.println(message);
	    Assert.assertEquals("verify get address OK",expMessage,message);	

	}
	
	@Given("User add header and bearer authorization  for accessing deleteAddress endpoint")
	public void userAddHeaderAndBearerAuthorizationForAccessingDeleteAddressEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+TC1_LoginStep.globalDatas.getLogtoken());
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h3);
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	    	}
	@When("User add request body for delete user address {string}")
	public void userAddRequestBodyForDeleteUserAddress(String string) {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo=new DeleteUserAddress_Input_Pojo(TC1_LoginStep.globalDatas.getAddress_id());
		addBody(deleteUserAddress_Input_Pojo);
	
	}
	@When("User send {string} request for deleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String type) {
		response=requestType(type, Endpoints.DELETEADDRESS);   
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	   	}
	@Then("User verify should the deleteAddress response message matches {string}")
	public void userVerifyShouldTheDeleteAddressResponseMessageMatches(String expMessage) {

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo=response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();	
		System.out.println(message);
		Assert.assertEquals("verify Address deleted successfully",expMessage,message);	

	}










}
