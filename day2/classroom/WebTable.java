package week3.day2.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table_id']//tr/th"));
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int totalRow = row.size();
		int totalColumn=column.size();
		System.out.println("Total no of rows : "+totalRow);
		System.out.println("Total no of column : "+totalColumn);
		WebTable obj = new WebTable();
		obj.progressValue("Learn to interact with Elements", totalRow, totalColumn, driver);
		obj.findLeastCompleteTask(driver, totalColumn, "Progress", totalRow);
	}
	public void progressValue(String givenText, int totalRow , int totalColumn , WebDriver driver)
	{
		
		String givenColumnText = "Progress";
		
		for(int i=2;i<=totalRow;i++)
		{			
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[1]")).getText();
			if(givenText.equals(text))
			{
				for(int j=1;j<=totalColumn;j++)
				{
					String progressText=driver.findElement(By.xpath("//table[@id='table_id']//tr//th["+j+"]")).getText();
					if(givenColumnText.equals(progressText))
					{
						String finalValue = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td["+j+"]")).getText();
						System.out.println("Progress value of "+givenText +" : "+finalValue);
					}
				}
			}
			
		}
	}
	public void findLeastCompleteTask(WebDriver driver , int totalColumn , String progressText , int totalRow )
	{
		List<Integer> percentage = new ArrayList<Integer>();
		
		
		for(int i =1;i<=totalColumn;i++)
		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr//th["+i+"]")).getText();
			if(progressText.equals(text)) 
			{
				for(int j=2;j<=totalRow;j++) 
				{
					String singleValue = ((driver.findElement(By.xpath("//table[@id='table_id']//tr["+j+"]/td["+i+"]"))).getText()).replaceAll("%", "");
					int percentage_1 = Integer.parseInt(singleValue);
					percentage.add(percentage_1);				
				
			}			
		}	
			
			
	}
		int minList = Collections.min(percentage); 
		int index = percentage.indexOf(minList);
		System.out.println("********");
		System.out.println(percentage);
		System.out.println("********");
		System.out.println(minList);
		System.out.println("********");
		System.out.println(index);
		// check the vital task
		int postionOfLeastField = 2+index;
		driver.findElement(By.xpath("//table[@id='table_id']//tr["+postionOfLeastField+"]/td[3]/input[@type='checkbox']")).click();		
		
	}
}
