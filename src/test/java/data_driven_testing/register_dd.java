package data_driven_testing;

	import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


	public class register_dd
	{
	    static WebDriver driver;
		public static void main(String[] args) throws BiffException, IOException 
		{
			  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			    driver = new ChromeDriver();
				driver.get("https://demo.opencart.com/");
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'My Account')]")).click();
				String path="D:\\sample.xls";
				FileInputStream fs= new FileInputStream(path);
				Workbook wb= Workbook.getWorkbook(fs);
				Sheet sh=wb.getSheet("Sheet1");
				int row=sh.getRows();
				
				for(int r=0;r<row;r++) 
				{
					driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Register')]")).click();
					
					driver.findElement(By.id("input-firstname")).sendKeys(sh.getCell(0, r).getContents());
					driver.findElement(By.id("input-lastname")).sendKeys(sh.getCell(1, r).getContents());
					driver.findElement(By.id("input-email")).sendKeys(sh.getCell(2, r).getContents());
					driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(sh.getCell(3, r).getContents());
					driver.findElement(By.id("input-password")).sendKeys(sh.getCell(4, r).getContents());
					driver.findElement(By.id("input-confirm")).sendKeys(sh.getCell(4, r).getContents());
					driver.findElement(By.xpath("//input[@name='agree']")).click();
					driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
					driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Logout')]")).click();
				
	
				}		
							  
		 }
	 }
		


