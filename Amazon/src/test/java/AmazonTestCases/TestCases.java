package AmazonTestCases;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TestCases extends BaseClass {

	WebDriver driver;
	@BeforeMethod
	public void initilization()
	{
		driver= browserInitilization("Chrome");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
		
	
	@Test
	public void TC01()
	{
		System.out.println("TEST CASE 1");
		driver.findElement(By.name("field-keywords")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//driver.findElement(By.id("nav-search-submit-button")).submit();
		
		String bradname=driver.findElement(By.xpath("(//span[@class='a-list-item']//ancestor::span)[23]")).getText();
		System.out.println(bradname);
		String brandtagname=driver.findElement(By.xpath("(//span[@class='a-list-item']//ancestor::span)[23]")).getTagName();
		System.out.println(brandtagname);
		String brandclassname=driver.findElement(By.xpath("(//span[@class='a-list-item']//ancestor::span)[23]")).getAttribute("class");
		System.out.println(brandclassname);
		
		//dropdown
		WebElement dropdown=driver.findElement(By.id("s-result-sort-select"));
		Select drp=new Select(dropdown);
		//drp.selectByValue("review-rank");
		//drp.selectByVisibleText("Newest Arrivals");
		drp.selectByIndex(4);
		
		/*
		 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();	
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int prodcount=products.size();
		System.out.println("size= "+prodcount);
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().refresh();
		//driver.navigate().to("https://www.flipkart.com/");
		//driver.close();
		*/
	}
	
	@Test
		public void TC02()
		{
			System.out.println("TC02");
			//driver.navigate().to("https://www.immigration.ca/");
			//driver.findElement((By.xpath("(//div[@class='elementor-button-wrapper']//child::a)[1]"))).click();
			
			driver.navigate().to("https://form.immigration.ca/skilled-worker/");
			driver.findElement(By.id("name")).sendKeys("Athira"); 
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("phone")).sendKeys("123");
			
			WebElement dropdown= driver.findElement(By.id("nationality"));
			Select  drp=new Select(dropdown);
			drp.selectByValue("Albania");
			
			
			
			WebElement dropdown1=driver.findElement(By.id("residence_country"));
			Select drp1=new Select(dropdown1);
			drp1.selectByValue("Albania");
			
			WebElement dropdown2=driver.findElement(By.id("age"));
			Select drp2=new Select(dropdown2);
			drp2.selectByValue("18");
			
			WebElement dropdown3=driver.findElement(By.id("sex"));
			Select drp3=new Select(dropdown3);
			drp3.selectByValue("Female");
		}
	@Test
		public void TC03() throws InterruptedException
		{
			driver.navigate().to("https://www.redbus.in/");
			driver.findElement(By.id("src")).sendKeys("Kochi");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//text[@class='placeHolderMainText'])[1]")).click();
			
			driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");		
			WebElement source=driver.findElement(By.xpath("//div[@id='column-a']"));
			WebElement destination=driver.findElement(By.xpath("//div[@id='column-a']"));			
			Actions action=new Actions(driver);
			//action.dragAndDrop(source, destination);		
			//action.contextClick();//right click 		
			driver.navigate().back();
		    Thread.sleep(2000);			
		 //  action.doubleClick(driver.findElement(By.id("search_button")));		 
		 //  action.moveToElement(driver.findElement(By.xpath("//span[text()='Train Tickets']")));
			
		   driver.findElement(By.id("src")).sendKeys("Kochi");		 
		    Thread.sleep(2000);
		    action.sendKeys(Keys.ARROW_DOWN);
			action.sendKeys(Keys.ENTER);
		     action.build().perform();				
		}
	
	@Test
	
	public void TC04()
	{
		driver.findElement(By.name("field-keywords")).sendKeys("Laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[7]")).click();
		driver.navigate().to("https://form.immigration.ca/skilled-worker/");
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
	}
	
	@Test
	public void TC05() throws Exception
	{
		
		
		boolean searchboxstatus=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		System.out.println(searchboxstatus);
		boolean locationstatus=driver.findElement(By.id("nav-search-submit-button")).isEnabled();
		System.out.println(locationstatus);
		driver.findElement(By.name("field-keywords")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[4]")).click();
		
		String parentwindow =driver.getWindowHandle();
		Set<String> childwindows=driver.getWindowHandles();
		for(String actual:childwindows)
		{
			if(!actual.equalsIgnoreCase(parentwindow))
			{
			driver.switchTo().window(actual);
		    System.out.println(driver.getTitle());
		    Thread.sleep(20000);
			driver.findElement(By.xpath("(//input[@name='submit.add-to-cart'])[2]")).click();
			}
		}
				
		driver.switchTo().window(parentwindow);
		driver.navigate().refresh();
				
	}
	
	@Test
	public void TC06() throws InterruptedException
	{
		driver.get("https://www.immigration.ca/");        

        driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[1]")).click();
        Thread.sleep(20000);
     String parentwindow= driver.getWindowHandle();
        Set<String> childwindows=driver.getWindowHandles();
         for(String actual:childwindows)
        {
               if (!actual.equalsIgnoreCase(parentwindow))
               {
                     driver.switchTo().window(actual);
                     System.out.println(driver.getTitle());
		             Thread.sleep(20000);
                     driver.findElement(By.id("name")).sendKeys("Athira");
                     }
               
               }
      //  driver.switchTo().window(parentwindow);
      //  driver.navigate().refresh(); 
	} 
}
