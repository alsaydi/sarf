Feature: augmented quadrilateral passive past verb conjugation

  Scenario Outline: passive augmented quadrilateral verb past conjugation
    Given an augmented verb
    When the verb is conjugated
    Then the first person singular conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<single_first>"
    And the first person plural conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<plural_first>"
    And the masculine singular second person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_single_second>"
    And the feminine singular second person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<f_single_second>"
    And the masculine dual second person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_single_third>"
    And the feminine singular third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<f_single_third>"
    And the masculine dual third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the quad passive verb "<verb>" and formula of "<formula>" is "<f_plural_third>"
    Examples:
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | 1       |              |              |                 |                 |               |                 |                 | تُدُحْرِجَ     | تُدُحْرِجَتْ   |              |              |                |                |
      | بلور | 1       |              |              |                 |                 |               |                 |                 | تُبُلْوِرَ     | تُبُلْوِرَتْ   |              |              |                |                |
      | جءجء | 1       |              |              |                 |                 |               |                 |                 | تُجُؤْجِئَ     | تُجُؤْجِئَتْ   |              |              |                |                |
      | رهيء | 1       |              |              |                 |                 |               |                 |                 | تُرُهْيِئَ     | تُرُهْيِئَتْ   |              |              |                |                |
      | زلزل | 1       |              |              |                 |                 |               |                 |                 | تُزُلْزِلَ     | تُزُلْزِلَتْ   |              |              |                |                |
      | سيطر | 1       |              |              |                 |                 |               |                 |                 | تُسُيْطِرَ     | تُسُيْطِرَتْ   |              |              |                |                |
      | طمءن | 1       |              |              |                 |                 |               |                 |                 | تُطُمْئِنَ     | تُطُمْئِنَتْ   |              |              |                |                |
      | طمءن | 3       |              |              |                 |                 |               |                 |                 | اطْمُئِنَّ     | اطْمُئِنَّتْ   |              |              |                |                |
      | قلسي | 1       |              |              |                 |                 |               |                 |                 | تُقُلْسِيَ     | تُقُلْسِيَتْ   |              |              |                |                |
      | شرءب | 3       |              |              |                 |                 |               |                 |                 | اشْرُئِبَّ     | اشْرُئِبَّتْ   |              |              |                |                |
      | مرءي | 1       |              |              |                 |                 |               |                 |                 | تُمُرْئِيَ     | تُمُرْئِيَتْ   |              |              |                |                |
      | شيطن | 1       |              |              |                 |                 |               |                 |                 | تُشُيْطِنَ     | تُشُيْطِنَتْ   |              |              |                |                |
      | وشوش | 1       |              |              |                 |                 |               |                 |                 | تُوُشْوِشَ     | تُوُشْوِشَتْ   |              |              |                |                |
      | بخدن | 2       |              |              |                 |                 |               |                 |                 | ابْخُنْدِنَ    | ابْخُنْدِنَتْ  |              |              |                |                |
      | حبطء | 2       |              |              |                 |                 |               |                 |                 | احْبُنْطِئَ    | احْبُنْطِئَتْ  |              |              |                |                |
      | حوصل | 2       |              |              |                 |                 |               |                 |                 | احْوُنْصِلَ    | احْوُنْصِلَتْ  |              |              |                |                |
      | سلقي | 2       |              |              |                 |                 |               |                 |                 | اسْلُنْقِيَ    | اسْلُنْقِيَتْ  |              |              |                |                |
      | فرقع | 1       |              |              |                 |                 |               |                 |                 | تُفُرْقِعَ     | تُفُرْقِعَتْ   |              |              |                |                |
      | فرقع | 2       |              |              |                 |                 |               |                 |                 | افْرُنْقِعَ    | افْرُنْقِعَتْ  |              |              |                |                |
      | قشعر | 1       |              |              |                 |                 |               |                 |                 | تُقُشْعِرَ     | تُقُشْعِرَتْ   |              |              |                |                |
      | قشعر | 3       |              |              |                 |                 |               |                 |                 | اقْشُعِرَّ     | اقْشُعِرَّتْ   |              |              |                |                |
      | كوءد | 3       |              |              |                 |                 |               |                 |                 | اكْوُئِدَّ     | اكْوُئِدَّتْ   |              |              |                |                |
      | كوهد | 3       |              |              |                 |                 |               |                 |                 | اكْوُهِدَّ     | اكْوُهِدَّتْ   |              |              |                |                |
      | مضحن | 3       |              |              |                 |                 |               |                 |                 | امْضُحِنَّ     | امْضُحِنَّتْ   |              |              |                |                |
