package com.amazon.retail.myproj.utilies;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseUtilities 
{
	// validate status code and line
	public void verifyStatusCodeOk(Response resp)
	{
			Assert.assertEquals(resp.getStatusCode(), 200);
			Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200" );
	}
	
	public void verifyStatusCodeCreated(Response resp)
	{
		
		Assert.assertEquals(resp.getStatusCode(), 201);
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 201" );
	}
	
	public void verifyStatusCodeNoContent(Response resp)
	{
		
		Assert.assertEquals(resp.getStatusCode(), 204);
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 204" );
	}
	
	// validate resp time
	
	public void VerifyResponseTime(Response resp)
	{
		if (resp.getTimeIn(TimeUnit.MILLISECONDS)<1000)
		{
			System.out.println("Response time is correct" +resp.getTimeIn(TimeUnit.MILLISECONDS));
		}
		else
		{
			System.out.println("response time is slow");
		}
	
		
	}
	
	public void verifyHeaders (Response resp, String headerName)
	{
		Assert.assertTrue(resp.getHeaders().hasHeaderWithName(resp.getHeader(headerName)));
	}
	
}
