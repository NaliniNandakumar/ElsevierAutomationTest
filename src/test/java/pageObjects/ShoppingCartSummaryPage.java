package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

    @FindBy(css = "#product_5_19_0_0 > td.cart_description > p")
    public WebElement orderDetail;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    public WebElement btnToCheckOut;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebDriver driver;
    public SignInPage proceedToCheckout() {
        btnToCheckOut.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean dressInCart(){
        if(orderDetail.getText().contains("Printed Summer Dress"))
            return true;
        else
            return false;
    }

}
