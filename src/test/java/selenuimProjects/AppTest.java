package selenuimProjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    WebDriver driver=null;


    @BeforeMethod
    public void init(){
        String path=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.walgreens.com/");
        String current = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Expected="Walgreens: Pharmacy, Health & Wellness, Photo & More for You";
        Assert.assertEquals(current,Expected);
        driver.manage().window().maximize();

    }

    @Test
    public void test01() throws InterruptedException {
        //create a new account
        driver.findElement(By.xpath("//span[@class=\"inner-focus hide-on-mobile truncate\"]")).click();


        driver.findElement(By.xpath("//a[@id=\"pf-dropdown-register\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("john");

        driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("alba");

        driver.findElement(By.xpath("//input[@name=\"registerData\"]")).sendKeys("john1899@gmail.com");

        driver.findElement(By.xpath("//input[@name=\"registerPassword\"]")).sendKeys("John1899test");

        driver.findElement(By.xpath("//input[@id=\"wag-reg-myw-checkbox\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\"phoneno\"]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"phoneno\"]")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"phoneno\"]")).sendKeys("3478965412");
        driver.findElement(By.xpath("//input[@name=\"zipcode\"]")).sendKeys("11105");
        driver.findElement(By.xpath("//input[@id=\"wag-mywterms-checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"wag-terms-checkbox\"]")).click();

        //driver.findElement(By.xpath("//span[@class=\"btn mt0 btn__blue\"]")).click();
        // driver.findElement(By.xpath("//input[@name=\"Ntt\"]")).sendKeys("tooth paste");
        // driver.findElement(By.xpath("//button[@class=\"icon icon__search\"][@title=\"Search\"]")).click();



    }

    @Test
    public void test02() throws InterruptedException {
        //create a new account different way
        driver.findElement(By.xpath("//a[@class=\"menu-trigger trigHS\"]")).click();

        driver.findElement(By.xpath("//a[@data-element-name=\"Your Account\"][@class=\"dropdown__title\"]")).click();

        driver.findElement(By.xpath("//a[@id=\"pf-m-register\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"firstName\"]")).sendKeys("john");

        driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("alba");

        driver.findElement(By.xpath("//input[@name=\"registerData\"]")).sendKeys("john1899@gmail.com");

        driver.findElement(By.xpath("//input[@name=\"registerPassword\"]")).sendKeys("John1899test");

        driver.findElement(By.xpath("//input[@id=\"wag-reg-myw-checkbox\"]")).click();

        driver.findElement(By.xpath("//input[@name=\"phoneno\"]")).sendKeys("4987");

        driver.findElement(By.xpath("//input[@name=\"zipcode\"]")).sendKeys("11105");
        driver.findElement(By.xpath("//input[@id=\"wag-mywterms-checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"wag-terms-checkbox\"]")).click();
       // driver.findElement(By.xpath("//span[@class=\"btn mt0 btn__blue\"]")).click();



        //   driver.findElement(By.xpath("//a[@class=\"menu-trigger trigHS\"]")).click();
        //Thread.sleep(1000);
        //  driver.findElement(By.xpath("//a[@data-element-name=\"Photo\"]")).click();
        // driver.findElement(By.xpath("//a[@id=\"your_photos\"]")).click();


    }

    @Test
    public void test03() throws InterruptedException {
        //schedule an appointment
        driver.findElement(By.xpath("//div[@class=\"card__item card__item-new\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"covid-btn\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"location\"]")).clear();

        driver.findElement(By.xpath("//input[@name=\"location\"]")).sendKeys("11105");
        driver.findElement(By.xpath("//input[@name=\"dob\"]")).sendKeys("10061995");
        driver.findElement(By.xpath("//input[@id=\"dose1\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"radio-1\"]")).click();

        driver.findElement(By.xpath("//span[@name=\"nextBtn\"]")).click();
        //missing script

    }
    @Test
    public void test04() throws InterruptedException {
        //order a covid home test
        driver.findElement(By.xpath("//img[@src=\"/images/adaptive/sp1/1947208_brandstory_tile3_DrClipboard-Full-F2.png\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"#at-home-testing\"]")).click();
        driver.findElement(By.xpath("//img[@src=\"/images/adaptive/sp1/1729776_Icon-envelope@2x.png\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/findcare/partner/HealthConfirmbyCRL?ec=hn:Covid-EML_Weekly-Update_NA_NA_NA_NA_1_salivaorderkit&$web_only=true&~campaign=hn:Covid-EML_Weekly-Update_NA_NA_NA_NA_1_salivaorderkit&cid=wagDM2880&wag_mid=737875801&bid=882816903#faq&ban=covidfy21_newtestingpg_healthconfirm\"]")).click();
        driver.findElement(By.xpath("//a[@title=\"Get started \"][@id=\"service_details_cta\"]")).click();
        driver.findElement(By.xpath("//a[@id=\"navigationButton\"]")).click();
        // Thread.sleep(100);
        // WebDriverWait wai=new WebDriverWait(driver, Duration.ofSeconds(10));

        // WebElement element= wai.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"row d-none d-sm-block\"]")));
        driver.findElement(By.cssSelector("div[class=\"row d-none d-sm-block\"]>a[class=\"btn btn-primary\"]")).click();
        //not clicking

    }

    @Test
    public void test5(){
        //order an item
        driver.findElement(By.xpath("//input[@name=\"Ntt\"]")).sendKeys("tooth paste");

        driver.findElement(By.xpath("//button[@class=\"icon icon__search\"][@title=\"Search\"]")).sendKeys(Keys.RETURN);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"pickup-ship-btncompare_sku6314909\"]")));
        driver.findElement(By.xpath("//button[@id=\"pickup-ship-btncompare_sku6314909\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"dropdown__title--card\"][@aria-controls=\"PICK_IT\"]")).click();
        driver.findElement(By.xpath("//span[@class=\"btn btn__blue\"][contains(text(),\"Finish\")]")).click();



    }
    @Test
    public void test06() throws InterruptedException {
        // order an item from menu
        // driver.findElement(By.xpath("//a[@class=\"menu-trigger trigHS\"]")).click();
        driver.findElement(By.cssSelector("a[class=\"menu-trigger trigHS\"]")).click();
        Thread.sleep(1000);
        // driver.findElement(By.xpath("//a[@data-element-name=\"Shop Products\"][@class=\"dropdown__title\"]")).click();
        driver.findElement(By.cssSelector("a[data-element-name=\"Shop Products\"]")).click();
        driver.findElement(By.cssSelector("a[data-element-name=\"Home Goods\"]")).click();
        driver.findElement(By.cssSelector("a[data-element-name=\"Small Home Appliances\"]")).click();
        driver.findElement(By.cssSelector("a[data-element-name=\"Kitchen Appliances\"]")).click();
        driver.findElement(By.cssSelector("button#pickup-ship-btncompare_sku6244026")).click();
        driver.findElement(By.cssSelector("a[name=\"viewcart\"]")).click();
        driver.findElement(By.cssSelector("button#wag-cart-proceed-to-checkout")).click();
        driver.findElement(By.cssSelector("button#checkout_btn")).click();
        driver.findElement(By.cssSelector("input#wag-checkout-contact-info-email")).sendKeys("nchaour4@gmail.com");
        driver.findElement(By.cssSelector("input#wag-checkout-contact-info-phoneNumber")).sendKeys("3478974512");
        //  driver.findElement(By.cssSelector("input#ship-to-store")).click();
        driver.findElement(By.cssSelector("input#wag-checkout-shipping-info-firstName")).sendKeys("lorry");
        driver.findElement(By.cssSelector("input#wag-checkout-shipping-info-lastName")).sendKeys("kate");
        driver.findElement(By.cssSelector("input#wag-checkout-shipping-info-address")).sendKeys("5024 42 st ");
        driver.findElement(By.cssSelector("input#wag-checkout-shipping-info-city")).sendKeys("new york  ");
        driver.findElement(By.cssSelector("select#wag-checkout-shipping-info-state")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("option[value=\"NY\"]")).click();
        driver.findElement(By.cssSelector("input#wag-checkout-shipping-info-zipCode")).sendKeys("11105");



    }
    @Test
    public void test07() throws InterruptedException {
        //find nearby walgreen locations
        // driver.findElement(By.cssSelector("span[class=\"icon icon__arrow-down\"][style=\"width: 16px; height: 16px;\"]")).click();
        driver.findElement(By.cssSelector("a[class^=\"store-trigger\"]")).click();
        driver.findElement(By.cssSelector("a[class^=\"store-trigger\"]")).click();

        driver.findElement(By.cssSelector("input#store-header-search")).sendKeys("11104");
        Thread.sleep(100);
        //driver.findElement(By.cssSelector("input#store-header-search")).sendKeys(Keys.RETURN);

    }
    @Test
    public void test08() throws InterruptedException {
        //find nearby locations using our location
        driver.findElement(By.cssSelector("a[class^=\"store-trigger\"]")).click();
        driver.findElement(By.cssSelector("a[class^=\"store-trigger\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("strong[style=\"vertical-align: top; font-size: large;\"]")).click();


    }
    @Test
    public void test09() throws InterruptedException {
// update account
        driver.findElement(By.cssSelector("span[class=\"inner-focus hide-on-mobile truncate\"]")).click();
        driver.findElement(By.cssSelector("ul[class=\"default-dropdown account-dropdown show\"]>li>a[href=\"/youraccount/default.jsp\"]")).click();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("john1899@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("John1899test");

        driver.findElement(By.cssSelector("button#submit_btn")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("span[class=\"inner-focus hide-on-mobile truncate\"]")).click();
        driver.findElement(By.cssSelector("ul[class=\"default-dropdown account-dropdown show\"]>li>a[href=\"/youraccount/default.jsp\"]")).click();
        driver.findElement(By.cssSelector("a[class=\"link__cta link_underline\"]")).click();
        driver.findElement(By.cssSelector("span[class=\"btn btn__blue col-xs-12\"]")).click();
        driver.findElement(By.cssSelector("input[name=\"wagAddress\"]")).sendKeys("5030 42 st ");
        driver.findElement(By.cssSelector("input[name=\"date\"]")).sendKeys("12051997");

    }
    @Test
    public void test010(){
        //search for coupons
        driver.findElement(By.cssSelector("a[class=\"menu-trigger trigHS\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul>li>a[data-element-name=\"Coupons\"]")));
        driver.findElement(By.cssSelector("ul>li>a[data-element-name=\"Coupons\"]")).click();

    }

    @AfterMethod
    public void closeTest(){

         driver.close();
    }
}
