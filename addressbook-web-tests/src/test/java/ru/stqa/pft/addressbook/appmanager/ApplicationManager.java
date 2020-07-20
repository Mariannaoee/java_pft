package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
        //all helper classes and webDriver
        WebDriver webDriver;
        private SessionHelper sessionHelper;
        private NavigationHelper navigationHelper;
        private GroupHelper groupHelper;
        private ContactHelper contactHelper;
        private String browser;

        // constructor that receive the browser type
        public ApplicationManager(String browser) {
                this.browser = browser;
        }

        public void init() {

                // initialize Browser
                initializeBrowser();
                //
                webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                webDriver.get("http://localhost/addressbook/");

                groupHelper = new GroupHelper(webDriver);
                contactHelper= new ContactHelper(webDriver);
                navigationHelper = new NavigationHelper(webDriver);
                sessionHelper = new SessionHelper(webDriver);
                sessionHelper.login("admin", "secret");
        }

        // initialize browser by browser type that received from constructor
        private void initializeBrowser() {

                if (browser.equals(BrowserType.FIREFOX)){
                        webDriver = new FirefoxDriver();
                }else if (browser.equals(BrowserType.CHROME)){
                        webDriver = new ChromeDriver();
                }else if (browser.equals(BrowserType.IE)){
                        webDriver = new InternetExplorerDriver();
                }
        }

        public void stop() {

                webDriver.quit();
        }

        public GroupHelper getGroupHelper() {

                return groupHelper;
        }

        public NavigationHelper getNavigationHelper() {

                return navigationHelper;
        }

        public ContactHelper getContactHelper() {
                return contactHelper;
        }

}