package com.masGlobal.masGlobalWebTesting.tests;

import com.masGlobal.masGlobalWebTesting.data.UserData;
import com.masGlobal.masGlobalWebTesting.pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPatrickRothfussPageTest extends TestBase {
    @Test(description = "Verify the user can get Patrick Rothfuss page")
    public void checkPatrickRothfussPage()
    {   HomePage user = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);

        //Given I’m on the homepage
        //When I type “The name of the wind” into the search field
        user.typeIntoSearchField(UserData.BOOKTITLE);
        user.getGoogleLogo().click();
        //And I click the Google Search button
        user.getInputSearchButton().click();
        //Then I go to the search results page
        //And the first result is “The Name of the Wind - Patrick Rothfuss”
        Assert.assertTrue(user.getSearchResultTitle().toLowerCase().contains(UserData.BOOKTITLE.toLowerCase()));
        Assert.assertTrue(user.getSearchResultTitle().toLowerCase().contains(UserData.AUTHOR.toLowerCase()));
        //When I click on the first result link
        user.getSearchResultList().get(0).click();
        wait.until(ExpectedConditions.visibilityOf(user.getAuthor()));
        //Then I go to the “Patrick Rothfuss - The Books” page
        actions.moveToElement(user.getAuthor()).perform();
        user.getAuthorPage().click();
        wait.until(ExpectedConditions.visibilityOf(user.getDivAuthorName()));
    }
}
