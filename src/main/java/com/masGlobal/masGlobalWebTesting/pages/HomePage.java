package com.masGlobal.masGlobalWebTesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase{
    private By inputSearchField = By.xpath("//input[@class=\"gLFyf gsfi\"]");
    private WebElement inputSearchButton = driver.findElement(By.xpath("//div[@class=\"FPdoLc tfB0Bf\"]//input[@value=\"Google Search\"]"));
    private By searchResult = By.xpath("//div[@class=\"rc\"]//h3//span");
    private WebElement googleLogo = driver.findElement(By.id("hplogo"));
    private By author = By.xpath("//a[@data-asin=\"B001DAHXZQ\"]");
    private By authorPage = By.xpath("//a[text()=\"Visit Amazon's Patrick Rothfuss Page\"]");
    private By divAuthorName = By.id("authorName");
    private By spanSuggestionList = By.xpath("//ul[@class=\"erkvQe\"]//li//span");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputSearchButton() {
        return inputSearchButton;
    }

    public WebElement getGoogleLogo() {
        return googleLogo;
    }

    public void typeIntoSearchField (String text) {
        driver.findElement(inputSearchField).sendKeys(text);
    }

    public String getSearchResultTitle() {
        return driver.findElements(searchResult).get(0).getText();
    }

    public List<WebElement> getSearchResultList() {
       return driver.findElements(searchResult);
    }

    public WebElement getAuthor() {
        return driver.findElement(author);
    }

    public WebElement getAuthorPage() {
        return driver.findElement(authorPage);
    }

    public WebElement getDivAuthorName() {
        return driver.findElement(divAuthorName);
    }

    public List<WebElement> getSuggestionList() {
        return driver.findElements(spanSuggestionList);
    }
}

