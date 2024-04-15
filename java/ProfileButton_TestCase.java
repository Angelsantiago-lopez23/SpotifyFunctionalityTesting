import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileButton_TestCase {

    // Shared WebDriver Instance
    public WebDriver driver = new ChromeDriver();

    @Test (priority = 1)
    void login_spotify() throws InterruptedException {
        // Open Spotify and let Home Page load. --> Click Login --> Let Page Load
        driver.get("https://open.spotify.com/");
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

    //@Test (priority = 2)
    void profile_button() throws InterruptedException {
        // Clicking on the Profile Button
        WebElement profile_button = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']"));
        profile_button.click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    void sub_account_button() throws InterruptedException {
        profile_button();
        // Profile Button Opened --> Click on Account Link Button --> Let Account Page Load
        WebElement account_button = driver.findElement(By.xpath("(//button[@class='mWj8N7D_OlsbDgtQx5GW'])[1]"));
        account_button.click();
        Thread.sleep(5000);

        // Inside Account Page --> Demonstrate Account Section Works --> Click Manage your plan --> Let Plan Page Load
        // Implement wait for switching to new tab (Account Page Tab)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        WebElement manage_plan = driver.findElement(By.xpath("//div[@aria-describedby='onClickHintmanageYourPlan']"));
        manage_plan.click();
        Thread.sleep(5000);
        // Click Back Button --> Let Account Page Load
        WebElement click_back = driver.findElement(By.className("ButtonInner-sc-14ud5tc-0"));
        click_back.click();
        Thread.sleep(5000);

        // In Account Page --> Scroll To Bottom --> Click on Spotify Logo to redirect to Home Page --> Let Home Page Load
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        WebElement spotify_logo_home = driver.findElement(By.className("mh-footer-primary"));
        spotify_logo_home.click();
        Thread.sleep(5000);
        // Close Previous Tab & Switch Handle back to Original Page
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    @Test (priority = 3)
    void sub_profile_button() throws InterruptedException {
        profile_button();

        // Click on Profile Link Button and let Page Load
        WebElement sub_profile_button = driver.findElement(By.xpath("(//a[@class='mWj8N7D_OlsbDgtQx5GW'])[1]"));
        Thread.sleep(2500);
        sub_profile_button.click();
        Thread.sleep(5000);
        // Explore Profile section. Demonstrate options / limited due to new Account
        WebElement edit_profile = driver.findElement(By.cssSelector(".Button-sc-1dqy6lx-0.lnKBlZ"));
        edit_profile.click();
        Thread.sleep(2500);
        edit_profile.click();
        // Click Back Button --> Back to Home Page --> Load
        WebElement go_back_button = driver.findElement(By.xpath("(//button[@class='ql0zZd7giPXSnPg75NR0'])[1]"));
        go_back_button.click();
        Thread.sleep(2500);
    }

    @Test (priority = 4)
    void sub_upgrade_to_premium_button() throws InterruptedException {
        profile_button();

        // Click on Upgrade to Premium Button and let Page Load
        WebElement upgrade_to_premium_button = driver.findElement(By.xpath("(//a[@class='mWj8N7D_OlsbDgtQx5GW'])[2]"));
        upgrade_to_premium_button.click();
        Thread.sleep(5000);
        // Utilized wait command and switch handle. To the 'Upgrade to Premium tab'.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Once Page Loads an issue occurs. Same page loads but different name for 'View Plan' Button.
        // Either 'View all Premium plans' or 'View all plans'
        WebElement viewPlansButton = null;
        try {
            viewPlansButton = driver.findElement(By.xpath("//span[text()='View all Premium plans']"));
        } catch (NoSuchElementException e) {
            // If "View all Premium plans" button is not found, try finding "View all plans" button
            viewPlansButton = driver.findElement(By.xpath("//span[text()='View all plans']"));
        }
        // Click on Plans Button
        viewPlansButton.click();
        Thread.sleep(3000);

        // Scroll the bottom of View Plans Page and Click on Spotify Logo to redirect back to Home Page.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Thread.sleep(2500); // adding this sleep finally allowed for the spotify logo to be clicked.
        WebElement plans_spotify_logo = driver.findElement(By.cssSelector(".mh-footer-primary.svelte-1gcdbl9"));
        plans_spotify_logo.click();
        Thread.sleep(5000); // Let Home Page Load

        // But we close that tab and switch back to the original tab.
        driver.close();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        // Switch to the original tab using handles.
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    @Test (priority = 5)
    void sub_settings_button() throws InterruptedException {
        profile_button();

        // Click on Settings Button and let Setting Page Load
        WebElement settings_button = driver.findElement(By.cssSelector(".mWj8N7D_OlsbDgtQx5GW.Vz3pFUXmll6fKB5Fc4nd"));
        settings_button.click();
        Thread.sleep(5000);

        // Explore Settings section. --> Change Language --> Apply --> Page Reloads
        Select language_dropdown = new Select(driver.findElement(By.className("zrvvPyoxE6wQNqnu0yWA")));
        language_dropdown.selectByValue("ja");
        Thread.sleep(2000);
        WebElement apply_language = driver.findElement(By.cssSelector(".Button-sc-y0gtbx-0.blXNnr"));
        apply_language.click();
        Thread.sleep(10000);

        // NOTE: Refresh element references after page reloads
        language_dropdown = new Select(driver.findElement(By.className("zrvvPyoxE6wQNqnu0yWA")));
        language_dropdown.selectByValue("en");
        Thread.sleep(2000);
        apply_language = driver.findElement(By.cssSelector(".Button-sc-y0gtbx-0.blXNnr"));
        apply_language.click();
        Thread.sleep(10000);

        // Use the Home Button element since after page reloads the back button is disabled.
        WebElement setting_to_home_button = driver.findElement(By.xpath("(//li[@class='KAcp7QFuEYSouAsuC5i_ InvalidDropTarget'])[1]"));
        setting_to_home_button.click();
        Thread.sleep(5000); // Let Home Page load

        // Let Home Page Load
        // End of Presentation --> Profile Button --> Logout Button
        // profile_button();
        WebElement profile_button = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']"));
        profile_button.click();
        WebElement log_out_button = driver.findElement(By.xpath("//button[@data-testid='user-widget-dropdown-logout']"));
        log_out_button.click();
        Thread.sleep(5000);
        driver.quit();

    }







}
