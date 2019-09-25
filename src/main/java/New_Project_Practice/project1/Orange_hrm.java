package New_Project_Practice.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Orange_hrm extends Utils {
    LoadProperty props = new LoadProperty();

    @BeforeMethod
    public  void setup(){

        System.setProperty("webdriver.chrome.driver","src\\main\\java\\Resources\\Browser\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //open the website
        driver.get("https://opensource-demo.orangehrmlive.com/");


    }

    @Test

    public  void UserShouldBeAbleToRegisterSucessfully()  {

        //type username
       // driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        enterText(By.id("txtUsername"),props.getProperty("username"));

        //type password
       // driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        enterText(By.name("txtPassword"),props.getProperty(("password")));

        //click on login
        //driver.findElement(By.className("button")).click();
        clickElement(By.className("button"));
    }







}
