package pageObjects;

import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends CommonFunctions {

    public Homepage(WebDriver browser)
    {PageFactory.initElements(browser,this);}

    @FindBy(id = "header-logo")
    public WebElement logoIcon;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookieButton;

    @FindBy(id="sli_search_1")
    public WebElement searchTxtField;

    @FindBy(className = "SearchButton")
    public WebElement searchIcon;

    @FindBy(id = "gel-bag-summary")
    public WebElement basketIcon;


    @FindBy(id = "helpsite")
    public WebElement helpLink;

    public void assertLogo()
    {
        Assert.assertTrue(logoIcon.isDisplayed());
    }

    public void clickCookieButton()
    {
        cookieButton.click();
    }

    public void typeSearchTerm(String searchTerm)
    {
        searchTxtField.sendKeys(searchTerm);
    }
    public void clickSearchIcon()
    {
        searchIcon.click();
    }
    public void clickBasketIcon()
    {
        basketIcon.click();
    }

    public void clickHelpLink()
    {
        helpLink.click();
    }
    public void openHomePage(String url){
        browser.get(url);
        waitTime(3);
      clickCookieButton();
      assertLogo();
    }
}
