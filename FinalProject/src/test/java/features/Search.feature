@searchTest
Feature: Test search page mail.ru

Background:
	Given I am on main application page

  Scenario: Search by request "Benedict Cumberbatch"
    When I perform search by "Бенедикт Камбербэтч"
    Then I see name "Бенедикт Камбербэтч" in the first link
    
  Scenario: Transition by external link "Мой Мир"
  	When I follow the link "Мой Мир"
  	Then I see button "Зарегистрируйтесь сейчас"
  	
  Scenario: Transition by external link "ICQ"
  	When I follow the link "ICQ"
  	Then I see button "Скачать ICQ"