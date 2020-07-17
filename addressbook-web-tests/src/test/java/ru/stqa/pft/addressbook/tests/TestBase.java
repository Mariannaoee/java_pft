package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

// this is our application class that starts the browser and close
public class TestBase {
    // this is our app manager that holds all helper classes and initialize all browser drivers (chrome, firefox,explorer)
    protected final ApplicationManager applicationManager = new ApplicationManager(BrowserType.CHROME);

    // init all browser and helper classes and make login with session helper class
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManager.init();
    }

    // stop the browser driver
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManager.stop();
    }

}