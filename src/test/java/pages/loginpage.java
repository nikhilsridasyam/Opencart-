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

public class loginpage
{

	WebDriver driver;
	WebElement loginn, mail, password, submit,subclick,acc;

	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void myaccount() throws IOException   {
		
		
		acc=driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'My Account')]"));
		acc.click();
		takeSnap();
		Criticalclass.logger("my account is oppened ryt now");
		
		
	}
	public void enterlogin() throws IOException 
	{
	  loginn=driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Login')]"));
	  loginn.click();
	  takeSnap();
	 Criticalclass.logger("login is openned now");
	}
	public void entermail(String s) throws IOException 
	{
	 mail=driver.findElement(By.xpath("//input[@id='input-email']"));
	 mail.sendKeys(s);
	 takeSnap();
	 Criticalclass.logger("email given");
	}
	public void enterpasswd(String s) throws IOException
	{
	  password=driver.findElement(By.xpath("//input[@id='input-password']"));
	  password.sendKeys(s);
	  takeSnap();
	  Criticalclass.logger("password given");
	}
	public void submit_click() throws IOException 
	{
	  submit = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	  submit.click();
	  takeSnap();
	  Criticalclass.logger("hey u loggedin here");
	  
	}
	public void log_out() throws IOException 
	{  
	  driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Logout')]")).click();
		takeSnap();
		
	}
	
	ExtentReports extent;
	ExtentTest logger;
	{
	extent=new ExtentReports("D:\\CTS chennai\\Open_Cart\\src\\test\\resources\\Extant_reports\\login_report.html",true);
	logger=extent.startTest("Login");
	
	logger.log(LogStatus.PASS,"Scenario: Login to the application");
	
	logger.log(LogStatus.PASS,"Given open application and click on login link");
	
	
	logger.log(LogStatus.PASS,"When the user enters the valid Email and valid password and click login");
	
	logger.log(LogStatus.PASS,"Then the system navigates to HOME page ");
	
	logger.log(LogStatus.PASS,"login details are added succesfully");
	System.out.println("login details are added succesfully");
	extent.flush();
	extent.endTest(logger);
	extent.close();
	//driver.wait(2000);
	}
	static int j=1;
	 public void takeSnap() throws IOException{
	    	File scrFile;
			scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile,new File("D:\\CTS chennai\\Open_Cart\\screenshot\\login"+j+".jpeg"));
			j++;
	 }
}
