package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testdata.excelutils;

public class LoginMethod extends excelutils {

	
	public static final String excel_path = "D:\\smoketest";
	public static final String excel_name = "new3.xlsx";
	
	 
	
	@Test (dataProvider="loginurl")
	
	public void loginurl(String URL , String username , String password , String env , String Softcoding ) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\stickers\\chromedriver_win32\\chromedriver.exe");
	   
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		String actualTitle = "JD Edwards";
		
		String expectedTitle = driver.getTitle();
		
		System.out.println(driver.getTitle());
		
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		
			System.out.println("System is up for  "  );
			
			driver.findElement(By.id("User")).sendKeys(username);
			
			driver.findElement(By.id("Password")).sendKeys(password);
			
			driver.findElement(By.xpath("//*[@id=\"mainLoginTable\"]/tbody/tr[7]/td/input")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			
			driver.findElement(By.id("drop_mainmenu")).click();
		 	
		 	driver.findElement(By.id("TE_FAST_PATH_BOX")).sendKeys("p954000");
		 	
		
		 	driver.findElement(By.id("fastPathButton")).click();
		 	
		 	driver.switchTo().frame("e1menuAppIframe");
		 	
		 
		 	driver.findElement(By.id("hc_Add")).click();
		 	
		 	
		 	driver.findElement(By.xpath("//input[@id='C0_14']")).sendKeys("BBHAYA");
		 	
		 	driver.findElement(By.xpath("//input[@id='C0_16']")).sendKeys(env);
		 	
		 	driver.findElement(By.xpath("//textarea[@id='C0_22']")).sendKeys(Softcoding);
		 	
		 
		 	driver.findElement(By.xpath("//input[@id='C0_18']")).sendKeys("ONEVIEW_BIP_CONN");
		 	
		 	
		 	
		 	driver.findElement(By.id("hc_OK")).click();
		 	
		 	
			if (driver.getCurrentUrl().contains("PROTECTED") == true) {
				
				
				System.out.println("Login Successful for JAS ");
			}
			
			else
			{
					
				
				System.out.println("Login failed for JAS " );
			}
		
			//driver.quit();
		
		}
		
			else
			{	System.out.println("System is down for   "  );
			
				//driver.quit();
			}
		
		
		 	
	}
	
	@DataProvider(name="loginurl")
    public Object[][] getDataFromDataprovider() throws Exception{
		 
		Object[][] testObjArray = excelutils.getTableArray("D:\\smoketest\\new3.xlsx","Sheet1");
		 
        return (testObjArray);


    }
		
	}


