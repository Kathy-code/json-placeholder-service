Feature: Probar el servicio de Json Place Holder
  Como tester
  Quiero hacer pruebas de regresión
  Para validar que los principales servicios sigan funcionando correctamente

  @t1
  Scenario: Validar la obtención de la lista de artículos

    Given que la aplicación está operativa
    When consulto la lista de artículos
    Then se valida que el código es 200
    And se me mostrará en consola la lista de artículos existentes