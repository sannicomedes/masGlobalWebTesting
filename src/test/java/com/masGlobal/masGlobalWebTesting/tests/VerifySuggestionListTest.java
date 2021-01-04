package com.masGlobal.masGlobalWebTesting.tests;

import com.masGlobal.masGlobalWebTesting.data.UserData;
import com.masGlobal.masGlobalWebTesting.pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySuggestionListTest extends TestBase {
    int textFontPxBeforeClick, textFontPxAfterClick, fontSize;

    @Test(description = "Verify Suggestion list")
    public void checkSuggestionList()
    {   HomePage user = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);

        //Given I’m on the homepage
        //When I type “The name of the w” into the search field
        user.typeIntoSearchField(UserData.REDUCEDTITLE);
        //Then suggestions list is displayed
        Assert.assertTrue(!user.getSuggestionList().isEmpty());
    }
}
