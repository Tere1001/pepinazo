Feature: IMDB búsqueda de peliculas

  Scenario: Busqueda  por título
    Given I am in IMDB page
    When I search by title
    Then It displays movies by the title

  Scenario: Búqueda por episodio
    Given I am in IMDB page
    When I search by episode
    Then It displays movies by episode

  Scenario : Búsqueda  por celebridad
    Given I am in IMDB page
    When I search by celebrity
    Then It displays movies by the celebrity

  Scenario: Búsqueda  por género
    Given I am in IMDB page
    When I search by genre
    Then It displays movies by genre

  Scenario : Búsqueda por compañía
    Given I am in IMDB page
    When I search by company
    Then It displays movies by the company

  Scenario : Búsqueda por palabra clave
    Given I am in IMDB page
    When I search by key word
    Then It displays movies by the key word

