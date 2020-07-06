package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().returnToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Marianna", "Estrina", "Holon", "0865567", "mariann@mail.ru", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Marianna", "Estrina", "Holon", "0865567", "mariann@mail.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();

    }
}
