package com.opticores.test;

import org.junit.BeforeClass;

import com.opticores.util.HibernateUtil;


public class BaseTest {
	
		
	@BeforeClass
	public static void initialize(){
		HibernateUtil.init();
	}
	

}
