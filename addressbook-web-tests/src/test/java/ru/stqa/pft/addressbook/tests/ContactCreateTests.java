package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreateTests extends TestBase{

  @Test
  public void testContactCreate()  {
    applicationManager.goTo().homePage();
    Contacts before = applicationManager.contact().list();
    applicationManager.goTo().addNewPage();
    File photo = new File("src/test/resources/mari.jpg");
    ContactData contact = new ContactData().withFirstname("Marianna").withSurname("Estrina").withPhoto(photo);
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

//  @Test
//  public void testCurrentDirectory(){
//    File currentDirectory = new File(".");
//    System.out.println(currentDirectory.getAbsolutePath());
//    File photo = new File("src/test/resources/mari.jpg");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//
//  }



}