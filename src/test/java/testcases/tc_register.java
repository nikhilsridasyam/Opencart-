package testcases;


	import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.registerpage;

	@RunWith(Cucumber.class)
	public class tc_register
	{

		WebDriver driver;
		registerpage ring;
		/*public tc_register(WebDriver driver)
		{
			this.driver=driver;
		}*/
	    @Given("^Open application and click on Register link$")
	    public void open_application_and_click_on_register_link() throws Throwable
	    {

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		    driver.get("https://demo.opencart.com/");
		    driver.manage().window().maximize();
		    ring=new registerpage(driver);
		    ring.myaccount();
		    ring.entertoreg();
	    }

	    @When("^the user enters the details and click register$")
	    public void the_user_enters_the_details_and_click_register() throws Throwable
	    {
	    	ring.enterfname("pancha");
			ring.enterlname("pandas");
			ring.entermail("sonicmungii18989@gmail.com");
			ring.enterphone();
			ring.enterpass("ctschennai");
			ring.enterconpass("ctschennai");
	    }

	    @Then("^the system stores the details and automatically logs in$")
	    public void the_system_stores_the_details_and_automatically_logs_in() throws Throwable
	    {
	    	ring.submit();
	    	driver.quit();
	    }

	}


