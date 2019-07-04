package ui;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	private WebDriver driver;

	// REGISTER
	By registerLinkLocator = By.linkText("Crear cuenta");

	By emailLocator = By.name("email");
	By pswLocator = By.name("psw");
	By pswRptLocator = By.name("psw-repeat");

	By registerBtnLocator = By.name("registerBtn");

	// LOGIN
	By unameLocator = By.name("uname");
	By upswLocator = By.name("upsw");
	
	By loginBtnLocator = By.name("loginBtn");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/login-form/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testA() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if (driver.getTitle().equals("Registro")) {
			driver.findElement(emailLocator).sendKeys("usuario@mail.com");
			driver.findElement(pswLocator).sendKeys("administrador");
			driver.findElement(pswRptLocator).sendKeys("administrador");
			Thread.sleep(2000);
			driver.findElement(registerBtnLocator).click();
			Thread.sleep(5000);
		} else {
			System.out.println("Página no encontrada");
		}
		assertEquals("Registrado con éxito", driver.getTitle());
	}
	
	@Test
	public void testB() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(unameLocator).sendKeys("usuario@mail.com");
		driver.findElement(upswLocator).sendKeys("administrador");
		Thread.sleep(2000);
		driver.findElement(loginBtnLocator).click();
		Thread.sleep(5000);
		assertEquals("Bienvenido", driver.getTitle());
	}
	

}
