package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreateTests extends TestBase{

  @Test
  public void testContactCreate()  {
    applicationManager.goTo().homePage();
    Contacts before = applicationManager.contact().list();
    applicationManager.goTo().addNewPage();
    ContactData contact = new ContactData().withFirstname("Marianna").withSurname("Estrina");
    applicationManager.contact().createContact(contact,true);
    applicationManager.goTo().homePage();
    Contacts after = applicationManager.contact().list();
    assertThat(after.size(), equalTo(before.size() + 1));

    int max = 0;
    for (ContactData c : after)//variable g that runs in list after
      if (c.getId() > max) {
        max = c.getId();
      }
    contact.setId(max);
    before.add(contact);
    assertThat(after, equalTo(before.withAdded(contact)));
  }

}