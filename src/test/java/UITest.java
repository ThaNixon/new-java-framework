import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.CommandConstants.UI_BASE_URI;
public class UITest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void submitFormTest() {
        driver.get(UI_BASE_URI);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());

    }
}

