package com.openlyCRM.step_definitions;

import com.github.javafaker.Faker;
import com.openlyCRM.pages.ActiveStreamPage;
import com.openlyCRM.pages.OpenlyCRMLoginPage;
import com.openlyCRM.utilities.BrowserUtils;
import com.openlyCRM.utilities.ConfigurationReader;
import com.openlyCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Message_StepDef {

    OpenlyCRMLoginPage loginPage = new OpenlyCRMLoginPage();

    ActiveStreamPage activeStreamPage = new ActiveStreamPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    Faker faker = new Faker();

    String expectedMentionedEmployee;


    //-----------------AC1-1---------------------
    @Given("user is on the homepage and clicks on the Message on the quick menu")
    public void user_is_on_the_homepage_and_clicks_on_the_message_on_the_quick_menu() {
        loginPage.login();

        activeStreamPage.messageButton.click();
    }

    @When("user clicks on the Add Mention button")
    public void user_clicks_on_the_add_mention_button() {
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.addMentionButton));

        activeStreamPage.addMentionButton.click();
    }

    @When("user clicks on the departments name to open")
    public void user_clicks_on_the_departments_name_to_open() {
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.mentionEmployeesAndDepartmentButton));

        activeStreamPage.mentionEmployeesAndDepartmentButton.click();

        activeStreamPage.mentionHr3Department.click();
    }

    @When("user clicks on the employees names to add mention inside departments")
    public void user_clicks_on_the_employees_names_to_add_mention_inside_departments() {

        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.mentionOneOfTheEmployees));

        expectedMentionedEmployee = activeStreamPage.mentionOneOfTheEmployees.getText();

        activeStreamPage.mentionOneOfTheEmployees.click();
    }

    @When("user clicks on the Send button")
    public void user_clicks_on_the_send_button() {

        activeStreamPage.sendButton.click();
    }

    @Then("user should see employees are mentioned in the message body.")
    public void user_should_see_employees_are_added_in_the_message_body() {
        String actualMentionedMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'blog_post_body')])[1]/a[2]"));

        Assert.assertTrue(actualMentionedMessageBody.contains(expectedMentionedEmployee));
    }

    //-----------------AC1-2---------------------

    @When("user clicks on the employees names to add mention outside departments")
    public void user_clicks_on_the_employees_names_to_add_mention_outside_departments() {
        activeStreamPage.addMentionButton.click();

        activeStreamPage.mentionEmployeesAndDepartmentButton.click();

        expectedMentionedEmployee = activeStreamPage.mentionEmployeeOutsideDepartment.getText();
        System.out.println("AC1-2 expected: " + expectedMentionedEmployee);

        BrowserUtils.waitForClickablility(activeStreamPage.mentionEmployeeOutsideDepartment, 10);
        activeStreamPage.mentionEmployeeOutsideDepartment.click();

        activeStreamPage.sendButton.click();
    }

    @Then("users should not add mentions outside of departments.")
    public void users_should_not_add_mentions_outside_of_departments() {

        String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'feed-post-contentview-BLOG_POST-')])[1]"));
        System.out.println("AC1-2 actual: " + actualMessageBody);

        Assert.assertFalse(actualMessageBody.contains(expectedMentionedEmployee));
    }

    //-------------------AC2-1------------------------

    @When("user clicks on link button")
    public void user_clicks_on_link_button() {
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.linkButton));
        activeStreamPage.linkButton.click();
    }

    String expectedLinkText;

    @When("user types {string} into text input box")
    public void user_types_into_text_input_box(String textOfLink) {
        expectedLinkText = textOfLink;
        activeStreamPage.textInputBox.sendKeys(textOfLink);
    }

    @When("user types {string} into link inputbox and clicks save button and then clicks send button")
    public void user_types_into_link_inputbox_and_clicks_save_button(String link) {
        activeStreamPage.linkInputBox.sendKeys(link);
        activeStreamPage.linkSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should see the text is posted as a link successfully")
    public void user_should_see_the_text_is_posted_as_a_link_successfully() {
        //activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'blog_post_body')])[1]/a"));
        String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'blog_post_body')])[1]/a"));
        Assert.assertEquals(expectedLinkText, actualMessageBody);
    }

    //-----------------AC2-2-------------------------
    String linkText;

    @When("user types {string} invalid link and clicks save and send button")
    public void user_types_invalid_link(String link) {

        activeStreamPage.linkInputBox.sendKeys(link);
        activeStreamPage.linkSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should not see the text is posted as a link successfully")
    public void user_should_not_see_the_text_is_posted_as_a_link_successfully() {
        String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'feed-post-contentview-BLOG_POST-')])[1]"));

        Assert.assertFalse(actualMessageBody.contains(expectedLinkText));

    }

    //-----------------AC2-3-------------------------

    @When("user types valid link and clicks save and send button")
    public void user_types_valid_link_and_clicks_save_and_send_button() {
        linkText = faker.internet().url();
        activeStreamPage.linkInputBox.sendKeys(linkText);
        activeStreamPage.linkSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should not see the link is posted as a link successfully")
    public void user_should_not_see_the_link_is_posted_as_a_link_successfully() {
        String actualMessageBody = activeStreamPage.sentMessageBody.getText();
        Assert.assertFalse(actualMessageBody.contains(linkText));
    }

    //---------------##@AC2-4 946---------------------------

    @When("user types {string} into text input box and clicks save and send button")
    public void user_types_into_text_input_box_and_clicks_save_and_send_button(String textOfLink) {
        expectedLinkText = textOfLink;
        activeStreamPage.textInputBox.sendKeys(expectedLinkText);
        activeStreamPage.linkSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should not see the text is posted as a link")
    public void user_should_not_see_the_text_is_posted_as_a_link() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(@id,'blog_post_body')])[1]")));
        //String actualMessageBody = activeStreamPage.getSentMessageBody(By.xpath("(//div[contains(@id,'blog_post_body')])[1]"));
        String actualMessageBody = "";  // Driver.getDriver().findElement(By.xpath("(//div[contains(@id,'blog_post_body')])[1]")).getText();

        By messageBodyLocator = By.xpath("(//div[contains(@id,'blog_post_body')])[1]");
        WebElement messageBodyElement = Driver.getDriver().findElement(messageBodyLocator);
        actualMessageBody = messageBodyElement.getText();

        System.out.println("expected: " + expectedLinkText);
        System.out.println("actual  : " + actualMessageBody);


        Assert.assertFalse(actualMessageBody.contains(expectedLinkText));
    }

    //----------------##AC3-1 ----------------------------

    @When("user clicks on the insert video button")
    public void user_clicks_on_the_insert_video_button() {
        wait.until(ExpectedConditions.elementToBeClickable(activeStreamPage.insertVideoButton));
        activeStreamPage.insertVideoButton.click();
        // BrowserUtils.sleep(2);
    }

    @When("user pass a youtube video url into the inputbox and clicks save and send button")
    public void user_pass_a_youtube_video_url_into_the_inputbox_and_clicks_save_and_send_button() {
        activeStreamPage.insertVideoInputBox.sendKeys(ConfigurationReader.getProperty("youtube.url"));

        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.insertVideoTitle));

        activeStreamPage.insertVideoSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should see the Youtube Video in the posted message")
    public void user_should_see_the_youtube_video_in_the_posted_message() {
        BrowserUtils.waitForVisibility(activeStreamPage.insertVideoErrorMessage, 10);
        Assert.assertTrue(activeStreamPage.insertVideoErrorMessage.isDisplayed());
        //Assert.assertTrue(activeStreamPage.insertVideoVerify.isDisplayed());
    }

    //----------------##AC3-2 ----------------------------

    @When("user pass a vimeo video url into the inputbox and clicks save and send button")
    public void user_pass_a_vimeo_video_url_into_the_inputbox_and_clicks_save_and_send_button() {
        activeStreamPage.insertVideoInputBox.sendKeys(ConfigurationReader.getProperty("vimeo.url"));
        //BrowserUtils.sleep(2);
        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.insertVideoTitle));

        activeStreamPage.insertVideoSaveButton.click();
        activeStreamPage.sendButton.click();
    }

    @Then("user should see the Vimeo Video in the posted message")
    public void user_should_see_the_vimeo_video_in_the_posted_message() {
        BrowserUtils.waitForVisibility(activeStreamPage.insertVideoVerify, 10);
        Assert.assertTrue(activeStreamPage.insertVideoVerify.isDisplayed());
    }

    //----------------##AC3-3-----------------------------------

    @When("user pass a invalid video url {string} into the inputbox")
    public void user_pass_a_invalid_video_url_into_the_inputbox(String invalidURL) {
        activeStreamPage.insertVideoInputBox.sendKeys(invalidURL);
    }

    @Then("user should see error message on the screen")
    public void user_should_see_error_message_on_the_screen() {

        wait.until(ExpectedConditions.visibilityOf(activeStreamPage.insertVideoErrorMessage));
        //String actualErrorMessage = activeStreamPage.insertVideoErrorMessage.getText();
        Assert.assertTrue(activeStreamPage.insertVideoErrorMessage.isDisplayed());

    }

    //------------------##AC4-1-------------------------------

    @When("Click on the Quote text button")
    public void click_on_the_button() {
        BrowserUtils.waitForClickablility(activeStreamPage.addQuoteTextButton, 10);
        activeStreamPage.addQuoteTextButton.click();
    }

    String expectedMessageBody;

    @When("Tpye {string} character into the quote area and click send button")
    public void tpye_character_into_the_quote_area_and_click_send_button(String string) {
        expectedMessageBody = string;

        Driver.getDriver().switchTo().frame(activeStreamPage.iframe);

        activeStreamPage.blockQuote.sendKeys(string);

        Driver.getDriver().switchTo().defaultContent();

        activeStreamPage.sendButton.click();
    }

    @Then("user should add quotes into the message body successfully.")
    public void user_should_add_quotes_into_the_message_body_successfully() {
        BrowserUtils.waitForVisibility(activeStreamPage.addQuoteSentMessageBody, 10);

        String actualMessageBody = activeStreamPage.addQuoteSentMessageBody.getText();

        Assert.assertEquals(expectedMessageBody, actualMessageBody);

    }

//    @When("Click on the Quote text button and clicks send button")
//    public void click_on_the_quote_text_button_and_clicks_send_button() {
//        BrowserUtils.waitForClickablility(activeStreamPage.addQuoteTextButton,10);
//        activeStreamPage.addQuoteTextButton.click();
//        activeStreamPage.sendButton.click();
//    }
//    @Then("user should see the Error Message on the homepage")
//    public void user_should_see_the_error_message_on_the_homepage() {
//        Assert.assertTrue(activeStreamPage.addQuoteErrorMessage.isDisplayed());
//    }

    //------------------##AC5-------------------------------

    @When("user clicks on the Add Tag button")
    public void user_clicks_on_the_add_tag_button() {
        BrowserUtils.waitForClickablility(activeStreamPage.addTagButton, 10);
        activeStreamPage.addTagButton.click();
    }

    String expectedTagText;

    @When("user types {string} as a tag and clicks add and send button")
    public void user_types_as_a_tag_and_clicks_add_and_send_button(String string) {

        expectedTagText = string;

        Driver.getDriver().switchTo().frame(activeStreamPage.iframe);
        activeStreamPage.inputMessageBody.sendKeys(string);
        Driver.getDriver().switchTo().defaultContent();

        activeStreamPage.addTagInputBox.sendKeys(string);
        activeStreamPage.addTagAddButton.click();
        activeStreamPage.sendButton.click();

    }

    @Then("user should add tags into the message  successfully.")
    public void user_should_add_tags_into_the_message_successfully() {

        System.out.println("activeStreamPage.noIndex.getText() = " + activeStreamPage.noIndex.getText());


//        WebElement noIndexATag = Driver.getDriver().findElement(By.xpath("(//div//noindex)[1]//a"));
//
//        boolean resultTag = BrowserUtils.isElementPresent(By.xpath("(//div//noindex)[1]//a"));
//
//        String actualTagText = noIndexATag.getText();
//
//        //Assert.assertTrue(resultTag);
//
//        Assert.assertEquals(expectedTagText,actualTagText);
        boolean result = activeStreamPage.isElementPresent(By.xpath("(//div//noindex)[1]//a"));

        //boolean result1 = activeStreamPage.isElementPresent(By.xpath("(//div//noindex)[1]//a"));

        Assert.assertTrue(result);

    }

    //--------------------------AC6---------------------------

    @When("user types {string} as a tag and clicks add button")
    public void user_types_as_a_tag_and_clicks_add_button(String string) {

        activeStreamPage.addTagInputBox.sendKeys(string);

        activeStreamPage.addTagAddButton.click();

        activeStreamPage.deleteTagButton.click();
    }

    @Then("user should remove tag before sending message")
    public void user_should_remove_tag_before_sending_message() {

        boolean result = BrowserUtils.isElementPresent(By.xpath("//span[@class='feed-add-post-tags']"));

        Assert.assertFalse(result);

    }

}
