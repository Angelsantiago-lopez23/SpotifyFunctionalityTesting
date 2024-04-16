import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AccountCreation {

    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    void Account_Creation() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[3]/header/div[4]/div[1]/button[1]"));
        signUp.click();
        Thread.sleep(2000);
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailInput.sendKeys("SpotifyTestProject@yahoo.com");
        Thread.sleep(1000);
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/button/span[1]"));
        nextButton.click();
        Thread.sleep(3000);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"new-password\"]"));
        passwordInput.sendKeys("SpotifyTest123");
        Thread.sleep(1000);
        WebElement nextButton2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[2]/button"));
        nextButton2.click();
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"displayName\"]"));
        nameInput.sendKeys("Spotify Test");
        Thread.sleep(1000);
        WebElement monthDD = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select dd = new Select(monthDD);
        dd.selectByIndex(1);
        Thread.sleep(1000);
        WebElement dayInput = driver.findElement(By.xpath("//*[@id=\"day\"]"));
        dayInput.sendKeys("1");
        Thread.sleep(1000);
        WebElement yearInput = driver.findElement(By.xpath("//*[@id=\"year\"]"));
        yearInput.sendKeys("2000");
        Thread.sleep(1000);
        WebElement genderButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[1]/div[2]/div/section/div[3]/fieldset/div/div/div[4]/label/span[2]"));
        genderButton.click();
        Thread.sleep(3000);
        WebElement nextButton3 = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[2]/button"));
        nextButton3.click();
        Thread.sleep(1000);
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/main/section/div/form/div[2]/button"));
        signUpButton.click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
