package pageObjects;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver browser)
    {
        PageFactory.initElements(browser,this);
    }

    @FindBy(xpath = "//li[@data-section]/a")
    public WebElement myAccountLink;

       @FindBy(id="EmailOrAccountNumber")
        public WebElement usernameField;


    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(id = "SignInNow")
    public WebElement signinIcon;

    public void clickMyAccountLink()
    {
        myAccountLink.click();
    }

    public void enterUsername(String un)
    {
        usernameField.sendKeys(un);
    }

    public void enterPassword(String ps)
    {
        passwordField.sendKeys(ps);
    }

    public void clickSigninIcon()
    {
        signinIcon.click();
    }

}


