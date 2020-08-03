package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void submitContactCreation() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSurname());
        attach(By.name("photo"), contactData.getPhoto());

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

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void createContact(ContactData contactData, boolean b) {
        goContactPage();
        fillContactForm(contactData, b);
        submitContactCreation();
        contactCache = null;

    }

    public void modifyContact(ContactData contactForModification, int index) {
        selectContact(index);
        initContactModification(index);
        fillContactForm(contactForModification, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }

    public void deleteContact(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        acceptAlert();
        contactCache = null;
        returnToHomePage();
    }

    private void selectContactById(int id) {
        webDriver.findElement(By.cssSelector("input[value = '" + id + "']")).click();
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

    private Contacts contactCache = null;

    public Contacts list() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elementsTr = webDriver.findElements(By.name("entry"));
        String surname;
        String firstname;
        int id;

        for (int i = 0; i < elementsTr.size(); i++) {

            // get tr element from list
            WebElement elementTr = elementsTr.get(i);

            // get all td for specific tr
            List<WebElement> cells = elementTr.findElements(By.tagName("td"));
            id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            surname = cells.get(1).getText();
            firstname = cells.get(2).getText();
            String[] phones = cells.get(5).getText().split("\n");

            // create new contact data and add to contacts list
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withSurname(surname)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return new Contacts(contactCache);
    }
 /*   public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = webDriver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String[] phones = cells.get(5).getText().split("\n");
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withSurname(lastname)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
return contacts;
    }*/

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = webDriver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = webDriver.findElement(By.name("lastname")).getAttribute("value");
        String home = webDriver.findElement(By.name("home")).getAttribute("value");
        String mobile = webDriver.findElement(By.name("mobile")).getAttribute("value");
        String work = webDriver.findElement(By.name("work")).getAttribute("value");
        webDriver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname)
                .withSurname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

    private void initContactModificationById(int id) {
        WebElement checkbox = webDriver.findElement(By.cssSelector(String.format("input[value='%s']", id)));// find checkbox
        WebElement row = checkbox.findElement(By.xpath("./../.."));//find row
        List<WebElement> cells = row.findElements(By.tagName("td"));//take list of columns
        cells.get(7).findElement(By.tagName("a")).click();//take the 8th column (edit column).. numeration starts from 0

        // webDriver.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
        // webDriver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
        // webDriver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }
}