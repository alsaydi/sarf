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

Feature: augmented quadrilateral verb conjugation in passive present nominative state
# المضارع المرفوع المبني للمجهول من الرباعي المزيد
  Scenario Outline: passive augmented quadrilateral verb past conjugation in present nominative state
    Given an augmented verb
    When the augmented quadrilateral verb is passively conjugated in "PassiveNominative" state
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
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third | f_dual_third | m_plural_third | f_plural_third |
      | دحرج | 1       |              |              |                 |                 |               |                 |                 | يُتَدَحْرَجُ   | تُتَدَحْرَجُ   |              |              |                |                |
      | بلور | 1       |              |              |                 |                 |               |                 |                 | يُتَبَلْوَرُ   | تُتَبَلْوَرُ   |              |              |                |                |
      | جءجء | 1       |              |              |                 |                 |               |                 |                 | يُتَجَأْجَأُ   | تُتَجَأْجَأُ   |              |              |                |                |
      | رهيء | 1       |              |              |                 |                 |               |                 |                 | يُتَرَهْيَأُ   | تُتَرَهْيَأُ   |              |              |                |                |
      | زلزل | 1       |              |              |                 |                 |               |                 |                 | يُتَزَلْزَلُ   | تُتَزَلْزَلُ   |              |              |                |                |
      | سيطر | 1       |              |              |                 |                 |               |                 |                 | يُتَسَيْطَرُ   | تُتَسَيْطَرُ   |              |              |                |                |
      | طمءن | 1       |              |              |                 |                 |               |                 |                 | يُتَطَمْأَنُ   | تُتَطَمْأَنُ   |              |              |                |                |
      | طمءن | 3       |              |              |                 |                 |               |                 |                 | يُطْمَأَنُّ    | تُطْمَأَنُّ    |              |              |                |                |
      | قلسي | 1       |              |              |                 |                 |               |                 |                 | يُتَقَلْسَى    | تُتَقَلْسَى    |              |              |                |                |
      | شرءب | 3       |              |              |                 |                 |               |                 |                 | يُشْرَأَبُّ    | تُشْرَأَبُّ    |              |              |                |                |
      | مرءي | 1       |              |              |                 |                 |               |                 |                 | يُتَمَرْأَى    | تُتَمَرْأَى    |              |              |                |                |
      | شيطن | 1       |              |              |                 |                 |               |                 |                 | يُتَشَيْطَنُ   | تُتَشَيْطَنُ   |              |              |                |                |
      | وشوش | 1       |              |              |                 |                 |               |                 |                 | يُتَوَشْوَشُ   | تُتَوَشْوَشُ   |              |              |                |                |
      | بخدن | 2       |              |              |                 |                 |               |                 |                 | يُبْخَنْدَنُ   | تُبْخَنْدَنُ   |              |              |                |                |
      | حبطء | 2       |              |              |                 |                 |               |                 |                 | يُحْبَنْطَأُ   | تُحْبَنْطَأُ   |              |              |                |                |
      | حوصل | 2       |              |              |                 |                 |               |                 |                 | يُحْوَنْصَلُ   | تُحْوَنْصَلُ   |              |              |                |                |
      | سلقي | 2       |              |              |                 |                 |               |                 |                 | يُسْلَنْقَى    | تُسْلَنْقَى    |              |              |                |                |
      | فرقع | 1       |              |              |                 |                 |               |                 |                 | يُتَفَرْقَعُ   | تُتَفَرْقَعُ   |              |              |                |                |
      | فرقع | 2       |              |              |                 |                 |               |                 |                 | يُفْرَنْقَعُ   | تُفْرَنْقَعُ   |              |              |                |                |
      | قشعر | 1       |              |              |                 |                 |               |                 |                 | يُتَقَشْعَرُ   | تُتَقَشْعَرُ   |              |              |                |                |
      | قشعر | 3       |              |              |                 |                 |               |                 |                 | يُقْشَعَرُّ    | تُقْشَعَرُّ    |              |              |                |                |
      | كوءد | 3       |              |              |                 |                 |               |                 |                 | يُكْوَأَدُّ    | تُكْوَأَدُّ    |              |              |                |                |
      | كوهد | 3       |              |              |                 |                 |               |                 |                 | يُكْوَهَدُّ    | تُكْوَهَدُّ    |              |              |                |                |
      | مضحن | 3       |              |              |                 |                 |               |                 |                 | يُمْضَحَنُّ    | تُمْضَحَنُّ    |              |              |                |                |
