Feature: User Story 1 Fail Scenarios 

Scenario: 
	The task should require at least three characters so the user can enter it (fail)
	Given I am at the ToDo app home page 
	When I Click on "My Tasks" 
	And I input "aa" 
	Then "aa" should not exist 
	
#Scenario: The task can’t have more than 250 characters (fail) 
#	Given I am at the ToDo app home page 
#	When I Click on "My Tasks" 
#	And I input a task greater than 250 
#	Then The task should not exist