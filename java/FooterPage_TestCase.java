import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FooterPage_TestCase {

    // Shared WebDriver Instance
    public WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    void login_spotify() throws InterruptedException {
        // Open Spotify and let Home Page load. --> Click Login --> Let Page Load
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement login_button = driver.findElement(By.xpath("(//span[@class='ButtonInner-sc-14ud5tc-0 cnKUru encore-inverted-light-set'])[1]"));
        login_button.click();
        Thread.sleep(5000);

        // Pass Keys into the Email and Password Textbox --> Click Log In --> Let Home Page Load
        WebElement email_textbox = driver.findElement(By.xpath("(//input[@id='login-username'])[1]"));
        email_textbox.click();
        email_textbox.sendKeys("soulworld63@gmail.com");
        Thread.sleep(2500);
        WebElement password_textbox = driver.findElement(By.xpath("(//input[@id='login-password'])[1]"));
        password_textbox.click();
        password_textbox.sendKeys("SoftwareTestingSpotify@");
        Thread.sleep(2500);
        // Log In Button
        WebElement user_login_button = driver.findElement(By.className("ButtonInner-sc-14ud5tc-0"));
        user_login_button.click();
        Thread.sleep(5000);

        // Successfully In Spotify
    }

    void scroll_to_footer_page() throws InterruptedException {
        WebElement footer_section = driver.findElement(By.cssSelector(".Footer__StyledFooter-sc-xwm5vq-0.cuLHaM"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", footer_section);
        Thread.sleep(2500);
    }

    @Test (priority = 2)
    void company_section() throws InterruptedException {
        scroll_to_footer_page();

        // Click on About Button --> Page Load
        WebElement about_button = driver.findElement(By.xpath("//span[text()='About']"));
        about_button.click();
        Thread.sleep(5000);
        // Scroll into different section of the page.
        WebElement customer_and_support = driver.findElement(By.xpath("//h2[text()='Customer Service and Support']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", customer_and_support);
        Thread.sleep(2500);
        WebElement spotify_around_world = driver.findElement(By.xpath("//h2[text()='Spotify around the world']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", spotify_around_world);
        // Scroll to the top of the page.
        WebElement header = driver.findElement(By.tagName("header"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", spotify_around_world);
        // Click Spotify Logo to return to Home Page
        WebElement spotify_logo_about = driver.findElement(By.cssSelector(".mh-header-primary.svelte-1gcdbl9"));
        spotify_logo_about.click();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on Jobs Button --> Page Load
        WebElement jobs_button = driver.findElement(By.xpath("//span[text()='Jobs']"));
        jobs_button.click();
        Thread.sleep(5000);
        // Using back() to go to previous Page or Home Page due to lack of return Button.
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on the For the Record button
        WebElement for_the_record_button = driver.findElement(By.xpath("//span[text()='For the Record']"));
        for_the_record_button.click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    void communities_section() throws InterruptedException {
        scroll_to_footer_page();

        // Click on 'For Artists' button --> View --> Go back --> Home Page Load --> Repeat for rest.
        WebElement for_artists_button = driver.findElement(By.xpath("//span[text()='For Artists']"));
        for_artists_button.click();
        Thread.sleep(7000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on 'Developers' button
        WebElement developers_button = driver.findElement(By.xpath("//span[text()='Developers']"));
        developers_button.click();
        Thread.sleep(6000);
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on 'Advertising' button
        WebElement advertising_button = driver.findElement(By.xpath("//span[text()='Advertising']"));
        advertising_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // CLick on 'Investors' button
        WebElement investors_button = driver.findElement(By.xpath("//span[text()='Investors']"));
        investors_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on 'Vendors' button
        WebElement vendors_button = driver.findElement(By.xpath("//span[text()='Vendors']"));
        vendors_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    void useful_link_section() throws InterruptedException {
        scroll_to_footer_page();

        // Click on 'Support' button
        WebElement support_button = driver.findElement(By.xpath("//span[text()='Support']"));
        support_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on 'Free Mobile' button
        WebElement mobile_button = driver.findElement(By.xpath("//span[text()='Free Mobile App']"));
        mobile_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    void spotify_plans_section() throws InterruptedException {
        scroll_to_footer_page();

        // Doing 2 other test case had a method that display an overview deal.
        // Click on 'Premium Individual' button
        WebElement premium_individual_button = driver.findElement(By.xpath("//span[text()='Premium Individual']"));
        premium_individual_button.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
        scroll_to_footer_page();

        // Click on 'Premium Student' button
        WebElement premium_student = driver.findElement(By.xpath("//span[text()='Premium Student']"));
        premium_student.click();
        Thread.sleep(5500);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    void social_media_section() throws InterruptedException {
        scroll_to_footer_page();

        // Click on 'Instagram' button
        WebElement instagram_button = driver.findElement(By.xpath("//a[@title='Instagram']"));
        instagram_button.click();
        Thread.sleep(6000);
        // Utilize switch window handle to switch to that tab. --> View then close tab and switch window handle back.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        // Switch to the original tab after closing the one before
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        scroll_to_footer_page();

        // Click on 'Twitter' button
        WebElement twitter_button = driver.findElement(By.xpath("//a[@title='Twitter']"));
        twitter_button.click();
        Thread.sleep(6000);
        // Utilize switch window handle to switch to that tab. --> View then close tab and switch window handle back.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        // Switch to the original tab after closing the one before
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        scroll_to_footer_page();

        // Click on 'Facebook' button
        WebElement facebook_button = driver.findElement(By.xpath("//a[@title='Facebook']"));
        facebook_button.click();
        Thread.sleep(6000);
        // Utilize switch window handle to switch to that tab. --> View then close tab and switch window handle back.
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        // Switch to the original tab after closing the one before
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        Thread.sleep(5000);

        driver.quit();




    }







}
