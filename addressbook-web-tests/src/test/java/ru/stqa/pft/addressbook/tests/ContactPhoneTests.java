package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones(){
        applicationManager.goTo().homePage();
        ContactData contact = applicationManager.contact().list().iterator().next();// load set of contacts
        ContactData contactInfoFromEditForm = applicationManager.contact().infoFromEditForm(contact);

    }


}
