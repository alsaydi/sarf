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

Feature: augmented quadrilateral verb conjugation in emphasized imperative state
# الأمر المؤكد من الرباعي المزيد
  Scenario Outline: active augmented quadrilateral verb past conjugation in emphasized imperative state
    Given an augmented verb
    When the augmented quadrilateral verb is actively conjugated in "ImperativeEmphasized" state
    Then the first person singular conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<single_first>"
    And the first person plural conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<plural_first>"
    And the masculine singular second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_single_second>"
    And the feminine singular second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_single_second>"
    And the masculine dual second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_dual_second>"
    And the masculine plural second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_plural_second>"
    And the feminine plural second person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_plural_second>"
    And the masculine singular third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_single_third>"
    And the feminine singular third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_single_third>"
    And the masculine dual third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_dual_third>"
    And the feminine dual third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_dual_third>"
    And the masculine plural third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<m_plural_third>"
    And the feminine plural third person conjugation of the active present quad verb "<verb>" and formula of "<formula>" is "<f_plural_third>"
    Examples:
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second   | m_plural_second | f_plural_second   | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | 1       |              |              | تَدَحْرَجَنَّ   | تَدَحْرَجِنَّ   | تَدَحْرَجَانِّ  | تَدَحْرَجُنَّ   | تَدَحْرَجْنَانِّ  |                |                |              |              |                |                |
      | بلور | 1       |              |              | تَبَلْوَرَنَّ   | تَبَلْوَرِنَّ   | تَبَلْوَرَانِّ  | تَبَلْوَرُنَّ   | تَبَلْوَرْنَانِّ  |                |                |              |              |                |                |
      | جءجء | 1       |              |              | تَجَأْجَأَنَّ   | تَجَأْجَئِنَّ   | تَجَأْجَأَانِّ  | تَجَأْجَؤُنَّ   | تَجَأْجَأْنَانِّ  |                |                |              |              |                |                |
      | رهيء | 1       |              |              | تَرَهْيَأَنَّ   | تَرَهْيَئِنَّ   | تَرَهْيَأَانِّ  | تَرَهْيَؤُنَّ   | تَرَهْيَأْنَانِّ  |                |                |              |              |                |                |
      | زلزل | 1       |              |              | تَزَلْزَلَنَّ   | تَزَلْزَلِنَّ   | تَزَلْزَلانِّ   | تَزَلْزَلُنَّ   | تَزَلْزَلْنَانِّ  |                |                |              |              |                |                |
      | سيطر | 1       |              |              | تَسَيْطَرَنَّ   | تَسَيْطَرِنَّ   | تَسَيْطَرَانِّ  | تَسَيْطَرُنَّ   | تَسَيْطَرْنَانِّ  |                |                |              |              |                |                |
      | طمءن | 1       |              |              | تَطَمْأَنَنَّ   | تَطَمْأَنِنَّ   | تَطَمْأَنَانِّ  | تَطَمْأَنُنَّ   | تَطَمْأَنَّانِّ   |                |                |              |              |                |                |
      | طمءن | 3       |              |              | اطْمَئِنَّنَّ   | اطْمَئِنِّنَّ   | اطْمَئِنَّانِّ  | اطْمَئِنُّنَّ   | اطْمَأْنِنَّانِّ  |                |                |              |              |                |                |
      | قلسي | 1       |              |              | تَقَلْسَيَنَّ   | تَقَلْسَيِنَّ   | تَقَلْسَيَانِّ  | تَقَلْسَوُنَّ   | تَقَلْسَيْنَانِّ  |                |                |              |              |                |                |
      | شرءب | 3       |              |              | اشْرَئِبَّنَّ   | اشْرَئِبِّنَّ   | اشْرَئِبَّانِّ  | اشْرَئِبُّنَّ   | اشْرَأْبِبْنَانِّ |                |                |              |              |                |                |
      | مرءي | 1       |              |              | تَمَرْأَيَنَّ   | تَمَرْأَيِنَّ   | تَمَرْأَيَانِّ  | تَمَرْأَوُنَّ   | تَمَرْأَيْنَانِّ  |                |                |              |              |                |                |
      | شيطن | 1       |              |              | تَشَيْطَنَنَّ   | تَشَيْطَنِنَّ   | تَشَيْطَنَانِّ  | تَشَيْطَنُنَّ   | تَشَيْطَنَّانِّ   |                |                |              |              |                |                |
      | وشوش | 1       |              |              | تَوَشْوَشَنَّ   | تَوَشْوَشِنَّ   | تَوَشْوَشَانِّ  | تَوَشْوَشُنَّ   | تَوَشْوَشْنَانِّ  |                |                |              |              |                |                |
      | بخدن | 2       |              |              | ابْخَنْدِنَنَّ  | ابْخَنْدِنِنَّ  | ابْخَنْدِنَانِّ | ابْخَنْدِنُنَّ  | ابْخَنْدِنَّانِّ  |                |                |              |              |                |                |
      | حبطء | 2       |              |              | احْبَنْطِئَنَّ  | احْبَنْطِئِنَّ  | احْبَنْطِئَانِّ | احْبَنْطِئُنَّ  | احْبَنْطِئْنَانِّ |                |                |              |              |                |                |
      | حوصل | 2       |              |              | احْوَنْصِلَنَّ  | احْوَنْصِلِنَّ  | احْوَنْصِلانِّ  | احْوَنْصِلُنَّ  | احْوَنْصِلْنَانِّ |                |                |              |              |                |                |
      | سلقي | 2       |              |              | اسْلَنْقِيَنَّ  | اسْلَنْقِنَّ    | اسْلَنْقِيَانِّ | اسْلَنْقُنَّ    | اسْلَنْقِينَانِّ  |                |                |              |              |                |                |
      | فرقع | 1       |              |              | تَفَرْقَعَنَّ   | تَفَرْقَعِنَّ   | تَفَرْقَعَانِّ  | تَفَرْقَعُنَّ   | تَفَرْقَعْنَانِّ  |                |                |              |              |                |                |
      | فرقع | 2       |              |              | افْرَنْقِعَنَّ  | افْرَنْقِعِنَّ  | افْرَنْقِعَانِّ | افْرَنْقِعُنَّ  | افْرَنْقِعْنَانِّ |                |                |              |              |                |                |
      | قشعر | 1       |              |              | تَقَشْعَرَنَّ   | تَقَشْعَرِنَّ   | تَقَشْعَرَانِّ  | تَقَشْعَرُنَّ   | تَقَشْعَرْنَانِّ  |                |                |              |              |                |                |
      | قشعر | 3       |              |              | اقْشَعِرَّنَّ   | اقْشَعِرِّنَّ   | اقْشَعِرَّانِّ  | اقْشَعِرُّنَّ   | اقْشَعْرِرْنَانِّ |                |                |              |              |                |                |
      | كوءد | 3       |              |              | اكْوَئِدَّنَّ   | اكْوَئِدِّنَّ   | اكْوَئِدَّانِّ  | اكْوَئِدُّنَّ   | اكْوَأْدِدْنَانِّ |                |                |              |              |                |                |
      | كوهد | 3       |              |              | اكْوَهِدَّنَّ   | اكْوَهِدِّنَّ   | اكْوَهِدَّانِّ  | اكْوَهِدُّنَّ   | اكْوَهْدِدْنَانِّ |                |                |              |              |                |                |
      | مضحن | 3       |              |              | امْضَحِنَّنَّ   | امْضَحِنِّنَّ   | امْضَحِنَّانِّ  | امْضَحِنُّنَّ   | امْضَحْنِنَّانِّ  |                |                |              |              |                |                |
