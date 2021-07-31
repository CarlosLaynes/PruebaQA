package com.project.scripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class Logout  extends Base{


		/* 
		    Feature: Logout de la página web
		    Como usuario, deseo ingresa a la web mediante un login y luego cerrar sesión
		    
		    Scenario: Ingresar sesión y Cerrar sesión
		    Given: ingresamos usuario y contraseña en la ventana del login
		    When: en la ventana principal damos click a logout
		    Then: se cierra sesión y volvemos a la ventana del login
			
		*/
	
		Properties prop = new Properties();	
		public WebDriver driver;
		
		By userName = By.id("user-name");
		By userPass = By.id("password");
		By ingresar = By.id("login-button");	
		
		By cuadro = By.id("react-burger-menu-btn");
		By logout = By.id("logout_sidebar_link");
		
		public Boolean validador = false;
		
		/*
		 * Constructor que invoca el driver del navegador a utilizar
		 */
		public Logout(WebDriver driver) {
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
		
		public void logout() throws FileNotFoundException, IOException, InterruptedException {		
			
			click(cuadro);
			Thread.sleep(1000);
			click(logout);
			Thread.sleep(2000);
	}	
	
}
