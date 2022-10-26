package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AssignmentSteps {

    WebDriver driver;
    @Given("Launch The Browser")
    public void launch_the_browser() {
        System.setProperty("webdriver.chrome.driver","/home/akshiy/Desktop/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @When("open amazon website url {string}")
    public void open_amazon_website_url(String url) {
        driver.get(url);

    }
    @Then("clicks on Accounts & Lists")
    public void clicks_on_accounts_lists() {
        driver.findElement(By.id("nav-link-accountList")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("Enter the emailId  as {string}")
    public void enter_the_email_id_as(String email) {
        driver.findElement(By.id("ap_email")).sendKeys(email);


    }
    @Then("Click on continue")
    public void click_on_continue() {
        driver.findElement(By.id("continue")).click();
    }
    @Then("Enter the password")
    public void enter_the_password() {
        driver.findElement(By.id("ap_password")).sendKeys("karthik123");

    }
    @Then("Click on signIn")
    public void click_on_sign_in() {
        driver.findElement(By.id("signInSubmit")).click();
    }
    @Then("Click on Returns & Orders")
    public void click_on_returns_orders() {
        driver.findElement(By.id("nav-orders")).click();
    }
    @Then("get the first displayed item delivery date")
    public void get_the_first_displayed_item_delivery_date() {
        driver.findElement(By.xpath("//a[normalize-space()='View order details']")).click();
        String deliveryDate =  driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-success a-text-bold'])")).getText();
        System.out.println(deliveryDate);
    }

    @Then("Click on Today's deals")
    public void click_on_today_s_deals() {
        driver.findElement(By.linkText("Today's Deals")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    @Then("Search for {string}")
    public void search_for(String text) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @And("Select first item")
    public void select_first_item() {
        driver.findElement(By.xpath("(//div[@class=\"aok-relative\"])[1]")).click();
    }
    @Then("Add an item to the cart")
   public void add_an_item_to_the_cart() throws InterruptedException {

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();


    }
    @Then("Verify the cart quantity is  as expected or not")
    public void verify_the_cart_quantity_is_as_expected_or_not() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
        String s = driver.findElement(By.className("a-dropdown-prompt")).getText();
        Assert.assertEquals("1",s);

    }

        @And("Verify No results for 123456789$#@ghjk in Today's Deals.")
        public void verify_no_results_for_numalphaspecialchar(){

            String s = driver.findElement(By.xpath("(//div[@class=\"a-row\"])[1]")).getText();
            Assert.assertEquals("No results for 123456789$#@ghjk in Today's Deals.",s);
            driver.quit();

        }

        @And("Verify No results for @#& in Deals")
    public void verify_no_results_for_specialchar() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String s = driver.findElement(By.xpath("//h3[@class=\"a-size-base a-spacing-base a-color-base a-text-normal\"]")).getText();
        Assert.assertEquals("No results for @#& in Deals",s);
            driver.quit();

    }
       @And("Verify results for \"Mobi@les\"")
    public void verify_results_for_extrachar_string(){

           String s = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")).getText();
           Assert.assertEquals("1-16 of 34 results for \"Mobi@les\"",s);
           driver.quit();

       }

       @And("Verify Price and other details may vary based on product size and colour.")
    public void verify_results_for_wrong_string(){
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

           String s = driver.findElement(By.xpath("(//span[@class=\"a-size-base a-color-secondary a-text-normal\"])[1]")).getText();
           Assert.assertEquals("Price and other details may vary based on product size and colour.",s);
           driver.quit();
       }

}
