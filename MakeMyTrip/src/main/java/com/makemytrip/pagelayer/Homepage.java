package com.makemytrip.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.baseclass.Baseclass;

public class Homepage extends Baseclass {

	WebDriver driver;
	WebDriverWait wait;
	Actions a;

	@FindBy(xpath = "//i[@class='wewidgeticon we_close']")
	private WebElement closeFrame;

	@FindBy(xpath = "//ul[@class='makeFlex font12']/li/div/a/span[2]")
	private List<WebElement> mkeFlx;

	@FindBy(xpath = "//span[@class='chNavText darkGreyText']")
	private List<WebElement> mkeFlxMenu;

	@FindBy(xpath = "//a[@class='mmtLogo makeFlex']")
	private WebElement Logo;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
		wait = new WebDriverWait(driver, (20));
	}

	public void ClsFme() {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
			closeFrame.click();
		} catch (Exception e) {

			System.out.println("---------Cause is----------  " + e.getCause());
			System.out.println();
			System.out.println("---------Message is----------" + e.getMessage());
			System.out.println();
			System.out.println("-------Localized Msg is------" + e.getLocalizedMessage());
//			e.printStackTrace();
		}
	}

	public void mkeFlx() throws InterruptedException {
		System.out.println("_________________________________________");
		for (WebElement s : mkeFlx) {
			Thread.sleep(200);
			a.moveToElement(s).build().perform();
			System.out.println(s.getText());
		}
	}

	public boolean validateLogo() {

		return Logo.isDisplayed();
	}
}
