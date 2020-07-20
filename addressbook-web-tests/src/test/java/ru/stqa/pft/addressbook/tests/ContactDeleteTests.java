package ru.stqa.pft.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteTests extends  TestBase {
  @BeforeMethod
  public  void ensurePreconditions(){
    applicationManager.getNavigationHelper().returnToHomePage();
    if (!applicationManager.getContactHelper().isThereAContact()) {
      applicationManager.getContactHelper().createContact(new ContactData("Marianna", "Estrina",
              null, null, null, null), true);
    }
  }

  @Test
  public void testContactDelete() throws Exception {

    List<ContactData> before = applicationManager.getContactHelper().getContactList();

    applicationManager.getContactHelper().deleteContact(before);
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);

  }




}