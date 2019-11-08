package businesslogic;

import java.io.File;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import output.Finalresult;
import pageobject.PageObject;
import testcases.Testcases;
import filereading.Readingoperation;


public class BusinessLogics extends Testcases{
	
	static PageObject pageobj =null;
	WebDriver driver=null;
	String TC_ID=null;
	Finalresult result = null;
	Readingoperation read=null;
	//String docpath=null;
	
	public BusinessLogics(WebDriver driver,String TC_ID) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.TC_ID=TC_ID;
		//this.docpath=docpath;
		pageobj= new PageObject();
		result = new Finalresult();
		read = new Readingoperation();
		
	}
	
	
	public void login() throws InterruptedException {
		String scrnshotpath ;
		//System.out.println("Login business logic");
		//System.out.println(pageobj.strobject);
		//TakesScreenshot scrnshot= ((TakesScreenshot)driver);
		if(driver.findElement(By.xpath(pageobj.email)).isDisplayed()) {
		driver.findElement(By.xpath(pageobj.email)).sendKeys(read.reading("Username"));
		driver.findElement(By.xpath(pageobj.countinue)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pageobj.username)).sendKeys(read.reading("Username"));
		Thread.sleep(2000);
		WebElement password =driver.findElement(By.name(pageobj.password));
		password.sendKeys(read.reading("Password"));
		Thread.sleep(2000);
		driver.findElement(By.name("checkbox1_lbl")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pageobj.signbutton)).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(pageobj.countinue)).click();
		Thread.sleep(10000);
			/*
			 * if(driver.findElement(By.tagName("h3")).isDisplayed()) {
			 * if((driver.findElement(By.tagName("h3")).getText()).contains(pageobj.
			 * otp_header)) { otp_valaidation(); } } else Thread.sleep(10000);
			 */
		
		//driver.findElement(By.xpath(pageobj.lastname)).sendKeys("Testers");
		//scrnshotpath =screenShotz();
		//driver.findElement(By.xpath(pageobj.submitbut)).click();
		//result.OutputPass(TC_ID,"Scenario one passed",scrnshotpath);
		
		}
		else {
		//scrnshotpath =screenShotz();
		//result.OutputFail(TC_ID,"scerario second failed",scrnshotpath);
			System.out.println("Login failed");
		driver.close();
		}
		
	}
	
	public void otp_valaidation() throws InterruptedException {
		driver.findElement(By.xpath(pageobj.otp)).click();		
		Thread.sleep(10000);
		driver.findElement(By.xpath(pageobj.submitbutton)).click();
		Thread.sleep(15000);
		
	}
	
	public void composeMail() throws InterruptedException {
		Thread.sleep(20000);
		//System.out.println("Home page business logic");
		//System.out.println(pageobj.strobject);
		//TakesScreenshot scrnshot= ((TakesScreenshot)driver);
		//String scrnshotpath;
		
		//if(driver.findElement(By.xpath(pageobj.conmposebutton)).isDisplayed()) {
			driver.findElement(By.xpath(pageobj.conmposebutton)).click();
			Thread.sleep(5000);
			Actions builder=  new Actions(driver);
			WebElement to_mail =driver.findElement(By.xpath(pageobj.compose_to));
			builder.click(to_mail).sendKeys(read.reading("To"));
			builder.perform();
			//to_mail.sendKeys(read.reading("To"));
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 120);
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "pageobj.compose_to"))).sendKeys(read.reading("To"));
			 */
			/*JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", to_mail).*/
			
			driver.findElement(By.xpath(pageobj.subject)).sendKeys(read.reading("Subject"));
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath(pageobj.frame_body)));
			Thread.sleep(5000);
			
			WebElement body=driver.findElement(By.xpath(pageobj.body));
			builder.click(body).sendKeys(read.reading("Main body"));
			builder.perform();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement send_mail = driver.findElement(By.xpath(pageobj.sendMail));
			builder.click(send_mail);
			builder.perform();
			 
		
			}
			
			
		// scrnshotpath =screenShotz();
		 //result.OutputPass(TC_ID,"Scenario second passed",scrnshotpath);
		// driver.close();
		
//		}
		/*
		 * else { //scrnshotpath =screenShotz();
		 * //result.OutputFail(TC_ID,"Scenario second failed",scrnshotpath);
		 * System.out.println("Compose failed"); driver.close(); }
		 */
			

	
	public void  chekdropdown() {
		/*System.out.println("Logout business logic");
		System.out.println(pageobj.strobject);*/
		String scrnshotpath;
		Select dropdonws= new Select(driver.findElement(By.name(pageobj.dropdown)));
		if(driver.findElement(By.name(pageobj.dropdown)).isDisplayed()) {
		 dropdonws.selectByVisibleText("Selenium");
		 scrnshotpath =screenShotz();
		 result.OutputPass(TC_ID,"Scenario Third passed",scrnshotpath);
		 driver.close();
		
		}else {
			 scrnshotpath =screenShotz();
			result.OutputFail(TC_ID,"Scenario Third failed",scrnshotpath);
			driver.close();
		}
	}
	
	public void  chekMulwindow() throws InterruptedException {
		/*System.out.println("Logout business logic");
		System.out.println(pageobj.strobject);*/
		String scrnshotpath;
		
		if(driver.findElement(By.linkText(pageobj.linkingtext)).isDisplayed()) {
			
		driver.findElement(By.linkText(pageobj.linkingtext)).click();
		String defwindow =driver.getWindowHandle();
		Thread.sleep(2000);
		for(String newwindowhandle:driver.getWindowHandles()) {
			
			driver.switchTo().window(newwindowhandle);
			scrnshotpath =screenShotz();
			 result.OutputPass(TC_ID,"New Handle window",scrnshotpath);
			
		}
		 
		 driver.switchTo().window(defwindow);
		 Thread.sleep(2000);
		 scrnshotpath =screenShotz();
		 result.OutputPass(TC_ID,"Switching back to window",scrnshotpath);
		 driver.close();
		
		}else {
			 scrnshotpath =screenShotz();
			result.OutputFail(TC_ID,"Scenario fourth failed",scrnshotpath);
			driver.close();
		}
	}
	
	public String screenShotz() {
		try {
		//Converting the driver object to take screenshot
		TakesScreenshot ts =((TakesScreenshot)driver);
		
		//Creating the file of the screenshot
		File scrnshot = ts.getScreenshotAs(OutputType.FILE);
		
		//Moving the file to new path.
		File screenshotzpath = new File("C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Screenshots/TC_ID.png");
		
		//Copy file at destination
		FileUtils.copyFile(scrnshot, screenshotzpath);
		}
		catch(Exception e) {
			System.out.println("Screenshot catch: "+e);
		}
		String scrnshotpath="C:/Users/SausthavNegi/Desktop/autoscript/Ouput Files_IBM/Screenshots/TC_ID.png";
		return scrnshotpath;
		
		
	}

}
