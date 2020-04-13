package wrap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.loginpage;
import pages.registerpage;
import pages.search_cartpage;

public class Testng_class
{
	WebDriver driver;
	
  @Test(priority = 1)
  public void registration() throws Throwable
  {
	  registerpage ring=new registerpage(driver);
	    ring=new registerpage(driver);
	    ring.myaccount();
	    ring.entertoreg();
	    ring.enterfname("pancha");
	    ring.enterlname("pandas");
		ring.entermail("sonicmungii99090@gmail.com");
		ring.enterphone();
		ring.enterpass("ctschennai");
		ring.enterconpass("ctschennai");
		ring.submit();
		
  }
  @Test(priority = 2)
  public void login() throws Throwable
  {
	  loginpage log=new loginpage(driver);
		 log.enterlogin();
	    log.entermail("sonicmungi@gmail.com");
	    	log.enterpasswd("ctschennai");
	    	log.submit_click();
	    	log.log_out();
	
  }
  @Test(priority = 3)
  public void search_cart() throws Throwable
  {
	  search_cartpage obj= new search_cartpage(driver);

	  	 obj.searchname("HTC touch HD");
		        obj.searchdone(); 
		        obj.addingto_cart();
	
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/");
		    driver.manage().window().maximize(); 
  }

  @AfterTest
  public void afterTest()
  {
	  driver.quit();
  }

}
