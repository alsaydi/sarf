Feature: unaugmented quadrilateral verb conjugation in passive emphasized state
# المضارع الرباعي المنصوب المبني للمجهول
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in passive emphasized state
    Given an unaugmented verb
    When the quadrilateral verb is passively conjugated in "PassiveEmphasized" state
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
      | دحرج | أُدَحْرَجَنَّ | نُدَحْرَجَنَّ | تُدَحْرَجَنَّ | تُدَحْرَجِنَّ | تُدَحْرَجَانِّ | تُدَحْرَجُنَّ | تُدَحْرَجْنَانِّ | يُدَحْرَجَنَّ | تُدَحْرَجَنَّ | يُدَحْرَجَانِّ | تُدَحْرَجَانِّ | يُدَحْرَجُنَّ | يُدَحْرَجْنَانِّ |
      | بءدل |  |  |  |  |  |  |  | يُبَأْدَلَنَّ | تُبَأْدَلَنَّ |  |  |  |  |
      | بلور | أُبَلْوَرَنَّ | نُبَلْوَرَنَّ | تُبَلْوَرَنَّ | تُبَلْوَرِنَّ | تُبَلْوَرَانِّ | تُبَلْوَرُنَّ | تُبَلْوَرْنَانِّ | يُبَلْوَرَنَّ | تُبَلْوَرَنَّ | يُبَلْوَرَانِّ | تُبَلْوَرَانِّ | يُبَلْوَرُنَّ | يُبَلْوَرْنَانِّ |
      | تلفن |  |  |  |  |  |  |  | يُتَلْفَنَنَّ | تُتَلْفَنَنَّ |  |  |  |  |
      | تنتن |  |  |  |  |  |  |  | يُتَنْتَنَنَّ | تُتَنْتَنَنَّ |  |  |  |  |
      | جءجء | أُجَأْجَأَنَّ | نُجَأْجَأَنَّ | تُجَأْجَأَنَّ | تُجَأْجَئِنَّ | تُجَأْجَأَانِّ | تُجَأْجَؤُنَّ | تُجَأْجَأْنَانِّ | يُجَأْجَأَنَّ | تُجَأْجَأَنَّ | يُجَأْجَأَانِّ | تُجَأْجَأَانِّ | يُجَأْجَؤُنَّ | يُجَأْجَأْنَانِّ |
      | حوقل | أُحَوْقَلَنَّ | نُحَوْقَلَنَّ | تُحَوْقَلَنَّ | تُحَوْقَلِنَّ | تُحَوْقَلانِّ | تُحَوْقَلُنَّ | تُحَوْقَلْنَانِّ | يُحَوْقَلَنَّ | تُحَوْقَلَنَّ | يُحَوْقَلانِّ | تُحَوْقَلانِّ | يُحَوْقَلُنَّ | يُحَوْقَلْنَانِّ |
      | حيحي |  |  |  |  |  |  |  | يُحَيْحَيَنَّ | تُحَيْحَيَنَّ |  |  |  |  |
      | رهيء | أُرَهْيَأَنَّ | نُرَهْيَأَنَّ | تُرَهْيَأَنَّ | تُرَهْيَئِنَّ | تُرَهْيَأَانِّ | تُرَهْيَؤُنَّ | تُرَهْيَأْنَانِّ | يُرَهْيَأَنَّ | تُرَهْيَأَنَّ | يُرَهْيَأَانِّ | تُرَهْيَأَانِّ | يُرَهْيَؤُنَّ | يُرَهْيَأْنَانِّ |
      | زلزل | أُزَلْزَلَنَّ | نُزَلْزَلَنَّ | تُزَلْزَلَنَّ | تُزَلْزَلِنَّ | تُزَلْزَلانِّ | تُزَلْزَلُنَّ | تُزَلْزَلْنَانِّ | يُزَلْزَلَنَّ | تُزَلْزَلَنَّ | يُزَلْزَلانِّ | تُزَلْزَلانِّ | يُزَلْزَلُنَّ | يُزَلْزَلْنَانِّ |
      | سبرت |  |  |  |  |  |  |  | يُسَبْرَتَنَّ | تُسَبْرَتَنَّ |  |  |  |  |
      | سيطر |  |  |  |  |  |  |  | يُسَيْطَرَنَّ | تُسَيْطَرَنَّ |  |  |  |  |
      | شريف | أُشَرْيَفَنَّ | نُشَرْيَفَنَّ | تُشَرْيَفَنَّ | تُشَرْيَفِنَّ | تُشَرْيَفَانِّ | تُشَرْيَفُنَّ | تُشَرْيَفْنَانِّ | يُشَرْيَفَنَّ | تُشَرْيَفَنَّ | يُشَرْيَفَانِّ | تُشَرْيَفَانِّ | يُشَرْيَفُنَّ | يُشَرْيَفْنَانِّ |
      | ضوضي |  |  |  |  |  |  |  | يُضَوْضَيَنَّ | تُضَوْضَيَنَّ |  |  |  |  |
      | طمءن | أُطَمْأَنَنَّ | نُطَمْأَنَنَّ | تُطَمْأَنَنَّ | تُطَمْأَنِنَّ | تُطَمْأَنَانِّ | تُطَمْأَنُنَّ | تُطَمْأَنَّانِّ | يُطَمْأَنَنَّ | تُطَمْأَنَنَّ | يُطَمْأَنَانِّ | تُطَمْأَنَانِّ | يُطَمْأَنُنَّ | يُطَمْأَنَّانِّ |
      | غرقء | أُغَرْقَأَنَّ | نُغَرْقَأَنَّ | تُغَرْقَأَنَّ | تُغَرْقَئِنَّ | تُغَرْقَأَانِّ | تُغَرْقَؤُنَّ | تُغَرْقَأْنَانِّ | يُغَرْقَأَنَّ | تُغَرْقَأَنَّ | يُغَرْقَأَانِّ | تُغَرْقَأَانِّ | يُغَرْقَؤُنَّ | يُغَرْقَأْنَانِّ |
      | قلسي | أُقَلْسَيَنَّ | نُقَلْسَيَنَّ | تُقَلْسَيَنَّ | تُقَلْسَيِنَّ | تُقَلْسَيَانِّ | تُقَلْسَوُنَّ | تُقَلْسَيْنَانِّ | يُقَلْسَيَنَّ | تُقَلْسَيَنَّ | يُقَلْسَيَانِّ | تُقَلْسَيَانِّ | يُقَلْسَوُنَّ | يُقَلْسَيْنَانِّ |
      | وءوء |  |  |  |  |  |  |  | يُوَأْوَأَنَّ | تُوَأْوَأَنَّ |  |  |  |  |
      | وسوس | أُوَسْوَسَنَّ | نُوَسْوَسَنَّ | تُوَسْوَسَنَّ | تُوَسْوَسِنَّ | تُوَسْوَسَانِّ | تُوَسْوَسُنَّ | تُوَسْوَسْنَانِّ | يُوَسْوَسَنَّ | تُوَسْوَسَنَّ | يُوَسْوَسَانِّ | تُوَسْوَسَانِّ | يُوَسْوَسُنَّ | يُوَسْوَسْنَانِّ |
      | يءيء |  |  |  |  |  |  |  | يُيَأْيَأَنَّ | تُيَأْيَأَنَّ |  |  |  |  |
      | يرنء | أُيَرْنَأَنَّ | نُيَرْنَأَنَّ | تُيَرْنَأَنَّ | تُيَرْنَئِنَّ | تُيَرْنَأَانِّ | تُيَرْنَؤُنَّ | تُيَرْنَأْنَانِّ | يُيَرْنَأَنَّ | تُيَرْنَأَنَّ | يُيَرْنَأَانِّ | تُيَرْنَأَانِّ | يُيَرْنَؤُنَّ | يُيَرْنَأْنَانِّ |
      | يهيه |  |  |  |  |  |  |  | يُيَهْيَهَنَّ | تُيَهْيَهَنَّ |  |  |  |  |
