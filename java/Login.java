import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

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
    void login() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[1]/input"));
        userName.sendKeys("SpotifyTestProject@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        password.sendKeys("SpotifyTest123");
        Thread.sleep(1000);
        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]/span[1]"));
        logInButton.click();
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }
}
