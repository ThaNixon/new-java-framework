import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

import static constants.CommandConstants.UI_BASE_URI;
class UITest extends BaseTest{
    @Test
    public void submitFormTest() {
        driver.get(UI_BASE_URI);
        driver.findElement(By.linkText("Web form")).click();
        driver.findElement(By.id("my-text-id")).sendKeys("Text");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }
    @Test
    void loadingImageImplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement compass = driver.findElement(By.id("compass"));
        WebElement calender = driver.findElement(By.id("calendar"));
        WebElement award = driver.findElement(By.id("award"));
        WebElement landscape = driver.findElement(By.id("landscape"));

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(compass.getDomAttribute("src")).containsIgnoringCase("compass");
        softly.assertThat(calender.getDomAttribute("src")).containsIgnoringCase("calendar");
        softly.assertThat(award.getDomAttribute("src")).containsIgnoringCase("award");
        softly.assertThat(landscape.getDomAttribute("src")).containsIgnoringCase("landscape");
        softly.assertAll();
    }

    @Test
    void loadingImageExplicitWaitTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement landscape = longWait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getDomAttribute("src")).containsIgnoringCase("landscape");
    }
}

