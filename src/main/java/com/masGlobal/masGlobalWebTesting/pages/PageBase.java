package com.masGlobal.masGlobalWebTesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }
}


