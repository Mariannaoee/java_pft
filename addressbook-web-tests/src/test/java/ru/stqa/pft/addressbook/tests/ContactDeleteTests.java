package ru.stqa.pft.addressbook.tests;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteTests extends  TestBase {
  @BeforeMethod
  public  void ensurePreconditions(){
    applicationManager.goTo().homePage();
    if (applicationManager.contact().list().size()==0) {
      applicationManager.contact().createContact(new ContactData().withFirstname("Marianna").withSurname("Estrina"), true);
    }
  }

  @Test
  public void testContactDelete() throws Exception {

    Contacts before = applicationManager.contact().list();
    ContactData deletedContact = before.iterator().next();
    applicationManager.contact().deleteContact(deletedContact);
    Contacts  after = applicationManager.contact().list();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));

  }




}