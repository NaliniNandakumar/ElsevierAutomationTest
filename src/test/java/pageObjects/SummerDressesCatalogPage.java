package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesCatalogPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement chooseFirstDress;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    public WebElement lnkAddToCart;

    @FindBy(css = "#layer_cart")
    public WebElement cartLayer;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement btnProceedToCheckout;

    public WebDriverWait wait;
    public WebDriver driver;

    public SummerDressesCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);

    }
    public ShoppingCartSummaryPage selectSummerDress() {
        Actions action = new Actions(driver);
        action.moveToElement(chooseFirstDress).build().perform();
        lnkAddToCart.click();
        wait.until(ExpectedConditions.visibilityOf(cartLayer));
        btnProceedToCheckout.click();
        return PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
    }
}
