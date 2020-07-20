package ru.stqa.pft.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteTests extends  TestBase {
  @BeforeMethod
  public  void ensurePreconditions(){
    applicationManager.goTo().homePage();
    if (applicationManager.contact().list().size()==0) {
      applicationManager.contact().createContact(new ContactData("Marianna", "Estrina"), true);
    }
  }

  @Test
  public void testContactDelete() throws Exception {

    List<ContactData> before = applicationManager.contact().list();

    applicationManager.contact().deleteContact(before);
    List<ContactData> after = applicationManager.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);

  }




}