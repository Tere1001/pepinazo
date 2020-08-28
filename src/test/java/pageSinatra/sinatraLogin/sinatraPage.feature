Feature: Sinatra Login Parameters

  Scenario: Navegar a pagina Sinatra
    Given I am in Sinatra page
    When I can see Sinatra Home Page
    Then i can see in the footer the logging button


  Scenario: Ingresar credenciales en pagina Sinatra
    Given I am on Sinatra page
    When I imput user and password
    And click on log in button
    Then I am on Sinatra songs page


  Scenario: Agregar una cancion en pagina sinatra
    Given I am on Sinatra songs page
    When I create a songs
    Then I can see the new songs on the list