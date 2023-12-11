#language: en
#AOriginal Author: Claudia Nieto - Appium 1.x
#Author: David Morales Valencia - Appium 2.x
#Email: davidmoralv@gmail.com

@All
Feature: Validate shopping cart
  As a user of Exito
  I want to access the app
  To add one product to cart

  Background: Access to the main platform
    Given that I enter the apk movil Exito
      | email                   | password    |
      | xayiniy999@naymedia.com | Prueba1234* |


  @AddProductToCart
  Scenario Outline: Validate the product in the shopping cart on the app
    When I add product to cart
      | <productCategory> |
    Then I verify the item in my shopping cart

    Examples:
      | productCategory |
      | televisores     |