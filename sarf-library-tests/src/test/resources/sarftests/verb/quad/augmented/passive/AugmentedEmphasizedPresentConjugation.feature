Feature: augmented quadrilateral verb conjugation in passive present emphasized state
# المضارع المؤكد المبني للمجهول من الرباعي المزيد
  Scenario Outline: passive augmented quadrilateral verb past conjugation in present emphasized state
    Given an augmented verb
    When the augmented quadrilateral verb is passively conjugated in "PassiveEmphasized" state
    Then the first person singular conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<single_first>"
    And the first person plural conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<plural_first>"
    And the masculine singular second person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_single_second>"
    And the feminine singular second person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<f_single_second>"
    And the masculine dual second person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_single_third>"
    And the feminine singular third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<f_single_third>"
    And the masculine dual third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the passive present quad verb "<verb>" and formula of "<formula>" is "<f_plural_third>"
    Examples:
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third  | f_single_third  | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | 1       |              |              |                 |                 |               |                 |                 | يُتَدَحْرَجَنَّ | تُتَدَحْرَجَنَّ |              |              |                |                |
      | بلور | 1       |              |              |                 |                 |               |                 |                 | يُتَبَلْوَرَنَّ | تُتَبَلْوَرَنَّ |              |              |                |                |
      | جءجء | 1       |              |              |                 |                 |               |                 |                 | يُتَجَأْجَأَنَّ | تُتَجَأْجَأَنَّ |              |              |                |                |
      | رهيء | 1       |              |              |                 |                 |               |                 |                 | يُتَرَهْيَأَنَّ | تُتَرَهْيَأَنَّ |              |              |                |                |
      | زلزل | 1       |              |              |                 |                 |               |                 |                 | يُتَزَلْزَلَنَّ | تُتَزَلْزَلَنَّ |              |              |                |                |
      | سيطر | 1       |              |              |                 |                 |               |                 |                 | يُتَسَيْطَرَنَّ | تُتَسَيْطَرَنَّ |              |              |                |                |
      | طمءن | 1       |              |              |                 |                 |               |                 |                 | يُتَطَمْأَنَنَّ | تُتَطَمْأَنَنَّ |              |              |                |                |
      | طمءن | 3       |              |              |                 |                 |               |                 |                 | يُطْمَأَنَّنَّ  | تُطْمَأَنَّنَّ  |              |              |                |                |
      | قلسي | 1       |              |              |                 |                 |               |                 |                 | يُتَقَلْسَيَنَّ | تُتَقَلْسَيَنَّ |              |              |                |                |
      | شرءب | 3       |              |              |                 |                 |               |                 |                 | يُشْرَأَبَّنَّ  | تُشْرَأَبَّنَّ  |              |              |                |                |
      | مرءي | 1       |              |              |                 |                 |               |                 |                 | يُتَمَرْأَيَنَّ | تُتَمَرْأَيَنَّ |              |              |                |                |
      | شيطن | 1       |              |              |                 |                 |               |                 |                 | يُتَشَيْطَنَنَّ | تُتَشَيْطَنَنَّ |              |              |                |                |
      | وشوش | 1       |              |              |                 |                 |               |                 |                 | يُتَوَشْوَشَنَّ | تُتَوَشْوَشَنَّ |              |              |                |                |
      | بخدن | 2       |              |              |                 |                 |               |                 |                 | يُبْخَنْدَنَنَّ | تُبْخَنْدَنَنَّ |              |              |                |                |
      | حبطء | 2       |              |              |                 |                 |               |                 |                 | يُحْبَنْطَأَنَّ | تُحْبَنْطَأَنَّ |              |              |                |                |
      | حوصل | 2       |              |              |                 |                 |               |                 |                 | يُحْوَنْصَلَنَّ | تُحْوَنْصَلَنَّ |              |              |                |                |
      | سلقي | 2       |              |              |                 |                 |               |                 |                 | يُسْلَنْقَيَنَّ | تُسْلَنْقَيَنَّ |              |              |                |                |
      | فرقع | 1       |              |              |                 |                 |               |                 |                 | يُتَفَرْقَعَنَّ | تُتَفَرْقَعَنَّ |              |              |                |                |
      | فرقع | 2       |              |              |                 |                 |               |                 |                 | يُفْرَنْقَعَنَّ | تُفْرَنْقَعَنَّ |              |              |                |                |
      | قشعر | 1       |              |              |                 |                 |               |                 |                 | يُتَقَشْعَرَنَّ | تُتَقَشْعَرَنَّ |              |              |                |                |
      | قشعر | 3       |              |              |                 |                 |               |                 |                 | يُقْشَعَرَّنَّ  | تُقْشَعَرَّنَّ  |              |              |                |                |
      | كوءد | 3       |              |              |                 |                 |               |                 |                 | يُكْوَأَدَّنَّ  | تُكْوَأَدَّنَّ  |              |              |                |                |
      | كوهد | 3       |              |              |                 |                 |               |                 |                 | يُكْوَهَدَّنَّ  | تُكْوَهَدَّنَّ  |              |              |                |                |
      | مضحن | 3       |              |              |                 |                 |               |                 |                 | يُمْضَحَنَّنَّ  | تُمْضَحَنَّنَّ  |              |              |                |                |
