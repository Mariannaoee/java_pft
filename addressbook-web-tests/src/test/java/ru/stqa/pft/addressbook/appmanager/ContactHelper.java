package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        firstname(By.name("firstname"), contactData.getFirstname());
        firstname(By.name("lastname"), contactData.getSurname());
        firstname(By.name("address"), contactData.getAddress());
        firstname(By.name("mobile"), contactData.getMobile());
        firstname(By.name("email"), contactData.getEmail());
    }

    private void firstname(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void acceptAlert() {

        wd.switchTo().alert().accept();
    }

    public void selectContact() {

        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {

        click(By.xpath("//input[@value='Delete']"));
    }
}
