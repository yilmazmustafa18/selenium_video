package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestBase_Each {

    protected WebDriver driver;

    @BeforeEach
    public void setup(){


        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Bağlantı reddini önler
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Bellek yetersizliği çökmelerini engeller
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
}
