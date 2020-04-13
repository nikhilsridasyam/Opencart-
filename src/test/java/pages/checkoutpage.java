package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrap.Criticalclass;

public class checkoutpage {
	 WebDriver driver;
	 WebElement open,change,ref,chec,bac,logou;
	  public checkoutpage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	  public void opencart() throws IOException
	  {
		driver.findElement(By.xpath("//button[@class='btn btn-inverse bt")).click();
		takeSnap();
		 open=driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]"));
		 open.click();
		 takeSnap();
	  }
	  public void changeQNT(String n)
	  {
		change=driver.findElement(By.xpath("//input[@name='quantity[393311]"));
		change.sendKeys(n);
	  }
	  public void refresh()
	  {
		ref=driver.findElement(By.xpath("//span[@class='input-group-btn']//button[@class='btn btn-primary']"));
		ref.click();
	  }
	  public void checkout_subm() throws IOException
	  {
		chec=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		chec.click();
		takeSnap();
	  }
	  public void backacc()
	  {
		bac=driver.findElement(By.xpath("//ul[@class='list-inline']//a[@class='dropdown-toggle']"));
		bac.click();
	  }
	  public void logout() throws IOException
	  {
		logou=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logou.click();
		takeSnap();
		Criticalclass.logger("successfully order the project");
	  }
	  ExtentReports extent;
		ExtentTest logger;
		{
		extent=new ExtentReports("D:\\CTS chennai\\Open_Cart\\src\\test\\resources\\Extant_reports\\checkout.html",true);
		logger=extent.startTest("test4");
		logger.log(LogStatus.PASS,"login details are added succesfully");
		System.out.println("Scenario: Checkout a product to buy a\r\n" + 
				"Given I am on the shopping cart page \r\n" + 
				"When the user selects the cart and fill all detailes\r\n" + 
				"Then the user checkout with the order fonfrmation\r\n" + 
				"Then the user clicks logout and goes to home page");
		System.out.println("selected the product and added to cart succesfully");
		extent.flush();
		extent.endTest(logger);
		extent.close();
		}
	static int l=1;
	 public void takeSnap() throws IOException{
	    	File scrFile;
			scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile,new File("D:\\CTS chennai\\Open_Cart\\screenshot\\checkout"+l+".jpeg"));
			l++;
	 }

}
