package Pages;

import Bots.ActionBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver webDriver;
    private ActionBot actionBot;

    private final By emailField = By.xpath("//input[@type='email']");
    private final By loginButton = By.cssSelector("[class=\"a-button-input\"]");
    private final By createUserButton = By.xpath("//span[@id='intention-submit-button']");


    public LoginPage (WebDriver webDriver){
        this.webDriver = webDriver;
        this.actionBot = new ActionBot(webDriver);
    }

    @Step("Login to amazon with invalid email: {randomEmail}")
    public LoginPage logIn(String randomEmail){
        actionBot.typeText(emailField, randomEmail);
        actionBot.clickElement(loginButton);
        return this;
    }

    @Step("Verify user didn't bypass login with invalid email")
    public LoginPage verifyLoginBlockedWithInvalidEmail(String createButtonText){
        Assert.assertTrue(actionBot.readText(createUserButton).contains(createButtonText), "Create New User button text mismatch");
        return this;
    }


}