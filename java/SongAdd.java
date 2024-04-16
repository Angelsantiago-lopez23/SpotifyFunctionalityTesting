import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SongAdd {

    WebDriver driver = new ChromeDriver();

    @Test (priority = 1)
    void login_button() throws InterruptedException{
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/header/div[4]/div[1]/button[2]/span"));
        signInButton.click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    void login() throws InterruptedException{
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"login-username\"]"));
        userName.sendKeys("SpotifyTestProject@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        password.sendKeys("SpotifyTest123");
        Thread.sleep(1000);
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]/span[1]"));
        logInButton.click();
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    void Song_Add_Playlist() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div[1]/ul/li[2]/a/span"));
        searchButton.click();
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/header/div[3]/div/div/form/input"));
        searchBar.sendKeys("TEXAS HOLD 'EM");
        Thread.sleep(2000);
        WebElement addToLiked = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div/div/section[2]/section/div[2]/div/div/div/div[2]/div[1]/div/div[2]/button[1]"));
        addToLiked.click();
        WebElement songDetails = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div/div/section[2]/section/div[2]/div/div/div/div[2]/div[1]/div/div[2]/button[2]"));
        songDetails.click();
        Thread.sleep(1000);
        WebElement addSongButton = driver.findElement(By.xpath("//*[@id=\"context-menu\"]/ul/li[1]/button"));
        addSongButton.click();
        WebElement playlistSelection = driver.findElement(By.xpath("/html/body/div[19]/div/ul/li[1]/div/ul/div/li[3]/button"));
        playlistSelection.click();
        Thread.sleep(1000);
        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div[1]/ul/li[1]/a/span"));
        homeButton.click();
        Thread.sleep(1000);
        WebElement playlistButton = driver.findElement(By.xpath("//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul/div/div[2]/li/div/div[1]"));
        playlistButton.click();
        Thread.sleep(2000);
        WebElement likedPlaylist = driver.findElement(By.xpath("//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div[2]/div[1]/div[2]/div[2]/div/div[2]/ul/div/div[2]/li[2]/div/div[1]"));
        likedPlaylist.click();
        Thread.sleep(4000);
        driver.close();
        driver.quit();
    }
}
