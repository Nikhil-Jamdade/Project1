package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement globalsearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		globalsearch.sendKeys("Samsung Mobile");
		WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
		searchIcon.click();

		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		System.out.println("Total names: " + productName.size());
		List<WebElement> rupeesymbol = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		System.out.println("Total rupee symbols: " + rupeesymbol.size());
		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		System.out.println("Tota price: " + productPrice.size());
		for (int i = 0; i < productName.size(); i++) {
			System.out.println(productName.get(i).getText() + " " + rupeesymbol.get(i).getText() + productPrice.get(i).getText());
		}
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		FileUtils.copyFile(fileObj, screenshotObj);
		Thread.sleep(1000);
		driver.quit();
	}
}
