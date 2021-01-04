package com.masGlobal.masGlobalWebTesting.tests;

import com.masGlobal.masGlobalWebTesting.data.UserData;
import com.masGlobal.masGlobalWebTesting.pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyFirstResultLinkTest extends TestBase {
    @Test(description = "Verify the user will see “The Name of the Wind - Patrick Rothfuss” as first result link on search results page")
    public void checkFirstResultLink()
    {   HomePage user = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);

        //Given I’m on the homepage
        //When I type “The name of the w” into the search field
        user.typeIntoSearchField(UserData.REDUCEDTITLE);
        //And the suggestions list is displayed
        //And I click on the first suggestion in the list
        user.getSuggestionList().get(0).click();
        //Then I go to the search results page
        //And the first result is “The Name of the Wind - Patrick Rothfuss”
        Assert.assertTrue(user.getSearchResultTitle().toLowerCase().contains(UserData.BOOKTITLE.toLowerCase()));
        Assert.assertTrue(user.getSearchResultTitle().toLowerCase().contains(UserData.AUTHOR.toLowerCase()));
        //When I click on the first result link
        user.getSearchResultList().get(0).click();
        wait.until(ExpectedConditions.visibilityOf(user.getAuthor()));
        actions.moveToElement(user.getAuthor()).perform();
        user.getAuthorPage().click();
        //Then I go to the “Patrick Rothfuss - The Books” page
        wait.until(ExpectedConditions.visibilityOf(user.getDivAuthorName()));
    }
}
