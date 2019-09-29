Feature: trilateral unaugmented roots

  Scenario Outline: trilateral unaugmented roots
    Given a trilateral unaugmented verb
    When I request all roots
    Then for a verb "<root>" all tasareef "<tasareef>" are returned
    Examples:
      | root | tasareef                                                   |
      | سلم  | سَلَمَ يَسْلِمُ متعد,سَلِمَ يَسْلَمُ لازم                  |
      | وعد  | وَعَدَ يَعِدُ كلاهما                                       |
      | سعد  | سَعَدَ يَسْعَدُ كلاهما,سَعِدَ يَسْعَدُ لازم                |
      | دءم  | دَأَمَ يَدْأَمُ متعد                                       |
      | يبس  | يَبِسَ يَيْبَسُ لازم,يَبِسَ يَيْبِسُ لازم                  |
      | وله  | وَلَهَ يَلِهُ لازم,وَلِهَ يَوْلَهُ لازم,وَلِهَ يَلِهُ لازم |
      | قدد  | قَدَّ يَقُدُّ متعد                                         |

