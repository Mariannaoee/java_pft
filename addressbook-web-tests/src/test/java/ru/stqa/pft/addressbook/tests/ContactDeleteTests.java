package ru.stqa.pft.addressbook.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactDeleteTests {
  private WebDriver wd;


  @Test
  public void testContactDelete() throws Exception {
    selectContact();
    deleteSelectedContact();
    acceptAlert();

  }

  private void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  private void selectContact() {
    wd.findElement(By.id("5")).click();
  }

  private void deleteSelectedContact() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }


}
