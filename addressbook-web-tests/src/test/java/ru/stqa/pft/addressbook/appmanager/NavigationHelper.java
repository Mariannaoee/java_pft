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

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("name.entry"));
        for (WebElement element: elements){
            String firstname = element.getText();
            String surname = element.getText();
            String address = element.getText();
            String mobile = element.getText();
            String email =element.getText();
            ContactData contact= new ContactData(firstname,surname,address,mobile,email, null);
            contacts.add(contact);
        }
        return contacts;
    }

}

