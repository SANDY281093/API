package com.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	public static String getProjectLocator() {
		String path = System.getProperty("user.dir");
		return path;
	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream( getProjectLocator() +"\\Config\\Config.properties"));
		return(String) properties.get(key);
	
	}
	public void addForm(String key, File value) {
		reqSpec=reqSpec.multiPart( key, value);

	}
	
	public void addHeader(String key,String value) {
		 reqSpec = RestAssured.given().header(key,value);
	
	}
	public void addHeaders(Headers headers) {
		reqSpec= RestAssured.given().headers(headers);

	}
	public void addBody(Object body) {
		reqSpec=reqSpec.body(body);
	}
	
	public void basicAuth(String userName, String password) {
		reqSpec=reqSpec.auth().preemptive().basic(userName, password);

	}
	public void addPathParam(String key,String value) {
		reqSpec = reqSpec.pathParam(key,value);

	}
	public void addQueryParam(String key,String value) {
		reqSpec = reqSpec.queryParam(key,value);
	}
	public void addbody(String body) {
		reqSpec = reqSpec.body(body);
	}
	public Response requestType(String type, String endPoint) {
		switch(type) {
		case "GET":
		    response= reqSpec.log().all().get(endPoint);
			break;
		case "POST":
		    response= reqSpec.log().all().post(endPoint);
			break;
		case "PUT":
		    response= reqSpec.log().all().put(endPoint);
			break;
		case "DELETE":
		    response= reqSpec.log().all().delete(endPoint);
			break;
		default:
			break;
		}
		return response;
		}
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

}
	

