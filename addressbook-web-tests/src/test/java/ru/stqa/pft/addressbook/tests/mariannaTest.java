package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class mariannaTest {
    private WebDriver driver;

    @BeforeTest
    public void mariannaTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void Login() {
        driver.get("http://students-aid.org:9222/platforms/nuis/");
        driver.findElement(By.id("register")).click();
        By checkBoxWait = By.id("agreeTerms");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated( checkBoxWait));
        driver.findElement(By.id("firstname")).sendKeys("marianna");
        driver.findElement(By.id("personalId")).sendKeys("574546464");
        driver.findElement(By.id("lastname")).sendKeys("estrina");
        driver.findElement(By.id("phone")).sendKeys("0526212787");
        driver.findElement(By.id("dateOfBirth")).sendKeys("30071991");
        WebElement checkBox = driver.findElement(By.id("agreeTerms"));
        checkBox.click();
        driver.findElement(By.cssSelector("button[onclick^=nextFormTab]")).click();
        driver.findElement(By.xpath("//*[@id=\"form-register\"]/div[1]/div[4]/div[2]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'המשך')]")).click();

        driver.findElement(By.id("isStudentYes")).click();
        driver.findElement(By.id("academicSchool")).sendKeys("תל");

    }

    @AfterTest
        public void stop() {
            driver.quit();
            driver = null;
        }

    }

