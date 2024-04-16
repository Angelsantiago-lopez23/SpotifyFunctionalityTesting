import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Playlist_Creation {


    WebDriver driver = new ChromeDriver();

    @Test (priority = 1)
    void login_button() throws  InterruptedException{
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/header/div[4]/div[1]/button[2]/span"));
        signInButton.click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    void login() throws InterruptedException{
        WebElement userName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/input"));
        userName.sendKeys("SpotifyTestProject@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        password.sendKeys("SpotifyTest123");
        Thread.sleep(1000);
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]/span[1]"));
        logInButton.click();
        Thread.sleep(7000);
    }

    @Test (priority = 3)
    void playlist_creation () throws InterruptedException{
        WebElement newPlaylistButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/nav/div[2]/div[1]/div[1]/header/div/span/button"));
        newPlaylistButton.click();
        Thread.sleep(1000);
        WebElement createButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/nav/div[2]/div[1]/div[1]/header/div/span/div/div/ul/li[1]/button/span"));
        createButton.click();
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
