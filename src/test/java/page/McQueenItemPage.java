package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class McQueenItemPage extends AbstractPage{
    public static String MC_QUEEN_ITEM_PAGE_URL = "https://www.alexandermcqueen.com/en-us/boots/hybrid-chelsea-boot-586198WHX521000.html";

    @FindBy(xpath = "//option[@data-attr-value='44']")
    private WebElement buttonSize;
    @FindBy(xpath = "//select[@data-action='selectProductSize']")
    private WebElement selectOpen;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookies;
    @FindBy(xpath = "//button[@data-action='addProductToCart']")
    private WebElement addToCartButton;

    public McQueenItemPage(WebDriver driver) {
        super(driver);
    }

    public McQueenItemPage closeCookies() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(cookies));
        cookies.click();
        return this;
    }

    public McQueenItemPage clickSizeButton() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(selectOpen));
        selectOpen.click();
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(buttonSize));
        buttonSize.click();
        new WebDriverWait(webDriver, waitWebDriver);
        return this;
    }

    public McQueenItemPage addItemToCart() {
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public String tryGetErrorMessadge() {
        WebElement getMessadge = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//span[@data-msg='Please select a size']")));
        return getMessadge.getText();
    }

    public String getAmountOfProducts() {
        WebElement amountOfProductsInCart = new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//span[@class='c-minicart__quantity']")));
        new WebDriverWait(webDriver, waitWebDriver)
                .until(ExpectedConditions.visibilityOf(amountOfProductsInCart));
        return amountOfProductsInCart.getText();
    }

    @Override
    public McQueenItemPage openPage() {
        webDriver.get(MC_QUEEN_ITEM_PAGE_URL);
        return this;
    }
}