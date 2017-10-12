package com.jamcracker.objectRepository.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class StaticPublicIpPage extends TestBase{
	public StaticPublicIpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='staticIPWrapper']//button//span[text()='Obtain New IP']")
	public WebElement obtainNewIpButton;
	
	

}
