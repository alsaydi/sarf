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

Feature: unaugmented quadrilateral verb conjugation in jussive state
# المضارع الرباعي المجرد المجزوم المبني للمعلوم
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in jussive state
    Given an unaugmented verb
    When the quadrilateral verb is conjugated in "Jussive" state
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
      | دحرج | أُدَحْرِجْ   | نُدَحْرِجْ   | تُدَحْرِجْ      | تُدَحْرِجِي     | تُدَحْرِجَا   | تُدَحْرِجُوا    | تُدَحْرِجْنَ    | يُدَحْرِجْ     | تُدَحْرِجْ     | يُدَحْرِجَا  | تُدَحْرِجَا  | يُدَحْرِجُوا   | يُدَحْرِجْنَ   |
      | بءدل | أُبَأْدِلْ   | نُبَأْدِلْ   | تُبَأْدِلْ      | تُبَأْدِلِي     | تُبَأْدِلا    | تُبَأْدِلُوا    | تُبَأْدِلْنَ    | يُبَأْدِلْ     | تُبَأْدِلْ     | يُبَأْدِلا   | تُبَأْدِلا   | يُبَأْدِلُوا   | يُبَأْدِلْنَ   |
      | بلور | أُبَلْوِرْ   | نُبَلْوِرْ   | تُبَلْوِرْ      | تُبَلْوِرِي     | تُبَلْوِرَا   | تُبَلْوِرُوا    | تُبَلْوِرْنَ    | يُبَلْوِرْ     | تُبَلْوِرْ     | يُبَلْوِرَا  | تُبَلْوِرَا  | يُبَلْوِرُوا   | يُبَلْوِرْنَ   |
      | تلفن | أُتَلْفِنْ   | نُتَلْفِنْ   | تُتَلْفِنْ      | تُتَلْفِنِي     | تُتَلْفِنَا   | تُتَلْفِنُوا    | تُتَلْفِنَّ     | يُتَلْفِنْ     | تُتَلْفِنْ     | يُتَلْفِنَا  | تُتَلْفِنَا  | يُتَلْفِنُوا   | يُتَلْفِنَّ    |
      | تنتن | أُتَنْتِنْ   | نُتَنْتِنْ   | تُتَنْتِنْ      | تُتَنْتِنِي     | تُتَنْتِنَا   | تُتَنْتِنُوا    | تُتَنْتِنَّ     | يُتَنْتِنْ     | تُتَنْتِنْ     | يُتَنْتِنَا  | تُتَنْتِنَا  | يُتَنْتِنُوا   | يُتَنْتِنَّ    |
      | جءجء | أُجَأْجِئْ   | نُجَأْجِئْ   | تُجَأْجِئْ      | تُجَأْجِئِي     | تُجَأْجِئَا   | تُجَأْجِئُوا    | تُجَأْجِئْنَ    | يُجَأْجِئْ     | تُجَأْجِئْ     | يُجَأْجِئَا  | تُجَأْجِئَا  | يُجَأْجِئُوا   | يُجَأْجِئْنَ   |
      | حوقل | أُحَوْقِلْ   | نُحَوْقِلْ   | تُحَوْقِلْ      | تُحَوْقِلِي     | تُحَوْقِلا    | تُحَوْقِلُوا    | تُحَوْقِلْنَ    | يُحَوْقِلْ     | تُحَوْقِلْ     | يُحَوْقِلا   | تُحَوْقِلا   | يُحَوْقِلُوا   | يُحَوْقِلْنَ   |
      | حيحي | أُحَيْحِ     | نُحَيْحِ     | تُحَيْحِ        | تُحَيْحِي       | تُحَيْحِيَا   | تُحَيْحُوا      | تُحَيْحِينَ     | يُحَيْحِ       | تُحَيْحِ       | يُحَيْحِيَا  | تُحَيْحِيَا  | يُحَيْحُوا     | يُحَيْحِينَ    |
      | رهيء | أُرَهْيِئْ   | نُرَهْيِئْ   | تُرَهْيِئْ      | تُرَهْيِئِي     | تُرَهْيِئَا   | تُرَهْيِئُوا    | تُرَهْيِئْنَ    | يُرَهْيِئْ     | تُرَهْيِئْ     | يُرَهْيِئَا  | تُرَهْيِئَا  | يُرَهْيِئُوا   | يُرَهْيِئْنَ   |
      | زلزل | أُزَلْزِلْ   | نُزَلْزِلْ   | تُزَلْزِلْ      | تُزَلْزِلِي     | تُزَلْزِلا    | تُزَلْزِلُوا    | تُزَلْزِلْنَ    | يُزَلْزِلْ     | تُزَلْزِلْ     | يُزَلْزِلا   | تُزَلْزِلا   | يُزَلْزِلُوا   | يُزَلْزِلْنَ   |
      | سبرت | أُسَبْرِتْ   | نُسَبْرِتْ   | تُسَبْرِتْ      | تُسَبْرِتِي     | تُسَبْرِتَا   | تُسَبْرِتُوا    | تُسَبْرِتْنَ    | يُسَبْرِتْ     | تُسَبْرِتْ     | يُسَبْرِتَا  | تُسَبْرِتَا  | يُسَبْرِتُوا   | يُسَبْرِتْنَ   |
      | سيطر | أُسَيْطِرْ   | نُسَيْطِرْ   | تُسَيْطِرْ      | تُسَيْطِرِي     | تُسَيْطِرَا   | تُسَيْطِرُوا    | تُسَيْطِرْنَ    | يُسَيْطِرْ     | تُسَيْطِرْ     | يُسَيْطِرَا  | تُسَيْطِرَا  | يُسَيْطِرُوا   | يُسَيْطِرْنَ   |
      | شريف | أُشَرْيِفْ   | نُشَرْيِفْ   | تُشَرْيِفْ      | تُشَرْيِفِي     | تُشَرْيِفَا   | تُشَرْيِفُوا    | تُشَرْيِفْنَ    | يُشَرْيِفْ     | تُشَرْيِفْ     | يُشَرْيِفَا  | تُشَرْيِفَا  | يُشَرْيِفُوا   | يُشَرْيِفْنَ   |
      | ضوضي | أُضَوْضِ     | نُضَوْضِ     | تُضَوْضِ        | تُضَوْضِي       | تُضَوْضِيَا   | تُضَوْضُوا      | تُضَوْضِينَ     | يُضَوْضِ       | تُضَوْضِ       | يُضَوْضِيَا  | تُضَوْضِيَا  | يُضَوْضُوا     | يُضَوْضِينَ    |
      | طمءن | أُطَمْئِنْ   | نُطَمْئِنْ   | تُطَمْئِنْ      | تُطَمْئِنِي     | تُطَمْئِنَا   | تُطَمْئِنُوا    | تُطَمْئِنَّ     | يُطَمْئِنْ     | تُطَمْئِنْ     | يُطَمْئِنَا  | تُطَمْئِنَا  | يُطَمْئِنُوا   | يُطَمْئِنَّ    |
      | غرقء | أُغَرْقِئْ   | نُغَرْقِئْ   | تُغَرْقِئْ      | تُغَرْقِئِي     | تُغَرْقِئَا   | تُغَرْقِئُوا    | تُغَرْقِئْنَ    | يُغَرْقِئْ     | تُغَرْقِئْ     | يُغَرْقِئَا  | تُغَرْقِئَا  | يُغَرْقِئُوا   | يُغَرْقِئْنَ   |
      | قلسي | أُقَلْسِ     | نُقَلْسِ     | تُقَلْسِ        | تُقَلْسِي       | تُقَلْسِيَا   | تُقَلْسُوا      | تُقَلْسِينَ     | يُقَلْسِ       | تُقَلْسِ       | يُقَلْسِيَا  | تُقَلْسِيَا  | يُقَلْسُوا     | يُقَلْسِينَ    |
      | وءوء | أُوَأْوِئْ   | نُوَأْوِئْ   | تُوَأْوِئْ      | تُوَأْوِئِي     | تُوَأْوِئَا   | تُوَأْوِئُوا    | تُوَأْوِئْنَ    | يُوَأْوِئْ     | تُوَأْوِئْ     | يُوَأْوِئَا  | تُوَأْوِئَا  | يُوَأْوِئُوا   | يُوَأْوِئْنَ   |
      | وسوس | أُوَسْوِسْ   | نُوَسْوِسْ   | تُوَسْوِسْ      | تُوَسْوِسِي     | تُوَسْوِسَا   | تُوَسْوِسُوا    | تُوَسْوِسْنَ    | يُوَسْوِسْ     | تُوَسْوِسْ     | يُوَسْوِسَا  | تُوَسْوِسَا  | يُوَسْوِسُوا   | يُوَسْوِسْنَ   |
      | يءيء | أُيَأْيِئْ   | نُيَأْيِئْ   | تُيَأْيِئْ      | تُيَأْيِئِي     | تُيَأْيِئَا   | تُيَأْيِئُوا    | تُيَأْيِئْنَ    | يُيَأْيِئْ     | تُيَأْيِئْ     | يُيَأْيِئَا  | تُيَأْيِئَا  | يُيَأْيِئُوا   | يُيَأْيِئْنَ   |
      | يرنء | أُيَرْنِئْ   | نُيَرْنِئْ   | تُيَرْنِئْ      | تُيَرْنِئِي     | تُيَرْنِئَا   | تُيَرْنِئُوا    | تُيَرْنِئْنَ    | يُيَرْنِئْ     | تُيَرْنِئْ     | يُيَرْنِئَا  | تُيَرْنِئَا  | يُيَرْنِئُوا   | يُيَرْنِئْنَ   |
      | يهيه | أُيَهْيِهْ   | نُيَهْيِهْ   | تُيَهْيِهْ      | تُيَهْيِهِي     | تُيَهْيِهَا   | تُيَهْيِهُوا    | تُيَهْيِهْنَ    | يُيَهْيِهْ     | تُيَهْيِهْ     | يُيَهْيِهَا  | تُيَهْيِهَا  | يُيَهْيِهُوا   | يُيَهْيِهْنَ   |
