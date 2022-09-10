package pagesObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;


public class ReservationPage {
	
	private WebDriver driver;
	private By titleText;
	private By badgeFlights;
	private By passagersDrop;
	private By fromDrop;
	private By toDrop;
	
	public ReservationPage(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");		
		badgeFlights = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
		passagersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}
	
	public void assertReservation(String textMessage) {
		Assert.assertTrue(driver.findElement(titleText).getText().contains(textMessage));
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
	}
	
	public void selectBadgeFlights() {
		driver.findElement(badgeFlights).click();
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
	}
	
	/* Esperamos que un elemento esté presente en el DOM: */
	public void selectPassgers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passagersDrop));		
		Select selectPasajeros = new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));		
	}
	
	public void selecFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
	
	

}
