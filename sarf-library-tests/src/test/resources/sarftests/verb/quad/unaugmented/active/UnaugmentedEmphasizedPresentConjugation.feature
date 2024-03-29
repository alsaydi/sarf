###
# /*
# *
# * MIT License
# *
# * Copyright (c) 2021 Abdalaziz Alsaydi
# *
# * Permission is hereby granted, free of charge, to any person obtaining a copy
# * of this software and associated documentation files (the "Software"), to deal
# * in the Software without restriction, including without limitation the rights
# * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# * copies of the Software, and to permit persons to whom the Software is
# * furnished to do so, subject to the following conditions:
# *
# * The above copyright notice and this permission notice shall be included in all
# * copies or substantial portions of the Software.
# *
# * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# * SOFTWARE.
# */

Feature: unaugmented quadrilateral verb conjugation in emphasized state
# المضارع الرباعي المؤكد المبني للمعلوم
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in emphasized state
    Given an unaugmented verb
    When the quadrilateral verb is conjugated in "Emphasized" state
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
      | verb | single_first  | plural_first  | m_single_second | f_single_second | m_dual_second  | m_plural_second | f_plural_second  | m_single_third | f_single_third | m_dual_third   | f_dual_third   | m_plural_third | f_plural_third   |
      | دحرج | أُدَحْرِجَنَّ | نُدَحْرِجَنَّ | تُدَحْرِجَنَّ   | تُدَحْرِجِنَّ   | تُدَحْرِجَانِّ | تُدَحْرِجُنَّ   | تُدَحْرِجْنَانِّ | يُدَحْرِجَنَّ  | تُدَحْرِجَنَّ  | يُدَحْرِجَانِّ | تُدَحْرِجَانِّ | يُدَحْرِجُنَّ  | يُدَحْرِجْنَانِّ |
      | بءدل | أُبَأْدِلَنَّ | نُبَأْدِلَنَّ | تُبَأْدِلَنَّ   | تُبَأْدِلِنَّ   | تُبَأْدِلانِّ  | تُبَأْدِلُنَّ   | تُبَأْدِلْنَانِّ | يُبَأْدِلَنَّ  | تُبَأْدِلَنَّ  | يُبَأْدِلانِّ  | تُبَأْدِلانِّ  | يُبَأْدِلُنَّ  | يُبَأْدِلْنَانِّ |
      | بلور | أُبَلْوِرَنَّ | نُبَلْوِرَنَّ | تُبَلْوِرَنَّ   | تُبَلْوِرِنَّ   | تُبَلْوِرَانِّ | تُبَلْوِرُنَّ   | تُبَلْوِرْنَانِّ | يُبَلْوِرَنَّ  | تُبَلْوِرَنَّ  | يُبَلْوِرَانِّ | تُبَلْوِرَانِّ | يُبَلْوِرُنَّ  | يُبَلْوِرْنَانِّ |
      | تلفن | أُتَلْفِنَنَّ | نُتَلْفِنَنَّ | تُتَلْفِنَنَّ   | تُتَلْفِنِنَّ   | تُتَلْفِنَانِّ | تُتَلْفِنُنَّ   | تُتَلْفِنَّانِّ  | يُتَلْفِنَنَّ  | تُتَلْفِنَنَّ  | يُتَلْفِنَانِّ | تُتَلْفِنَانِّ | يُتَلْفِنُنَّ  | يُتَلْفِنَّانِّ  |
      | تنتن | أُتَنْتِنَنَّ | نُتَنْتِنَنَّ | تُتَنْتِنَنَّ   | تُتَنْتِنِنَّ   | تُتَنْتِنَانِّ | تُتَنْتِنُنَّ   | تُتَنْتِنَّانِّ  | يُتَنْتِنَنَّ  | تُتَنْتِنَنَّ  | يُتَنْتِنَانِّ | تُتَنْتِنَانِّ | يُتَنْتِنُنَّ  | يُتَنْتِنَّانِّ  |
      | جءجء | أُجَأْجِئَنَّ | نُجَأْجِئَنَّ | تُجَأْجِئَنَّ   | تُجَأْجِئِنَّ   | تُجَأْجِئَانِّ | تُجَأْجِئُنَّ   | تُجَأْجِئْنَانِّ | يُجَأْجِئَنَّ  | تُجَأْجِئَنَّ  | يُجَأْجِئَانِّ | تُجَأْجِئَانِّ | يُجَأْجِئُنَّ  | يُجَأْجِئْنَانِّ |
      | حوقل | أُحَوْقِلَنَّ | نُحَوْقِلَنَّ | تُحَوْقِلَنَّ   | تُحَوْقِلِنَّ   | تُحَوْقِلانِّ  | تُحَوْقِلُنَّ   | تُحَوْقِلْنَانِّ | يُحَوْقِلَنَّ  | تُحَوْقِلَنَّ  | يُحَوْقِلانِّ  | تُحَوْقِلانِّ  | يُحَوْقِلُنَّ  | يُحَوْقِلْنَانِّ |
      | حيحي | أُحَيْحِيَنَّ | نُحَيْحِيَنَّ | تُحَيْحِيَنَّ   | تُحَيْحِنَّ     | تُحَيْحِيَانِّ | تُحَيْحُنَّ     | تُحَيْحِينَانِّ  | يُحَيْحِيَنَّ  | تُحَيْحِيَنَّ  | يُحَيْحِيَانِّ | تُحَيْحِيَانِّ | يُحَيْحُنَّ    | يُحَيْحِينَانِّ  |
      | رهيء | أُرَهْيِئَنَّ | نُرَهْيِئَنَّ | تُرَهْيِئَنَّ   | تُرَهْيِئِنَّ   | تُرَهْيِئَانِّ | تُرَهْيِئُنَّ   | تُرَهْيِئْنَانِّ | يُرَهْيِئَنَّ  | تُرَهْيِئَنَّ  | يُرَهْيِئَانِّ | تُرَهْيِئَانِّ | يُرَهْيِئُنَّ  | يُرَهْيِئْنَانِّ |
      | زلزل | أُزَلْزِلَنَّ | نُزَلْزِلَنَّ | تُزَلْزِلَنَّ   | تُزَلْزِلِنَّ   | تُزَلْزِلانِّ  | تُزَلْزِلُنَّ   | تُزَلْزِلْنَانِّ | يُزَلْزِلَنَّ  | تُزَلْزِلَنَّ  | يُزَلْزِلانِّ  | تُزَلْزِلانِّ  | يُزَلْزِلُنَّ  | يُزَلْزِلْنَانِّ |
      | سبرت | أُسَبْرِتَنَّ | نُسَبْرِتَنَّ | تُسَبْرِتَنَّ   | تُسَبْرِتِنَّ   | تُسَبْرِتَانِّ | تُسَبْرِتُنَّ   | تُسَبْرِتْنَانِّ | يُسَبْرِتَنَّ  | تُسَبْرِتَنَّ  | يُسَبْرِتَانِّ | تُسَبْرِتَانِّ | يُسَبْرِتُنَّ  | يُسَبْرِتْنَانِّ |
      | سيطر | أُسَيْطِرَنَّ | نُسَيْطِرَنَّ | تُسَيْطِرَنَّ   | تُسَيْطِرِنَّ   | تُسَيْطِرَانِّ | تُسَيْطِرُنَّ   | تُسَيْطِرْنَانِّ | يُسَيْطِرَنَّ  | تُسَيْطِرَنَّ  | يُسَيْطِرَانِّ | تُسَيْطِرَانِّ | يُسَيْطِرُنَّ  | يُسَيْطِرْنَانِّ |
      | شريف | أُشَرْيِفَنَّ | نُشَرْيِفَنَّ | تُشَرْيِفَنَّ   | تُشَرْيِفِنَّ   | تُشَرْيِفَانِّ | تُشَرْيِفُنَّ   | تُشَرْيِفْنَانِّ | يُشَرْيِفَنَّ  | تُشَرْيِفَنَّ  | يُشَرْيِفَانِّ | تُشَرْيِفَانِّ | يُشَرْيِفُنَّ  | يُشَرْيِفْنَانِّ |
      | ضوضي | أُضَوْضِيَنَّ | نُضَوْضِيَنَّ | تُضَوْضِيَنَّ   | تُضَوْضِنَّ     | تُضَوْضِيَانِّ | تُضَوْضُنَّ     | تُضَوْضِينَانِّ  | يُضَوْضِيَنَّ  | تُضَوْضِيَنَّ  | يُضَوْضِيَانِّ | تُضَوْضِيَانِّ | يُضَوْضُنَّ    | يُضَوْضِينَانِّ  |
      | طمءن | أُطَمْئِنَنَّ | نُطَمْئِنَنَّ | تُطَمْئِنَنَّ   | تُطَمْئِنِنَّ   | تُطَمْئِنَانِّ | تُطَمْئِنُنَّ   | تُطَمْئِنَّانِّ  | يُطَمْئِنَنَّ  | تُطَمْئِنَنَّ  | يُطَمْئِنَانِّ | تُطَمْئِنَانِّ | يُطَمْئِنُنَّ  | يُطَمْئِنَّانِّ  |
      | غرقء | أُغَرْقِئَنَّ | نُغَرْقِئَنَّ | تُغَرْقِئَنَّ   | تُغَرْقِئِنَّ   | تُغَرْقِئَانِّ | تُغَرْقِئُنَّ   | تُغَرْقِئْنَانِّ | يُغَرْقِئَنَّ  | تُغَرْقِئَنَّ  | يُغَرْقِئَانِّ | تُغَرْقِئَانِّ | يُغَرْقِئُنَّ  | يُغَرْقِئْنَانِّ |
      | قلسي | أُقَلْسِيَنَّ | نُقَلْسِيَنَّ | تُقَلْسِيَنَّ   | تُقَلْسِنَّ     | تُقَلْسِيَانِّ | تُقَلْسُنَّ     | تُقَلْسِينَانِّ  | يُقَلْسِيَنَّ  | تُقَلْسِيَنَّ  | يُقَلْسِيَانِّ | تُقَلْسِيَانِّ | يُقَلْسُنَّ    | يُقَلْسِينَانِّ  |
      | وءوء | أُوَأْوِئَنَّ | نُوَأْوِئَنَّ | تُوَأْوِئَنَّ   | تُوَأْوِئِنَّ   | تُوَأْوِئَانِّ | تُوَأْوِئُنَّ   | تُوَأْوِئْنَانِّ | يُوَأْوِئَنَّ  | تُوَأْوِئَنَّ  | يُوَأْوِئَانِّ | تُوَأْوِئَانِّ | يُوَأْوِئُنَّ  | يُوَأْوِئْنَانِّ |
      | وسوس | أُوَسْوِسَنَّ | نُوَسْوِسَنَّ | تُوَسْوِسَنَّ   | تُوَسْوِسِنَّ   | تُوَسْوِسَانِّ | تُوَسْوِسُنَّ   | تُوَسْوِسْنَانِّ | يُوَسْوِسَنَّ  | تُوَسْوِسَنَّ  | يُوَسْوِسَانِّ | تُوَسْوِسَانِّ | يُوَسْوِسُنَّ  | يُوَسْوِسْنَانِّ |
      | يءيء | أُيَأْيِئَنَّ | نُيَأْيِئَنَّ | تُيَأْيِئَنَّ   | تُيَأْيِئِنَّ   | تُيَأْيِئَانِّ | تُيَأْيِئُنَّ   | تُيَأْيِئْنَانِّ | يُيَأْيِئَنَّ  | تُيَأْيِئَنَّ  | يُيَأْيِئَانِّ | تُيَأْيِئَانِّ | يُيَأْيِئُنَّ  | يُيَأْيِئْنَانِّ |
      | يرنء | أُيَرْنِئَنَّ | نُيَرْنِئَنَّ | تُيَرْنِئَنَّ   | تُيَرْنِئِنَّ   | تُيَرْنِئَانِّ | تُيَرْنِئُنَّ   | تُيَرْنِئْنَانِّ | يُيَرْنِئَنَّ  | تُيَرْنِئَنَّ  | يُيَرْنِئَانِّ | تُيَرْنِئَانِّ | يُيَرْنِئُنَّ  | يُيَرْنِئْنَانِّ |
      | يهيه | أُيَهْيِهَنَّ | نُيَهْيِهَنَّ | تُيَهْيِهَنَّ   | تُيَهْيِهِنَّ   | تُيَهْيِهَانِّ | تُيَهْيِهُنَّ   | تُيَهْيِهْنَانِّ | يُيَهْيِهَنَّ  | تُيَهْيِهَنَّ  | يُيَهْيِهَانِّ | تُيَهْيِهَانِّ | يُيَهْيِهُنَّ  | يُيَهْيِهْنَانِّ |
