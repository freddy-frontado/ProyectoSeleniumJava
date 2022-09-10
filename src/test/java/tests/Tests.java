package tests;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import helpers.Helpers;
import pagesObjects.LoginPage;
import pagesObjects.LogonPage;
import pagesObjects.ReservationPage;



public class Tests {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/newtours/");		
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
	}	
	
	@Test
	public void loginUsuarioRegistrado() {		
		LoginPage pageLogin = new LoginPage(driver);
		pageLogin.login("chencho1234","chencho1234");
		LogonPage pageLogon = new LogonPage(driver);
		pageLogon.assertLogon("Login Successfully");
	}
	
	@Test
	public void loginUsuarioNoRegistrado() {
		LoginPage pageLogin = new LoginPage(driver);
		pageLogin.login("chencho","chencho");
		pageLogin.assertLogin("Enter your userName and password correct");
	}
	
	@Test
	public void buscarPasajeros() {
		/* LoginPage pageLogin = new LoginPage(driver);		
		pageLogin.login("chencho1234","chencho1234");  */
		ReservationPage pageReservation = new ReservationPage(driver);
		pageReservation.selectBadgeFlights();
		Helpers helper = new Helpers();
		helper.sleepSecounds(4);
		// pageReservation.assertReservation("Flight Finder to search");
		pageReservation.selectPassgers(2);
		pageReservation.selecFromPort(3);
		pageReservation.selectToPort("Acapulco");	
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
}
