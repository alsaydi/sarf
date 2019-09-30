Feature: augmented quadrilateral verb conjugation in imperative state
# الأمر من الرباعي المزيد
  Scenario Outline: active augmented quadrilateral verb past conjugation in imperative state
    Given an augmented verb
    When the augmented quadrilateral verb is actively conjugated in "Imperative" state
    Then the first person singular conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<single_first>"
    And the first person plural conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<plural_first>"
    And the masculine singular second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_single_second>"
    And the feminine singular second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_single_second>"
    And the masculine dual second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_single_third>"
    And the feminine singular third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_single_third>"
    And the masculine dual third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_plural_third>"
    Examples:
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | 1       |              |              | تَدَحْرَجْ      | تَدَحْرَجِي     | تَدَحْرَجَا   | تَدَحْرَجُوا    | تَدَحْرَجْنَ    |                |                |              |              |                |                |
      | بلور | 1       |              |              | تَبَلْوَرْ      | تَبَلْوَرِي     | تَبَلْوَرَا   | تَبَلْوَرُوا    | تَبَلْوَرْنَ    |                |                |              |              |                |                |
      | جءجء | 1       |              |              | تَجَأْجَأْ      | تَجَأْجَئِي     | تَجَأْجَأَا   | تَجَأْجَؤُوا    | تَجَأْجَأْنَ    |                |                |              |              |                |                |
      | رهيء | 1       |              |              | تَرَهْيَأْ      | تَرَهْيَئِي     | تَرَهْيَأَا   | تَرَهْيَؤُوا    | تَرَهْيَأْنَ    |                |                |              |              |                |                |
      | زلزل | 1       |              |              | تَزَلْزَلْ      | تَزَلْزَلِي     | تَزَلْزَلا    | تَزَلْزَلُوا    | تَزَلْزَلْنَ    |                |                |              |              |                |                |
      | سيطر | 1       |              |              | تَسَيْطَرْ      | تَسَيْطَرِي     | تَسَيْطَرَا   | تَسَيْطَرُوا    | تَسَيْطَرْنَ    |                |                |              |              |                |                |
      | طمءن | 1       |              |              | تَطَمْأَنْ      | تَطَمْأَنِي     | تَطَمْأَنَا   | تَطَمْأَنُوا    | تَطَمْأَنَّ     |                |                |              |              |                |                |
      | طمءن | 3       |              |              | اطْمَئِنَّ      | اطْمَئِنِّي     | اطْمَئِنَّا   | اطْمَئِنُّوا    | اطْمَأْنِنَّ    |                |                |              |              |                |                |
      | قلسي | 1       |              |              | تَقَلْسَ        | تَقَلْسَيْ      | تَقَلْسَيَا   | تَقَلْسَوْا     | تَقَلْسَيْنَ    |                |                |              |              |                |                |
      | شرءب | 3       |              |              | اشْرَئِبَّ      | اشْرَئِبِّي     | اشْرَئِبَّا   | اشْرَئِبُّوا    | اشْرَأْبِبْنَ   |                |                |              |              |                |                |
      | مرءي | 1       |              |              | تَمَرْأَ        | تَمَرْأَيْ      | تَمَرْأَيَا   | تَمَرْأَوْا     | تَمَرْأَيْنَ    |                |                |              |              |                |                |
      | شيطن | 1       |              |              | تَشَيْطَنْ      | تَشَيْطَنِي     | تَشَيْطَنَا   | تَشَيْطَنُوا    | تَشَيْطَنَّ     |                |                |              |              |                |                |
      | وشوش | 1       |              |              | تَوَشْوَشْ      | تَوَشْوَشِي     | تَوَشْوَشَا   | تَوَشْوَشُوا    | تَوَشْوَشْنَ    |                |                |              |              |                |                |
      | بخدن | 2       |              |              | ابْخَنْدِنْ     | ابْخَنْدِنِي    | ابْخَنْدِنَا  | ابْخَنْدِنُوا   | ابْخَنْدِنَّ    |                |                |              |              |                |                |
      | حبطء | 2       |              |              | احْبَنْطِئْ     | احْبَنْطِئِي    | احْبَنْطِئَا  | احْبَنْطِئُوا   | احْبَنْطِئْنَ   |                |                |              |              |                |                |
      | حوصل | 2       |              |              | احْوَنْصِلْ     | احْوَنْصِلِي    | احْوَنْصِلا   | احْوَنْصِلُوا   | احْوَنْصِلْنَ   |                |                |              |              |                |                |
      | سلقي | 2       |              |              | اسْلَنْقِ       | اسْلَنْقِي      | اسْلَنْقِيَا  | اسْلَنْقُوا     | اسْلَنْقِينَ    |                |                |              |              |                |                |
      | فرقع | 1       |              |              | تَفَرْقَعْ      | تَفَرْقَعِي     | تَفَرْقَعَا   | تَفَرْقَعُوا    | تَفَرْقَعْنَ    |                |                |              |              |                |                |
      | فرقع | 2       |              |              | افْرَنْقِعْ     | افْرَنْقِعِي    | افْرَنْقِعَا  | افْرَنْقِعُوا   | افْرَنْقِعْنَ   |                |                |              |              |                |                |
      | قشعر | 1       |              |              | تَقَشْعَرْ      | تَقَشْعَرِي     | تَقَشْعَرَا   | تَقَشْعَرُوا    | تَقَشْعَرْنَ    |                |                |              |              |                |                |
      | قشعر | 3       |              |              | اقْشَعِرَّ      | اقْشَعِرِّي     | اقْشَعِرَّا   | اقْشَعِرُّوا    | اقْشَعْرِرْنَ   |                |                |              |              |                |                |
      | كوءد | 3       |              |              | اكْوَئِدَّ      | اكْوَئِدِّي     | اكْوَئِدَّا   | اكْوَئِدُّوا    | اكْوَأْدِدْنَ   |                |                |              |              |                |                |
      | كوهد | 3       |              |              | اكْوَهِدَّ      | اكْوَهِدِّي     | اكْوَهِدَّا   | اكْوَهِدُّوا    | اكْوَهْدِدْنَ   |                |                |              |              |                |                |
      | مضحن | 3       |              |              | امْضَحِنَّ      | امْضَحِنِّي     | امْضَحِنَّا   | امْضَحِنُّوا    | امْضَحْنِنَّ    |                |                |              |              |                |                |
