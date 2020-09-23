Feature: End2EndTest for API
Pet store swagger url: https://petstore.toolsqa.com/swagger/index.html
		
  Scenario: Authorized user is able to Add and Remove a pet
    Given A list of pets are available
    When I add a pet to my list
    Then The pet is added
    #When I remove a pet from the list
    #Then The pet is removed
