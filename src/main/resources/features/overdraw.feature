Feature: withdraw(overdraw)
    As a customer
    I want to withdraw from my account using ATM and can overdrawn and the OD account(with a negotiated amount specified when the account was open).

Background:
    Given a customer with id 1 and pin 111 with overdraft 1500 exists and balance 200 exists
    And I login to ATM with id 1 and pin 111

Scenario: Withdraw amount less than balance
    When I withdraw 50 from ATM
    Then my account balance is 150
    And overdraft left 1500

Scenario: Withdraw amount more than balance but in limit.
    When I withdraw 1400 from ATM
    Then my account balance is 0
    And overdraft left 300 

Scenario: Withdraw amount more than balance and over limit.
    When I overdraw 5000 from ATM
    Then my account balance is 200
    And overdraft left 1500