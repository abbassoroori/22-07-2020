Feature: Application form for Mortgage Loan

@gilan
Scenario: user Goes to Application Form Page
Given user is on bank homepage
When user clicks on Mortgage Loan button
Then user is on mortgage loan page


Scenario: User goes to what-is-your-goal page
Given user is on mortgage-loan page
When user clicks on Apply New Bu button
Then user goes to what-is-your-goal page 


Scenario: user is on what-is-your-goal page
When user clicks on I Want to Buy a new Home button
Then user see this message 'Glad to meet you here!'


Scenario: User Can Fill All Section of Application Form
Given user is on Buy new Home Application page
When user fills fields by bellow information
|firstName|lastName|phoneNumber|email|cEmail|address|zipCode|ssn|bod|hLEdue|miteralS|phTtpe|
|jhkh|gjgkf|7032525215|fdgff@hgff.com|fdgff@hgff.com|jhfjhf|55482|4856381596|06/14/1962|PHD|Married|Mobile|
And user selects 'yes' dependency
And user selects'No' military
And user clicks on agreement checkbox
And user clicks on send application
Then user See this message'Thank you for your message. It has been sent. '


