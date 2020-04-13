package testcases;



	import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.loginpage;
import wrap.Criticalclass;

	@RunWith(Cucumber.class)
	public class tc_login extends Criticalclass 
	{

		WebDriver driver;
		loginpage logg;
	   // ExtentTest war;
		/*public tc_login(WebDriver driver)
		{
		   this.driver = driver;	
		}*/
	    @Given("^open application and click on login link$")
	    public void open_application_and_click_on_login_link() throws Throwable
	    {
	    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			 driver.get("https://demo.opencart.com/");
			    driver.manage().window().maximize(); 
			    logg=new loginpage(driver);
			   // war = report.startTest("logInTest");
			    logg.myaccount();
			   
	    }

	    @When("^the user enters the valid Email and valid password and click login$")
	    public void the_user_enters_the_valid_email_and_valid_password_and_click_login() throws Throwable
	    {
	        logg.enterlogin();
	    	logg.entermail("sonicmungi@gmail.com");
	    	logg.enterpasswd("ctschennai");
	    	logger("successflly entered email & password");
	    	logg.submit_click();
	    	//war.log(LogStatus.PASS, "Successfully Logged in");
	    	logger("log in successful");
	    	logg.log_out();
	    }

	    @Then("^the system navigates to HOME page $")
	    public void the_system_navigates_to_home_page() throws Throwable
	    {
	    
	    	System.out.println(" now u r in home page");
	    }

	}

	
