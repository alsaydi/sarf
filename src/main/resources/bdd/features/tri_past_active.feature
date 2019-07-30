Feature: trilateral unaugmented verbs

  Scenario Outline: Trilateral unaugmented verb conjugations
    Given trilateral root "<root>" to conjugate
    When conjugation is requested
    Then trilateral unaugmented verbs are "<verb1>" and "<verb1>" and "<verb1>" and "<verb1>" and "<verb1>" and "<verb1>"
    Examples:
      | root | verb1 | verb2 | verb3 | verb4 | verb5 | verb6 |
      | f    |  f     |       |       |       |       |       |
