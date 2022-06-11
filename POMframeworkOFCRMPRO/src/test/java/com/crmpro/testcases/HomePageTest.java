package com.crmpro.testcases;

import com.crmpro.base.TestBase;
import com.crmpro.pages.ContactsPage;
import com.crmpro.pages.DealsPage;
import com.crmpro.pages.HomePage;
import com.crmpro.pages.LoginPage;
import com.crmpro.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
    }

    @Test(priority=2)
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority=3)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }
    @Test(priority = 4)
    public void verifyDealsLinkTest(){
        testUtil.switchToFrame();
        dealsPage= homePage.clickOnDealsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
