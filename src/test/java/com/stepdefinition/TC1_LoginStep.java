package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.globals.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {
	
Response response;
String logtoken;
 static GlobalDatas globalDatas =new GlobalDatas();
      
	@Given("User add header for accessing login endpoint")
	public void userAddHeaderForAccessingLoginEndpoint() {
		addHeader("accept", "application/login");
	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("userName"),getPropertyFileValue("password"));
	}
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String type) {
		response=requestType(type, Endpoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	globalDatas.setStatusCode(statusCode);
	 	}
	@Then("User should verify the login response body first_name present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String expFirst_name) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
	
		Assert.assertEquals("verify first name in login endpoint",expFirst_name,first_name);
	   String logtoken = login_Output_Pojo.getData().getLogtoken();
	   globalDatas.setLogtoken(logtoken);
	   

	}
	











}
