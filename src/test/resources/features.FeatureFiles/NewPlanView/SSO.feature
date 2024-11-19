##====================================================
## ORBIT REGRESSION PACK - NEW PLAN VIEW
##====================================================
Feature: Orbit Automation Regression Pack - New Plan View

  Background: User to Login
#    Given I navigate to D&G CC Agent Portal
    Given I navigate to new D&G CC Agent Portal
#    When I enter username and password and click Login for New Plan View
    When I enter username and password and click SignIn for New Plan View
    Then I verify the Login is successful