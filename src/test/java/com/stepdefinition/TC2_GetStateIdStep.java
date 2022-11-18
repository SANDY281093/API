package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.address.GetStateList_Output_Pojo;
import com.pojo.address.StateList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass {
	Response response;

	@Given("User add header for accessing stateList endpoint")
	public void userAddHeaderForAccessingStateListEndpoint() {
		addHeader("accept", "application/login");
	   	}
	@When("User send {string} request for stateList endpoint")
	public void userSendRequestForStateListEndpoint(String type) {
		response=requestType(type, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	    	}
	@Then("User should verify the stateList response body name present as {string} and get the stateId of Tamil Nadu saved")
	public void userShouldVerifyTheStateListResponseBodyNamePresentAsAndGetTheStateIdOfTamilNaduSaved(String expStateName) {
		GetStateList_Output_Pojo getStateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);
		ArrayList<StateList> listState = getStateList_Output_Pojo.getData();
		for (StateList eachStateList : listState) {
			String StateName = eachStateList.getName();
			if (StateName.equals("Tamil Nadu")) {
				int stateId = eachStateList.getId();
				String state_id=String.valueOf(stateId);
				System.out.println(state_id);
				
				
				TC1_LoginStep.globalDatas.setStateId(stateId);
				TC1_LoginStep.globalDatas.setState_Id(state_id);
				
				
				Assert.assertEquals("verify state name is Tamil Nadu",expStateName,StateName);
				break;	
		 }
	  
	 }

  }

}	





