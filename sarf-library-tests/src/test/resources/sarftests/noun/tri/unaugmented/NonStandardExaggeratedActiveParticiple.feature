Feature: تصريف اسم الفاعل المبالغ غير القياسي من الفعل الثلاثي المجرد

  Scenario Outline: unaugmented trilateral emphasized active participle
    Given an unaugmented verb
    When the derived noun is "EmphasizedActiveParticiple" and the root type is "TrilateralUnaugmented"
    Then singular masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>" with formula "<formula>"
    And  singular feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>" with formula "<formula>"
    And  dual masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>" with formula "<formula>"
    And  dual feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>" with formula "<formula>"
    And  plural masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>" with formula "<formula>"
    And  plural feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>" with formula "<formula>"
    Examples:
      | verb | conjugation | m_single_n | f_single_n  | m_dual_n     | f_dual_n       | m_plural_n   | f_plural_n   | m_single_a | f_single_a  | m_dual_a      | f_dual_a        | m_plural_a   | f_plural_a   | m_single_g | f_single_g  | m_dual_g      | f_dual_g        | m_plural_g   | f_plural_g   | formula   |
      | ءنن  | 2           | أُنَنَةٌ   |             |              |                |              |              | أُنَنَةً   |             |               |                 |              |              | أُنَنَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | ءكل  | 1           | أَكُولٌ    | أَكُولَةٌ   | أَكُولانِ    | أَكُولَتَانِ   | أَكُولُونَ   | أَكُولاتٌ    | أَكُولاً   | أَكُولَةً   | أَكُولَيْنِ   | أَكُولَتَيْنِ   | أَكُولِينَ   | أَكُولاتٍ    | أَكُولٍ    | أَكُولَةٍ   | أَكُولَيْنِ   | أَكُولَتَيْنِ   | أَكُولِينَ   | أَكُولَاتٍ   | فَعُول    |
      | ءكل  | 1           | أُكَلَةٌ   |             |              |                |              |              | أُكَلَةً   |             |               |                 |              |              | أُكَلَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | ءكل  | 1           | أَكِيلٌ    | أَكِيلَةٌ   | أَكِيلانِ    | أَكِيلَتَانِ   | أَكِيلُونَ   | أَكِيلاتٌ    | أَكِيلاً   | أَكِيلَةً   | أَكِيلَيْنِ   | أَكِيلَتَيْنِ   | أَكِيلِينَ   | أَكِيلاتٍ    | أَكِيلٍ    | أَكِيلَةٍ   | أَكِيلَيْنِ   | أَكِيلَتَيْنِ   | أَكِيلِينَ   | أَكِيلَاتٍ   | فَعِيل    |
      | ءكل  | 4           | أَكُولٌ    | أَكُولَةٌ   | أَكُولانِ    | أَكُولَتَانِ   | أَكُولُونَ   | أَكُولاتٌ    | أَكُولاً   | أَكُولَةً   | أَكُولَيْنِ   | أَكُولَتَيْنِ   | أَكُولِينَ   | أَكُولاتٍ    | أَكُولٍ    | أَكُولَةٍ   | أَكُولَيْنِ   | أَكُولَتَيْنِ   | أَكُولِينَ   | أَكُولَاتٍ   | فَعُول    |
      | ءكل  | 4           | أُكَلَةٌ   |             |              |                |              |              | أُكَلَةً   |             |               |                 |              |              | أُكَلَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | ءكل  | 4           | أَكِيلٌ    | أَكِيلَةٌ   | أَكِيلانِ    | أَكِيلَتَانِ   | أَكِيلُونَ   | أَكِيلاتٌ    | أَكِيلاً   | أَكِيلَةً   | أَكِيلَيْنِ   | أَكِيلَتَيْنِ   | أَكِيلِينَ   | أَكِيلاتٍ    | أَكِيلٍ    | أَكِيلَةٍ   | أَكِيلَيْنِ   | أَكِيلَتَيْنِ   | أَكِيلِينَ   | أَكِيلَاتٍ   | فَعِيل    |
      | ءمن  | 4           | أَمُونٌ    | أَمُونَةٌ   | أَمُونَانِ   | أَمُونَتَانِ   | أَمُونُونَ   | أَمُونَاتٌ   | أَمُونًا   | أَمُونَةً   | أَمُونَيْنِ   | أَمُونَتَيْنِ   | أَمُونِينَ   | أَمُونَاتٍ   | أَمُونٍ    | أَمُونَةٍ   | أَمُونَيْنِ   | أَمُونَتَيْنِ   | أَمُونِينَ   | أَمُونَاتٍ   | فَعُول    |
      | ءمن  | 4           | أُمَنَةٌ   |             |              |                |              |              | أُمَنَةً   |             |               |                 |              |              | أُمَنَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | ءمن  | 5           | أَمُونٌ    | أَمُونَةٌ   | أَمُونَانِ   | أَمُونَتَانِ   | أَمُونُونَ   | أَمُونَاتٌ   | أَمُونًا   | أَمُونَةً   | أَمُونَيْنِ   | أَمُونَتَيْنِ   | أَمُونِينَ   | أَمُونَاتٍ   | أَمُونٍ    | أَمُونَةٍ   | أَمُونَيْنِ   | أَمُونَتَيْنِ   | أَمُونِينَ   | أَمُونَاتٍ   | فَعُول    |
      | ءمن  | 5           | أُمَنَةٌ   |             |              |                |              |              | أُمَنَةً   |             |               |                 |              |              | أُمَنَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | ءنن  | 2           | أُنَنَةٌ   |             |              |                |              |              | أُنَنَةً   |             |               |                 |              |              | أُنَنَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | بيع  | 2           | بَيُوعٌ    | بَيُوعَةٌ   | بَيُوعَانِ   | بَيُوعَتَانِ   | بَيُوعُونَ   | بَيُوعَاتٌ   | بَيُوعًا   | بَيُوعَةً   | بَيُوعَيْنِ   | بَيُوعَتَيْنِ   | بَيُوعِينَ   | بَيُوعَاتٍ   | بَيُوعٍ    | بَيُوعَةٍ   | بَيُوعَيْنِ   | بَيُوعَتَيْنِ   | بَيُوعِينَ   | بَيُوعَاتٍ   | فَعُول    |
      | روي  | 2           | رَاوِيَةٌ  |             |              |                |              |              | رَاوِيَةً  |             |               |                 |              |              | رَاوِيَةٍ  |             |               |                 |              |              | فَاعِلَة  |
      | روي  | 4           | رَاوِيَةٌ  |             |              |                |              |              | رَاوِيَةً  |             |               |                 |              |              | رَاوِيَةٍ  |             |               |                 |              |              | فَاعِلَة  |
      | سءل  | 3           | سَؤُولٌ    | سَؤُولَةٌ   | سَؤُولانِ    | سَؤُولَتَانِ   | سَؤُولُونَ   | سَؤُولاتٌ    | سَؤُولاً   | سَؤُولَةً   | سَؤُولَيْنِ   | سَؤُولَتَيْنِ   | سَؤُولِينَ   | سَؤُولاتٍ    | سَؤُولٍ    | سَؤُولَةٍ   | سَؤُولَيْنِ   | سَؤُولَتَيْنِ   | سَؤُولِينَ   | سَؤُولَاتٍ   | فَعُول    |
      | سءل  | 3           | سُؤَلَةٌ   |             |              |                |              |              | سُؤَلَةً   |             |               |                 |              |              | سُؤَلَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | سءم  | 4           | سَؤُومٌ    | سَؤُومَةٌ   | سَؤُومَانِ   | سَؤُومَتَانِ   | سَؤُومُونَ   | سَؤُومَاتٌ   | سَؤُومًا   | سَؤُومَةً   | سَؤُومَيْنِ   | سَؤُومَتَيْنِ   | سَؤُومِينَ   | سَؤُومَاتٍ   | سَؤُومٍ    | سَؤُومَةٍ   | سَؤُومَيْنِ   | سَؤُومَتَيْنِ   | سَؤُومِينَ   | سَؤُومَاتٍ   | فَعُول    |
      | سءم  | 4           | سَئِمٌ     | سَئِمَةٌ    | سَئِمَانِ    | سَئِمَتَانِ    | سَئِمُونَ    | سَئِمَاتٌ    | سَئِمًا    | سَئِمَةً    | سَئِمَيْنِ    | سَئِمَتَيْنِ    | سَئِمِينَ    | سَئِمَاتٍ    | سَئِمٍ     | سَئِمَةٍ    | سَئِمَيْنِ    | سَئِمَتَيْنِ    | سَئِمِينَ    | سَئِمَاتٍ    | فَعِل     |
      | سكت  | 1           | سَكُوتٌ    | سَكُوتَةٌ   | سَكُوتَانِ   | سَكُوتَتَانِ   | سَكُوتُونَ   | سَكُوتَاتٌ   | سَكُوتًا   | سَكُوتَةً   | سَكُوتَيْنِ   | سَكُوتَتَيْنِ   | سَكُوتِينَ   | سَكُوتَاتٍ   | سَكُوتٍ    | سَكُوتَةٍ   | سَكُوتَيْنِ   | سَكُوتَتَيْنِ   | سَكُوتِينَ   | سَكُوتَاتٍ   | فَعُول    |
      | سكت  | 1           | سِكِّيتٌ   | سِكِّيتَةٌ  | سِكِّيتَانِ  | سِكِّيتَتَانِ  | سِكِّيتُونَ  | سِكِّيتَاتٌ  | سِكِّيتًا  | سِكِّيتَةً  | سِكِّيتَيْنِ  | سِكِّيتَتَيْنِ  | سِكِّيتِينَ  | سِكِّيتَاتٍ  | سِكِّيتٍ   | سِكِّيتَةٍ  | سِكِّيتَيْنِ  | سِكِّيتَتَيْنِ  | سِكِّيتِينَ  | سِكِّيتَاتٍ  | فِعِّيل   |
      | سكت  | 1           | سَاكُوتٌ   |             | سَاكُوتَانِ  |                |              |              | سَاكُوتًا  |             | سَاكُوتَيْنِ  |                 |              |              | سَاكُوتٍ   |             | سَاكُوتَيْنِ  |                 |              |              | فَاعُول   |
      | سكن  | 1           | مِسْكِينٌ  | مِسْكِينَةٌ | مِسْكِينَانِ | مِسْكِينَتَانِ | مِسْكِينُونَ | مِسْكِينَاتٌ | مِسْكِينًا | مِسْكِينَةً | مِسْكِينَيْنِ | مِسْكِينَتَيْنِ | مِسْكِينِينَ | مِسْكِينَاتٍ | مِسْكِينٍ  | مِسْكِينَةٍ | مِسْكِينَيْنِ | مِسْكِينَتَيْنِ | مِسْكِينِينَ | مِسْكِينَاتٍ | مِفْعِيل  |
      | سكن  | 5           | مِسْكِينٌ  | مِسْكِينَةٌ | مِسْكِينَانِ | مِسْكِينَتَانِ | مِسْكِينُونَ | مِسْكِينَاتٌ | مِسْكِينًا | مِسْكِينَةً | مِسْكِينَيْنِ | مِسْكِينَتَيْنِ | مِسْكِينِينَ | مِسْكِينَاتٍ | مِسْكِينٍ  | مِسْكِينَةٍ | مِسْكِينَيْنِ | مِسْكِينَتَيْنِ | مِسْكِينِينَ | مِسْكِينَاتٍ | مِفْعِيل  |
      | صدق  | 1           | صَدُوقٌ    | صَدُوقَةٌ   | صَدُوقَانِ   | صَدُوقَتَانِ   | صَدُوقُونَ   | صَدُوقَاتٌ   | صَدُوقًا   | صَدُوقَةً   | صَدُوقَيْنِ   | صَدُوقَتَيْنِ   | صَدُوقِينَ   | صَدُوقَاتٍ   | صَدُوقٍ    | صَدُوقَةٍ   | صَدُوقَيْنِ   | صَدُوقَتَيْنِ   | صَدُوقِينَ   | صَدُوقَاتٍ   | فَعُول    |
      | صدق  | 1           | صِدِّيقٌ   | صِدِّيقَةٌ  | صِدِّيقَانِ  | صِدِّيقَتَانِ  | صِدِّيقُونَ  | صِدِّيقَاتٌ  | صِدِّيقًا  | صِدِّيقَةً  | صِدِّيقَيْنِ  | صِدِّيقَتَيْنِ  | صِدِّيقِينَ  | صِدِّيقَاتٍ  | صِدِّيقٍ   | صِدِّيقَةٍ  | صِدِّيقَيْنِ  | صِدِّيقَتَيْنِ  | صِدِّيقِينَ  | صِدِّيقَاتٍ  | فِعِّيل   |
      | ضحك  | 4           | ضَحُوكٌ    | ضَحُوكَةٌ   | ضَحُوكَانِ   | ضَحُوكَتَانِ   | ضَحُوكُونَ   | ضَحُوكَاتٌ   | ضَحُوكًا   | ضَحُوكَةً   | ضَحُوكَيْنِ   | ضَحُوكَتَيْنِ   | ضَحُوكِينَ   | ضَحُوكَاتٍ   | ضَحُوكٍ    | ضَحُوكَةٍ   | ضَحُوكَيْنِ   | ضَحُوكَتَيْنِ   | ضَحُوكِينَ   | ضَحُوكَاتٍ   | فَعُول    |
      | ضحك  | 4           | ضُحَكَةٌ   |             |              |                |              |              | ضُحَكَةً   |             |               |                 |              |              | ضُحَكَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | طلق  | 1           | مِطْلاقٌ   |             | مِطْلاقَانِ  |                |              |              | مِطْلاقًا  |             | مِطْلاقَيْنِ  |                 |              |              | مِطْلاقٍ   |             | مِطْلَاقَيْنِ |                 |              |              | مِفْعَال  |
      | طلق  | 1           | طُلَقَةٌ   |             |              |                |              |              | طُلَقَةً   |             |               |                 |              |              | طُلَقَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | طلق  | 1           | طِلِّيقٌ   | طِلِّيقَةٌ  | طِلِّيقَانِ  | طِلِّيقَتَانِ  | طِلِّيقُونَ  | طِلِّيقَاتٌ  | طِلِّيقًا  | طِلِّيقَةً  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | طِلِّيقٍ   | طِلِّيقَةٍ  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | فِعِّيل   |
      | طلق  | 2           | مِطْلاقٌ   |             | مِطْلاقَانِ  |                |              |              | مِطْلاقًا  |             | مِطْلاقَيْنِ  |                 |              |              | مِطْلاقٍ   |             | مِطْلَاقَيْنِ |                 |              |              | مِفْعَال  |
      | طلق  | 2           | طُلَقَةٌ   |             |              |                |              |              | طُلَقَةً   |             |               |                 |              |              | طُلَقَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | طلق  | 2           | طِلِّيقٌ   | طِلِّيقَةٌ  | طِلِّيقَانِ  | طِلِّيقَتَانِ  | طِلِّيقُونَ  | طِلِّيقَاتٌ  | طِلِّيقًا  | طِلِّيقَةً  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | طِلِّيقٍ   | طِلِّيقَةٍ  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | فِعِّيل   |
      | طلق  | 4           | مِطْلاقٌ   |             | مِطْلاقَانِ  |                |              |              | مِطْلاقًا  |             | مِطْلاقَيْنِ  |                 |              |              | مِطْلاقٍ   |             | مِطْلَاقَيْنِ |                 |              |              | مِفْعَال  |
      | طلق  | 4           | طُلَقَةٌ   |             |              |                |              |              | طُلَقَةً   |             |               |                 |              |              | طُلَقَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | طلق  | 4           | طِلِّيقٌ   | طِلِّيقَةٌ  | طِلِّيقَانِ  | طِلِّيقَتَانِ  | طِلِّيقُونَ  | طِلِّيقَاتٌ  | طِلِّيقًا  | طِلِّيقَةً  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | طِلِّيقٍ   | طِلِّيقَةٍ  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | فِعِّيل   |
      | طلق  | 5           | مِطْلاقٌ   |             | مِطْلاقَانِ  |                |              |              | مِطْلاقًا  |             | مِطْلاقَيْنِ  |                 |              |              | مِطْلاقٍ   |             | مِطْلَاقَيْنِ |                 |              |              | مِفْعَال  |
      | طلق  | 5           | طُلَقَةٌ   |             |              |                |              |              | طُلَقَةً   |             |               |                 |              |              | طُلَقَةٍ   |             |               |                 |              |              | فُعَلَة   |
      | طلق  | 5           | طِلِّيقٌ   | طِلِّيقَةٌ  | طِلِّيقَانِ  | طِلِّيقَتَانِ  | طِلِّيقُونَ  | طِلِّيقَاتٌ  | طِلِّيقًا  | طِلِّيقَةً  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | طِلِّيقٍ   | طِلِّيقَةٍ  | طِلِّيقَيْنِ  | طِلِّيقَتَيْنِ  | طِلِّيقِينَ  | طِلِّيقَاتٍ  | فِعِّيل   |
      | ظمء  | 4           | مِظْمَاءٌ  |             | مِظْمَاءَانِ |                |              |              | مِظْمَاءً  |             | مِظْمَاءَيْنِ |                 |              |              | مِظْمَاءٍ  |             | مِظْمَاءَيْنِ |                 |              |              | مِفْعَال  |
      | عضض  | 4           | عَضُوضٌ    | عَضُوضَةٌ   | عَضُوضَانِ   | عَضُوضَتَانِ   | عَضُوضُونَ   | عَضُوضَاتٌ   | عَضُوضًا   | عَضُوضَةً   | عَضُوضَيْنِ   | عَضُوضَتَيْنِ   | عَضُوضِينَ   | عَضُوضَاتٍ   | عَضُوضٍ    | عَضُوضَةٍ   | عَضُوضَيْنِ   | عَضُوضَتَيْنِ   | عَضُوضِينَ   | عَضُوضَاتٍ   | فَعُول    |
      | علم  | 1           | عَلِيمٌ    | عَلِيمَةٌ   | عَلِيمَانِ   | عَلِيمَتَانِ   | عَلِيمُونَ   | عَلِيمَاتٌ   | عَلِيمًا   | عَلِيمَةً   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | عَلِيمٍ    | عَلِيمَةٍ   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | فَعِيل    |
      | علم  | 1           | عَلاَّمَةٌ |             |              |                |              |              | عَلاَّمَةً |             |               |                 |              |              | عَلاَّمَةٍ |             |               |                 |              |              | فَعَّالَة |
      | علم  | 2           | عَلِيمٌ    | عَلِيمَةٌ   | عَلِيمَانِ   | عَلِيمَتَانِ   | عَلِيمُونَ   | عَلِيمَاتٌ   | عَلِيمًا   | عَلِيمَةً   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | عَلِيمٍ    | عَلِيمَةٍ   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | فَعِيل    |
      | علم  | 2           | عَلاَّمَةٌ |             |              |                |              |              | عَلاَّمَةً |             |               |                 |              |              | عَلاَّمَةٍ |             |               |                 |              |              | فَعَّالَة |
      | علم  | 4           | عَلِيمٌ    | عَلِيمَةٌ   | عَلِيمَانِ   | عَلِيمَتَانِ   | عَلِيمُونَ   | عَلِيمَاتٌ   | عَلِيمًا   | عَلِيمَةً   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | عَلِيمٍ    | عَلِيمَةٍ   | عَلِيمَيْنِ   | عَلِيمَتَيْنِ   | عَلِيمِينَ   | عَلِيمَاتٍ   | فَعِيل    |
      | علم  | 4           | عَلاَّمَةٌ |             |              |                |              |              | عَلاَّمَةً |             |               |                 |              |              | عَلاَّمَةٍ |             |               |                 |              |              | فَعَّالَة |
      | فرق  | 1           | فَرُوقٌ    | فَرُوقَةٌ   | فَرُوقَانِ   | فَرُوقَتَانِ   | فَرُوقُونَ   | فَرُوقَاتٌ   | فَرُوقًا   | فَرُوقَةً   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَرُوقٍ    | فَرُوقَةٍ   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَعُول    |
      | فرق  | 1           | فَارُوقٌ   |             | فَارُوقَانِ  |                |              |              | فَارُوقًا  |             | فَارُوقَيْنِ  |                 |              |              | فَارُوقٍ   |             | فَارُوقَيْنِ  |                 |              |              | فَاعُول   |
      | فرق  | 1           | فَرِقٌ     | فَرِقَةٌ    | فَرِقَانِ    | فَرِقَتَانِ    | فَرِقُونَ    | فَرِقَاتٌ    | فَرِقًا    | فَرِقَةً    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَرِقٍ     | فَرِقَةٍ    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَعِل     |
      | فرق  | 2           | فَرُوقٌ    | فَرُوقَةٌ   | فَرُوقَانِ   | فَرُوقَتَانِ   | فَرُوقُونَ   | فَرُوقَاتٌ   | فَرُوقًا   | فَرُوقَةً   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَرُوقٍ    | فَرُوقَةٍ   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَعُول    |
      | فرق  | 2           | فَارُوقٌ   |             | فَارُوقَانِ  |                |              |              | فَارُوقًا  |             | فَارُوقَيْنِ  |                 |              |              | فَارُوقٍ   |             | فَارُوقَيْنِ  |                 |              |              | فَاعُول   |
      | فرق  | 2           | فَرِقٌ     | فَرِقَةٌ    | فَرِقَانِ    | فَرِقَتَانِ    | فَرِقُونَ    | فَرِقَاتٌ    | فَرِقًا    | فَرِقَةً    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَرِقٍ     | فَرِقَةٍ    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَعِل     |
      | فرق  | 4           | فَرُوقٌ    | فَرُوقَةٌ   | فَرُوقَانِ   | فَرُوقَتَانِ   | فَرُوقُونَ   | فَرُوقَاتٌ   | فَرُوقًا   | فَرُوقَةً   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَرُوقٍ    | فَرُوقَةٍ   | فَرُوقَيْنِ   | فَرُوقَتَيْنِ   | فَرُوقِينَ   | فَرُوقَاتٍ   | فَعُول    |
      | فرق  | 4           | فَارُوقٌ   |             | فَارُوقَانِ  |                |              |              | فَارُوقًا  |             | فَارُوقَيْنِ  |                 |              |              | فَارُوقٍ   |             | فَارُوقَيْنِ  |                 |              |              | فَاعُول   |
      | فرق  | 4           | فَرِقٌ     | فَرِقَةٌ    | فَرِقَانِ    | فَرِقَتَانِ    | فَرِقُونَ    | فَرِقَاتٌ    | فَرِقًا    | فَرِقَةً    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَرِقٍ     | فَرِقَةٍ    | فَرِقَيْنِ    | فَرِقَتَيْنِ    | فَرِقِينَ    | فَرِقَاتٍ    | فَعِل     |
      | لوح  | 1           | مِلْوَاحٌ  |             | مِلْوَاحَانِ |                |              |              | مِلْوَاحًا |             | مِلْوَاحَيْنِ |                 |              |              | مِلْوَاحٍ  |             | مِلْوَاحَيْنِ |                 |              |              | مِفْعَال  |
      | ملل  | 1           | مَلُولٌ    | مَلُولَةٌ   | مَلُولانِ    | مَلُولَتَانِ   | مَلُولُونَ   | مَلُولاتٌ    | مَلُولاً   | مَلُولَةً   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولاتٍ    | مَلُولٍ    | مَلُولَةٍ   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولَاتٍ   | فَعُول    |
      | ملل  | 2           | مَلُولٌ    | مَلُولَةٌ   | مَلُولانِ    | مَلُولَتَانِ   | مَلُولُونَ   | مَلُولاتٌ    | مَلُولاً   | مَلُولَةً   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولاتٍ    | مَلُولٍ    | مَلُولَةٍ   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولَاتٍ   | فَعُول    |
      | ملل  | 4           | مَلُولٌ    | مَلُولَةٌ   | مَلُولانِ    | مَلُولَتَانِ   | مَلُولُونَ   | مَلُولاتٌ    | مَلُولاً   | مَلُولَةً   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولاتٍ    | مَلُولٍ    | مَلُولَةٍ   | مَلُولَيْنِ   | مَلُولَتَيْنِ   | مَلُولِينَ   | مَلُولَاتٍ   | فَعُول    |
      | منن  | 1           | مَنُونٌ    | مَنُونَةٌ   | مَنُونَانِ   | مَنُونَتَانِ   | مَنُونُونَ   | مَنُونَاتٌ   | مَنُونًا   | مَنُونَةً   | مَنُونَيْنِ   | مَنُونَتَيْنِ   | مَنُونِينَ   | مَنُونَاتٍ   | مَنُونٍ    | مَنُونَةٍ   | مَنُونَيْنِ   | مَنُونَتَيْنِ   | مَنُونِينَ   | مَنُونَاتٍ   | فَعُول    |
      | نءم  | 2           | نَؤُومٌ    | نَؤُومَةٌ   | نَؤُومَانِ   | نَؤُومَتَانِ   | نَؤُومُونَ   | نَؤُومَاتٌ   | نَؤُومًا   | نَؤُومَةً   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | نَؤُومٍ    | نَؤُومَةٍ   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | فَعُول    |
      | نءم  | 3           | نَؤُومٌ    | نَؤُومَةٌ   | نَؤُومَانِ   | نَؤُومَتَانِ   | نَؤُومُونَ   | نَؤُومَاتٌ   | نَؤُومًا   | نَؤُومَةً   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | نَؤُومٍ    | نَؤُومَةٍ   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | فَعُول    |
      | نءم  | 2           | نَؤُومٌ    | نَؤُومَةٌ   | نَؤُومَانِ   | نَؤُومَتَانِ   | نَؤُومُونَ   | نَؤُومَاتٌ   | نَؤُومًا   | نَؤُومَةً   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | نَؤُومٍ    | نَؤُومَةٍ   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | فَعُول    |
      | نءم  | 3           | نَؤُومٌ    | نَؤُومَةٌ   | نَؤُومَانِ   | نَؤُومَتَانِ   | نَؤُومُونَ   | نَؤُومَاتٌ   | نَؤُومًا   | نَؤُومَةً   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | نَؤُومٍ    | نَؤُومَةٍ   | نَؤُومَيْنِ   | نَؤُومَتَيْنِ   | نَؤُومِينَ   | نَؤُومَاتٍ   | فَعُول    |
      | نصر  | 1           | نَصُورٌ    | نَصُورَةٌ   | نَصُورَانِ   | نَصُورَتَانِ   | نَصُورُونَ   | نَصُورَاتٌ   | نَصُورًا   | نَصُورَةً   | نَصُورَيْنِ   | نَصُورَتَيْنِ   | نَصُورِينَ   | نَصُورَاتٍ   | نَصُورٍ    | نَصُورَةٍ   | نَصُورَيْنِ   | نَصُورَتَيْنِ   | نَصُورِينَ   | نَصُورَاتٍ   | فَعُول    |
      | نصر  | 1           | نَصِيرٌ    | نَصِيرَةٌ   | نَصِيرَانِ   | نَصِيرَتَانِ   | نَصِيرُونَ   | نَصِيرَاتٌ   | نَصِيرًا   | نَصِيرَةً   | نَصِيرَيْنِ   | نَصِيرَتَيْنِ   | نَصِيرِينَ   | نَصِيرَاتٍ   | نَصِيرٍ    | نَصِيرَةٍ   | نَصِيرَيْنِ   | نَصِيرَتَيْنِ   | نَصِيرِينَ   | نَصِيرَاتٍ   | فَعِيل    |
      | ودد  | 4           | وَدُودٌ    | وَدُودَةٌ   | وَدُودَانِ   | وَدُودَتَانِ   | وَدُودُونَ   | وَدُودَاتٌ   | وَدُودًا   | وَدُودَةً   | وَدُودَيْنِ   | وَدُودَتَيْنِ   | وَدُودِينَ   | وَدُودَاتٍ   | وَدُودٍ    | وَدُودَةٍ   | وَدُودَيْنِ   | وَدُودَتَيْنِ   | وَدُودِينَ   | وَدُودَاتٍ   | فَعُول    |
      | وقي  | 2           | وَقٍ       | وَقِيَةٌ    | وَقِيَانِ    | وَقِيَتَانِ    | وَقُونَ      | وَقِيَاتٌ    | وَقِيًا    | وَقِيَةً    | وَقِيَيْنِ    | وَقِيَتَيْنِ    | وَقِينَ      | وَقِيَاتٍ    | وَقٍ       | وَقِيَةٍ    | وَقِيَيْنِ    | وَقِيَتَيْنِ    | وَقِينَ      | وَقِيَاتٍ    | فَعِل     |