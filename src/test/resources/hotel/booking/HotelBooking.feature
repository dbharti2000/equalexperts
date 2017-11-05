@hotelBooking
Feature: Create and Delete a hotel booking
  As a product manager
  I want our customer to be able to create/Delete a booking
  So that they can book/cancel their hotel booking for any day

  Scenario: Create a booking for first saturday of next month
    Given customer navigates to the hotel booking page
    When customer creates the booking with below details:
      | FirstName | LastName | Price | Deposit |
      | Ross      | Allan    | 1000  | false   |
    Then new booking should be displayed on the booking page

  Scenario: Customer deletes the first booking on the booking page
    Given customer navigates to the hotel booking page
    When customer deletes the first booking on the page
    Then first booking should not be visible on the booking page