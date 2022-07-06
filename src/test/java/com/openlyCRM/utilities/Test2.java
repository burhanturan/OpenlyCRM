package com.openlyCRM.utilities;

import com.openlyCRM.pages.ActiveStreamPage;
import com.openlyCRM.pages.OpenlyCRMLoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

    OpenlyCRMLoginPage loginPage = new OpenlyCRMLoginPage();
    ActiveStreamPage activeStreamPage = new ActiveStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    String expectedMentionedEmployee;



//    @Test // ac1-1
//    public void test1(){
//        loginPage.login();
//        activeStreamPage.messageButton.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.addMentionButton));
//        activeStreamPage.addMentionButton.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.mentionEmployeesAndDepartmentButton));
//        activeStreamPage.mentionEmployeesAndDepartmentButton.click();
//        activeStreamPage.mentionHr3Department.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.mentionedEmployee));
//        expectedMentionedEmployee = activeStreamPage.mentionedEmployee.getText();
//        activeStreamPage.mentionedEmployee.click();
//
//        activeStreamPage.deleteAllEmployees.click();
//        //BrowserUtils.sleep(2);
//        activeStreamPage.sendButton.click();
//
//        String actualMentionedMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'feed-post-contentview-BLOG_POST-')])[1]"));
//        //String expectedMentionedEmployee = activeStreamPage.mentionedEmployee.getText();
//        Assert.assertTrue(actualMentionedMessageBody.contains(expectedMentionedEmployee));
//
//    }

    @Test // ac1-2
    public void test2(){
        loginPage.login();
        activeStreamPage.messageButton.click();

        activeStreamPage.addMentionButton.click();

        activeStreamPage.mentionEmployeesAndDepartmentButton.click();

        expectedMentionedEmployee = activeStreamPage.mentionEmployeeOutsideDepartment.getText();
        System.out.println("AC1-2 expected: "+expectedMentionedEmployee);

        BrowserUtils.waitForClickablility(activeStreamPage.mentionEmployeeOutsideDepartment,10);
        activeStreamPage.mentionEmployeeOutsideDepartment.click();

        activeStreamPage.sendButton.click();

        String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'feed-post-contentview-BLOG_POST-')])[1]"));
        System.out.println("AC1-2 actual: "+actualMessageBody);

        Assert.assertFalse(actualMessageBody.contains(expectedMentionedEmployee));
    }


    @Test //ac2-4
    public void test3(){
        loginPage.login();
        activeStreamPage.messageButton.click();

        activeStreamPage.linkButton.click();

        String expectedLinkText = "textOfLink";
        activeStreamPage.textInputBox.sendKeys(expectedLinkText);
        activeStreamPage.linkSaveButton.click();
        activeStreamPage.sendButton.click();


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(@id,'blog_post_body')])[1]")));
        //String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'blog_post_body')])[1]"));
        String actualMessageBody = "";  // Driver.getDriver().findElement(By.xpath("(//div[contains(@id,'blog_post_body')])[1]")).getText();

        By messageBodyLocator = By.xpath("(//div[contains(@id,'blog_post_body')])[1]");
        WebElement messageBodyElement = Driver.getDriver().findElement(messageBodyLocator);
        actualMessageBody = messageBodyElement.getText();

        System.out.println("expected: "+expectedLinkText);
        System.out.println("actual  : "+actualMessageBody);


        Assert.assertFalse(actualMessageBody.contains(expectedLinkText));
    }

}
