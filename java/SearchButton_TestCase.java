import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchButton_TestCase {

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

    @Test (priority = 2)
    void search_sidebar_person() throws InterruptedException {
        // Click on the Search sidebar.
        WebElement search_sidebar = driver.findElement(By.xpath("//a[@aria-label='Search']"));
        search_sidebar.click();
        Thread.sleep(5000);
        // Search by passing Artist Name.
        WebElement search_textbox = driver.findElement(By.xpath("//input[@data-testid='search-input']"));
        search_textbox.click();
        search_textbox.sendKeys("Young Thug");
        Thread.sleep(2500);
        search_textbox.sendKeys(Keys.ENTER);
        // Let Search Results Load
        Thread.sleep(6500);
    }

    @Test (priority = 3)
    void search_all_tabs() throws InterruptedException {
        // After Search Results load. Click and View all tabs like Artist, Songs, etc.
        WebElement artists_tab = driver.findElement(By.xpath("//span[text()='Artists']"));
        artists_tab.click();
        Thread.sleep(3000);
        WebElement songs_tab = driver.findElement(By.xpath("//span[text()='Songs']"));
        songs_tab.click();
        Thread.sleep(3000);
        WebElement profiles_tab = driver.findElement(By.xpath("//span[text()='Profiles']"));
        profiles_tab.click();
        Thread.sleep(3000);
        WebElement podcasts_and_shows_tab = driver.findElement(By.xpath("//span[text()='Podcasts & Shows']"));
        podcasts_and_shows_tab.click();
        Thread.sleep(3000);
        WebElement albums_tab = driver.findElement(By.xpath("//span[text()='Albums']"));
        albums_tab.click();
        Thread.sleep(3000);
        WebElement playlists_tab = driver.findElement(By.xpath("//span[text()='Playlists']"));
        playlists_tab.click();
        Thread.sleep(3000);
        WebElement audiobooks_tab = driver.findElement(By.xpath("//span[text()='Audiobooks']"));
        audiobooks_tab.click();
        Thread.sleep(3000);
        WebElement all_tab = driver.findElement(By.xpath("//span[text()='All']"));
        all_tab.click();
        Thread.sleep(3000);
        // In the end we click 'All' tab for the next method.
    }

    @Test (priority = 4)
    void view_artist_info() throws InterruptedException {
        // After All tab loads. We click 'Top Results' of that Artist.
        WebElement top_results_button = driver.findElement(By.className("ouEZqTcvcvMfvezimm_J"));
        top_results_button.click();
        Thread.sleep(5000);

        // After Artist page loads. --> Scroll through page and display Popular, Discography, etc.
        WebElement popular_section = driver.findElement(By.xpath("//h2[text()='Popular']"));
        // After identifying the element we use javascript executor to scroll element into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", popular_section);
        Thread.sleep(2500);
        WebElement discography_section = driver.findElement(By.xpath("//a[text()='Discography']"));
        // After identifying the element we use javascript executor to scroll element into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", discography_section);
        Thread.sleep(2800);
        //WebElement featuring_section = driver.findElement(By.xpath("//a[text()='Featuring Young Thug']"));
        // After identifying the element we use javascript executor to scroll element into view
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", featuring_section);
        //Thread.sleep(2500);
        WebElement tour_section = driver.findElement(By.xpath("//a[text()='On Tour']"));
        // After identifying the element we use javascript executor to scroll element into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", tour_section);
        Thread.sleep(2500);
        WebElement about_section = driver.findElement(By.xpath("//h2[text()='About']"));
        // After identifying the element we use javascript executor to scroll element into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", about_section);
        Thread.sleep(2500);

        // Click on the about section to display the bio.
        WebElement about_section_button = driver.findElement(By.cssSelector(".jW4eWdr_LUeOXwPpKhWG.DRXonbAbVN5Vg9anDL1X"));
        about_section_button.click();
        Thread.sleep(4500);
        WebElement exit_about_button = driver.findElement(By.className("pSxFsY9Fgcj5f8Gf05mh"));
        exit_about_button.click();

        // Return to Home Page
        WebElement view_artist_home_button = driver.findElement(By.xpath("(//li[@class='KAcp7QFuEYSouAsuC5i_ InvalidDropTarget'])[1]"));
        view_artist_home_button.click();
        Thread.sleep(5000);

        driver.quit();
    }



}
