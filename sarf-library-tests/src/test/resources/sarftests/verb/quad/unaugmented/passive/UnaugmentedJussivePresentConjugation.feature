Feature: unaugmented quadrilateral verb conjugation in passive jussive state
# المضارع الرباعي المنصوب المبني للمجهول
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in passive jussive state
    Given an unaugmented verb
    When the quadrilateral verb is passively conjugated in "PassiveJussive" state
    Then first person singular passive present conjugation the verb "<verb>" is "<single_first>"
    And first person plural passive present conjugation the verb "<verb>" is "<plural_first>"
    And masculine singular second person passive present conjugation the verb "<verb>" is "<m_single_second>"
    And feminine singular second person passive present conjugation the verb "<verb>" is "<f_single_second>"
    And masculine dual second person passive present conjugation the verb "<verb>" is "<m_dual_second>"
    And masculine plural second person passive present conjugation the verb "<verb>" is "<m_plural_second>"
    And feminine plural second person passive present conjugation the verb "<verb>" is "<f_plural_second>"
    And masculine singular third person passive present conjugation the verb "<verb>" is "<m_single_third>"
    And feminine singular third person passive present conjugation the verb "<verb>" is "<f_single_third>"
    And masculine dual third person passive present conjugation the verb "<verb>" is "<m_dual_third>"
    And feminine dual third person passive present conjugation the verb "<verb>" is "<f_dual_third>"
    And masculine plural third person passive present conjugation the verb "<verb>" is "<m_plural_third>"
    And feminine plural third person passive present conjugation the verb "<verb>" is "<f_plural_third>"
    Examples:
      | verb | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | أُدَحْرَجْ   | نُدَحْرَجْ   | تُدَحْرَجْ      | تُدَحْرَجِي     | تُدَحْرَجَا   | تُدَحْرَجُوا    | تُدَحْرَجْنَ    | يُدَحْرَجْ     | تُدَحْرَجْ     | يُدَحْرَجَا  | تُدَحْرَجَا  | يُدَحْرَجُوا   | يُدَحْرَجْنَ   |
      | بءدل |              |              |                 |                 |               |                 |                 | يُبَأْدَلْ     | تُبَأْدَلْ     |              |              |                |                |
      | بلور | أُبَلْوَرْ   | نُبَلْوَرْ   | تُبَلْوَرْ      | تُبَلْوَرِي     | تُبَلْوَرَا   | تُبَلْوَرُوا    | تُبَلْوَرْنَ    | يُبَلْوَرْ     | تُبَلْوَرْ     | يُبَلْوَرَا  | تُبَلْوَرَا  | يُبَلْوَرُوا   | يُبَلْوَرْنَ   |
      | تلفن |              |              |                 |                 |               |                 |                 | يُتَلْفَنْ     | تُتَلْفَنْ     |              |              |                |                |
      | تنتن |              |              |                 |                 |               |                 |                 | يُتَنْتَنْ     | تُتَنْتَنْ     |              |              |                |                |
      | جءجء | أُجَأْجَأْ   | نُجَأْجَأْ   | تُجَأْجَأْ      | تُجَأْجَئِي     | تُجَأْجَأَا   | تُجَأْجَؤُوا    | تُجَأْجَأْنَ    | يُجَأْجَأْ     | تُجَأْجَأْ     | يُجَأْجَأَا  | تُجَأْجَأَا  | يُجَأْجَؤُوا   | يُجَأْجَأْنَ   |
      | حوقل | أُحَوْقَلْ   | نُحَوْقَلْ   | تُحَوْقَلْ      | تُحَوْقَلِي     | تُحَوْقَلا    | تُحَوْقَلُوا    | تُحَوْقَلْنَ    | يُحَوْقَلْ     | تُحَوْقَلْ     | يُحَوْقَلا   | تُحَوْقَلا   | يُحَوْقَلُوا   | يُحَوْقَلْنَ   |
      | حيحي |              |              |                 |                 |               |                 |                 | يُحَيْحَ       | تُحَيْحَ       |              |              |                |                |
      | رهيء | أُرَهْيَأْ   | نُرَهْيَأْ   | تُرَهْيَأْ      | تُرَهْيَئِي     | تُرَهْيَأَا   | تُرَهْيَؤُوا    | تُرَهْيَأْنَ    | يُرَهْيَأْ     | تُرَهْيَأْ     | يُرَهْيَأَا  | تُرَهْيَأَا  | يُرَهْيَؤُوا   | يُرَهْيَأْنَ   |
      | زلزل | أُزَلْزَلْ   | نُزَلْزَلْ   | تُزَلْزَلْ      | تُزَلْزَلِي     | تُزَلْزَلا    | تُزَلْزَلُوا    | تُزَلْزَلْنَ    | يُزَلْزَلْ     | تُزَلْزَلْ     | يُزَلْزَلا   | تُزَلْزَلا   | يُزَلْزَلُوا   | يُزَلْزَلْنَ   |
      | سبرت |              |              |                 |                 |               |                 |                 | يُسَبْرَتْ     | تُسَبْرَتْ     |              |              |                |                |
      | سيطر |              |              |                 |                 |               |                 |                 | يُسَيْطَرْ     | تُسَيْطَرْ     |              |              |                |                |
      | شريف | أُشَرْيَفْ   | نُشَرْيَفْ   | تُشَرْيَفْ      | تُشَرْيَفِي     | تُشَرْيَفَا   | تُشَرْيَفُوا    | تُشَرْيَفْنَ    | يُشَرْيَفْ     | تُشَرْيَفْ     | يُشَرْيَفَا  | تُشَرْيَفَا  | يُشَرْيَفُوا   | يُشَرْيَفْنَ   |
      | ضوضي |              |              |                 |                 |               |                 |                 | يُضَوْضَ       | تُضَوْضَ       |              |              |                |                |
      | طمءن | أُطَمْأَنْ   | نُطَمْأَنْ   | تُطَمْأَنْ      | تُطَمْأَنِي     | تُطَمْأَنَا   | تُطَمْأَنُوا    | تُطَمْأَنَّ     | يُطَمْأَنْ     | تُطَمْأَنْ     | يُطَمْأَنَا  | تُطَمْأَنَا  | يُطَمْأَنُوا   | يُطَمْأَنَّ    |
      | غرقء | أُغَرْقَأْ   | نُغَرْقَأْ   | تُغَرْقَأْ      | تُغَرْقَئِي     | تُغَرْقَأَا   | تُغَرْقَؤُوا    | تُغَرْقَأْنَ    | يُغَرْقَأْ     | تُغَرْقَأْ     | يُغَرْقَأَا  | تُغَرْقَأَا  | يُغَرْقَؤُوا   | يُغَرْقَأْنَ   |
      | قلسي | أُقَلْسَ     | نُقَلْسَ     | تُقَلْسَ        | تُقَلْسَيْ      | تُقَلْسَيَا   | تُقَلْسَوْا     | تُقَلْسَيْنَ    | يُقَلْسَ       | تُقَلْسَ       | يُقَلْسَيَا  | تُقَلْسَيَا  | يُقَلْسَوْا    | يُقَلْسَيْنَ   |
      | وءوء |              |              |                 |                 |               |                 |                 | يُوَأْوَأْ     | تُوَأْوَأْ     |              |              |                |                |
      | وسوس | أُوَسْوَسْ   | نُوَسْوَسْ   | تُوَسْوَسْ      | تُوَسْوَسِي     | تُوَسْوَسَا   | تُوَسْوَسُوا    | تُوَسْوَسْنَ    | يُوَسْوَسْ     | تُوَسْوَسْ     | يُوَسْوَسَا  | تُوَسْوَسَا  | يُوَسْوَسُوا   | يُوَسْوَسْنَ   |
      | يءيء |              |              |                 |                 |               |                 |                 | يُيَأْيَأْ     | تُيَأْيَأْ     |              |              |                |                |
      | يرنء | أُيَرْنَأْ   | نُيَرْنَأْ   | تُيَرْنَأْ      | تُيَرْنَئِي     | تُيَرْنَأَا   | تُيَرْنَؤُوا    | تُيَرْنَأْنَ    | يُيَرْنَأْ     | تُيَرْنَأْ     | يُيَرْنَأَا  | تُيَرْنَأَا  | يُيَرْنَؤُوا   | يُيَرْنَأْنَ   |
      | يهيه |              |              |                 |                 |               |                 |                 | يُيَهْيَهْ     | تُيَهْيَهْ     |              |              |                |                |
