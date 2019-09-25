package New_Project_Practice.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Shein_uk extends Utils{


@BeforeMethod
    public static void setup(){

    System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Resources\\Browser\\chromedriver.exe");

    //open the browser
    driver = new ChromeDriver();

    //maximise the browser window screen
    driver.manage().window().fullscreen();

    //set implicity wait for driver object
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://www.shein.co.uk/");

}

@Test
public static void userShouldBeAbleToViewProductsAccordingToDateSelectedInWhatsNewInWomenCategory(){
    mouseHover(By.xpath("//span[contains(text(),\"What's New\")]"));
    clickElement(By.xpath("//a[contains(text(),'09-24-2019')]"));
    String exp_date = gettingAttributeofWebElement(By.xpath("//a[@data-daily='2019-09-24']"),"data-daily");
    String temp = driver.getCurrentUrl();
    // System.out.println(temp);
    String arr[] = temp.split("=");
    String act_date = arr[4];
    Assert.assertEquals(act_date,exp_date);


}





}
