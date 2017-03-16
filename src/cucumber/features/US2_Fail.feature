Feature: User Story 2 Fail Scenarios

Scenario: This popup should have a read only field with the task ID and the task description (fail)
	Given I am at the ToDo app home page 
	When I Click on "My Tasks"
	And I input "test"
	And I click on "/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button"
	Then Both Task ID and description should be disabled

#Scenario: The subtask can’t have more than 250 characters (fail)
#	Given I am at the ToDo app home page 
#	When I Click on "My Tasks" 
#	And I input "test"
#	And I click on "/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button"
#	And I input a subtask greater than 250 
#	Then The subtask should not exist

#Scenario: SubTask due date must have the MM/dd/yyyy format (fail)
#	Given I am at the ToDo app home page 
#	When I Click on "My Tasks" 
#	And I input "test"
#	And I click on "/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button"
#	And I input subtask "subtask test" and due date "5165161"
#	Then Subtask "subtask test" should not existe

#Scenario: The Task Description and Due Date are required fields (fail)
#	Given I am at the ToDo app home page 
#	When I Click on "My Tasks" 
#	And I input "test"
#	And I click on "/html/body/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]/button"
#	And I input subtask "" and due date ""	
#	Then Subtask "empty" should not existe