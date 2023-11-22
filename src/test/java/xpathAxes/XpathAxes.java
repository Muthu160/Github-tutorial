package xpathAxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	@Test
	public void xpath() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.facebook.com/");
		WebElement text = driver.findElement(By.xpath("//input[@name=\"email\"]/"
				+ "parent::div/following-sibling::div/"
				+ "child::div[@id='passContainer']/ancestor::form/"
				+ "child::div[@class='_6ltg']/child::button/../"
				+ "following-sibling::div[@class='_6ltj']/"
				+ "child::a/../following-sibling::div[@class='_8icz']/"
				+ "following-sibling::div[@class='_6ltg']/../../../../"
				+ "preceding-sibling::div/child::h2[@class='_8eso']"));
		
		String text2 = text.getText();
		System.out.println(text2);
		Thread.sleep(3000);
		driver.quit();
System.out.println("sucess");

}
}
