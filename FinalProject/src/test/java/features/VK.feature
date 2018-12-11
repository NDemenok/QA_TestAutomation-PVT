@vktest
Feature: Test VKService
	
Scenario:Test positive send message
	When I call send message service
    Then I get positive status code by send
    
Scenario:Test positive edit message
	When I call edit message service
    Then I get positive status code by edit
    
Scenario:Test positive delete message
	When I call delete message service
    Then I get positive status code by delete 
    
Scenario:Test positive send photo 
	When I call post photo service
    Then I get positive status code by send photo