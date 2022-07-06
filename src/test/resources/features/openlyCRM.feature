Feature: Testing Message Functionality

  User Story: As a user, I should be able to add link,
  insert video, mention,  quote, add tag in message.

  1. User should be able to add mentions about only department employees.
  2. User should be able to attach link to specified text.
  3. User should be able to insert YouTube and Vimeo video.
  4. User should be able to add quotes.
  5. User should be able to add tags in message.
  6. User should be able to remove tags before sending the message

  Background:
    Given user is on the homepage and clicks on the Message on the quick menu

##@AC1-1 905
  @ac1-1
  Scenario: AC1-1 :Verify that users can add mentions about only department employees.
    When user clicks on the Add Mention button
    And user clicks on the departments name to open
    And user clicks on the employees names to add mention inside departments
    And user clicks on the Send button
    Then user should see employees are mentioned in the message body.

##@AC1-2 907
  @ac1-2
  Scenario: AC1-2 : Verify that users can not add mentions about any employees outside of departments.
    When user clicks on the Add Mention button
    And user clicks on the employees names to add mention outside departments
    Then users should not add mentions outside of departments.

##@AC2-1 943
  @ac2-1
  Scenario: AC2-1 : Verify that users can attach a valid link to specified text.
    When user clicks on link button
    When user types "google" into text input box
    And user types "https://www.google.com" into link inputbox and clicks save button and then clicks send button
    Then user should see the text is posted as a link successfully

##@AC2-2 944
  @ac2-2
  Scenario: AC2-2 : Verify that users can not attach an invalid link to specified text.
    When user clicks on link button
    When user types "google.12" into text input box
    And user types "https://www.ggle.com" invalid link and clicks save and send button
    Then user should not see the text is posted as a link successfully

##@AC2-3 945
  @ac2-3
  Scenario: AC2-3 : Verify that users can not attach a link to specified text without passing a text
    When user clicks on link button
    And user types valid link and clicks save and send button
    Then user should not see the link is posted as a link successfully

##@AC2-4 946
  @ac2-4
  Scenario: AC2-4 : Verify that users can not attach a link to specified text without passing a link
    When user clicks on link button
    When user types "Hello Cydeo" into text input box and clicks save and send button
    Then user should not see the text is posted as a link

##AC3-1 947
  @ac3-1
  Scenario: AC3-1 : Verify that users can insert valid Youtube video.
    When user clicks on the insert video button
    When user pass a youtube video url into the inputbox and clicks save and send button
    Then user should see the Youtube Video in the posted message

##AC3-2 948
  @ac3-2
  Scenario: AC3-1 : Verify that users can insert valid Vimeo video.
    When user clicks on the insert video button
    When user pass a vimeo video url into the inputbox and clicks save and send button
    Then user should see the Vimeo Video in the posted message

##AC3-3 949
  @ac3-3
  Scenario: AC3-3 : Verify that users can not insert invalid video URL.
    When user clicks on the insert video button
    When user pass a invalid video url "https://twitter.com/video" into the inputbox
    Then user should see error message on the screen

##AC4-1 950
  @ac4-1
  Scenario: AC4-1 : Verify that users can add quotes
    When Click on the Quote text button
    And Tpye "Cydeo EU8 Group19" character into the quote area and click send button
    Then user should add quotes into the message body successfully.

###AC4-2 951
#  Scenario: AC4-2 : Verify that users can add tags in message
#    When Click on the Quote text button and clicks send button
#    Then user should see the Error Message on the homepage

##AC5 952
  @ac5-1
  Scenario: AC5 : Verify that users can add tags in message
    When user clicks on the Add Tag button
    And user types "Group-19" as a tag and clicks add and send button
    Then user should add tags into the message  successfully.

##AC6 953
  @ac6-1
  Scenario: AC6 :Verify that users can remove tags  before sending the message.
    When user clicks on the Add Tag button
    And user types "Group-1923" as a tag and clicks add button
    Then user should remove tag before sending message
