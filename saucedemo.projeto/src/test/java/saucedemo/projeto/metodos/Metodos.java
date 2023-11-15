package saucedemo.projeto.metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import saucedemo.projeto.drivers.Drivers;
import saucedemo.projeto.elementos.Elementos;

public class Metodos extends Drivers{
	
	Elementos elemento = new Elementos();
	
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}
public void clicar(By elemento) {
	driver.findElement(elemento).click();
}

  public static void validarmsg(By elemento, String msgEsperada) {
	String msgCapturada = driver.findElement(elemento).getText();
     assertEquals(msgEsperada,msgCapturada);
}

public static void takeScreenshot(WebDriver driver, String nomeArquivo) {
	// Converte o driver para um objeto TakesScreenshot
	TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

	// Tira a screenshot como um arquivo
	File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

	try {
		// Copia o arquivo para o destino desejado
		FileUtils.copyFile(screenshotFile, new File(nomeArquivo));
		System.out.println("Screenshot salva em: " + nomeArquivo);
	} catch (Exception e) {
		
	}
}}
