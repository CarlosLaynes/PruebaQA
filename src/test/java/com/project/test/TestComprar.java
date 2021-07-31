/**
 * Clase que contiene la llamada al script para el caso de prueba
 * 
 * @author Sergio Urbano
 * @since 02/03/2021
 * @version 1.0
 * 
 */

package com.project.test;

import org.testng.annotations.Test;

import com.project.pom.Excel;
import com.project.pom.RutasGenerales;
import com.project.scripts.Comprar;

import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestComprar {
	
	private WebDriver driver;
	Comprar objCP;
	RutasGenerales ruta;
	Properties prop = new Properties();
	Excel reader;

	/*
	 * Método que invoca al driver del navegador y
	 * la ruta del asplicativo a probar
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		objCP = new Comprar(driver);
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
		
		for(int rowNum = 2; rowNum <=reader.getRowCount("CP001"); rowNum++){
			
			String usuario = reader.getCellData("CP001", "USUARIO", rowNum);
			String pass = reader.getCellData("CP001", "PASS", rowNum);
			String productos = reader.getCellData("CP001", "PRODUCTOS", rowNum);
			String fname = reader.getCellData("CP001", "FNAME", rowNum);
			String lname = reader.getCellData("CP001", "LNAME", rowNum);
			String postal = reader.getCellData("CP001", "POSTAL", rowNum);
			
			objCP.visit(prop.getProperty("URL").trim());
			objCP.recargar();
			
			try {
				objCP.login(usuario, pass);
				objCP.agregar(productos);
				objCP.informacion(fname, lname, postal);
				
				reader.setCellData("CP001", "ESTADOREPOR", rowNum, "PASSED");
				
			}catch(Exception e){		
				reader.setCellData("CP001", "ESTADOREPOR", rowNum, "FAILED");	
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
