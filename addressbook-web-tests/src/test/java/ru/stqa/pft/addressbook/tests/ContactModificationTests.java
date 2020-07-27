package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
    int num  = 0;
    @BeforeMethod
    public  void ensurePreconditions(){
        applicationManager.goTo().homePage();
        if (applicationManager.contact().list().size()==0) {
            applicationManager.contact().createContact(new ContactData().withFirstname("Marianna").withSurname("Estrina"), true);
        }
    }

    @Test
    public void testContactModification() {

        // go to contact list and choose contact that is created to edit
//        applicationManager.contact().initContactModification();
        Contacts before = applicationManager.contact().list();
        ContactData modifiedContact = before.iterator().next();
        int index = before.size() - 1;
        ContactData contactForModification = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Marianna").withSurname("Estrina");
        applicationManager.contact().modifyContact(contactForModification, index);

        Contacts after = applicationManager.contact().list();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contactForModification)));



    }


}