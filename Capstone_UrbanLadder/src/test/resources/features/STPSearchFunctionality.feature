@SearchFunctionality
Feature: Search Functionality in urbanladder

 Scenario: Verify Search functionality 

  Given the user is on the home page 
  Then the user should see the searchbar
  And the enters the "<product>" name in searchbar
  And the user can filter the product based on new arrivals 
  And the user can filter product on Low to high
   And the user can filter product on high to low
    
    Examples:
    |product|
    |sofa|