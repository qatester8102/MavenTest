package uipackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class E2E {

	
	 @Test
	public void allCheck()
	{
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sehaj\\chromedriver.exe");
		 WebDriver w = new ChromeDriver();
		 w.manage().deleteAllCookies();
		 w.manage().window().maximize();
		 w.get("http://airindia.in");
		 w.findElement(By.linkText("Schedule")).click();
		 System.out.println(w.getTitle());
		 Set<String> h =w.getWindowHandles();
		  Iterator<String> it= h.iterator();
		  String pid = it.next();
		  String cid= it.next();
		  w.switchTo().window(cid);
		  System.out.println(w.getTitle());
		  w.switchTo().window(pid);
		  System.out.println(w.getTitle());
		  w.switchTo().window(cid);
		  Select sd = new Select(w.findElement(By.cssSelector("select#searchDepartLocation")));
		  sd.selectByValue("Airport.JAI");
		  Select sa = new Select(w.findElement(By.cssSelector("select#searchArriveLocation")));
		  sa.selectByValue("Airport.AKL");
		  w.findElement(By.cssSelector("a#calLink0")).click();
		if(w.findElement(By.cssSelector("div[id=calContainer0_0]  div.calheader")).getText().contains("XYZ"))
		 { 	  
		  int rc= w.findElements(By.cssSelector("tbody.m9.calbody  a.selector")).size();
		  List<WebElement> l =  w.findElements(By.cssSelector("tbody.m9.calbody  a.selector"));
		  
		  for(int i=0;i<rc;i++)
		   { if( l.get(i).getText().equals("29"))
				   {l.get(i).click();   }
		   }
		 } else
		 { while (!w.findElement(By.cssSelector("div[id=calContainer0_1]  a.calnavright")).getText().contains("December"))
		    {  w.findElement(By.cssSelector("div[id=calContainer0_1]  a.calnavright")).click();  }
			 
		 int rc1= w.findElements(By.cssSelector("tbody.m10.calbody  a.selector")).size();
		  List<WebElement> l1 =  w.findElements(By.cssSelector("tbody.m10.calbody  a.selector"));
		  
		  for(int i=0;i<rc1;i++)
		   { if( l1.get(i).getText().equals("30"))
				   {l1.get(i).click();   }
		   }
		 }
		
	}
	 
}
