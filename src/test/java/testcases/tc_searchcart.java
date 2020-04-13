package testcases;



import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import pages.search_cartpage;

@RunWith(Cucumber.class)
public class tc_searchcart
{
	 WebDriver driver;
		search_cartpage obj;
		
  /* public tc_searchcart(WebDriver driver)
    {
		this.driver = driver;
	}*/
    @Given("^I am in HomePage now$")
    public void i_am_in_homepage_now() throws Throwable
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		 obj= new search_cartpage(driver);
    }

    @Then("^I search a product by category and adding to cart$")
    public void i_search_a_product_by_category_and_adding_to_cart() throws Throwable
    {
    	 obj.searchname("HTC touch HD");
	        obj.searchdone(); 
	        obj.addingto_cart();
	        
    }

}

