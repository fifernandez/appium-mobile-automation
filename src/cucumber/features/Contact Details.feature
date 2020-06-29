@ContactDetails

Feature: Contact Page
  As a Developer
  I want to be sure
  That the Contact Details page is working correctly

  Scenario:
    Given I am on the 'Contact List'
    And I click on the first contact name
    Then On the contact detail screen, I must see: 'Name'
    And On the contact detail screen, I must see: 'Phone'
    And On the contact detail screen, I must see: 'Email'
    And On the contact detail screen, I must see: 'Address1'
    And On the contact detail screen, I must see: 'Address2'