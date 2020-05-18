package week3.day2.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");	
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Mgr Chennai Ctr",Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Mumbai Central",Keys.ENTER);        
		driver.findElement(By.id("buttonFromTo")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();	
		Thread.sleep(1000);
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		List<String> trainNames_1 = new ArrayList<String>();
		for (int i=1;i<=trainNames.size();i++) 
		{
			String xpath = "//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]/a";
			String trainName = driver.findElement(By.xpath(xpath)).getText();
			//System.out.println(trainName);
			trainNames_1.add(trainName);
			
		}
		Collections.sort(trainNames_1);
		System.out.println(trainNames_1);
		
		LinkedHashSet<String> uniqueTrains = new LinkedHashSet<String>();
		for (int j=0;j<trainNames_1.size();j++)
		{
			
			uniqueTrains.add(trainNames_1.get(j));
		}
		System.out.println(uniqueTrains);
	
	if(trainNames_1.size()==uniqueTrains.size())
	{
		System.out.println("there is no duplicate in train names");
	}
	else 
	{
		System.out.println("there is a duplicate in train names");
	}
	}

}
