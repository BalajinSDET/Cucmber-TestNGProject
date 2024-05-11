@RegressionTest
Feature: This is the Job Seeker sign in scenario
  I want to sign in as Job Seeker of Ihp application

  Background: 
    Given User is enter the Ihp website URL

  @RegressionTest
  Scenario Outline: Verify that sign in as Job Provider functionality of the application
    When The user should able to click on the Login as Job Provider button in the HomePage
    Then User should navigated to the sign in page
    And The user enter their Email Id as "<email>" and Password as "<password>"
    When User clicks on the sign in button
    And User should navigated to the KYC Verification
    And User clicks the email verification radio button and then user clicks the submit button
    Then User navigates to the dashboard page of the Ihp project successfully

    Examples: 
      | email                 | password |
      | lgstester50@gmail.com | Test123  |
