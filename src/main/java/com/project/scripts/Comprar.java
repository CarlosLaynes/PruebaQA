/**
 * Clase que contiene la llamada al script para el caso de prueba 
 *  
 * @author Sergio Urbano
 * @since 02/03/2021
 * @version 1.0
 * 
 */

package com.project.scripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.pom.Base;

public class Comprar extends Base {
	
	
	
	/* 
	    Feature: Comprar productos de SAUDEMO
	    Como usuario, deseo comprar productos desde la página web de SAUDEMO
	    
	    Scenario: Agregar productos y comprarlos
	    Given: una vez logueado en la web, escogemos los productos a comprar
	    When: se agregan los productos al carrito de compras
	    Then: en el carrito podemos finalizar la compra
		
	*/
	
	Properties prop = new Properties();	
	public WebDriver driver;
	
	By userName = By.id("user-name");
	By userPass = By.id("password");
	By ingresar = By.id("login-button");	
	
	By agregar = By.xpath("//button[contains(text(), 'Add to cart')]");	
	
	By carrito = By.id("shopping_cart_container");
	By checkout = By.id("checkout");
	
	By fname = By.id("first-name");
	By lname = By.id("last-name");
	By pcode = By.id("postal-code");
	By continuee = By.id("continue");
	
	By fin = By.id("finish");
	
	public Boolean validador = false;
	
	/*
	 * Constructor que invoca el driver del navegador a utilizar
	 */
	public Comprar(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Método que contiene el caso de la prueba
	 */
	public void login(String usuario, String pass) throws FileNotFoundException, IOException {		
		
			prop.load(new FileReader(rutaProperties()));
		
			type(usuario,userName);
			type(pass,userPass);
			click(ingresar);
			
	}	
	
	public void agregar(String productos) throws FileNotFoundException, IOException, InterruptedException {		
		
		
		int numEntero = Integer.parseInt(productos);
		for (int i = numEntero; i-1 > numEntero - 1 - numEntero; i--) {
			click(agregar);
			Thread.sleep(2000);
		}
		
		click(carrito);
		Thread.sleep(1000);
		click(checkout);
	
}	
	public void informacion(String fnamee, String lnamee, String cpostal) throws FileNotFoundException, IOException, InterruptedException {		
			
		type(fnamee,fname);
		type(lnamee,lname);
		type(cpostal,pcode);
		click(continuee);
		Thread.sleep(1000);

		click(fin);
		Thread.sleep(1000);
		
	}

}
