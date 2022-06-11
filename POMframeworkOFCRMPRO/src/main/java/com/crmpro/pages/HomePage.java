package com.crmpro.pages;

import com.crmpro.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'User: shubhangi Amilkanthwar')]")
    @CacheLookup
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public void clickOnNewContactLink() {
        Actions action = new Actions(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        action.moveToElement(contactsLink).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        newContactLink.click();


    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
}
