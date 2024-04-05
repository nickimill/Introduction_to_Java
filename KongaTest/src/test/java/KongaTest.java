import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {

    //import selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        //Locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver-win64/chromedriver.exe");

        //1. Open your chrome browser
        driver = new ChromeDriver();

        //2. Input your Konga Web page URL https://www.konga.com/
        driver.get("https://www.konga.com/");
        //Test 1. Verify the user inputs the right URL and is on the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Page");
        Thread.sleep(5000);

        //3. Maximize the browser
        driver.manage().window().maximize();

        //4. Click on login/signup button to open the login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void Login() throws InterruptedException {
        //5. Input your email address on the email address field
        driver.findElement(By.id("username")).sendKeys("faithidebi@gmail.com");

        //6. Locate the password field and input your password on the password field
        driver.findElement(By.id("password")).sendKeys("14/15CD143");

        //7. Click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void Computer_Accessories() throws InterruptedException {
        //8. Select Computer and Accessories Category
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        // Create an instance of Actions class
        Actions actions = new Actions(driver);
        // Hover over the element
        actions.moveToElement(elementToHover).build().perform();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void Macbook() throws InterruptedException {
        //9. Select MacBooks
        driver.findElement(By.xpath("//*[@id=\"subFixId\"]/div/div/div[1]/a[6]")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 3)
    public void SelectItem() throws InterruptedException {
        //10. Select an item
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[1]/a[1]/picture/img")).click();
        Thread.sleep(5000);

        //11. Click on Buy Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void CheckoutPage() throws InterruptedException {
        //12. Click on Continue to check out
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(10000);

        //Click on Pay Now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);

        //13. Click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);

        //14. Select card payment
        //Switched to iFrame
        WebElement paymentMethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);

        WebElement cardPayment = driver.findElement(By.className("Card"));
        cardPayment.click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void CardDetails() throws InterruptedException {
        //15. Input invalid card details
        // input card number on card number field
        driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("5789-2789-2012-3456");
        // input card date on date field
        driver.findElement(By.xpath("//*[@id=\"expiry\"]")).sendKeys("9/9");
        // input cvv number in cvv field
        driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("345");
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void Invalid_Message() throws InterruptedException {
        //Return invalid message
        //16. Print out error message "Invalid card Number"
        WebElement message = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        System.out.println(message.getText());
    }

    @Test (priority = 7)
    public void Close_iFrame(){
        //17. Close the iFrame that displays the input card modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
    }

    @AfterTest
    public void CloseBrowser(){
        //18. Quit browser
        driver.quit();
    }
}




