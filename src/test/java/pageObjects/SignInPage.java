package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy(css = "#SubmitLogin")
    public WebElement signInButton;

    public WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isSignInButtonPresent(){
        if(signInButton.getText().contains("Sign in"))
        return true;
    else
        return false;
    }
}
