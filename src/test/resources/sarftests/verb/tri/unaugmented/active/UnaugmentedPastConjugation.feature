Feature: unaugmented trilateral verb conjugation

  Scenario Outline: active unaugmented trilateral verb past conjugation
    Given an unaugmented verb
    When the verb is conjugated
    Then the first person singular conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<single_first>"
    And the first person plural conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<plural_first>"
    And the masculine singular second person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_single_second>"
    And the feminine singular second person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<f_single_second>"
    And the masculine dual second person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_single_third>"
    And the feminine singular third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<f_single_third>"
    And the masculine dual third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the verb "<verb>" and conjugation of "<conjugation>" is "<f_plural_third>"
    Examples:
      | verb | conjugation | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | سلم  | 2           | سَلَمْتُ     | سَلَمْنَا    | سَلَمْتَ        | سَلَمْتِ        | سَلَمْتُمَا   | سَلَمْتُمْ      | سَلَمْتُنَّ     | سَلَمَ         | سَلَمَتْ       | سَلَمَا      | سَلَمَتَا    | سَلَمُوا       | سَلَمْنَ       |
      | قدد  | 1           | قَدَدْتُ     | قَدَدْنَا    | قَدَدْتَ        | قَدَدْتِ        | قَدَدْتُمَا   | قَدَدْتُمْ      | قَدَدْتُنَّ     | قَدَّ          | قَدَّتْ        | قَدَّا       | قَدَّتَا     | قَدُّوا        | قَدَدْنَ       |
      | سءد  | 3           | سَأَدْتُ     | سَأَدْنَا    | سَأَدْتَ        | سَأَدْتِ        | سَأَدْتُمَا   | سَأَدْتُمْ      | سَأَدْتُنَّ     | سَأَدَ         | سَأَدَتْ       | سَأَدَا      | سَأَدَتَا    | سَأَدُوا       | سَأَدْنَ       |
      | وءل  | 2           | وَأَلْتُ     | وَأَلْنَا    | وَأَلْتَ        | وَأَلْتِ        | وَأَلْتُمَا   | وَأَلْتُمْ      | وَأَلْتُنَّ     | وَأَلَ         | وَأَلَتْ       | وَأَلا       | وَأَلَتَا    | وَأَلُوا       | وَأَلْنَ       |
      | ءول  | 1           | أُلْتُ       | أُلْنَا      | أُلْتَ          | أُلْتِ          | أُلْتُمَا     | أُلْتُمْ        | أُلْتُنَّ       | آلَ            | آلَتْ          | آلا          | آلَتَا       | آلُوا          | أُلْنَ         |
      | ءول  | 4           | أَوِلْتُ     | أَوِلْنَا    | أَوِلْتَ        | أَوِلْتِ        | أَوِلْتُمَا   | أَوِلْتُمْ      | أَوِلْتُنَّ     | أَوِلَ         | أَوِلَتْ       | أَوِلا       | أَوِلَتَا    | أَوِلُوا       | أَوِلْنَ       |
      | جوي  | 4           | جَوِيتُ      | جَوِينَا     | جَوِيتَ         | جَوِيتِ         | جَوِيتُمَا    | جَوِيتُمْ       | جَوِيتُنَّ      | جَوِيَ         | جَوِيَتْ       | جَوِيَا      | جَوِيَتَا    | جَوُوا         | جَوِينَ        |
      | سير  | 2           | سِرْتُ       | سِرْنَا      | سِرْتَ          | سِرْتِ          | سِرْتُمَا     | سِرْتُمْ        | سِرْتُنَّ       | سَارَ          | سَارَتْ        | سَارَا       | سَارَتَا     | سَارُوا        | سِرْنَ         |
      | وضء  | 5           | وَضُؤْتُ     | وَضُؤْنَا    | وَضُؤْتَ        | وَضُؤْتِ        | وَضُؤْتُمَا   | وَضُؤْتُمْ      | وَضُؤْتُنَّ     | وَضُؤَ         | وَضُؤَتْ       | وَضُؤَا      | وَضُؤَتَا    | وَضُؤُوا       | وَضُؤْنَ       |
      | وضء  | 3           | وَضَأْتُ     | وَضَأْنَا    | وَضَأْتَ        | وَضَأْتِ        | وَضَأْتُمَا   | وَضَأْتُمْ      | وَضَأْتُنَّ     | وَضَأَ         | وَضَأَتْ       | وَضَأَا      | وَضَأَتَا    | وَضَؤُوا       | وَضَأْنَ       |
      | ولي  | 6           | وَلِيتُ      | وَلِينَا     | وَلِيتَ         | وَلِيتِ         | وَلِيتُمَا    | وَلِيتُمْ       | وَلِيتُنَّ      | وَلِيَ         | وَلِيَتْ       | وَلِيَا      | وَلِيَتَا    | وَلُوا         | وَلِينَ        |
      | وبء  | 5           | وَبُؤْتُ     | وَبُؤْنَا    | وَبُؤْتَ        | وَبُؤْتِ        | وَبُؤْتُمَا   | وَبُؤْتُمْ      | وَبُؤْتُنَّ     | وَبُؤَ         | وَبُؤَتْ       | وَبُؤَا      | وَبُؤَتَا    | وَبُؤُوا       | وَبُؤْنَ       |
      | بيه  | 2           | بِهْتُ       | بِهْنَا      | بِهْتَ          | بِهْتِ          | بِهْتُمَا     | بِهْتُمْ        | بِهْتُنَّ       | بَاهَ          | بَاهَتْ        | بَاهَا       | بَاهَتَا     | بَاهُوا        | بِهْنَ         |
      | بوه  | 1           | بُهْتُ       | بُهْنَا      | بُهْتَ          | بُهْتِ          | بُهْتُمَا     | بُهْتُمْ        | بُهْتُنَّ       | بَاهَ          | بَاهَتْ        | بَاهَا       | بَاهَتَا     | بَاهُوا        | بُهْنَ         |
