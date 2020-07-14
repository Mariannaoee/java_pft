package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreateTests extends TestBase{

  @Test
  public void testContactCreate()  {
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> before = app.getNavigationHelper().getContactList();
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().fillContactForm(new ContactData("Marianna", "Estrina", "Holon", "0865567", "marianna@mail.ru" ,"test1" ),true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getNavigationHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


  }

}
