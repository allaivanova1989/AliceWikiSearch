Feature: Поиск курсов

  Scenario Outline: Поиск курсов по автоматизации
    Given имя курса <name>
    When Пользователь открывает ссылку курса
    Then заголовок страницы <title>

    Examples:
      | name                                      | title                                     |
      | Автоматизированное тестирование на Java   | Автоматизированное тестирование на Java   |
      | Автоматизированное тестирование на Python | Автоматизированное тестирование на Python |