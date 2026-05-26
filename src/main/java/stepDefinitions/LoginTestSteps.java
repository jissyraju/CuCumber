package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Homepage;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginTestSteps extends CommonFunctions {

    Homepage homepage = new Homepage(browser);
    LoginPage loginpage = new LoginPage(browser);


    @Given("I'm on home page in browser {string}")

    public void Home_Login(String url) {
        homepage.openHomePage(url);


    }

    @When("I click on MyAccount Link")
    public void clickMyAccountLink() throws IOException {
        loginpage.clickMyAccountLink();
        takeScreenShot("loginpage");
    }

    @When("I enter username {string}")
    public void enterValidUsername(String username) {
        loginpage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void enterValidPassword(String password) {
        loginpage.enterPassword(password);
    }

    @When("I click on SignIn button")
    public void clickSignInButton() {
        loginpage.clickSigninIcon();
    }

    @Then("I should login successfully with re-direction to profile page")

    public void verifyLoginPage() {
        String expectedLoginPage = "Customer Number:Y6R02272";
        System.out.println(expectedLoginPage);
        String actualLoginPage = browser.findElement(By.xpath("//div[@class=\"summaryBox\"]")).getText();
        System.out.println(actualLoginPage);
        Assert.assertEquals(expectedLoginPage,actualLoginPage);


    }


}


