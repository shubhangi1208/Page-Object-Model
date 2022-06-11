package com.crmpro.testcases;

import com.crmpro.base.TestBase;
import com.crmpro.pages.ContactsPage;
import com.crmpro.pages.HomePage;
import com.crmpro.pages.LoginPage;
import com.crmpro.util.TestUtil;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        //contactsPage = homePage.clickOnContactsLink();

    }

   /* @Test(priority = 1)
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
    }

    @Test(priority = 2)
    public void selectContactsTest(){
        contactsPage.selectContactsByName("xyz 123");
    }

    @Test(priority=3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactsByName("xyz 123");
        contactsPage.selectContactsByName("abc 123");

    }*/

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(priority=4,dataProvider="getCRMTestData")
    public void validateCreateNewContact(String title, String firstName, String lastName, String company){
        homePage.clickOnNewContactLink();
       //contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
        contactsPage.createNewContact(title, firstName, lastName, company);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
