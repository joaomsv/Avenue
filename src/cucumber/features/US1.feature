Feature: User Story 1 

Scenario Outline: The user should always see the My Tasks link on the NavBar 
	Given I am at the ToDo app home page 
	When I Click on <link> 
	Then The My Task link should be in the NavBar 

	Examples: 
		|link|
		|ToDo App|
		|Home|
		|My Tasks|

Scenario: 
	Clicking My Tasks will redirect the user to a page with all the created tasks 
	Given I am at the ToDo app home page 
	When I Click on "My Tasks" 
	Then I should be at My Tasks Page 

Scenario: 
	The user should see a message on the top part saying that list belongs to the logged user 
	Given I am at the ToDo app home page 
	When I Click on "My Tasks" 
	Then A message with the user name should be there 

Scenario: 
	The user should be able to enter a new task by hitting enter or clicking on the add task button 
	Given I am at the ToDo app home page 
	When I Click on "My Tasks" 
	And I add a Task with Add Task button 
	And I add a Task with Enter key 
	Then Both tasks should be added