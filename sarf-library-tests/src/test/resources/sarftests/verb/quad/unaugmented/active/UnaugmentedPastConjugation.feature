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

Feature: unaugmented quadrilateral verb conjugation

  Scenario Outline: active unaugmented quadrilateral verb past conjugation
    Given an unaugmented verb
    When the verb is conjugated
    Then the first person singular conjugation of the verb "<verb>"is "<single_first>"
    And the first person plural conjugation of the verb "<verb>"is "<plural_first>"
    And the masculine singular second person conjugation of the verb "<verb>"is "<m_single_second>"
    And the feminine singular second person conjugation of the verb "<verb>"is "<f_single_second>"
    And the masculine dual second person conjugation of the verb "<verb>"is "<m_dual_second>"
    And the masculine plural second person conjugation of the verb "<verb>"is "<m_plural_second>"
    And the feminine plural second person conjugation of the verb "<verb>"is "<f_plural_second>"
    And the masculine singular third person conjugation of the verb "<verb>"is "<m_single_third>"
    And the feminine singular third person conjugation of the verb "<verb>"is "<f_single_third>"
    And the masculine dual third person conjugation of the verb "<verb>"is "<m_dual_third>"
    And the feminine dual third person conjugation of the verb "<verb>"is "<f_dual_third>"
    And the masculine plural third person conjugation of the verb "<verb>"is "<m_plural_third>"
    And the feminine plural third person conjugation of the verb "<verb>"is "<f_plural_third>"
    Examples:
      | verb | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | دَحْرَجْتُ   | دَحْرَجْنَا  | دَحْرَجْتَ      | دَحْرَجْتِ      | دَحْرَجْتُمَا | دَحْرَجْتُمْ    | دَحْرَجْتُنَّ   | دَحْرَجَ       | دَحْرَجَتْ     | دَحْرَجَا    | دَحْرَجَتَا  | دَحْرَجُوا     | دَحْرَجْنَ     |
      | بءدل | بَأْدَلْتُ   | بَأْدَلْنَا  | بَأْدَلْتَ      | بَأْدَلْتِ      | بَأْدَلْتُمَا | بَأْدَلْتُمْ    | بَأْدَلْتُنَّ   | بَأْدَلَ       | بَأْدَلَتْ     | بَأْدَلا     | بَأْدَلَتَا  | بَأْدَلُوا     | بَأْدَلْنَ     |
      | بلور | بَلْوَرْتُ   | بَلْوَرْنَا  | بَلْوَرْتَ      | بَلْوَرْتِ      | بَلْوَرْتُمَا | بَلْوَرْتُمْ    | بَلْوَرْتُنَّ   | بَلْوَرَ       | بَلْوَرَتْ     | بَلْوَرَا    | بَلْوَرَتَا  | بَلْوَرُوا     | بَلْوَرْنَ     |
      | تلفن | تَلْفَنْتُ   | تَلْفَنَّا   | تَلْفَنْتَ      | تَلْفَنْتِ      | تَلْفَنْتُمَا | تَلْفَنْتُمْ    | تَلْفَنْتُنَّ   | تَلْفَنَ       | تَلْفَنَتْ     | تَلْفَنَا    | تَلْفَنَتَا  | تَلْفَنُوا     | تَلْفَنَّ      |
      | تنتن | تَنْتَنْتُ   | تَنْتَنَّا   | تَنْتَنْتَ      | تَنْتَنْتِ      | تَنْتَنْتُمَا | تَنْتَنْتُمْ    | تَنْتَنْتُنَّ   | تَنْتَنَ       | تَنْتَنَتْ     | تَنْتَنَا    | تَنْتَنَتَا  | تَنْتَنُوا     | تَنْتَنَّ      |
      | جءجء | جَأْجَأْتُ   | جَأْجَأْنَا  | جَأْجَأْتَ      | جَأْجَأْتِ      | جَأْجَأْتُمَا | جَأْجَأْتُمْ    | جَأْجَأْتُنَّ   | جَأْجَأَ       | جَأْجَأَتْ     | جَأْجَأَا    | جَأْجَأَتَا  | جَأْجَؤُوا     | جَأْجَأْنَ     |
      | حوقل | حَوْقَلْتُ   | حَوْقَلْنَا  | حَوْقَلْتَ      | حَوْقَلْتِ      | حَوْقَلْتُمَا | حَوْقَلْتُمْ    | حَوْقَلْتُنَّ   | حَوْقَلَ       | حَوْقَلَتْ     | حَوْقَلا     | حَوْقَلَتَا  | حَوْقَلُوا     | حَوْقَلْنَ     |
      | حيحي | حَيْحَيْتُ   | حَيْحَيْنَا  | حَيْحَيْتَ      | حَيْحَيْتِ      | حَيْحَيْتُمَا | حَيْحَيْتُمْ    | حَيْحَيْتُنَّ   | حَيْحَى        | حَيْحَتْ       | حَيْحَيَا    | حَيْحَتَا    | حَيْحَوْا      | حَيْحَيْنَ     |
      | رهيء | رَهْيَأْتُ   | رَهْيَأْنَا  | رَهْيَأْتَ      | رَهْيَأْتِ      | رَهْيَأْتُمَا | رَهْيَأْتُمْ    | رَهْيَأْتُنَّ   | رَهْيَأَ       | رَهْيَأَتْ     | رَهْيَأَا    | رَهْيَأَتَا  | رَهْيَؤُوا     | رَهْيَأْنَ     |
      | زلزل | زَلْزَلْتُ   | زَلْزَلْنَا  | زَلْزَلْتَ      | زَلْزَلْتِ      | زَلْزَلْتُمَا | زَلْزَلْتُمْ    | زَلْزَلْتُنَّ   | زَلْزَلَ       | زَلْزَلَتْ     | زَلْزَلا     | زَلْزَلَتَا  | زَلْزَلُوا     | زَلْزَلْنَ     |
      | سبرت | سَبْرَتُّ    | سَبْرَتْنَا  | سَبْرَتَّ       | سَبْرَتِّ       | سَبْرَتُّمَا  | سَبْرَتُّمْ     | سَبْرَتُّنَّ    | سَبْرَتَ       | سَبْرَتَتْ     | سَبْرَتَا    | سَبْرَتَتَا  | سَبْرَتُوا     | سَبْرَتْنَ     |
      | سيطر | سَيْطَرْتُ   | سَيْطَرْنَا  | سَيْطَرْتَ      | سَيْطَرْتِ      | سَيْطَرْتُمَا | سَيْطَرْتُمْ    | سَيْطَرْتُنَّ   | سَيْطَرَ       | سَيْطَرَتْ     | سَيْطَرَا    | سَيْطَرَتَا  | سَيْطَرُوا     | سَيْطَرْنَ     |
      | شريف | شَرْيَفْتُ   | شَرْيَفْنَا  | شَرْيَفْتَ      | شَرْيَفْتِ      | شَرْيَفْتُمَا | شَرْيَفْتُمْ    | شَرْيَفْتُنَّ   | شَرْيَفَ       | شَرْيَفَتْ     | شَرْيَفَا    | شَرْيَفَتَا  | شَرْيَفُوا     | شَرْيَفْنَ     |
      | ضوضي | ضَوْضَيْتُ   | ضَوْضَيْنَا  | ضَوْضَيْتَ      | ضَوْضَيْتِ      | ضَوْضَيْتُمَا | ضَوْضَيْتُمْ    | ضَوْضَيْتُنَّ   | ضَوْضَى        | ضَوْضَتْ       | ضَوْضَيَا    | ضَوْضَتَا    | ضَوْضَوْا      | ضَوْضَيْنَ     |
      | طمءن | طَمْأَنْتُ   | طَمْأَنَّا   | طَمْأَنْتَ      | طَمْأَنْتِ      | طَمْأَنْتُمَا | طَمْأَنْتُمْ    | طَمْأَنْتُنَّ   | طَمْأَنَ       | طَمْأَنَتْ     | طَمْأَنَا    | طَمْأَنَتَا  | طَمْأَنُوا     | طَمْأَنَّ      |
      | غرقء | غَرْقَأْتُ   | غَرْقَأْنَا  | غَرْقَأْتَ      | غَرْقَأْتِ      | غَرْقَأْتُمَا | غَرْقَأْتُمْ    | غَرْقَأْتُنَّ   | غَرْقَأَ       | غَرْقَأَتْ     | غَرْقَأَا    | غَرْقَأَتَا  | غَرْقَؤُوا     | غَرْقَأْنَ     |
      | قلسي | قَلْسَيْتُ   | قَلْسَيْنَا  | قَلْسَيْتَ      | قَلْسَيْتِ      | قَلْسَيْتُمَا | قَلْسَيْتُمْ    | قَلْسَيْتُنَّ   | قَلْسَى        | قَلْسَتْ       | قَلْسَيَا    | قَلْسَتَا    | قَلْسَوْا      | قَلْسَيْنَ     |
      | وءوء | وَأْوَأْتُ   | وَأْوَأْنَا  | وَأْوَأْتَ      | وَأْوَأْتِ      | وَأْوَأْتُمَا | وَأْوَأْتُمْ    | وَأْوَأْتُنَّ   | وَأْوَأَ       | وَأْوَأَتْ     | وَأْوَأَا    | وَأْوَأَتَا  | وَأْوَؤُوا     | وَأْوَأْنَ     |
      | وسوس | وَسْوَسْتُ   | وَسْوَسْنَا  | وَسْوَسْتَ      | وَسْوَسْتِ      | وَسْوَسْتُمَا | وَسْوَسْتُمْ    | وَسْوَسْتُنَّ   | وَسْوَسَ       | وَسْوَسَتْ     | وَسْوَسَا    | وَسْوَسَتَا  | وَسْوَسُوا     | وَسْوَسْنَ     |
      | يءيء | يَأْيَأْتُ   | يَأْيَأْنَا  | يَأْيَأْتَ      | يَأْيَأْتِ      | يَأْيَأْتُمَا | يَأْيَأْتُمْ    | يَأْيَأْتُنَّ   | يَأْيَأَ       | يَأْيَأَتْ     | يَأْيَأَا    | يَأْيَأَتَا  | يَأْيَؤُوا     | يَأْيَأْنَ     |
      | يرنء | يَرْنَأْتُ   | يَرْنَأْنَا  | يَرْنَأْتَ      | يَرْنَأْتِ      | يَرْنَأْتُمَا | يَرْنَأْتُمْ    | يَرْنَأْتُنَّ   | يَرْنَأَ       | يَرْنَأَتْ     | يَرْنَأَا    | يَرْنَأَتَا  | يَرْنَؤُوا     | يَرْنَأْنَ     |
      | يهيه | يَهْيَهْتُ   | يَهْيَهْنَا  | يَهْيَهْتَ      | يَهْيَهْتِ      | يَهْيَهْتُمَا | يَهْيَهْتُمْ    | يَهْيَهْتُنَّ   | يَهْيَهَ       | يَهْيَهَتْ     | يَهْيَهَا    | يَهْيَهَتَا  | يَهْيَهُوا     | يَهْيَهْنَ     |
