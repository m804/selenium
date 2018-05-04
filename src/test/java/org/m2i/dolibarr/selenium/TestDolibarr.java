package org.m2i.dolibarr.selenium;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import  org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestDolibarr {
	
	//on instancie le driver
	ChromeDriver driver= new ChromeDriver();
	
	@Before
	public void setup() {		
		driver.get("http://demo.testlogiciel.pro/dolibarr");
		driver.findElement(By.id("username")).sendKeys("jsmith");
		driver.findElement(By.id("password")).sendKeys("hp");
		driver.findElement(By.className("button")).click();
	}
	
	@After
	public void tearDown() {
		driver.findElement(By.cssSelector("img.login")).click();
		driver.close();
	}
	
	@Test
	public void testVerification() {
		Assert.assertEquals("Espace accueil",driver.findElement(By.className("titre")).getText());
	}

	@Test
	public void testCreationTiers() {
		driver.findElement(By.cssSelector("div.mainmenu.companies")).click();
		driver.findElement(By.cssSelector("a.vsmenu")).click();
		driver.findElement(By.name("nom")).sendKeys("aud");
		driver.findElement(By.name("firstname")).sendKeys("mich");
		new Select(driver.findElement(By.name("civilite_id"))).selectByVisibleText("Docteur");
		driver.findElement(By.name("address")).sendKeys("chez moi");
		driver.findElement(By.name("zipcode")).sendKeys("29000");
		driver.findElement(By.name("town")).sendKeys("brest");
		driver.findElement(By.xpath("//input[@value='Créer tiers']")).click();
		Assert.assertEquals("aud",driver.findElement(By.cssSelector("td.nobordernopadding")).getText());
	}

 }
