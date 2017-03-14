Feature: User Story 1 

Scenario Outline: The user should always see the My Tasks link on the NavBar 
	Given I am at the ToDo app home page 
	When I Click on the <link> 
	Then The My Task link should be in the NavBar 
	
	Examples: 
		|link|
		|ToDo App|
		|Home|
		|My Tasks|