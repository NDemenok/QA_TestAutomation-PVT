@mailTest 
Feature: Test mail page mail.ru

Background:
 Given I am on main application page
 
  Scenario: Test positive login as correct user
    When I login as correct user
    Then I see logout link
     
  Scenario: Test check presence of message in the box
    When I login as correct user
    Then I see letter on mail box
   
  Scenario: Test move letter to spam
   	When I login as correct user
    And I move letter on folder spam
    Then I see message "Letter moved to spam"

  Scenario: Test send letter for group users
    When I login as correct user
    And I push button "Send letter"
    And I input a few email addresses and letter subject
    Then I see message "Letter is sent"
  
  Scenario: Test check three letters with flag
    When I login as correct user
    And I mark three letter with flag
    Then I see letter with flag on folder "Marked flag"
    
  Scenario: Test unchecked letters with flag
    When I login as correct user
    And I unchecked letters with flag
    Then I checked folder "Marked flag" is empty
     
  Scenario: Test move letter in trash
    When I login as correct user
    And I delete one message
    Then I see message "Letter deleted" 