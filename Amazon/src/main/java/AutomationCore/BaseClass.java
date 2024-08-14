package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	
	public WebDriver driver;
   
	public WebDriver browserInitilization(String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome") )
		{
		driver= new ChromeDriver();
					
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browsername.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else 
		{
			System.out.println("invalid browser");
		}
		return   driver;
	}
	
}
