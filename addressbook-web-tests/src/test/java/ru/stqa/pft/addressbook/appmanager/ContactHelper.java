package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

//
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void submitContactCreation() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        firstname(By.name("firstname"), contactData.getFirstname());
        firstname(By.name("lastname"), contactData.getSurname());

        if (creation) {
            new Select(webDriver.findElement(By.name("new_group"))).selectByIndex(1);
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    private void firstname(By locator, String text) {
        webDriver.findElement(locator).click();
        webDriver.findElement(locator).clear();
        webDriver.findElement(locator).sendKeys(text);
    }

    public void acceptAlert() {

        webDriver.switchTo().alert().accept();
    }

    public void selectContact(int index) {
        webDriver.findElements(By.name("selected[]")).get(index).click();

    }

    public void deleteSelectedContact() {

        click(By.xpath("//input[@value='Delete']"));
    }

    public void initContactModification(int index) {

        webDriver.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    }

    public void submitContactModification() {

        click(By.name("update"));
    }
    public void returnToHomePage () {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void createContact(ContactData contactData, boolean b) {
        goContactPage();
        fillContactForm(contactData, b);
        submitContactCreation();


    }

    public void modifyContact(ContactData contactForModification, int index) {
        selectContact(index);
        initContactModification(index);
        fillContactForm(contactForModification,false);
        submitContactModification();
        returnToHomePage();
    }
    public void deleteContact(List<ContactData> before) {
        selectContact(before.size() -1 );
        deleteSelectedContact();
        acceptAlert();
        returnToHomePage();
    }


    private void goContactPage() {

        click(By.linkText("add new"));
    }


    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {

        return webDriver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {

        List<ContactData> contacts = new ArrayList<ContactData>();

        List<WebElement> elementsTr = webDriver.findElements(By.name("entry"));
        String surname;
        String firstname;
        int id;


        for (int i = 0; i < elementsTr.size(); i++) {

            // get tr element from list
            WebElement elementTr = elementsTr.get(i);

            // get all td for specific tr
            List<WebElement> cols = elementTr.findElements(By.tagName("td"));
            id =Integer.parseInt (cols.get(0).findElement(By.tagName("input")).getAttribute("value"));
            surname = cols.get(1).getText();
            firstname = cols.get(2).getText();



            // create new contact data and add to contacts list
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withSurname(surname));
        }
        return contacts;
    }
}