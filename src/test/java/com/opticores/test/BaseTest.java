package com.opticores.test;

import org.junit.BeforeClass;

import com.opticores.util.HibernateUtil;


/** A base test class to initialize hibernate
 * 
 * @author anubhav
 *
 */
public class BaseTest {
	
		
	@BeforeClass
	public static void initialize(){
		HibernateUtil.init();
	}
	

}
