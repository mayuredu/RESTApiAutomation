package test;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import apiCalls.GET;
import apiCalls.POST;
import base.TestBaseCalls;

public class TestMethods {
	
	public TestBaseCalls get, delete, put;
	public POST post;
	
	@BeforeTest
	public void setUp(){
		get = new GET();
		post = new POST();
		System.out.println("Starting the execution");
	}
	
	@Test(priority=0)
	@Parameters({"uri"})
	public void getGETStatus(String uri){
		get.getStatusCode(uri);
	}
	
	@Test(priority=1)
	@Parameters({"uri"})
	public void getGETJSON(String uri){
		get.getJSONResonse(uri);
	}
	
	@Test(priority=2)
	@Parameters({"uri"})
	public void getGETHeaders(String uri){
		get.getResponseHeaders(uri);
	}
	
	@Test
	@Parameters({"uri"})
	public void getPOSTstatus(String uri){		
		post.getStatusCode(uri);
	}
	
	@Test
	@Parameters({"uri"})
	public void getPOSTJSON(String uri){
		post.getJSONResonse(uri);
	}
	
	@Test
	@Parameters({"uri"})
	public void getPOSTHeaders(String uri){
		post.getResponseHeaders(uri);
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("Completed the execution");
	}

}
