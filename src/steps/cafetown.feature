Feature: User Login and Adding Employee

    Scenario: User Login
        Given uname is luke password skywalker
        When user click login button
        Then user login successful
        
    Scenario: Adding Employee
        Given user logins to system and goes to create new employee page
        When user enters new employee information and clicks add button
        Then new employee operation is successful