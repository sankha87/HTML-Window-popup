package HTMLWindow;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlWindow{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\browser drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.xpath("//button[text()='OK']")).click();		
driver.findElement(By.xpath("//*[@class='h_menu_drop_button hidden-xs']")).click();
driver.findElement(By.xpath("//*[text()='BUSES']")).click();
		System.out.println(driver.getTitle());
		Set<String> w = driver.getWindowHandles();
		System.out.println(w);
		Iterator<String> itr = w.iterator();
		String parent = itr.next();
		String child = itr.next();
	System.out.println(parent);	
	System.out.println(child);
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
	}
}
