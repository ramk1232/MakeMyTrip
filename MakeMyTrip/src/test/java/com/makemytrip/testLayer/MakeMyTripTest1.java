package com.makemytrip.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.makemytrip.baseclass.Baseclass;
import com.makemytrip.pagelayer.Homepage;

public class MakeMyTripTest1 extends Baseclass {
//
    Homepage Hp;
	int testID;
	
    @Test(priority=1)
	public void PopUp() throws InterruptedException {
    	testID = 101;
		System.out.println("test 1 is running");
		Hp = new Homepage(driver);
		Hp.ClsFme();
		String Title = driver.getTitle();
		System.out.println(Title);
		SoftAssert a = new SoftAssert();
		a.assertTrue(true, Title);
	}
	
	@Test(priority=2)
	public void Flex() throws InterruptedException {
		testID = 102;
		System.out.println("test 2 is running");
		Hp = new Homepage(driver);
		Hp.mkeFlx();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		SoftAssert a = new SoftAssert();
		a.assertEquals(url, "https://www.makemytrip.com/");
		a.assertAll();
	}
	
	@Test(priority = 3)
	public void LogoImageTest() {

	    boolean flag = Hp.validateLogo();
	    Assert.assertTrue(flag);
	}
	
	
}
