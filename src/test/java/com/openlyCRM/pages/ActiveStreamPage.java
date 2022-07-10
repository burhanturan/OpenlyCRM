package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveStreamPage {

    public ActiveStreamPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']/span")
    public WebElement messageButton;

    @FindBy(xpath = "//span[@title='Link']/i")
    public WebElement linkButton;

    @FindBy(xpath = "//span[@title='Insert video']/i")
    public WebElement insertVideoButton;

    @FindBy(xpath = "//span[@title='Quote text']/i")
    public WebElement addQuoteTextButton;

    @FindBy(id = "bx-b-tag-input-blogPostForm")
    public WebElement addTagButton;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "(//div[contains(@id,'feed-post-contentview-BLOG_POST-')])[1]")
    public WebElement sentMessageBody;

    public String getSentMessageBody(By locator) {
        String messageText = "";
        try {
            messageText = Driver.getDriver().findElement(locator).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageText;
    }

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement deleteAllEmployees;


    //--------<<< add mention section ------------->>>

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMentionButton;

    @FindBy(xpath = "//a[contains(@id,'destDepartmentTab_mention')]")
    public WebElement mentionEmployeesAndDepartmentButton;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-text'])[5]")
    public WebElement mentionHr3Department;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-employee-name'])[2]")
    public WebElement mentionOneOfTheEmployees;



    @FindBy(xpath = "(//*[@class='bx-finder-company-department-employee-name'])[6]")
    public WebElement mentionEmployeeOutsideDepartment;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBodyBeforeSend;

    @FindBy(xpath = "//span[@id='feed-add-post-destination-item']")
    public WebElement toList;

    //--------<<< add mention section ------------->>>

    //--------<<< add link section ---------------->>>

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    public WebElement textInputBox;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    public WebElement linkInputBox;

    @FindBy(xpath = "//input[@class='adm-btn-save']")
    public WebElement linkSaveButton;

    //--------<<< add link section ---------------->>>

    //--------<<< insert video section ---------------->>>

    @FindBy(xpath = "//*[@placeholder='YouTube or Vimeo video URL']")
    public WebElement insertVideoInputBox;

    @FindBy(xpath = "//*[@value='Save']")
    public WebElement insertVideoSaveButton;

    @FindBy(xpath = "//label[.='Video title:']")
    public WebElement insertVideoTitle;

    @FindBy(xpath = "//div/iframe[contains(@src,'//player.vimeo.com/video/')]")
    public WebElement insertVideoVerify;

    @FindBy(xpath = "//span[@class='bxhtmled-video-error']")
    public WebElement insertVideoErrorMessage;

    //--------<<< insert video section ---------------->>

    //----------<<< addQuote -------------------->>

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement blockQuote;

    @FindBy(xpath = "//div[@class='blog-post-quote']//td")
    public WebElement addQuoteSentMessageBody;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement addQuoteErrorMessage;

    //----------<<< addQuote -------------------->>

    //----------<<< add Tag -------------------->>

    @FindBy(id = "TAGS_blogPostForm67abSn")
    public WebElement addTagInputBox;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement inputMessageBody;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement addTagAddButton;

    @FindBy(xpath = "(//div[contains(@id,'blogpost-tags')])[1]")
    public WebElement addTagMessageTag;

    @FindBy(xpath = "(//div//noindex)[1]//a")
    public WebElement noIndex;


    public boolean isElementPresent(By by) {
        try {
            Driver.getDriver().findElement(by);//  by = By.xpath("(//div//noindex)[1]//a")
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    @FindBy(xpath = "//div/span/span[@class='feed-add-post-del-but']")
    public WebElement deleteTagButton;

    @FindBy(xpath = "//span[@class='feed-add-post-tags']")
    public WebElement tagBeforeDelete;

    @FindBy(xpath = "(//div[@class='feed-com-tags-block'])[1]")
    public WebElement tagBlock;

}
