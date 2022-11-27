package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver webDriver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected final Duration waitWebDriver = Duration.ofSeconds(5);

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
}