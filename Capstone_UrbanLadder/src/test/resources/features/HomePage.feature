@HomePage
Feature: Home Page Verification

@HomePageVerification

 Scenario: Verify Home Page Sections

  Given the user is on the home page
  Then the user should see Top Offers section
  And the user should see Best Sellers section
  And the user should see the search bar