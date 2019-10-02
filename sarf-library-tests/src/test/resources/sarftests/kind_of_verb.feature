Feature: kind of verb

  Scenario Outline: Kind of Verb
    Given a trilateral unaugmented verb
    When the kind of verb is request
    Then the verb "<verb>" kind is "<kind>"
    Examples:
      | verb | kind                       |
      | سلم  | Salim                      |
      | هدد  | Mudaaf                     |
      | وءي  | Lafeef_Mafrooq_Mahmouz_Ain |
      | ءوي  | Lafeef_Maqroon_Mahmouz_Faa |
      | وقي  | Lafeef_Mafrooq             |
      | شوي  | Lafeef_Maqroon             |
      | ءبي  | Naqis_Yaee_Mahmouz_Faa     |
      | رءي  | Naqis_Yaee_Mahmouz_Ain     |
      | ءسو  | Naqis_Wawi_Mahmouz_Faa     |
      | مءو  | Naqis_Wawi_Mahmouz_Ain     |
      | ءين   | Ajwaf_Yaee_Mahmouz_Faa     |
      | شيء  | Ajwaf_Yaee_Mahmouz_Laam    |
      | ءوب   | Ajwaf_Wawi_Mahmouz_Faa     |
      | بوء  | Ajwaf_Wawi_Mahmouz_Laam    |
      | يسس  | Mithal_Yaee_Mudaaf         |
      | يءس  | Mithal_Yaee_Mahmouz_Ain    |
      | ودد  | Mithal_Wawi_Mudaaf         |
      | وءد  | Mithal_Wawi_Mahmouz_Ain    |
      | وجء  | Mithal_Wawi_Mahmouz_Laam   |
      | ءمم  | Mahmouz_Faa_Mudaaf         |
      | ءثء  | Mahmouz_Faa_Mahmouz_Laam   |
      | رمي  | Naqis_Yaee                 |
      | غزو  | Naqis_Wawi                 |
      | بيع  | Ajwaf_Yaee                 |
      | قوم  | Ajwaf_Wawi                 |
      | يسر  | Mithal_Yaee                |
      | وعد  | Mithal_Wawi                |
      | بدء  | Mahmouz_Laam               |
      | سءل  | Mahmouz_Ain                |
      | ءكل  | Mahmouz_Faa                |
      | مدد  | Mudaaf                     |
      | نصر  | Salim                      |


