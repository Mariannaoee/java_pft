package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreateTests extends TestBase{

  @Test
  public void testContactCreate()  {
    applicationManager.goTo().homePage();
    List<ContactData> before = applicationManager.contact().list();
    applicationManager.goTo().addNewPage();
    ContactData contact = new ContactData("Marianna", "Estrina");
    applicationManager.contact().createContact(contact,true);
    applicationManager.goTo().homePage();
    List<ContactData> after = applicationManager.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData c : after)//variable g that runs in list after
      if (c.getId() > max) {
        max = c.getId();
      }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}