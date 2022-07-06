@OPC-1015
Feature: Default

	Background:
		#@OPC-1014
		Given user is on the homepage and clicks on the Message on the quick menu
		

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC1 :*
	#
	#User should be able to add mentions about only department employees.
	@OPC-1013
	Scenario: Verify that users can add mentions about only department employees.
		When user clicks on the Add Mention button
		And user clicks on the departments name to open
		And user clicks on the employees names to add mention inside departments
		And user clicks on the Send button
		Then user should see employees are mentioned in the message body.	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC1 :*
	#
	#User should be able to add mentions about only department employees.
	@OPC-1016
	Scenario: Verify that users can not add mentions about any employees outside of departments.
		When user clicks on the Add Mention button
		And user clicks on the employees names to add mention outside departments
		Then users should not add mentions outside of departments.	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC2 :*
	#
	#User should be able to attach link to specified text.
	@OPC-1017
	Scenario: Verify that users can attach a valid link to specified text.
		When user clicks on link button
		When user types "google" into text input box
		And user types "https://www.google.com" into link inputbox and clicks save button and then clicks send button
		Then user should see the text is posted as a link successfully	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC2 :*
	#
	#User should be able to attach link to specified text.
	@OPC-1018
	Scenario: Verify that users can not attach an invalid link to specified text.
		When user clicks on link button
		When user types "google.12" into text input box
		And user types "https://www.ggle.com" invalid link and clicks save and send button
		Then user should not see the text is posted as a link successfully	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC2 :*
	#
	#User should be able to attach link to specified text.
	@OPC-1019
	Scenario: Verify that users can not attach a link to specified text without passing a text
		When user clicks on link button
		And user types valid link and clicks save and send button
		Then user should not see the link is posted as a link successfully	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC2 :*
	#
	#User should be able to attach link to specified text.
	@OPC-1020
	Scenario: Verify that users can not attach a link to specified text without passing a link
		When user clicks on link button
		When user types "Hello Cydeo" into text input box and clicks save and send button
		Then user should not see the text is posted as a link	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC3 :*
	#
	#User should be able to insert YouTube and Vimeo video.
	@OPC-1021
	Scenario: Verify that users can insert valid Youtube video.
		When user clicks on the insert video button
		When user pass a youtube video url into the inputbox and clicks save and send button
		Then user should see the Youtube Video in the posted message	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC3 :*
	#
	#User should be able to insert YouTube and Vimeo video.
	@OPC-1022
	Scenario: Verify that users can insert valid Vimeo video.
		When user clicks on the insert video button
		When user pass a vimeo video url into the inputbox and clicks save and send button
		Then user should see the Vimeo Video in the posted message	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC3 :*
	#
	#User should be able to insert YouTube and Vimeo video.
	@OPC-1023
	Scenario: Verify that users can not insert invalid video URL.
		When user clicks on the insert video button
		When user pass a invalid video url "https://twitter.com/video" into the inputbox
		Then user should see error message on the screen	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC4 :*
	#
	#User should be able to add quotes.
	@OPC-1024
	Scenario: Verify that users can add quotes
		When Click on the Quote text button
		And Tpye "Cydeo EU8 Group19" character into the quote area and click send button
		Then user should add quotes into the message body successfully.	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC5 :*
	#
	#User should be able to add tags in message.
	@OPC-1025
	Scenario: Verify that users can add tags in message
		When user clicks on the Add Tag button
		And user types "Group-19" as a tag and clicks add and send button
		Then user should add tags into the message  successfully.	

	#*User Story:*
	#
	#As a user, I should be able to add link, insert video, mention,  quote, add tag in message.
	#
	#*AC6 :*
	#
	#Users should be able to remove tags before sending the message
	@OPC-1026
	Scenario: Verify that users can remove tags  before sending the message.
		When user clicks on the Add Tag button
		And user types "Group-1923" as a tag and clicks add button
		Then user should remove tag before sending message