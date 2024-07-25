package com.ots.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configread 
{
	/*public static  String getproperty(  String propertyname)
	{
		
		Properties pro=new Properties();
		try {
			pro.load(new FileInputStream( new File("./configfile/config.properties")));
		} catch (FileNotFoundException e) {
			
			System.out.println("File not present"+e.getMessage());
		} catch (IOException e) {
			
			System.out.println("could not load the file");
		}
		String value=pro.getProperty(propertyname);
		
		return value;
	}
	public static String getProperty(String propertyFileName,String propertyName) {

		Properties pro = new Properties();

		try 
		{
			System.out.println("LOG:INFO - Loading  Config File");
			
			pro.load(new FileInputStream(new File("./Config/"+propertyFileName+".properties")));
			
			System.out.println("LOG:INFO - Config File Loaded");

		} catch (FileNotFoundException e) 
		{
			System.out.println("File not present "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file");
		}

		String value=pro.getProperty(propertyName);
		
		return value;
	}*/
	public static String getProperty(String propertyName) {

		Properties pro = new Properties();

		try 
		{
			System.out.println("LOG:INFO - Loading  Config File");
			
			pro.load(new FileInputStream(new File("./configfile/Config.properties")));
			
			System.out.println("LOG:INFO - Config File Loaded");

		} catch (FileNotFoundException e) 
		{
			System.out.println("File not present "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file");
		}

		String value=pro.getProperty(propertyName);
		
		return value;
	}
	
	public static String getProperty(String propertyFileName,String propertyName) {

		Properties pro = new Properties();

		try 
		{
			System.out.println("LOG:INFO - Loading  Config File");
			
			pro.load(new FileInputStream(new File("./Config/"+propertyFileName+".properties")));
			
			System.out.println("LOG:INFO - Config File Loaded");

		} catch (FileNotFoundException e) 
		{
			System.out.println("File not present "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file");
		}

		String value=pro.getProperty(propertyName);
		
		return value;
	}

	


}
