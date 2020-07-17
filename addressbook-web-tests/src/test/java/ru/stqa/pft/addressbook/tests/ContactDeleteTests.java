package ru.stqa.pft.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteTests extends  TestBase {


  @Test
  public void testContactDelete() throws Exception {
    applicationManager.getNavigationHelper().returnToHomePage();
    if (!applicationManager.getContactHelper().isThereAContact()){
      applicationManager.getContactHelper().createContact(new ContactData("Marianna", "Estrina", "Holon", "0865567", "marianna@mail.ru" ,"test1" ),true);
    }
    List<ContactData> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().selectContact(before.size() -1 );
    applicationManager.getContactHelper().deleteSelectedContact();
    applicationManager.getContactHelper().acceptAlert();
    applicationManager.getNavigationHelper().returnToHomePage();
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);

  }


}
