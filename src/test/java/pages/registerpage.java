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

public class registerpage
{

	 WebDriver driver;
	 WebElement regi,fn,ln,email,pass,conpass,subclick,acc;
	 WebElement phone;
	 public registerpage(WebDriver driver)
	 {
		this.driver = driver;
	 }
	 public void myaccount() 
		{
			acc=driver.findElement(By.xpath(" //ul[@class='list-unstyled']//a[contains(text(),'My Account')]"));
			acc.click();
			Criticalclass.logger("you are at home page");
		}
	 public void entertoreg() throws IOException 
	 {
		regi=driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Register')]"));
		regi.click();
		Criticalclass.logger("you are in registrationpage");
		takeSnap();
	 }
	 public void enterfname(String s) 
	 {
		fn=driver.findElement(By.id("input-firstname"));
		fn.sendKeys(s);
	 }
	 public void enterlname(String s)
	 {
		ln=driver.findElement(By.id("input-lastname"));
		ln.sendKeys(s);
	 }
	 public void entermail(String s)
	 {
		email=driver.findElement(By.id("input-email"));
		email.sendKeys(s);
	 }
	 public void enterphone()
	 {
		phone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
		phone.sendKeys("9704668596");
	 }
	 public void enterpass(String s)
	 {
		pass=driver.findElement(By.id("input-password"));
		pass.sendKeys(s);
	 }
	 public void enterconpass(String s) throws IOException
	 {
		 conpass=driver.findElement(By.id("input-confirm"));
		 conpass.sendKeys(s);
		 takeSnap();
	 }
	 public void submit() throws IOException
	 {
		subclick=driver.findElement(By.xpath("//input[@name='agree']"));
		subclick.click();
		subclick=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		subclick.click();
		Criticalclass.logger("successfully entered the detailes");
		takeSnap();
		subclick=driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Logout')]"));
		subclick.click();
		takeSnap();
	 }
	 ExtentReports extent;
		ExtentTest logger;
		{
		extent=new ExtentReports("D:\\CTS chennai\\Open_Cart\\src\\test\\resources\\Extant_reports\\register_report.html",true);
		logger=extent.startTest("Registration");
		logger.log(LogStatus.PASS,"Scenario: Registering new user");
		logger.log(LogStatus.PASS,"Given Open application and click on Register link");
		logger.log(LogStatus.PASS,"When the user enters the details and click register");
		logger.log(LogStatus.PASS,"Then the system stores the details and automatically logs in");
		logger.log(LogStatus.PASS,"registrtation details are added succesfully");
		
		System.out.println("registration details are added succesfully");
		extent.flush();
		extent.endTest(logger);
		extent.close();
		}
		static int i=1;
		 public void takeSnap() throws IOException{
		    	File scrFile;
				scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Files.copy(scrFile,new File("D:\\CTS chennai\\Open_Cart\\screenshot\\register"+i+".jpeg"));
				i++;
		 }

}
