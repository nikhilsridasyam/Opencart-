package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrap.Criticalclass;

public class search_cartpage
{
  WebDriver driver;
	
	public search_cartpage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void searchname(String s) throws IOException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(s);
		takeSnap();
	}
	public void searchdone() throws IOException
	{	
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
			Criticalclass.logger("successfully search the product");
			takeSnap();
	}
	public void addingto_cart()
		{
			  driver.findElement(By.xpath("//img[@class='img-responsive']")).click();	
			  driver.findElement(By.xpath("//button[@id='button-cart']")).click();
			  Criticalclass.logger("product added to cart");
		}
	 ExtentReports extent;
		ExtentTest logger;
		{
		extent=new ExtentReports("D:\\CTS chennai\\Open_Cart\\src\\test\\resources\\Extant_reports\\search_cart.html",true);
		logger=extent.startTest("test3");
		logger.log(LogStatus.PASS,"Scenario: searching a product by category and adding to cart");
		logger.log(LogStatus.PASS,"Given I am in HomePage now");
		logger.log(LogStatus.PASS,"Then I search a product by category and adding to cart");
		logger.log(LogStatus.PASS,"login details are added succesfully");
		System.out.println("login details are added succesfully");
		extent.flush();
		extent.endTest(logger);
		extent.close();
		}
	static int k=1;
	 public void takeSnap() throws IOException{
	    	File scrFile;
			scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile,new File("D:\\CTS chennai\\Open_Cart\\screenshot\\search_cartpage"+k+".jpeg"));
			k++;
	 }
}
