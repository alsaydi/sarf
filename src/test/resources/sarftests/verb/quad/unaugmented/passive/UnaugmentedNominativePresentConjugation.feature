Feature: unaugmented quadrilateral verb conjugation in passive nominative state
# المضارع الرباعي المرفوع المبني للمجهول
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in passive nominative state
    Given an unaugmented verb
    When the quadrilateral verb is passively conjugated in "PassiveNominative" state
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
      | verb | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third  | f_dual_third  | m_plural_third | f_plural_third |
      | دحرج | أُدَحْرَجُ | نُدَحْرَجُ | تُدَحْرَجُ | تُدَحْرَجِينَ | تُدَحْرَجَانِ | تُدَحْرَجُونَ | تُدَحْرَجْنَ | يُدَحْرَجُ | تُدَحْرَجُ | يُدَحْرَجَانِ | تُدَحْرَجَانِ | يُدَحْرَجُونَ | يُدَحْرَجْنَ |
      | بءدل |  |  |  |  |  |  |  | يُبَأْدَلُ | تُبَأْدَلُ |  |  |  |  |
      | بلور | أُبَلْوَرُ | نُبَلْوَرُ | تُبَلْوَرُ | تُبَلْوَرِينَ | تُبَلْوَرَانِ | تُبَلْوَرُونَ | تُبَلْوَرْنَ | يُبَلْوَرُ | تُبَلْوَرُ | يُبَلْوَرَانِ | تُبَلْوَرَانِ | يُبَلْوَرُونَ | يُبَلْوَرْنَ |
      | تلفن |  |  |  |  |  |  |  | يُتَلْفَنُ | تُتَلْفَنُ |  |  |  |  |
      | تنتن |  |  |  |  |  |  |  | يُتَنْتَنُ | تُتَنْتَنُ |  |  |  |  |
      | جءجء | أُجَأْجَأُ | نُجَأْجَأُ | تُجَأْجَأُ | تُجَأْجَئِينَ | تُجَأْجَأَانِ | تُجَأْجَؤُونَ | تُجَأْجَأْنَ | يُجَأْجَأُ | تُجَأْجَأُ | يُجَأْجَأَانِ | تُجَأْجَأَانِ | يُجَأْجَؤُونَ | يُجَأْجَأْنَ |
      | حوقل | أُحَوْقَلُ | نُحَوْقَلُ | تُحَوْقَلُ | تُحَوْقَلِينَ | تُحَوْقَلانِ | تُحَوْقَلُونَ | تُحَوْقَلْنَ | يُحَوْقَلُ | تُحَوْقَلُ | يُحَوْقَلانِ | تُحَوْقَلانِ | يُحَوْقَلُونَ | يُحَوْقَلْنَ |
      | حيحي |  |  |  |  |  |  |  | يُحَيْحَى | تُحَيْحَى |  |  |  |  |
      | رهيء | أُرَهْيَأُ | نُرَهْيَأُ | تُرَهْيَأُ | تُرَهْيَئِينَ | تُرَهْيَأَانِ | تُرَهْيَؤُونَ | تُرَهْيَأْنَ | يُرَهْيَأُ | تُرَهْيَأُ | يُرَهْيَأَانِ | تُرَهْيَأَانِ | يُرَهْيَؤُونَ | يُرَهْيَأْنَ |
      | زلزل | أُزَلْزَلُ | نُزَلْزَلُ | تُزَلْزَلُ | تُزَلْزَلِينَ | تُزَلْزَلانِ | تُزَلْزَلُونَ | تُزَلْزَلْنَ | يُزَلْزَلُ | تُزَلْزَلُ | يُزَلْزَلانِ | تُزَلْزَلانِ | يُزَلْزَلُونَ | يُزَلْزَلْنَ |
      | سبرت |  |  |  |  |  |  |  | يُسَبْرَتُ | تُسَبْرَتُ |  |  |  |  |
      | سيطر |  |  |  |  |  |  |  | يُسَيْطَرُ | تُسَيْطَرُ |  |  |  |  |
      | شريف | أُشَرْيَفُ | نُشَرْيَفُ | تُشَرْيَفُ | تُشَرْيَفِينَ | تُشَرْيَفَانِ | تُشَرْيَفُونَ | تُشَرْيَفْنَ | يُشَرْيَفُ | تُشَرْيَفُ | يُشَرْيَفَانِ | تُشَرْيَفَانِ | يُشَرْيَفُونَ | يُشَرْيَفْنَ |
      | ضوضي |  |  |  |  |  |  |  | يُضَوْضَى | تُضَوْضَى |  |  |  |  |
      | طمءن | أُطَمْأَنُ | نُطَمْأَنُ | تُطَمْأَنُ | تُطَمْأَنِينَ | تُطَمْأَنَانِ | تُطَمْأَنُونَ | تُطَمْأَنَّ | يُطَمْأَنُ | تُطَمْأَنُ | يُطَمْأَنَانِ | تُطَمْأَنَانِ | يُطَمْأَنُونَ | يُطَمْأَنَّ |
      | غرقء | أُغَرْقَأُ | نُغَرْقَأُ | تُغَرْقَأُ | تُغَرْقَئِينَ | تُغَرْقَأَانِ | تُغَرْقَؤُونَ | تُغَرْقَأْنَ | يُغَرْقَأُ | تُغَرْقَأُ | يُغَرْقَأَانِ | تُغَرْقَأَانِ | يُغَرْقَؤُونَ | يُغَرْقَأْنَ |
      | قلسي | أُقَلْسَى | نُقَلْسَى | تُقَلْسَى | تُقَلْسَيْنَ | تُقَلْسَيَانِ | تُقَلْسَوْنَ | تُقَلْسَيْنَ | يُقَلْسَى | تُقَلْسَى | يُقَلْسَيَانِ | تُقَلْسَيَانِ | يُقَلْسَوْنَ | يُقَلْسَيْنَ |
      | وءوء |  |  |  |  |  |  |  | يُوَأْوَأُ | تُوَأْوَأُ |  |  |  |  |
      | وسوس | أُوَسْوَسُ | نُوَسْوَسُ | تُوَسْوَسُ | تُوَسْوَسِينَ | تُوَسْوَسَانِ | تُوَسْوَسُونَ | تُوَسْوَسْنَ | يُوَسْوَسُ | تُوَسْوَسُ | يُوَسْوَسَانِ | تُوَسْوَسَانِ | يُوَسْوَسُونَ | يُوَسْوَسْنَ |
      | يءيء |  |  |  |  |  |  |  | يُيَأْيَأُ | تُيَأْيَأُ |  |  |  |  |
      | يرنء | أُيَرْنَأُ | نُيَرْنَأُ | تُيَرْنَأُ | تُيَرْنَئِينَ | تُيَرْنَأَانِ | تُيَرْنَؤُونَ | تُيَرْنَأْنَ | يُيَرْنَأُ | تُيَرْنَأُ | يُيَرْنَأَانِ | تُيَرْنَأَانِ | يُيَرْنَؤُونَ | يُيَرْنَأْنَ |
      | يهيه |  |  |  |  |  |  |  | يُيَهْيَهُ | تُيَهْيَهُ |  |  |  |  |
