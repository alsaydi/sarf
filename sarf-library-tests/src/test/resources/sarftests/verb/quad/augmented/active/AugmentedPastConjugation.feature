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

Feature: augmented quadrilateral active past verb conjugation

  Scenario Outline: active augmented quadrilateral verb past conjugation
    Given an augmented verb
    When the verb is conjugated
    Then the first person singular conjugation of the quad verb "<verb>" and formula of "<formula>" is "<single_first>"
    And the first person plural conjugation of the quad verb "<verb>" and formula of "<formula>" is "<plural_first>"
    And the masculine singular second person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_single_second>"
    And the feminine singular second person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<f_single_second>"
    And the masculine dual second person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_single_third>"
    And the feminine singular third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<f_single_third>"
    And the masculine dual third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the quad verb "<verb>" and formula of "<formula>" is "<f_plural_third>"
    Examples:
      | verb | formula | single_first  | plural_first   | m_single_second | f_single_second | m_dual_second    | m_plural_second | f_plural_second  | m_single_third | f_single_third | m_dual_third | f_dual_third   | m_plural_third | f_plural_third |
      | دحرج | 1       | تَدَحْرَجْتُ  | تَدَحْرَجْنَا  | تَدَحْرَجْتَ    | تَدَحْرَجْتِ    | تَدَحْرَجْتُمَا  | تَدَحْرَجْتُمْ  | تَدَحْرَجْتُنَّ  | تَدَحْرَجَ     | تَدَحْرَجَتْ   | تَدَحْرَجَا  | تَدَحْرَجَتَا  | تَدَحْرَجُوا   | تَدَحْرَجْنَ   |
      | بلور | 1       | تَبَلْوَرْتُ  | تَبَلْوَرْنَا  | تَبَلْوَرْتَ    | تَبَلْوَرْتِ    | تَبَلْوَرْتُمَا  | تَبَلْوَرْتُمْ  | تَبَلْوَرْتُنَّ  | تَبَلْوَرَ     | تَبَلْوَرَتْ   | تَبَلْوَرَا  | تَبَلْوَرَتَا  | تَبَلْوَرُوا   | تَبَلْوَرْنَ   |
      | جءجء | 1       | تَجَأْجَأْتُ  | تَجَأْجَأْنَا  | تَجَأْجَأْتَ    | تَجَأْجَأْتِ    | تَجَأْجَأْتُمَا  | تَجَأْجَأْتُمْ  | تَجَأْجَأْتُنَّ  | تَجَأْجَأَ     | تَجَأْجَأَتْ   | تَجَأْجَأَا  | تَجَأْجَأَتَا  | تَجَأْجَؤُوا   | تَجَأْجَأْنَ   |
      | رهيء | 1       | تَرَهْيَأْتُ  | تَرَهْيَأْنَا  | تَرَهْيَأْتَ    | تَرَهْيَأْتِ    | تَرَهْيَأْتُمَا  | تَرَهْيَأْتُمْ  | تَرَهْيَأْتُنَّ  | تَرَهْيَأَ     | تَرَهْيَأَتْ   | تَرَهْيَأَا  | تَرَهْيَأَتَا  | تَرَهْيَؤُوا   | تَرَهْيَأْنَ   |
      | زلزل | 1       | تَزَلْزَلْتُ  | تَزَلْزَلْنَا  | تَزَلْزَلْتَ    | تَزَلْزَلْتِ    | تَزَلْزَلْتُمَا  | تَزَلْزَلْتُمْ  | تَزَلْزَلْتُنَّ  | تَزَلْزَلَ     | تَزَلْزَلَتْ   | تَزَلْزَلا   | تَزَلْزَلَتَا  | تَزَلْزَلُوا   | تَزَلْزَلْنَ   |
      | سيطر | 1       | تَسَيْطَرْتُ  | تَسَيْطَرْنَا  | تَسَيْطَرْتَ    | تَسَيْطَرْتِ    | تَسَيْطَرْتُمَا  | تَسَيْطَرْتُمْ  | تَسَيْطَرْتُنَّ  | تَسَيْطَرَ     | تَسَيْطَرَتْ   | تَسَيْطَرَا  | تَسَيْطَرَتَا  | تَسَيْطَرُوا   | تَسَيْطَرْنَ   |
      | طمءن | 1       | تَطَمْأَنْتُ  | تَطَمْأَنَّا   | تَطَمْأَنْتَ    | تَطَمْأَنْتِ    | تَطَمْأَنْتُمَا  | تَطَمْأَنْتُمْ  | تَطَمْأَنْتُنَّ  | تَطَمْأَنَ     | تَطَمْأَنَتْ   | تَطَمْأَنَا  | تَطَمْأَنَتَا  | تَطَمْأَنُوا   | تَطَمْأَنَّ    |
      | طمءن | 3       | اطْمَأْنَنْتُ | اطْمَأْنَنَّا  | اطْمَأْنَنْتَ   | اطْمَأْنَنْتِ   | اطْمَأْنَنْتُمَا | اطْمَأْنَنْتُمْ | اطْمَأْنَنْتُنَّ | اطْمَأَنَّ     | اطْمَأَنَّتْ   | اطْمَأَنَّا  | اطْمَأَنَّتَا  | اطْمَأَنُّوا   | اطْمَأْنَنَّ   |
      | قلسي | 1       | تَقَلْسَيْتُ  | تَقَلْسَيْنَا  | تَقَلْسَيْتَ    | تَقَلْسَيْتِ    | تَقَلْسَيْتُمَا  | تَقَلْسَيْتُمْ  | تَقَلْسَيْتُنَّ  | تَقَلْسَى      | تَقَلْسَتْ     | تَقَلْسَيَا  | تَقَلْسَتَا    | تَقَلْسَوْا    | تَقَلْسَيْنَ   |
      | شرءب | 3       | اشْرَأْبَبْتُ | اشْرَأْبَبْنَا | اشْرَأْبَبْتَ   | اشْرَأْبَبْتِ   | اشْرَأْبَبْتُمَا | اشْرَأْبَبْتُمْ | اشْرَأْبَبْتُنَّ | اشْرَأَبَّ     | اشْرَأَبَّتْ   | اشْرَأَبَّا  | اشْرَأَبَّتَا  | اشْرَأَبُّوا   | اشْرَأْبَبْنَ  |
      | مرءي | 1       | تَمَرْأَيْتُ  | تَمَرْأَيْنَا  | تَمَرْأَيْتَ    | تَمَرْأَيْتِ    | تَمَرْأَيْتُمَا  | تَمَرْأَيْتُمْ  | تَمَرْأَيْتُنَّ  | تَمَرْأَى      | تَمَرْأَتْ     | تَمَرْأَيَا  | تَمَرْأَتَا    | تَمَرْأَوْا    | تَمَرْأَيْنَ   |
      | شيطن | 1       | تَشَيْطَنْتُ  | تَشَيْطَنَّا   | تَشَيْطَنْتَ    | تَشَيْطَنْتِ    | تَشَيْطَنْتُمَا  | تَشَيْطَنْتُمْ  | تَشَيْطَنْتُنَّ  | تَشَيْطَنَ     | تَشَيْطَنَتْ   | تَشَيْطَنَا  | تَشَيْطَنَتَا  | تَشَيْطَنُوا   | تَشَيْطَنَّ    |
      | وشوش | 1       | تَوَشْوَشْتُ  | تَوَشْوَشْنَا  | تَوَشْوَشْتَ    | تَوَشْوَشْتِ    | تَوَشْوَشْتُمَا  | تَوَشْوَشْتُمْ  | تَوَشْوَشْتُنَّ  | تَوَشْوَشَ     | تَوَشْوَشَتْ   | تَوَشْوَشَا  | تَوَشْوَشَتَا  | تَوَشْوَشُوا   | تَوَشْوَشْنَ   |
      | بخدن | 2       | ابْخَنْدَنْتُ | ابْخَنْدَنَّا  | ابْخَنْدَنْتَ   | ابْخَنْدَنْتِ   | ابْخَنْدَنْتُمَا | ابْخَنْدَنْتُمْ | ابْخَنْدَنْتُنَّ | ابْخَنْدَنَ    | ابْخَنْدَنَتْ  | ابْخَنْدَنَا | ابْخَنْدَنَتَا | ابْخَنْدَنُوا  | ابْخَنْدَنَّ   |
      | حبطء | 2       | احْبَنْطَأْتُ | احْبَنْطَأْنَا | احْبَنْطَأْتَ   | احْبَنْطَأْتِ   | احْبَنْطَأْتُمَا | احْبَنْطَأْتُمْ | احْبَنْطَأْتُنَّ | احْبَنْطَأَ    | احْبَنْطَأَتْ  | احْبَنْطَأَا | احْبَنْطَأَتَا | احْبَنْطَؤُوا  | احْبَنْطَأْنَ  |
      | حوصل | 2       | احْوَنْصَلْتُ | احْوَنْصَلْنَا | احْوَنْصَلْتَ   | احْوَنْصَلْتِ   | احْوَنْصَلْتُمَا | احْوَنْصَلْتُمْ | احْوَنْصَلْتُنَّ | احْوَنْصَلَ    | احْوَنْصَلَتْ  | احْوَنْصَلا  | احْوَنْصَلَتَا | احْوَنْصَلُوا  | احْوَنْصَلْنَ  |
      | سلقي | 2       | اسْلَنْقَيْتُ | اسْلَنْقَيْنَا | اسْلَنْقَيْتَ   | اسْلَنْقَيْتِ   | اسْلَنْقَيْتُمَا | اسْلَنْقَيْتُمْ | اسْلَنْقَيْتُنَّ | اسْلَنْقَى     | اسْلَنْقَتْ    | اسْلَنْقَيَا | اسْلَنْقَتَا   | اسْلَنْقَوْا   | اسْلَنْقَيْنَ  |
      | فرقع | 1       | تَفَرْقَعْتُ  | تَفَرْقَعْنَا  | تَفَرْقَعْتَ    | تَفَرْقَعْتِ    | تَفَرْقَعْتُمَا  | تَفَرْقَعْتُمْ  | تَفَرْقَعْتُنَّ  | تَفَرْقَعَ     | تَفَرْقَعَتْ   | تَفَرْقَعَا  | تَفَرْقَعَتَا  | تَفَرْقَعُوا   | تَفَرْقَعْنَ   |
      | فرقع | 2       | افْرَنْقَعْتُ | افْرَنْقَعْنَا | افْرَنْقَعْتَ   | افْرَنْقَعْتِ   | افْرَنْقَعْتُمَا | افْرَنْقَعْتُمْ | افْرَنْقَعْتُنَّ | افْرَنْقَعَ    | افْرَنْقَعَتْ  | افْرَنْقَعَا | افْرَنْقَعَتَا | افْرَنْقَعُوا  | افْرَنْقَعْنَ  |
      | قشعر | 1       | تَقَشْعَرْتُ  | تَقَشْعَرْنَا  | تَقَشْعَرْتَ    | تَقَشْعَرْتِ    | تَقَشْعَرْتُمَا  | تَقَشْعَرْتُمْ  | تَقَشْعَرْتُنَّ  | تَقَشْعَرَ     | تَقَشْعَرَتْ   | تَقَشْعَرَا  | تَقَشْعَرَتَا  | تَقَشْعَرُوا   | تَقَشْعَرْنَ   |
      | قشعر | 3       | اقْشَعْرَرْتُ | اقْشَعْرَرْنَا | اقْشَعْرَرْتَ   | اقْشَعْرَرْتِ   | اقْشَعْرَرْتُمَا | اقْشَعْرَرْتُمْ | اقْشَعْرَرْتُنَّ | اقْشَعَرَّ     | اقْشَعَرَّتْ   | اقْشَعَرَّا  | اقْشَعَرَّتَا  | اقْشَعَرُّوا   | اقْشَعْرَرْنَ  |
      | كوءد | 3       | اكْوَأْدَدْتُ | اكْوَأْدَدْنَا | اكْوَأْدَدْتَ   | اكْوَأْدَدْتِ   | اكْوَأْدَدْتُمَا | اكْوَأْدَدْتُمْ | اكْوَأْدَدْتُنَّ | اكْوَأَدَّ     | اكْوَأَدَّتْ   | اكْوَأَدَّا  | اكْوَأَدَّتَا  | اكْوَأَدُّوا   | اكْوَأْدَدْنَ  |
      | كوهد | 3       | اكْوَهْدَدْتُ | اكْوَهْدَدْنَا | اكْوَهْدَدْتَ   | اكْوَهْدَدْتِ   | اكْوَهْدَدْتُمَا | اكْوَهْدَدْتُمْ | اكْوَهْدَدْتُنَّ | اكْوَهَدَّ     | اكْوَهَدَّتْ   | اكْوَهَدَّا  | اكْوَهَدَّتَا  | اكْوَهَدُّوا   | اكْوَهْدَدْنَ  |
      | مضحن | 3       | امْضَحْنَنْتُ | امْضَحْنَنَّا  | امْضَحْنَنْتَ   | امْضَحْنَنْتِ   | امْضَحْنَنْتُمَا | امْضَحْنَنْتُمْ | امْضَحْنَنْتُنَّ | امْضَحَنَّ     | امْضَحَنَّتْ   | امْضَحَنَّا  | امْضَحَنَّتَا  | امْضَحَنُّوا   | امْضَحْنَنَّ   |
