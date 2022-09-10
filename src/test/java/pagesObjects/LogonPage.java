package pagesObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class LogonPage {
	private WebDriver driver;	
	private By titleText;
	
	public LogonPage(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");
	}
	
	public void assertLogon(String textMessage) {
		Assert.assertTrue(driver.findElement(titleText).getText().contains(textMessage));
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
	}
}
