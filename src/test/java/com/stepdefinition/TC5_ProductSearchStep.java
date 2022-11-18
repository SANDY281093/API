package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.product.ProductSearch_Input_Pojo;
import com.pojo.product.ProductSearch_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class TC5_ProductSearchStep extends BaseClass {

	Response response;

	@Given("User add header for accessing searchProduct endpoint")
	public void userAddHeaderForAccessingSearchProductEndpoint() {
		List<Header>listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","application/json");	
		listHeader.add(h1);
		listHeader.add(h2);	
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	

	}
	@When("User add request body for searchProduct {string}")
	public void userAddRequestBodyForSearchProduct(String string) {
		ProductSearch_Input_Pojo productSearch_Input_Pojo=new  ProductSearch_Input_Pojo("nuts");
		addBody(productSearch_Input_Pojo);

	}
	@When("User send {string} request for searchProduct endpoint")
	public void userSendRequestForSearchProductEndpoint(String type) {
		response=requestType(type, Endpoints.PRODUCTSEARCH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
	TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}
	@Then("User verify should the searchProduct response message matches {string}")
	public void userVerifyShouldTheSearchProductResponseMessageMatches(String expMessage) {
		ProductSearch_Output_Pojo productSearch_Output_Pojo = response.as(ProductSearch_Output_Pojo.class);
		String message = productSearch_Output_Pojo.getMessage();
		Assert.assertEquals("verify OK product search",expMessage,message );
	}




}
