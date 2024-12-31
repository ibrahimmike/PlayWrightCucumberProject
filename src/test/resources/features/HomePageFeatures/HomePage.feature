Feature: Home page features


  Scenario Outline: Greetings section search bar
    Given Guest user is on the home page
    When User clicks on the greetings section search bar
    And The request for the topics is sent and the search page is loaded
    And The user types a search on the search bar page '<topic>'
    Then The search entered by the user is showing on the keyword search <topic>
    Examples:
    |topic|
    |Gold |


 Scenario: Greetings section sectors locations are visible and linking to the pages
   Given Guest user is on the home page
   When The user clicks on any of the sectors
   Then The user is redirected to the relevant topic page


 Scenario: User can see the trusted by section
  Given Guest user is on the home page
  When User scrolls to the trusted by section
  Then The trusted by logos are visible

 Scenario: User can change the slides left and right with the chevrons
   Given Guest user is on the home page
   When User scrolls to the main carousel
   And User clicks on the next chevron
   Then The sentiment slide is visible
   When User clicks on the previous chevron
   Then The premium slide is visible


 Scenario: Top stories Section is visible and the user can change between them
   Given Guest user is on the home page
   When User scrolls to the top stories page
   And User clicks on the see more button
   Then User is redirected to the News and Research page


 Scenario: General filters and settings
   Given Guest user is on the home page
   When User scrolls to the general filters section
   And User clicks on the general filters locations drop down
   Then The dropdown with the continents is displayed

 Scenario: General filters section Choose a continent
   Given Guest user is on the home page
   And User scrolls to the general filters section
   And User clicks on the general filters locations drop down
   And User chooses a continent
   Then The page sends the request to the stories endpoint with continent















