package java_application;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.checkoutpage;
import pages.loginpage;
import pages.registerpage;
import pages.search_cartpage;

public class bring
{

	public static void main(String args[]) throws IOException
	{
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get("https://demo.opencart.com/");
		    driver.manage().window().maximize();
		    registerpage ring=new registerpage(driver);
		    ring=new registerpage(driver);
		    ring.myaccount();
		    ring.entertoreg();
		    ring.enterfname("pancha");
		    ring.enterlname("pandas");
			ring.entermail("sonicmungii8989@gmail.com");
			ring.enterphone();
			ring.enterpass("ctschennai");
			ring.enterconpass("ctschennai");
			ring.submit();
			loginpage log=new loginpage(driver);
			 log.enterlogin();
		    log.entermail("sonicmungii9909@gmail.com");
		    	log.enterpasswd("ctschennai");
		    	log.submit_click();
		    	log.log_out();
		    search_cartpage obj= new search_cartpage(driver);

	    	 obj.searchname("HTC touch HD");
		        obj.searchdone(); 
		        obj.addingto_cart();
		       checkoutpage check= new checkoutpage(driver);
		       check.opencart();
		       check.changeQNT("2");
			      check.refresh();
			      check.checkout_subm();
			      check.backacc();
			       check.logout();
		        
		    	
	    }
}


