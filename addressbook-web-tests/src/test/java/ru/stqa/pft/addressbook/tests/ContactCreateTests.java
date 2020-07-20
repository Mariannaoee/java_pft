package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreateTests extends TestBase{

  @Test
  public void testContactCreate()  {
    applicationManager.getNavigationHelper().returnToHomePage();
    List<ContactData> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getNavigationHelper().gotoAddNewPage();
    ContactData contact = new ContactData("Marianna", "Estrina", null, null, null ,null);
    applicationManager.getContactHelper().createContact(contact,true);
    applicationManager.getNavigationHelper().returnToHomePage();
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
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
