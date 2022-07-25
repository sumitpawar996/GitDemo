package com.amazon.retail.myproj.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropFileOperation

{
	private FileInputStream fin;
	private String filePath;
	private Properties prop;
	
	
	public PropFileOperation() 
	{
		fin = null;
		filePath = null;
		prop = new Properties();
	}
	
	public Properties getPropertyFile(String Filename) 
	{	
		try {
		    filePath = System.getProperty("user.dir") + File.separator + "Inputfiles"+ File.separator + Filename;
			fin = new FileInputStream(filePath);
			prop.load(fin);
		}
		catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getLocalizedMessage());
		}
		return prop;
	}
}
