package brokenLink.brokenLinkURL;
import java.util.List;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;
import com.google.common.base.Predicate;


//import org.openqa.selenium.*;

//import org.openqa.selenium.firefox.*;

/*public class App {

  public static  List<WebElement> findAllLinks(WebDriver driver)
  {
	  List<WebElement> elementList = new ArrayList<WebElement>();
	  elementList = driver.findElements(By.tagName("a"));
	  elementList.addAll(driver.findElements(By.tagName("img")));
	  List finalList = new ArrayList(); ;
	  for (WebElement element : elementList)
	  {
		  if(element.getAttribute("href") != null)
		  {
			  finalList.add(element);
		  }		  
	  }	
	  return finalList;
  }
	public static  String isLinkBroken(URL url) throws Exception
	{
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		     response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			FirefoxDriver FF = new FirefoxDriver();
			FF.get("https://uk.m.webuy.com/");		    
			List<WebElement> allImages = findAllLinks(FF);    
		    System.out.println("Total number of elements found " + allImages.size());
		    for( WebElement element : allImages){
		    	try
		    	{
  System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    	}
		    	catch(Exception exp)
		    	{
	System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		
		    	}
		    }
	}}*/
public class App{
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver","//Users//cex//Downloads//chromedriver");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");driver.manage().window().maximize();
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("Total no of links "+ links.size());
	for(int i=0; i<links.size(); i++){
	WebElement ele=	links.get(i);
	String url=ele.getAttribute("href");
	System.out.println(i);;
	verifyLinkActive(url);
	}	
	driver.quit();
	}	
public static void 	verifyLinkActive(String LINKurl){
	try{
	URL url=new URL(LINKurl);	
	HttpURLConnection httpURLConnect= (HttpURLConnection)url.openConnection();
	httpURLConnect.setConnectTimeout(2000);
	httpURLConnect.connect();
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_OK){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	else{
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	/*if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_ACCEPTED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_BAD_GATEWAY){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_BAD_METHOD){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_BAD_REQUEST){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_CLIENT_TIMEOUT){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_CONFLICT){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_CREATED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_ENTITY_TOO_LARGE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_FORBIDDEN){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_GATEWAY_TIMEOUT){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_GONE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_INTERNAL_ERROR){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_LENGTH_REQUIRED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_MOVED_PERM){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_MOVED_TEMP){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_MULT_CHOICE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NO_CONTENT){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_ACCEPTABLE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_AUTHORITATIVE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_MODIFIED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_MODIFIED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_IMPLEMENTED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_PARTIAL){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_PAYMENT_REQUIRED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_PRECON_FAILED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_PROXY_AUTH){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_REQ_TOO_LONG){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_RESET){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_SEE_OTHER){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_SERVER_ERROR){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_UNAUTHORIZED){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_UNAVAILABLE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_UNSUPPORTED_TYPE){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_USE_PROXY){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}
	if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_VERSION){
		System.out.println(LINKurl + " -" +httpURLConnect.getResponseMessage());
	}*/
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	}