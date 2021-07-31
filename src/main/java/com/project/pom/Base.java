/**
 * Clase que contiene m�todos bases de uso para los scripts
 * 
 * @author Sergio Urbano
 * @since 02/12/2020
 * @version 1.0
 * 
 */

package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	
	private WebDriver driver;
	RutasGenerales ruta = new RutasGenerales();	
	
	/*
	 * Constructor que invoca el driver del navegador a utilizar
	 */
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	
	/*
	 * M�todo que obtiene el driver del navegador Chrome
	 */
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", ruta.rutaDriverChrome());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	
	}
	
	/*
	 * M�todo que obtiene el driver del navegador Firefox
	 */
	public WebDriver firefoxDriverConnection() {
		System.setProperty("webdriver.gecko.driver", ruta.rutaDriverFirefox());
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	
	}
	
	/*
	 * M�todo que obtiene el driver del navegador Internet Explorer
	 */
	public WebDriver iExplorerDriverConnection() {
		System.setProperty("webdriver.ie.driver", ruta.rutaDriverIE());
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		return driver;
	
	}
	
	/*
	 * M�todo que obtiene el driver del navegador Microsoft Edge
	 */
	public WebDriver edgeDriverConnection() {
		System.setProperty("webdriver.edge.driver", ruta.rutaDriverEdge());
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
	
	}
	
	/*
	 * M�todo que obtiene el driver del navegador Opera
	 */
	public WebDriver operaDriverConnection() {
		System.setProperty("webdriver.opera.driver", ruta.rutaDriverOpera());
		driver = new OperaDriver();
		driver.manage().window().maximize();
		return driver;
	
	}
	
	/*
	 * M�todo para encontrar un elemento
	 */
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	/*
	 * M�todo para encontrar una lista de elementos
	 */
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	/*
	 * M�todo para obtener el texto de un elemento
	 */
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	/*
	 * M�todo para obtener si el texto de un elemento es vac�o
	 */
	public Boolean getTextEmpty(By locator) {
		return driver.findElement(locator).getText().isEmpty();
	}
	
	/*
	 * M�todo para comparar el texto de un elemento con un valor
	 */
	public Boolean getTextCompare(By locator, String inputText) {
		return driver.findElement(locator).getText().trim().equalsIgnoreCase(inputText);
	}
	
	/*
	 * M�todo para ingresar un valor dentro de un elemento
	 */
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	/*
	 * M�todo para dar clic a un elemento
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	/*
	 * M�todo para validar si se muestra un elemento
	 */
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	/*
	 * M�todo para setear la url de una pagina al driver
	 */
	public void visit(String url) {
		driver.get(url);
	}
	
	/*
	 * M�todo para imrimir un texto en consola
	 */
	public void print(String inputText) {
		System.out.println(inputText);
	}
	
	/*
	 * M�todo que prepara un WebDriverWait
	 * Se utiliza para esperar que se muestr un elemento
	 * o si se puede hacer clic, etc.
	 */
	public WebDriverWait esperarElemento() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;
	}
	
	/*
	 * M�todo que devuelve la ruta del properties
	 * 
	 */
	public String rutaProperties() {
		return ruta.rutaProperties();
	}
	
	/*
	 * M�todo que devuelve la ruta del properties
	 * 
	 */
	public String ruta2Properties() {
		return ruta.ruta2Properties();
	}
	
	/*
	 * M�todo que devuelve la ruta del properties
	 * 
	 */
	public String ruta3Properties() {
		return ruta.ruta3Properties();
	}
	
	/*
	 * M�todo que devuelve la ruta del properties
	 * 
	 */
	public String ruta4Properties() {
		return ruta.ruta4Properties();
	}
	
	public List<WebElement> tablaListadoFilas(By element) {
		WebElement tableProducts = driver.findElement(element);
		
		List<WebElement> tableRows = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableProducts, By.tagName("tr")));
		
		return tableRows;
	}
	
	public List<WebElement> tablaListadoColumas(WebElement tableProducts) {		
		List<WebElement> tableColums = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableProducts, By.tagName("td")));
		
		return tableColums;
	}
	
	/*
	 * M�todo para limpiar un valor dentro de un elemento
	 */
	public void typeClear(By locator) {
		driver.findElement(locator).clear();;
	}
	
	public List<WebElement> listadoPorTag(By element, String tag) {
		WebElement tableProducts = driver.findElement(element);
		
		List<WebElement> tableRows = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableProducts, By.tagName(tag)));
		
		return tableRows;
	}
	
	public static void waitForElementPresent(WebDriver driver, By locator) {
	  	  for (int time = 0; time<=30 ; time++){				  		  
	  		  try{			  			  
	  			 if(isElementPresent(locator, driver)) 
	  			 break;			  			  
	  		  }catch (Exception e){}
	  		  delay(1);
	  		  }
	}
	
	public static boolean isElementPresent(By by, WebDriver driver) {
	      try {
	          driver.findElement(by);
	          return true;
	      } catch (NoSuchElementException e) {
	          return false;
	      }
	}
	
	public static void delay(int n) {	 
		  try {
				Thread.sleep(n*1000);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}	  		
	}
	
	/*
	 * M�todo para refrescar la p�gina
	 */
	public void recargar() {
		driver.navigate().refresh();
	}

}
