package pagesObjects;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class LoginPage {
	private WebDriver driver;
	private By titleText;
	private By userField;
	private By passwordField;
	private By loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span");
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");
	}
	
	public void assertLogin(String textMessage) {
		Assert.assertTrue(driver.findElement(titleText).getText().contains(textMessage));
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
	}

	public void login(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/* Helpers helper = new Helpers();
		helper.sleepSecounds(4); */
	}
}
