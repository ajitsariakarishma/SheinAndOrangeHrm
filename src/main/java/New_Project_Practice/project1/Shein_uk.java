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
public  void userShouldBeAbleToViewProductsAccordingToDateSelectedInWhatsNewInWomenCategory(){
    mouseHover(By.xpath("//span[contains(text(),\"What's New\")]")); //mouse hover to whats new
    clickElement(By.xpath("//a[contains(text(),'09-24-2019')]")); //clicking on date
    String exp_date = gettingAttributeofWebElement(By.xpath("//a[@data-daily='2019-09-24']"),"data-daily");
    String temp = driver.getCurrentUrl();
    // System.out.println(temp);
    String arr[] = temp.split("=");
    String act_date = arr[4];
    Assert.assertEquals(act_date,exp_date); //asserting actual and expected according to date


}
@Test
    public void UserShouldBeAbleToAddTwoPRoductsFromKidsShoeAndAccessoriesCategoryToShoppinBasket(){

    //clicking on kids tab button
    clickElement(By.xpath("//a[contains(@class,'j-nav-first-cate j-nav-first-cate-3 first-cate')]"));

    mouseHover(By.xpath("//span[contains(text(),'Shoes & Accessories')]"));// mouse hover movement to shoe and accesssories
    clickElement(By.xpath("//a[@title=\"Girls Shoes\"]"));//clicking on girls shoes

    //clicking on product to add in cart
    //clickElement(By.xpath("//button[@class='she-btn-white-opacity she-btn-s quick-add-btn j-btn-add-to-bag j-btn-add-to-bag-756635'] "));

    //chosing the size by clicking
   // clickElement(By.xpath("//span[contains(text(),'EUR19')]"));

    //clicking on submit button to add in cart
   // clickElement(By.xpath("//button[contains(@class,'she-btn-black she-btn-s quick-add-btn-submit j-add-bag-submit j-add-bag-submit-756635')]"));






}

@Test
    public void UserShouldBeAbleToSelectDisplayDesignOnGiftCardAccordingToSelectionFromDesignFilter(){

    //clicking on E Gift cards tab on homepage
    clickElement(By.xpath("//span[@class='cate-sec-in j-cate-sec-in'][contains(text(),'E-Gift Cards')]"));

    //clicking on a desing form filter design
    clickElement(By.xpath("//img[@src=\"http://img.shein.com/images2/2019/08/06/15650746063441756703.png\"]"));


    //aseerting the selection by comparing image selected and image display on card face

    String exp_img = "images2";


   String auc_img=gettingAttributeofWebElement(By.xpath("//div[@class='swiper-slide swiper-slide-active']//img"),"src");
    String temp[]=auc_img.split("/");
    //System.out.println(temp[3]);

    Assert.assertEquals(temp[3],exp_img);

}





}
