package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    public static WebDriver browser;

    public String screenShotFilePath = new File("src/main/resources/screenShots").getAbsolutePath();

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.get("http://www.next.co.uk");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    public void closeBrowser() {
        browser.quit();
    }

    //to find element
    public void waitTime(int waitTime) {
        browser.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    //wait until an element to load- solves 'No such element''Unable to locate element' kind of errors
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*for errors like 'unable to type','elements not visible''element not on focus''element click intercepted'
    'element click not interceptable' in general errors with actions like clicks so do javascript way of clicking
     */
    public void JSClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("arguments[0].click();,elements");
    }

    // if the element to click or find is at the bottom of the page to scroll down the page
    public void scrollTo() {
        JavascriptExecutor jse = (JavascriptExecutor) browser;
        jse.executeScript("window.scrollBy(0,750)");
    }
    //if there is no focus on particular element we use a class called 'actions' in selenium.
    public void mouseOver(WebElement element)
    {
        Actions actions = new Actions(browser);
        actions.moveToElement(element).build().perform();
    }
    public void DoEnter()
    {
        Actions actions = new Actions(browser);
        actions.keyDown(Keys.ENTER).build().perform();

    }
    //exception handling(throws IOException) when our compiler got permission to do it
public void takeScreenShot(String filename) throws IOException
{
        TakesScreenshot screenshot = ((TakesScreenshot) browser);
        File virtualFile = screenshot.getScreenshotAs(OutputType.FILE);
        File physicalFile = new File("screenShotFilePath+filename");
        FileUtils.copyFile(virtualFile,physicalFile);
}
/*if compiler dont have permission then do the following step
public void takeScreenShot()
{
        TakesScreenshot screenshot = ((TakesScreenshot) browser);
        File virtualFile = screenshot.getScreenshotAs(OutputType.FILE);
        File physicalFile = new File("C:\\Users\\rosem\\IdeaProjects\\CucumberBDDLearning\\src\\main\\resources\\screenShots\\homepage.png");
        try{
        FileUtils.copyFile(virtualFile,physicalFile);}
        catch (Exception e)
        {
        e.printStackTrace();
        }

}*/
}
