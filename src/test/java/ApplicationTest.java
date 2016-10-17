import net.lkrnac.blog.seleniumontravis.Application;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class ApplicationTest {
    private static FirefoxDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void contextLoads() {
        driver.get("https://jenkins.io/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("download-banner-btn"),
                "Download Jenkins")
        );
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
