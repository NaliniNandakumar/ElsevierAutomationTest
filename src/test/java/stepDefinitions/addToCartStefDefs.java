package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.MyStorePage;
import pageObjects.ShoppingCartSummaryPage;
import pageObjects.SignInPage;
import pageObjects.SummerDressesCatalogPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class addToCartStefDefs {
    public WebDriver driver = new FirefoxDriver();
    //public WebDriver driver = new ChromeDriver();
    public MyStorePage myStorePage = new MyStorePage(driver);
    public SummerDressesCatalogPage summerDressesCatalogPage = new SummerDressesCatalogPage(driver);
    private ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
    private SignInPage signInPage = new SignInPage(driver);


    @Given("^I am on the my store page$")
    public void i_am_on_the_my_store_page() {
        myStorePage.goToMyStore();
    }

    @Given("^I navigate to the summer dresses page$")
    public void i_navigate_to_the_summer_dresses_page() throws Exception {
        summerDressesCatalogPage = myStorePage.navigateSummerDressesPage();
    }

    @Given("^I select a summer dress and add to cart$")
    public void i_select_a_summer_dress_and_add_to_cart() throws Exception {
        summerDressesCatalogPage.selectSummerDress();
    }

    @When("^I see the summer dress in cart$")
    public void i_see_the_summer_dress_in_cart() {
        assertThat(shoppingCartSummaryPage.dressInCart(), is(true));
    }

    @When("^I click proceed to checkout$")
    public void i_click_proceed_to_checkout() {
        signInPage = shoppingCartSummaryPage.proceedToCheckout();
    }

    @Then("^I should be on the authentication sigIn page$")
    public void i_should_be_on_the_authentication_sigIn_page() {
        assertThat(signInPage.isSignInButtonPresent(), is(true));
    }

    @After
    public void afterTest(){
        driver.quit();
    }


}
