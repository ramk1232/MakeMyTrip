package com.makemytrip.pagelayer;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
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

	@FindBy(xpath = "(//div[@class='wrapper-outer']//a//i)[1]")
	private WebElement closeFrame;

	@FindBy(xpath = "//ul[@class='makeFlex font12 headerIconsGap']//li")
	private List<WebElement> mkeFlx;

	@FindBy(xpath = "//a[@class='mmtLogo makeFlex']")
	private WebElement Logo;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
		wait = new WebDriverWait(driver, (10));
	}

	public void ClsFme() {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
			Thread.sleep(3000);
			closeFrame.click();
		} catch (Exception e) {
			System.out.println();
			System.out.println("---------Message is----------" + e.getMessage());
			System.out.println();
		}
	}

	public void mkeFlx() throws InterruptedException {
		System.out.println("_________________________________________");
		for (WebElement s : mkeFlx) {
			Thread.sleep(5000);
			try {
				a.moveToElement(s).build().perform();
				System.out.println(s.getText());
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}
		}
	}

	public boolean validateLogo() {
		return Logo.isDisplayed();
	}
}
