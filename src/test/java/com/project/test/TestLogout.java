package com.project.test;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.pom.Excel;
import com.project.pom.RutasGenerales;
import com.project.scripts.Logout;

public class TestLogout {

	private WebDriver driver;
	Logout objCP;
	RutasGenerales ruta;
	Properties prop = new Properties();
	Excel reader;

	/*
	 * Método que invoca al driver del navegador y
	 * la ruta del asplicativo a probar
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		objCP = new Logout(driver);
		prop.load(new FileReader(objCP.rutaProperties()));
		
		if(prop.getProperty("001_NAV").equals("0")) {
			driver = objCP.chromeDriverConnection();
		} 
		
		ruta = new RutasGenerales();
	}

	/*
	 * Método que contiene el test de prueba
	 */
	@Test
	public void test() throws Exception {
		
		//Leer Excel	
		try {reader = new Excel(ruta.rutaInputs());
		}catch (Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <=reader.getRowCount("CP002"); rowNum++){
			
			String usuario = reader.getCellData("CP002", "USUARIO", rowNum);
			String pass = reader.getCellData("CP002", "PASS", rowNum);
			
			objCP.visit(prop.getProperty("URL").trim());
			objCP.recargar();
			
			try {
				objCP.login(usuario, pass);
				objCP.logout();
				
				reader.setCellData("CP002", "ESTADOREPOR", rowNum, "PASSED");
				
			}catch(Exception e){		
				reader.setCellData("CP002", "ESTADOREPOR", rowNum, "FAILED");	
				System.out.println("error: " +e);
			}
			
		}		
		
	}

	/*
	 * Método que culmina el proceso de prueba
	 */
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
