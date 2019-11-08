package testcases;

import org.testng.annotations.Test;

import businesslogic.BusinessLogics;
import output.Finalresult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Testcases {
	
	static BusinessLogics bussobj=null;
   static WebDriver driver=null;
   Finalresult result;
public Testcases() {
	// TODO Auto-generated constructor stub
}
	
  
   
  @Test(priority=1)
  public void login() throws InterruptedException {
	  result=new Finalresult();
	  String TC_ID="Login into the Verse";
	//  result.OutputSetup(TC_ID);
	 // System.out.println(docpath);
	  bussobj= new BusinessLogics(driver,TC_ID);
	  System.out.println("Hello Login");
	  bussobj.login();
	  
  }
  
  
  @Test(priority =2)
  public void composeMail() throws InterruptedException {
	  result=new Finalresult();
	  String TC_ID="Compose Mail";
	  result.OutputSetup(TC_ID);
	  bussobj= new BusinessLogics(driver,TC_ID);
	  //System.out.println("Heelo Homepage");
	  bussobj.composeMail();
	  
  }
  /*
  @Test(priority=3)
  public void chekdropdown() {
	  result=new Finalresult();
	  String TC_ID="Verify the all Options availability & item selection in Testing Tools dropdown";
	 result.OutputSetup(TC_ID);
	  bussobj= new BusinessLogics(driver,TC_ID);
	  System.out.println("Hello logout");
	  bussobj. chekdropdown();
  }
  @Test(priority=4)
  public void mulwinodw() throws InterruptedException {
	  result=new Finalresult();
	  String TC_ID="Multiple window handle";
	 result.OutputSetup(TC_ID);
	  bussobj= new BusinessLogics(driver,TC_ID);
	  //System.out.println("Hello logout");
	  bussobj.chekMulwindow();
  }*/
  
  @BeforeTest
  public void beforeMethod() {
	// bussobj.System.setProperty("webdriver.chrome.driver", "C://SAUSTHAV//Software//chromedriver//chromedriver.exe");
	 System.setProperty("webdriver.gecko.driver", "C://Sausthav//Software//gecko0.26//geckodriver.exe");
	 driver =new FirefoxDriver();
	 driver.get("https://mail.notes.na.collabserv.com/verse");
	 driver.manage().window().maximize();
  
  }
}
