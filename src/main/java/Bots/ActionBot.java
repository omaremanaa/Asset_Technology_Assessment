package Bots;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionBot {
    private WebDriver webDriver;
    private WaitBot waitBot;
    private Actions actions;

    public ActionBot(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.waitBot = new WaitBot(webDriver);
        this.actions = new Actions(webDriver);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return webDriver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickElement(By locator)
    {
        waitBot.waitFor(() -> isElementDisplayed(locator), 5);
        webDriver.findElement(locator).click();
    }

    public void typeText(By locator, String text){
        waitBot.waitFor(() -> isElementDisplayed(locator), 5);
        webDriver.findElement(locator).sendKeys(text);
    }

    public String readText(By locator){
        waitBot.waitFor(() -> isElementDisplayed(locator), 5);
        return webDriver.findElement(locator).getText();
    }

    public void hoverOverElement(By locator) {
        waitBot.waitFor(() -> isElementDisplayed(locator), 5);
        actions.moveToElement(webDriver.findElement(locator)).perform();
    }
}
