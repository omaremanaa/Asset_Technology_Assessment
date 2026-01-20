package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver webDriver;
    private ActionBot actionBot;


    public ProductsPage (WebDriver webDriver){
        this.webDriver = webDriver;
        this.actionBot = new ActionBot(webDriver);
    }

    private final By secondCategory = By.xpath("//*[@role='list']//div[@role='listitem'][position()=2]");
    private final By firstProduct = By.xpath("//div[@data-testid='virtuoso-item-list']//div[@data-index='0']//div[@data-test-index='0']");

    public ProductsPage selectSecondCategory(){
        actionBot.clickElement(secondCategory);
        return this;
    }
}
