package links.broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.net.ssl.HttpsURLConnection;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test(enabled = false)
	public void brokenLinks() throws IOException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.google.co.in/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int size = allLinks.size();
		System.out.println("No of links present in page : " + size);

		ListIterator<WebElement> listIterator = allLinks.listIterator();
		if (listIterator.hasNext()) {

			WebElement next = listIterator.next();
			String attribute = next.getAttribute("href");
			URL u = new URL(attribute);
			URLConnection openConnection = u.openConnection();
			HttpsURLConnection hc = (HttpsURLConnection) openConnection;
			int responseCode = hc.getResponseCode();
			if (responseCode >= 200 && responseCode <= 299) {
				System.out.println("Valid link : " + attribute);

			} else {
				System.out.println("Not a valid link : " + attribute);
			}
		}

		/*
		 * int size = allLinks.size(); System.out.println("Total links in page " +
		 * size);
		 * 
		 * ListIterator<WebElement> listIterator = allLinks.listIterator(); ;int count =
		 * 0;int count1=0; while(listIterator.hasNext()) {
		 * 
		 * WebElement link = listIterator.next(); String attribute =
		 * link.getAttribute("href"); URL u = new URL(attribute); URLConnection
		 * openConnection = u.openConnection(); HttpsURLConnection hc =
		 * (HttpsURLConnection)openConnection; int responseCode = hc.getResponseCode();
		 * 
		 * if (responseCode >=200 && responseCode <=299) {
		 * System.out.println("Valid link " + attribute); count++; } else {
		 * System.out.println("Invalid Link " + attribute); count1++; } }
		 */

		driver.close();
	}

}
