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

Feature: unaugmented quadrilateral verb conjugation in nominative state
# المضارع الرباعي المرفوع المبني للمعلوم
  Scenario Outline: active unaugmented quadrilateral verb present conjugation in nominative state
    Given an unaugmented verb
    When the quadrilateral verb is conjugated in "Nominative" state
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
      | verb | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third  | f_dual_third  | m_plural_third | f_plural_third |
      | دحرج | أُدَحْرِجُ   | نُدَحْرِجُ   | تُدَحْرِجُ      | تُدَحْرِجِينَ   | تُدَحْرِجَانِ | تُدَحْرِجُونَ   | تُدَحْرِجْنَ    | يُدَحْرِجُ     | تُدَحْرِجُ     | يُدَحْرِجَانِ | تُدَحْرِجَانِ | يُدَحْرِجُونَ  | يُدَحْرِجْنَ   |
      | بءدل | أُبَأْدِلُ   | نُبَأْدِلُ   | تُبَأْدِلُ      | تُبَأْدِلِينَ   | تُبَأْدِلانِ  | تُبَأْدِلُونَ   | تُبَأْدِلْنَ    | يُبَأْدِلُ     | تُبَأْدِلُ     | يُبَأْدِلانِ  | تُبَأْدِلانِ  | يُبَأْدِلُونَ  | يُبَأْدِلْنَ   |
      | بلور | أُبَلْوِرُ   | نُبَلْوِرُ   | تُبَلْوِرُ      | تُبَلْوِرِينَ   | تُبَلْوِرَانِ | تُبَلْوِرُونَ   | تُبَلْوِرْنَ    | يُبَلْوِرُ     | تُبَلْوِرُ     | يُبَلْوِرَانِ | تُبَلْوِرَانِ | يُبَلْوِرُونَ  | يُبَلْوِرْنَ   |
      | تلفن | أُتَلْفِنُ   | نُتَلْفِنُ   | تُتَلْفِنُ      | تُتَلْفِنِينَ   | تُتَلْفِنَانِ | تُتَلْفِنُونَ   | تُتَلْفِنَّ     | يُتَلْفِنُ     | تُتَلْفِنُ     | يُتَلْفِنَانِ | تُتَلْفِنَانِ | يُتَلْفِنُونَ  | يُتَلْفِنَّ    |
      | تنتن | أُتَنْتِنُ   | نُتَنْتِنُ   | تُتَنْتِنُ      | تُتَنْتِنِينَ   | تُتَنْتِنَانِ | تُتَنْتِنُونَ   | تُتَنْتِنَّ     | يُتَنْتِنُ     | تُتَنْتِنُ     | يُتَنْتِنَانِ | تُتَنْتِنَانِ | يُتَنْتِنُونَ  | يُتَنْتِنَّ    |
      | جءجء | أُجَأْجِئُ   | نُجَأْجِئُ   | تُجَأْجِئُ      | تُجَأْجِئِينَ   | تُجَأْجِئَانِ | تُجَأْجِئُونَ   | تُجَأْجِئْنَ    | يُجَأْجِئُ     | تُجَأْجِئُ     | يُجَأْجِئَانِ | تُجَأْجِئَانِ | يُجَأْجِئُونَ  | يُجَأْجِئْنَ   |
      | حوقل | أُحَوْقِلُ   | نُحَوْقِلُ   | تُحَوْقِلُ      | تُحَوْقِلِينَ   | تُحَوْقِلانِ  | تُحَوْقِلُونَ   | تُحَوْقِلْنَ    | يُحَوْقِلُ     | تُحَوْقِلُ     | يُحَوْقِلانِ  | تُحَوْقِلانِ  | يُحَوْقِلُونَ  | يُحَوْقِلْنَ   |
      | حيحي | أُحَيْحِي    | نُحَيْحِي    | تُحَيْحِي       | تُحَيْحِينَ     | تُحَيْحِيَانِ | تُحَيْحُونَ     | تُحَيْحِينَ     | يُحَيْحِي      | تُحَيْحِي      | يُحَيْحِيَانِ | تُحَيْحِيَانِ | يُحَيْحُونَ    | يُحَيْحِينَ    |
      | رهيء | أُرَهْيِئُ   | نُرَهْيِئُ   | تُرَهْيِئُ      | تُرَهْيِئِينَ   | تُرَهْيِئَانِ | تُرَهْيِئُونَ   | تُرَهْيِئْنَ    | يُرَهْيِئُ     | تُرَهْيِئُ     | يُرَهْيِئَانِ | تُرَهْيِئَانِ | يُرَهْيِئُونَ  | يُرَهْيِئْنَ   |
      | زلزل | أُزَلْزِلُ   | نُزَلْزِلُ   | تُزَلْزِلُ      | تُزَلْزِلِينَ   | تُزَلْزِلانِ  | تُزَلْزِلُونَ   | تُزَلْزِلْنَ    | يُزَلْزِلُ     | تُزَلْزِلُ     | يُزَلْزِلانِ  | تُزَلْزِلانِ  | يُزَلْزِلُونَ  | يُزَلْزِلْنَ   |
      | سبرت | أُسَبْرِتُ   | نُسَبْرِتُ   | تُسَبْرِتُ      | تُسَبْرِتِينَ   | تُسَبْرِتَانِ | تُسَبْرِتُونَ   | تُسَبْرِتْنَ    | يُسَبْرِتُ     | تُسَبْرِتُ     | يُسَبْرِتَانِ | تُسَبْرِتَانِ | يُسَبْرِتُونَ  | يُسَبْرِتْنَ   |
      | سيطر | أُسَيْطِرُ   | نُسَيْطِرُ   | تُسَيْطِرُ      | تُسَيْطِرِينَ   | تُسَيْطِرَانِ | تُسَيْطِرُونَ   | تُسَيْطِرْنَ    | يُسَيْطِرُ     | تُسَيْطِرُ     | يُسَيْطِرَانِ | تُسَيْطِرَانِ | يُسَيْطِرُونَ  | يُسَيْطِرْنَ   |
      | شريف | أُشَرْيِفُ   | نُشَرْيِفُ   | تُشَرْيِفُ      | تُشَرْيِفِينَ   | تُشَرْيِفَانِ | تُشَرْيِفُونَ   | تُشَرْيِفْنَ    | يُشَرْيِفُ     | تُشَرْيِفُ     | يُشَرْيِفَانِ | تُشَرْيِفَانِ | يُشَرْيِفُونَ  | يُشَرْيِفْنَ   |
      | ضوضي | أُضَوْضِي    | نُضَوْضِي    | تُضَوْضِي       | تُضَوْضِينَ     | تُضَوْضِيَانِ | تُضَوْضُونَ     | تُضَوْضِينَ     | يُضَوْضِي      | تُضَوْضِي      | يُضَوْضِيَانِ | تُضَوْضِيَانِ | يُضَوْضُونَ    | يُضَوْضِينَ    |
      | طمءن | أُطَمْئِنُ   | نُطَمْئِنُ   | تُطَمْئِنُ      | تُطَمْئِنِينَ   | تُطَمْئِنَانِ | تُطَمْئِنُونَ   | تُطَمْئِنَّ     | يُطَمْئِنُ     | تُطَمْئِنُ     | يُطَمْئِنَانِ | تُطَمْئِنَانِ | يُطَمْئِنُونَ  | يُطَمْئِنَّ    |
      | غرقء | أُغَرْقِئُ   | نُغَرْقِئُ   | تُغَرْقِئُ      | تُغَرْقِئِينَ   | تُغَرْقِئَانِ | تُغَرْقِئُونَ   | تُغَرْقِئْنَ    | يُغَرْقِئُ     | تُغَرْقِئُ     | يُغَرْقِئَانِ | تُغَرْقِئَانِ | يُغَرْقِئُونَ  | يُغَرْقِئْنَ   |
      | قلسي | أُقَلْسِي    | نُقَلْسِي    | تُقَلْسِي       | تُقَلْسِينَ     | تُقَلْسِيَانِ | تُقَلْسُونَ     | تُقَلْسِينَ     | يُقَلْسِي      | تُقَلْسِي      | يُقَلْسِيَانِ | تُقَلْسِيَانِ | يُقَلْسُونَ    | يُقَلْسِينَ    |
      | وءوء | أُوَأْوِئُ   | نُوَأْوِئُ   | تُوَأْوِئُ      | تُوَأْوِئِينَ   | تُوَأْوِئَانِ | تُوَأْوِئُونَ   | تُوَأْوِئْنَ    | يُوَأْوِئُ     | تُوَأْوِئُ     | يُوَأْوِئَانِ | تُوَأْوِئَانِ | يُوَأْوِئُونَ  | يُوَأْوِئْنَ   |
      | وسوس | أُوَسْوِسُ   | نُوَسْوِسُ   | تُوَسْوِسُ      | تُوَسْوِسِينَ   | تُوَسْوِسَانِ | تُوَسْوِسُونَ   | تُوَسْوِسْنَ    | يُوَسْوِسُ     | تُوَسْوِسُ     | يُوَسْوِسَانِ | تُوَسْوِسَانِ | يُوَسْوِسُونَ  | يُوَسْوِسْنَ   |
      | يءيء | أُيَأْيِئُ   | نُيَأْيِئُ   | تُيَأْيِئُ      | تُيَأْيِئِينَ   | تُيَأْيِئَانِ | تُيَأْيِئُونَ   | تُيَأْيِئْنَ    | يُيَأْيِئُ     | تُيَأْيِئُ     | يُيَأْيِئَانِ | تُيَأْيِئَانِ | يُيَأْيِئُونَ  | يُيَأْيِئْنَ   |
      | يرنء | أُيَرْنِئُ   | نُيَرْنِئُ   | تُيَرْنِئُ      | تُيَرْنِئِينَ   | تُيَرْنِئَانِ | تُيَرْنِئُونَ   | تُيَرْنِئْنَ    | يُيَرْنِئُ     | تُيَرْنِئُ     | يُيَرْنِئَانِ | تُيَرْنِئَانِ | يُيَرْنِئُونَ  | يُيَرْنِئْنَ   |
      | يهيه | أُيَهْيِهُ   | نُيَهْيِهُ   | تُيَهْيِهُ      | تُيَهْيِهِينَ   | تُيَهْيِهَانِ | تُيَهْيِهُونَ   | تُيَهْيِهْنَ    | يُيَهْيِهُ     | تُيَهْيِهُ     | يُيَهْيِهَانِ | تُيَهْيِهَانِ | يُيَهْيِهُونَ  | يُيَهْيِهْنَ   |
