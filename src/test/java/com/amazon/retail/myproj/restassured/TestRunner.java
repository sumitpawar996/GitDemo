package com.amazon.retail.myproj.restassured;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginAPI login = new LoginAPI();
		
		GetBoardAPI board = new GetBoardAPI();
		String url = "http://localhost:9090/rest";
	//	login.LoginWithEmptyUserName();
		
	//login.LoginwithValidCredentials();
	
	//System.out.println(login.cookie);
		
	//	login.LoginWithNullPassword();
		
	//	login.LoginWithEmptyPassword();
		
	//	login.LoginWithNullUserName();
		
		//login.LoginWithInvalidUserName();

	board.getBoard(url);
	}

}
