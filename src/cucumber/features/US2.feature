Feature: User Story 2

Scenario: The user should see a button labeled as ‘Manage Subtasks’
	Given I am at the ToDo app home page 
	When I Click on "My Tasks"
	And I input "test"
	Then "Manage Subtasks" should me visible