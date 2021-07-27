Feature: Employee Feature Verification

  Scenario: Client Gets All the Employees from the repo.

    Given client set get employees service api endpoint
    When client sends a get HTTP request
    Then client receives a valid response