package testcases;

	import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.checkoutpage;

	@RunWith(Cucumber.class)
    public class tc_checkout
    {
 
		WebDriver driver;
		checkoutpage check;
		@Given("^I am on the shopping cart page $")
	    public void i_am_on_the_shopping_cart_page() throws Throwable {
	    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			 driver.get("https://demo.opencart.com/");
			 driver.manage().window().maximize();
			 check= new checkoutpage(driver);
			 check.opencart();
	    }

	    @When("^the user selects the cart and fill all detailes$")
	    public void the_user_selects_the_cart_and_fill_all_detailes() throws Throwable
	    {
	    	
		      check.changeQNT("2");
		      check.refresh();
	    }

	    @Then("^the user checkout with the order fonfrmation$")
	    public void the_user_checkout_with_the_order_fonfrmation() throws Throwable
	    {
	    	check.checkout_subm();
	    }

	    @Then("^the user clicks logout and goes to home page$")
	    public void the_user_clicks_logout_and_goes_to_home_page() throws Throwable
	    {
	    	 check.backacc();
		       check.logout();
	    }

	 }

