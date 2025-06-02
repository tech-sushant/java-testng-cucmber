Feature: Google homepage test

  Scenario: Verify Google homepage title
    Given I open the Google homepage
    Then The page title should contain "Google"
