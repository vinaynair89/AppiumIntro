import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.Capabilities;


public class desiredcapab {

	private static final TimeUnit SECONDS = null;

	@Test
	public void test() throws MalformedURLException {
		
		File appDir = new File("src");
		File app =new File(appDir, "com.touristeye.apk");
		
		//fail("Not yet implemented");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElementByName("Continue").click();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(By.name("Not now")));
		driver.findElementByName("Not now").click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Search']")).click();
		List<WebElement>a=driver.findElements(By.id("android:id/search_src_text"));
		a.get(0).sendKeys("New York");
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Submit query']")).click();
		//List<WebElement>b=driver.findElements(By.className("android.widget.LinearLayout"));
		//int s= b.get(0).findElements(By.className("android.widget.LinearLayout")).size();
		//System.out.println(s);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		WebElement element1 = wait3.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.LinearLayout")));
		driver.findElement(By.className("android.widget.LinearLayout")).findElements(By.className("android.widget.LinearLayout")).get(0).click();
		//driver.findElement(By.xpath("(//img[@id,''])[2]")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='View Map']")).click();
		//driver.findElement(By.className("android.widget.ImageButton")).click();
		//driver.findElementByClassName("android.widget.ImageButton").click();
		//driver.findElementById("com.touristeye:id/tv_connect").click();
		//driver.close();
	}
	
}
