package com.openlyCRM.utilities;

import com.openlyCRM.pages.ActiveStreamPage;
import com.openlyCRM.pages.OpenlyCRMLoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

    OpenlyCRMLoginPage loginPage = new OpenlyCRMLoginPage();
    ActiveStreamPage activeStreamPage = new ActiveStreamPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @org.junit.Test
    public void test() {


        loginPage.login();

        activeStreamPage.messageButton.click();


        //WebElement frame = Driver.getDriver().findElement(By.xpath("bx-editor-iframe"));
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.sendButton));

        WebElement element = Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-destination-item']"));
        System.out.println("toList: " + element.getText());

        Driver.getDriver().switchTo().frame(0);
        WebElement messageBody = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']"));
        messageBody.sendKeys("asdads");


    }

    @org.junit.Test
    public void test2() {
        loginPage.login();

        WebElement moreButton = Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();
        WebElement fileButton = Driver.getDriver().findElement(By.xpath("(//span[.='File'])[5]"));

        wait.until(ExpectedConditions.visibilityOf(fileButton));

        fileButton.click();
        WebElement fileUpload = Driver.getDriver().findElement(By.xpath("(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[1]"));
        fileUpload.sendKeys("C:\\Users\\Turan\\Desktop\\Screenshot_1.png");
        BrowserUtils.sleep(2);

        WebElement editButton = Driver.getDriver().findElement(By.xpath("//span[@class='files-name-edit-btn']"));

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true)", editButton);
        executor.executeScript("arguments[0].click();", editButton);
//
//
//        Actions actions = new Actions(Driver.getDriver());
//        BrowserUtils.sleep(2);
//
//        executor.executeScript("arguments[0].scrollIntoView(true)", editButton);
//        //actions.moveToElement(editButton).perform();
//        editButton.click();

    }

    @org.junit.Test
    public void test3() {
        loginPage.login();
        WebElement editButton = Driver.getDriver().findElement(By.xpath("//span[@class='feed-destination-edit']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(editButton).perform();
        editButton.click();


    }

    @org.junit.Test
    public void test4() {
        loginPage.login();
        WebElement filterInput = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Filter and search']"));
        filterInput.click();
        WebElement addFilterButton = Driver.getDriver().findElement(By.xpath("//*[.='Add field']"));
        addFilterButton.click();

        WebElement dateFilter = Driver.getDriver().findElement(By.xpath("//div[@data-id='field_DATE_CREATE']"));

        System.out.println("dateFilter.getAttribute(\"class\") = " + dateFilter.getAttribute("class"));


    }

    @org.junit.Test
    public void test5() {
        loginPage.login();
        activeStreamPage.messageButton.click();

        BrowserUtils.waitForClickablility(activeStreamPage.addQuoteTextButton, 10);

        activeStreamPage.addQuoteTextButton.click();

        Driver.getDriver().switchTo().frame(activeStreamPage.iframe);

        activeStreamPage.blockQuote.sendKeys("Hello again!!");

        Driver.getDriver().switchTo().defaultContent();

        activeStreamPage.sendButton.click();

    }

    @org.junit.Test
    public void test6() {
        loginPage.login();

        WebElement messageBody = Driver.getDriver().findElement(By.xpath("//div[contains(@id,'blog_post_outer')]"));

        System.out.println(messageBody.getText());

        WebElement noIndex = Driver.getDriver().findElement(By.xpath("(//div//noindex)[1]//a"));

        System.out.println("BrowserUtils.isElementPresent(By.xpath(\"(//div//noindex)[1]\")) = " + BrowserUtils.isElementPresent(By.xpath("(//div//noindex)[1]//a")));

        System.out.println("noIndex.getText() = " + noIndex.getText());
    }

    @org.junit.Test
    public void test7() {

        // comes from page class to login to homepage
        loginPage.login();

        WebElement eventButton = Driver.getDriver().findElement(By.xpath("//span//span[.='Event']"));

        eventButton.click();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String expectedDate = sdf.format(Calendar.getInstance().getTime());
        System.out.println("expectedDate = " + expectedDate);


        WebElement beginDate = Driver.getDriver().findElement(By.xpath("//input[@id='feed-cal-event-fromcal_3Jcl']"));

        BrowserUtils.waitForClickablility(beginDate, 10);

        wait.until(ExpectedConditions.elementToBeClickable(beginDate));

        String actualDate = beginDate.getAttribute("value");
        System.out.println("actualDate = " + actualDate);

        Assert.assertEquals(expectedDate, actualDate);

    }

    @org.junit.Test
    public void test8() {
        loginPage.login();
        Driver.getDriver().findElement(By.id("feed-add-post-form-tab-vote")).click();

        WebElement question = Driver.getDriver().findElement(By.id("question_0"));

        question.sendKeys("Question?");

        WebElement ans1 = Driver.getDriver().findElement(By.id("answer_0__0_"));
        ans1.sendKeys("1.Answer");
        WebElement ans2 = Driver.getDriver().findElement(By.id("answer_0__1_"));

        ans2.sendKeys("2.Answer");

//        System.out.println("ques"+question.getText());
//
//        System.out.println("ans1.getText() = " + ans1.getText());
//
//        System.out.println("ans2.getText() = " + ans2.getText());
        Driver.getDriver().switchTo().frame(activeStreamPage.iframe);

        WebElement messageBody = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']"));

        messageBody.sendKeys("Hello2");

        Driver.getDriver().switchTo().defaultContent();

        WebElement sendBtn = Driver.getDriver().findElement(By.id("blog-submit-button-save"));
        BrowserUtils.waitForClickablility(sendBtn, 10);
        sendBtn.click();

        Actions actions = new Actions(Driver.getDriver());


    }

    @org.junit.Test
    public void test9() {
        loginPage.login();

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Filter and search']"));
        searchBox.click();

        //WebElement dateDropDown = Driver.getDriver().findElement(By.xpath("//span[@class='main-ui-select-name']"));

        WebElement dateDropDown = Driver.getDriver().findElement(By.xpath("//div[@data-name='DATE_CREATE_datesel']"));

        Actions actions = new Actions(Driver.getDriver());

        //WebElement yesterdayElement = Driver.getDriver().findElement(By.xpath("//span[.='Yesterday']"));


        WebElement tagInput = Driver.getDriver().findElement(By.xpath("//input[@class='main-ui-control main-ui-control-string']"));
        tagInput.sendKeys("58");

         BrowserUtils.setAttribute(dateDropDown, "data-value", "{\"NAME\":\"Yesterday\",\"VALUE\":\"YESTERDAY\"}");

        //System.out.println("Yesterday: "+yesterdayElement.getText());


        //actions.moveToElement(dateDropDown).click().sendKeys(Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
        BrowserUtils.sleep(1);

        BrowserUtils.clickWithJS(dateDropDown);
        BrowserUtils.sleep(1);
        //dateDropDown.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        BrowserUtils.sleep(1);


        actions.sendKeys(Keys.ENTER).perform();
        BrowserUtils.sleep(3);






    }


}
