Feature: Search bar Guest user


  Scenario: Home page greetings section search bar Keyword/Queries
    Given Guest user is on the home page
    When User clicks on the greetings section search bar
    And The search bar page is loaded
    And The user types a search for a predefined topic on the search bar
    Then The search entered by the user is showing on the keyword search

  Scenario: Home page greetings section make search and click on search
    Given Guest user is on the home page
    When User clicks on the greetings section search bar
    And The search bar page is loaded
    And The user types a search for a predefined topic on the search bar
    And The search bar page is loaded
    And User clicks on the search button next to the search bar to be redirected to the topic page
    Then User should be redirected to the topic page

  Scenario: Home page guest user advance search feature
    Given Guest user is on the home page
    When User clicks on the greetings section search bar
    And The search bar page is loaded
    And The user clicks on the advanced search tab
    And The user clicks on the open bracket operator
    And The user types a search on the search bar page Gold
    And The user clicks on the closing bracket operator
    And  User clicks on the search button next to the search bar to be redirected to the search
    Then User should be redirected to the topics search page


  Scenario: Advance search or operator
    Given Guest user is on the home page
    When User clicks on the greetings section search bar
    And The search bar page is loaded
    And The user clicks on the advanced search tab

    And The user types a search on the search bar page Crypto
    And The user clicks on the or operator
    And The user types a search for a predefined topic on the search bar
    When User clicks on the search button next to the search bar to be redirected to the search
    Then User should be redirected to the topics search page




