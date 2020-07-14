package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
            return;{
            {
                click(By.linkText("groups"));
            }
        }
    }
        public void gotoAddNewPage () {
            if (wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry"))
                return; {
            }
            click(By.linkText("add new"));
        }

            public void returnToHomePage () {
                if (isElementPresent(By.id("maintable"))) {
                    return;
                }
                click(By.linkText("home"));
            }



}

