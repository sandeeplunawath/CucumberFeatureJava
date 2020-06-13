package com.testautomation.StepDef;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import com.testautomation.Utility.PropertiesFileReader;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import io.cucumber.datatable.TableEntryTransformer;
import io.cucumber.datatable.TableRowTransformer;
import io.cucumber.datatable.TableTransformer;



public class SearchStepDef {

		
	public static WebDriver driver;
	PropertiesFileReader obj= new PropertiesFileReader();  


	@Given("Open {string} browser and enter url")
	public void open_browser_and_enter_url(String browserName) {
		Properties properties= obj.getProperty();   		 

		if(browserName.toLowerCase().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\libraries\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else if (browserName.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\libraries\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();			
		driver.get(properties.getProperty("browser.baseURL"));

	}

	@When("^Enter search creteria$")
	public void enter_search_creteria() throws Throwable 
	{
		driver.findElement(By.name("userName")).sendKeys("Sandeep Jain");		
		Thread.sleep(1000);	 	    
	}

	@When("Enter UserName {string} and Password {string}")
	public void enter_UserName_and_Password(String userName, String password) {
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("Click on Sign In button")
	public void click_on_Sign_In_button() {
		driver.findElement(By.name("login")).click();
	}


	@Given("Below Numbers is to be calculated.")
	public void below_Numbers_is_to_be_calculated(DataTable   table) {
		List<Map<String, String>> dataSets = table.asMaps(String.class, String.class);
		for(Map<String, String> map:dataSets) {
			for(String key:map.keySet()) {				
				System.out.println(key+":"+map.get(key));
			}
		}
	
		System.out.println("test");
		
	}



	@After
	public void dispose()
	{
		//driver.quit();
	}

}
