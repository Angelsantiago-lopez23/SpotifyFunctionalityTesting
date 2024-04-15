import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class WebPlayer_TestCase {
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

    @Test (priority = 2)
    void liked_songs_player() throws InterruptedException {
        // Click on Liked Songs
        WebElement liked_songs_button = driver.findElement(By.cssSelector(".RowButton-sc-xxkq4e-0.hIehTT"));
        liked_songs_button.click();
        Thread.sleep(2500);
        // I think clicking on track-list-row(data-testid) is best option. It brings you inside the first song track.
        WebElement play_music_row = driver.findElement(By.xpath("(//div[@data-testid='tracklist-row'])[1]"));
        play_music_row.click();
        // Inside the song. We press the play button.
        Thread.sleep(5500);
        WebElement play_button_song = driver.findElement(By.cssSelector(".ButtonInner-sc-14ud5tc-0.bXrXni.encore-bright-accent-set"));
        play_button_song.click();
        // Let the song play for 15 seconds. Then pause through the play_button_song button.
        Thread.sleep(15000);
        play_button_song.click();
        Thread.sleep(7500);
    }

    @Test (priority = 3)
    void web_player() throws InterruptedException {
        // Doing 3 actions on the web player.

        // Now playing view
        WebElement now_playing_view = driver.findElement(By.xpath("//button[@data-testid='control-button-npv']"));
        now_playing_view.click();
        Thread.sleep(5000);
        // Lyrics button
        WebElement lyrics_button = driver.findElement(By.xpath("//button[@data-testid='lyrics-button']"));
        lyrics_button.click();
        Thread.sleep(5000);
        // Queue button
        WebElement queue_button = driver.findElement(By.xpath("//button[@data-testid='control-button-queue']"));
        queue_button.click();
        Thread.sleep(5000);
        // Click Home Page Button
        WebElement songs_home_button = driver.findElement(By.xpath("(//li[@class='KAcp7QFuEYSouAsuC5i_ InvalidDropTarget'])[1]"));
        songs_home_button.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
