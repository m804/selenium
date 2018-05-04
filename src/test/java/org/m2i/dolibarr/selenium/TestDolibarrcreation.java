package org.m2i.dolibarr.selenium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDolibarrcreation {

	@Test

	public void testCreationTiers() {
		//on instancie le driver
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.testlogiciel.pro/dolibarr");
		driver.findElement(By.id("username")).sendKeys("jsmith");
		driver.findElement(By.id("password")).sendKeys("hp");
		driver.findElement(By.className("button")).click();
		driver.findElement(By.cssSelector("div.mainmenu.companies")).click();
		driver.findElement(By.cssSelector("a.vsmenu")).click();
		driver.findElement(By.name("nom")).sendKeys("tintin");
		driver.findElement(By.name("firstname")).sendKeys("mich");
		new Select(driver.findElement(By.name("civilite_id"))).selectByVisibleText("Docteur");
		driver.findElement(By.name("address")).sendKeys("chez moi");
		driver.findElement(By.name("zipcode")).sendKeys("29000");
		driver.findElement(By.name("town")).sendKeys("brest");
		driver.findElement(By.xpath("//input[@value='Créer tiers']")).click();
		Assert.assertEquals("tinti",driver.findElement(By.cssSelector("td.nobordernopadding")).getText());
		driver.findElement(By.cssSelector("img.login")).click();
		
			}

}
