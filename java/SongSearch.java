import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SongSearch {

    WebDriver driver = new ChromeDriver();

    @Test
    void songSearch() throws InterruptedException {
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"Desktop_LeftSidebar_Id\"]/nav/div[1]/ul/li[2]/a/span"));
        searchButton.click();
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/header/div[3]/div/div/form/input"));
        searchBar.sendKeys("TEXAS HOLD 'EM");
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }


}
