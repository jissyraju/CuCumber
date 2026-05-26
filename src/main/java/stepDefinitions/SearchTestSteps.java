package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Homepage;

import java.io.IOException;
import java.util.List;

public class SearchTestSteps extends CommonFunctions {

    Homepage homepage = new Homepage(browser);
    @Given("I'm on home page {string}")

   public void HomePage_Search(String url) throws IOException
    {

        homepage.openHomePage(url);
        takeScreenShot("homepage.png");
    }

    @When("I enter searchTerm {string}")
    public void enterSearchTerm(String searchTerm) throws IOException
    {

        homepage.typeSearchTerm(searchTerm);
        takeScreenShot("searchterm.png");

    }

    @When("I click the searchButton")
    public void clickSearchButton() {
        homepage.clickSearchIcon();
    }

    @Then("I should get re-directed to search result page with relevant results and title  as {string}")
    public void verifySearchResults(String expectedSearchResultTitle) throws IOException
    {
       String actualValidTitle = browser.findElement(By.xpath("//div[@id=\"ResultHeader\"]/div/h1/div[@class=\"spell-correct\"]")).getText();
       System.out.println(actualValidTitle);
       Assert.assertEquals(expectedSearchResultTitle, actualValidTitle);
       String actualBrandTitle = browser.findElement(By.xpath("//div[@id=\"ResultHeader\"]/div/h1/div")).getText();
        System.out.println(actualBrandTitle);
        Assert.assertEquals(expectedSearchResultTitle,actualBrandTitle);
        takeScreenShot("SRPage.png");
    }
    @Then("I should see relevant products listed with name contains {string}")
 public void verifyRelevanceOfProduct(String expectedTermInProductList) throws IOException
    {
        List<WebElement> products = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page1");
        }
        scrollTo();
        List<WebElement> products1 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products1){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page2");
        }
        scrollTo();
        List<WebElement> products2 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products2){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page 3");

        }
        scrollTo();
        List<WebElement> products3 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products3){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page 4");

        }
        scrollTo();
        List<WebElement> products4 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products4){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page 5");

        }
        scrollTo();
        List<WebElement> products6 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products6){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page 6");
        }
        scrollTo();
        List<WebElement> products7 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products7){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
            takeScreenShot("page 7");
        }
        scrollTo();List<WebElement> products8 = browser.findElements(By.xpath("//a[@class=\"TitleText\"]/span"));
        for(WebElement product: products8){
            String actualProductName= product.getText();
            Assert.assertTrue(actualProductName.contains(expectedTermInProductList));
           takeScreenShot("page 8");
        }

    }
    @Then("I should get re-directed to search result page with message as {string}")
    public void verifySearchWithInvalidData(String expectedSearchFailed) throws IOException
    {

        String expectedSearchResult = "No results found for yogurt";
        String actualSearchResult = browser.findElement(By.xpath("//*[@id=\"rhs\"]/div[3]")).getText();
        System.out.println(actualSearchResult);
        Assert.assertTrue(expectedSearchResult.contains(actualSearchResult));
        takeScreenShot("invalidpage");
    }
    }
