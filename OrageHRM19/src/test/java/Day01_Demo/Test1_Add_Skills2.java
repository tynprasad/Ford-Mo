package Day01_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Add_Skills2 {
	
	static WebDriver driver;
	
	
  @Test
  public void AddSkills() throws Exception{
	  
	  Test1_Add_Skills2.OpenChromeBrowser();
	  Test1_Add_Skills2.OpenOrangeHRM();
	  Test1_Add_Skills2.Login();
	  Test1_Add_Skills2.AddSkill();
	  Test1_Add_Skills2.CloseBrowser();
		  
  }
  
  
  public static void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
 public static void OpenOrangeHRM() throws Exception{
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
 public static void Login() throws Exception{
	  
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
 }
 
 public static void AddSkill() throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Java11");
		findElement(By.id("skill_description")).sendKeys("Java11 descr");
		findElement(By.id("btnSave")).click();
 }
 
 public static void CloseBrowser() throws Exception{
		driver.quit();
 }
 
 
  
  public static  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
}
