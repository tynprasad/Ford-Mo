package Day01_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Add_Skills_Static_Parameters {
	
	static WebDriver driver;
	
	// Step1 - Global Variables
	static String TestURL="https://opensource-demo.orangehrmlive.com/";
	static String UserName="Admin",Password="admin123";
	static String SkillName="Java16",SkillDescr="Java16 descr";
	
	
	
  @Test
  public void AddSkills() throws Exception{
	  
	 
	  
	  Test1_Add_Skills_Static_Parameters.OpenChromeBrowser();
	  Test1_Add_Skills_Static_Parameters.OpenOrangeHRM(TestURL); //Step2
	  Test1_Add_Skills_Static_Parameters.Login(UserName,Password);  // Step2
	  Test1_Add_Skills_Static_Parameters.AddSkill(SkillName,SkillDescr); //Step2
	  Test1_Add_Skills_Static_Parameters.CloseBrowser();
	
	 
	  
  }
  
  
  
  
  
  public static void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
}
  
  
  
  
  
  
  
  
  
  
 public static void OpenOrangeHRM(String TestURL1) throws Exception{
		driver.get(TestURL1); //Step3
  }
  
 public static void Login(String UserName1,String Password1) throws Exception{
	  
		findElement(By.id("txtUsername")).sendKeys(UserName1); //Step3
		findElement(By.id("txtPassword")).sendKeys(Password1); //Step3
		findElement(By.id("btnLogin")).click();
 }
 
 public static void AddSkill(String SkillName1,String SkillDescr1) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName1);//Step3
		findElement(By.id("skill_description")).sendKeys(SkillDescr1);//Step3
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
