package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStorePage {
    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    public WebElement dressesTopMenu;

    @FindBy(css = "#categories_block_left > div > ul > li.last > a")
    public WebElement summerDressesSideMenu;
    public WebDriverWait wait;
    public WebDriver driver;
    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait= new WebDriverWait(driver,15);
    }
    public void goToMyStore() {
        driver.get("http://automationpractice.com/index.php");
    }

    public SummerDressesCatalogPage navigateSummerDressesPage() throws Exception {
        dressesTopMenu.click();
        wait.until(ExpectedConditions.visibilityOf(summerDressesSideMenu));
        summerDressesSideMenu.click();
        return PageFactory.initElements(driver, SummerDressesCatalogPage.class);
    }
}
