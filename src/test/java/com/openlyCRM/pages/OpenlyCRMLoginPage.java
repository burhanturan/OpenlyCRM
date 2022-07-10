package com.openlyCRM.pages;

import com.openlyCRM.utilities.ConfigurationReader;
import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenlyCRMLoginPage {

    public OpenlyCRMLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    private WebElement username;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(xpath = "//input[@class='login-btn']")
    private WebElement loginButton;

    public void login() {
        Driver.getDriver().get(ConfigurationReader.getProperty("openlyCRM.url"));
        this.username.sendKeys(ConfigurationReader.getProperty("openlyCRM.email3"));
        this.password.sendKeys(ConfigurationReader.getProperty("openlyCRM.password"));
        this.loginButton.click();
    }

}
