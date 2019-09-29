Feature: unaugmented quadrilateral verb conjugation in emphasized imperative state
# الأمر المؤكد من الرباعي المجرد
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in emphasized imperative state
    Given an unaugmented verb
    When the quadrilateral verb is conjugated in "ImperativeEmphasized" state
    Then first person singular present conjugation the verb "<verb>" is "<single_first>"
    And first person plural present conjugation the verb "<verb>" is "<plural_first>"
    And masculine singular second person present conjugation the verb "<verb>" is "<m_single_second>"
    And feminine singular second person present conjugation the verb "<verb>" is "<f_single_second>"
    And masculine dual second person present conjugation the verb "<verb>" is "<m_dual_second>"
    And masculine plural second person present conjugation the verb "<verb>" is "<m_plural_second>"
    And feminine plural second person present conjugation the verb "<verb>" is "<f_plural_second>"
    And masculine singular third person present conjugation the verb "<verb>" is "<m_single_third>"
    And feminine singular third person present conjugation the verb "<verb>" is "<f_single_third>"
    And masculine dual third person present conjugation the verb "<verb>" is "<m_dual_third>"
    And feminine dual third person present conjugation the verb "<verb>" is "<f_dual_third>"
    And masculine plural third person present conjugation the verb "<verb>" is "<m_plural_third>"
    And feminine plural third person present conjugation the verb "<verb>" is "<f_plural_third>"
    Examples:
      | verb | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج |              |              | دَحْرِجَنَّ     | دَحْرِجِنَّ     | دَحْرِجَانِّ  | دَحْرِجُنَّ     | دَحْرِجْنَانِّ  |                |                |              |              |                |                |
      | بءدل |              |              | بَأْدِلَنَّ     | بَأْدِلِنَّ     | بَأْدِلانِّ   | بَأْدِلُنَّ     | بَأْدِلْنَانِّ  |                |                |              |              |                |                |
      | بلور |              |              | بَلْوِرَنَّ     | بَلْوِرِنَّ     | بَلْوِرَانِّ  | بَلْوِرُنَّ     | بَلْوِرْنَانِّ  |                |                |              |              |                |                |
      | تلفن |              |              | تَلْفِنَنَّ     | تَلْفِنِنَّ     | تَلْفِنَانِّ  | تَلْفِنُنَّ     | تَلْفِنَّانِّ   |                |                |              |              |                |                |
      | تنتن |              |              | تَنْتِنَنَّ     | تَنْتِنِنَّ     | تَنْتِنَانِّ  | تَنْتِنُنَّ     | تَنْتِنَّانِّ   |                |                |              |              |                |                |
      | جءجء |              |              | جَأْجِئَنَّ     | جَأْجِئِنَّ     | جَأْجِئَانِّ  | جَأْجِئُنَّ     | جَأْجِئْنَانِّ  |                |                |              |              |                |                |
      | حوقل |              |              | حَوْقِلَنَّ     | حَوْقِلِنَّ     | حَوْقِلانِّ   | حَوْقِلُنَّ     | حَوْقِلْنَانِّ  |                |                |              |              |                |                |
      | حيحي |              |              | حَيْحِيَنَّ     | حَيْحِنَّ       | حَيْحِيَانِّ  | حَيْحُنَّ       | حَيْحِينَانِّ   |                |                |              |              |                |                |
      | رهيء |              |              | رَهْيِئَنَّ     | رَهْيِئِنَّ     | رَهْيِئَانِّ  | رَهْيِئُنَّ     | رَهْيِئْنَانِّ  |                |                |              |              |                |                |
      | زلزل |              |              | زَلْزِلَنَّ     | زَلْزِلِنَّ     | زَلْزِلانِّ   | زَلْزِلُنَّ     | زَلْزِلْنَانِّ  |                |                |              |              |                |                |
      | سبرت |              |              | سَبْرِتَنَّ     | سَبْرِتِنَّ     | سَبْرِتَانِّ  | سَبْرِتُنَّ     | سَبْرِتْنَانِّ  |                |                |              |              |                |                |
      | سيطر |              |              | سَيْطِرَنَّ     | سَيْطِرِنَّ     | سَيْطِرَانِّ  | سَيْطِرُنَّ     | سَيْطِرْنَانِّ  |                |                |              |              |                |                |
      | شريف |              |              | شَرْيِفَنَّ     | شَرْيِفِنَّ     | شَرْيِفَانِّ  | شَرْيِفُنَّ     | شَرْيِفْنَانِّ  |                |                |              |              |                |                |
      | ضوضي |              |              | ضَوْضِيَنَّ     | ضَوْضِنَّ       | ضَوْضِيَانِّ  | ضَوْضُنَّ       | ضَوْضِينَانِّ   |                |                |              |              |                |                |
      | طمءن |              |              | طَمْئِنَنَّ     | طَمْئِنِنَّ     | طَمْئِنَانِّ  | طَمْئِنُنَّ     | طَمْئِنَّانِّ   |                |                |              |              |                |                |
      | غرقء |              |              | غَرْقِئَنَّ     | غَرْقِئِنَّ     | غَرْقِئَانِّ  | غَرْقِئُنَّ     | غَرْقِئْنَانِّ  |                |                |              |              |                |                |
      | قلسي |              |              | قَلْسِيَنَّ     | قَلْسِنَّ       | قَلْسِيَانِّ  | قَلْسُنَّ       | قَلْسِينَانِّ   |                |                |              |              |                |                |
      | وءوء |              |              | وَأْوِئَنَّ     | وَأْوِئِنَّ     | وَأْوِئَانِّ  | وَأْوِئُنَّ     | وَأْوِئْنَانِّ  |                |                |              |              |                |                |
      | وسوس |              |              | وَسْوِسَنَّ     | وَسْوِسِنَّ     | وَسْوِسَانِّ  | وَسْوِسُنَّ     | وَسْوِسْنَانِّ  |                |                |              |              |                |                |
      | يءيء |              |              | يَأْيِئَنَّ     | يَأْيِئِنَّ     | يَأْيِئَانِّ  | يَأْيِئُنَّ     | يَأْيِئْنَانِّ  |                |                |              |              |                |                |
      | يرنء |              |              | يَرْنِئَنَّ     | يَرْنِئِنَّ     | يَرْنِئَانِّ  | يَرْنِئُنَّ     | يَرْنِئْنَانِّ  |                |                |              |              |                |                |
      | يهيه |              |              | يَهْيِهَنَّ     | يَهْيِهِنَّ     | يَهْيِهَانِّ  | يَهْيِهُنَّ     | يَهْيِهْنَانِّ  |                |                |              |              |                |                |
