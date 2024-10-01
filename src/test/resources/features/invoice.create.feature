Feature: Creating Link

  As a system user
  I want to create link for customers

  Background:
    Given there is a customer "Customer 1" with id 1
    And there is an address "Address 1" with id 1
    And there is a category "Category A" with id 1

  Scenario: Create a valid call
    When I create a call for the customer "Customer 1" at the address "Address 1" with category "Category A"
    Then the call should be created successfully

  Scenario: Do not allow calls at an address with an active call
    Given there is an active call for the customer "Customer 1" at the address "Address 1"
    When I try to create a new call for the customer "Customer 1" at the address "Address 1" with category "Category A"
    Then the call creation should fail with the message "An address can only have one active call"

  Scenario: Do not allow calls if there is an overdue invoice
    Given there is an overdue invoice for the customer "Customer 1"
    When I try to create a call for the customer "Customer 1" at the address "Address 1" with category "Category A"
    Then the call creation should fail with the message "Cannot create a call with an overdue invoice"

  Scenario: Do not allow duplicate calls for the same customer and address
    Given there is an active call for the customer "Customer 1" at the address "Address 1"
    When I try to create a new call for the customer "Customer 1" at the address "Address 1" with category "Category A"
    Then the call creation should fail with the message "Cannot create a new call for the same customer and address"