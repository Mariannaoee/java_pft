package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
    protected WebDriver webDriver;

    public HelperBase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // function that receive locator and click on it
    protected void click(By locator) {

        webDriver.findElement(locator).click();
    }

    // function that fill text by locator (input,text box etc)
    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {//if text not null
            String existingText = webDriver.findElement(locator).getAttribute("value");//take the value
            if (!text.equals(existingText)) {
                webDriver.findElement(locator).clear();
                webDriver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {//if file not null
            webDriver.findElement(locator).sendKeys(file.getAbsolutePath());
        }

    }

    public boolean isAlertPresent() {
        try {
            webDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // function that check if element is present
    protected boolean isElementPresent(By locator) {
        try{
            webDriver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex ){
            return false;
        }
    }
}