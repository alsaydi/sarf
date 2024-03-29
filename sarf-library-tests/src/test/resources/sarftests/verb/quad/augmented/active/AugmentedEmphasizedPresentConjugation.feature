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

Feature: augmented quadrilateral verb conjugation in present emphasized state
# المضارع المؤكد المبني للمعلوم من الرباعي المزيد
  Scenario Outline: active augmented quadrilateral verb past conjugation in emphasized state
    Given an augmented verb
    When the augmented quadrilateral verb is actively conjugated in "Emphasized" state
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
      | verb | formula | single_first    | plural_first    | m_single_second | f_single_second | m_dual_second    | m_plural_second | f_plural_second    | m_single_third  | f_single_third  | m_dual_third     | f_dual_third     | m_plural_third  | f_plural_third     |
      | دحرج | 1       | أَتَدَحْرَجَنَّ | نَتَدَحْرَجَنَّ | تَتَدَحْرَجَنَّ | تَتَدَحْرَجِنَّ | تَتَدَحْرَجَانِّ | تَتَدَحْرَجُنَّ | تَتَدَحْرَجْنَانِّ | يَتَدَحْرَجَنَّ | تَتَدَحْرَجَنَّ | يَتَدَحْرَجَانِّ | تَتَدَحْرَجَانِّ | يَتَدَحْرَجُنَّ | يَتَدَحْرَجْنَانِّ |
      | بلور | 1       | أَتَبَلْوَرَنَّ | نَتَبَلْوَرَنَّ | تَتَبَلْوَرَنَّ | تَتَبَلْوَرِنَّ | تَتَبَلْوَرَانِّ | تَتَبَلْوَرُنَّ | تَتَبَلْوَرْنَانِّ | يَتَبَلْوَرَنَّ | تَتَبَلْوَرَنَّ | يَتَبَلْوَرَانِّ | تَتَبَلْوَرَانِّ | يَتَبَلْوَرُنَّ | يَتَبَلْوَرْنَانِّ |
      | جءجء | 1       | أَتَجَأْجَأَنَّ | نَتَجَأْجَأَنَّ | تَتَجَأْجَأَنَّ | تَتَجَأْجَئِنَّ | تَتَجَأْجَأَانِّ | تَتَجَأْجَؤُنَّ | تَتَجَأْجَأْنَانِّ | يَتَجَأْجَأَنَّ | تَتَجَأْجَأَنَّ | يَتَجَأْجَأَانِّ | تَتَجَأْجَأَانِّ | يَتَجَأْجَؤُنَّ | يَتَجَأْجَأْنَانِّ |
      | رهيء | 1       | أَتَرَهْيَأَنَّ | نَتَرَهْيَأَنَّ | تَتَرَهْيَأَنَّ | تَتَرَهْيَئِنَّ | تَتَرَهْيَأَانِّ | تَتَرَهْيَؤُنَّ | تَتَرَهْيَأْنَانِّ | يَتَرَهْيَأَنَّ | تَتَرَهْيَأَنَّ | يَتَرَهْيَأَانِّ | تَتَرَهْيَأَانِّ | يَتَرَهْيَؤُنَّ | يَتَرَهْيَأْنَانِّ |
      | زلزل | 1       | أَتَزَلْزَلَنَّ | نَتَزَلْزَلَنَّ | تَتَزَلْزَلَنَّ | تَتَزَلْزَلِنَّ | تَتَزَلْزَلانِّ  | تَتَزَلْزَلُنَّ | تَتَزَلْزَلْنَانِّ | يَتَزَلْزَلَنَّ | تَتَزَلْزَلَنَّ | يَتَزَلْزَلانِّ  | تَتَزَلْزَلانِّ  | يَتَزَلْزَلُنَّ | يَتَزَلْزَلْنَانِّ |
      | سيطر | 1       | أَتَسَيْطَرَنَّ | نَتَسَيْطَرَنَّ | تَتَسَيْطَرَنَّ | تَتَسَيْطَرِنَّ | تَتَسَيْطَرَانِّ | تَتَسَيْطَرُنَّ | تَتَسَيْطَرْنَانِّ | يَتَسَيْطَرَنَّ | تَتَسَيْطَرَنَّ | يَتَسَيْطَرَانِّ | تَتَسَيْطَرَانِّ | يَتَسَيْطَرُنَّ | يَتَسَيْطَرْنَانِّ |
      | طمءن | 1       | أَتَطَمْأَنَنَّ | نَتَطَمْأَنَنَّ | تَتَطَمْأَنَنَّ | تَتَطَمْأَنِنَّ | تَتَطَمْأَنَانِّ | تَتَطَمْأَنُنَّ | تَتَطَمْأَنَّانِّ  | يَتَطَمْأَنَنَّ | تَتَطَمْأَنَنَّ | يَتَطَمْأَنَانِّ | تَتَطَمْأَنَانِّ | يَتَطَمْأَنُنَّ | يَتَطَمْأَنَّانِّ  |
      | طمءن | 3       | أَطْمَئِنَّنَّ  | نَطْمَئِنَّنَّ  | تَطْمَئِنَّنَّ  | تَطْمَئِنِّنَّ  | تَطْمَئِنَّانِّ  | تَطْمَئِنُّنَّ  | تَطْمَأْنِنَّانِّ  | يَطْمَئِنَّنَّ  | تَطْمَئِنَّنَّ  | يَطْمَئِنَّانِّ  | تَطْمَئِنَّانِّ  | يَطْمَئِنُّنَّ  | يَطْمَأْنِنَّانِّ  |
      | قلسي | 1       | أَتَقَلْسَيَنَّ | نَتَقَلْسَيَنَّ | تَتَقَلْسَيَنَّ | تَتَقَلْسَيِنَّ | تَتَقَلْسَيَانِّ | تَتَقَلْسَوُنَّ | تَتَقَلْسَيْنَانِّ | يَتَقَلْسَيَنَّ | تَتَقَلْسَيَنَّ | يَتَقَلْسَيَانِّ | تَتَقَلْسَيَانِّ | يَتَقَلْسَوُنَّ | يَتَقَلْسَيْنَانِّ |
      | شرءب | 3       | أَشْرَئِبَّنَّ  | نَشْرَئِبَّنَّ  | تَشْرَئِبَّنَّ  | تَشْرَئِبِّنَّ  | تَشْرَئِبَّانِّ  | تَشْرَئِبُّنَّ  | تَشْرَأْبِبْنَانِّ | يَشْرَئِبَّنَّ  | تَشْرَئِبَّنَّ  | يَشْرَئِبَّانِّ  | تَشْرَئِبَّانِّ  | يَشْرَئِبُّنَّ  | يَشْرَأْبِبْنَانِّ |
      | مرءي | 1       | أَتَمَرْأَيَنَّ | نَتَمَرْأَيَنَّ | تَتَمَرْأَيَنَّ | تَتَمَرْأَيِنَّ | تَتَمَرْأَيَانِّ | تَتَمَرْأَوُنَّ | تَتَمَرْأَيْنَانِّ | يَتَمَرْأَيَنَّ | تَتَمَرْأَيَنَّ | يَتَمَرْأَيَانِّ | تَتَمَرْأَيَانِّ | يَتَمَرْأَوُنَّ | يَتَمَرْأَيْنَانِّ |
      | شيطن | 1       | أَتَشَيْطَنَنَّ | نَتَشَيْطَنَنَّ | تَتَشَيْطَنَنَّ | تَتَشَيْطَنِنَّ | تَتَشَيْطَنَانِّ | تَتَشَيْطَنُنَّ | تَتَشَيْطَنَّانِّ  | يَتَشَيْطَنَنَّ | تَتَشَيْطَنَنَّ | يَتَشَيْطَنَانِّ | تَتَشَيْطَنَانِّ | يَتَشَيْطَنُنَّ | يَتَشَيْطَنَّانِّ  |
      | وشوش | 1       | أَتَوَشْوَشَنَّ | نَتَوَشْوَشَنَّ | تَتَوَشْوَشَنَّ | تَتَوَشْوَشِنَّ | تَتَوَشْوَشَانِّ | تَتَوَشْوَشُنَّ | تَتَوَشْوَشْنَانِّ | يَتَوَشْوَشَنَّ | تَتَوَشْوَشَنَّ | يَتَوَشْوَشَانِّ | تَتَوَشْوَشَانِّ | يَتَوَشْوَشُنَّ | يَتَوَشْوَشْنَانِّ |
      | بخدن | 2       | أَبْخَنْدِنَنَّ | نَبْخَنْدِنَنَّ | تَبْخَنْدِنَنَّ | تَبْخَنْدِنِنَّ | تَبْخَنْدِنَانِّ | تَبْخَنْدِنُنَّ | تَبْخَنْدِنَّانِّ  | يَبْخَنْدِنَنَّ | تَبْخَنْدِنَنَّ | يَبْخَنْدِنَانِّ | تَبْخَنْدِنَانِّ | يَبْخَنْدِنُنَّ | يَبْخَنْدِنَّانِّ  |
      | حبطء | 2       | أَحْبَنْطِئَنَّ | نَحْبَنْطِئَنَّ | تَحْبَنْطِئَنَّ | تَحْبَنْطِئِنَّ | تَحْبَنْطِئَانِّ | تَحْبَنْطِئُنَّ | تَحْبَنْطِئْنَانِّ | يَحْبَنْطِئَنَّ | تَحْبَنْطِئَنَّ | يَحْبَنْطِئَانِّ | تَحْبَنْطِئَانِّ | يَحْبَنْطِئُنَّ | يَحْبَنْطِئْنَانِّ |
      | حوصل | 2       | أَحْوَنْصِلَنَّ | نَحْوَنْصِلَنَّ | تَحْوَنْصِلَنَّ | تَحْوَنْصِلِنَّ | تَحْوَنْصِلانِّ  | تَحْوَنْصِلُنَّ | تَحْوَنْصِلْنَانِّ | يَحْوَنْصِلَنَّ | تَحْوَنْصِلَنَّ | يَحْوَنْصِلانِّ  | تَحْوَنْصِلانِّ  | يَحْوَنْصِلُنَّ | يَحْوَنْصِلْنَانِّ |
      | سلقي | 2       | أَسْلَنْقِيَنَّ | نَسْلَنْقِيَنَّ | تَسْلَنْقِيَنَّ | تَسْلَنْقِنَّ   | تَسْلَنْقِيَانِّ | تَسْلَنْقُنَّ   | تَسْلَنْقِينَانِّ  | يَسْلَنْقِيَنَّ | تَسْلَنْقِيَنَّ | يَسْلَنْقِيَانِّ | تَسْلَنْقِيَانِّ | يَسْلَنْقُنَّ   | يَسْلَنْقِينَانِّ  |
      | فرقع | 1       | أَتَفَرْقَعَنَّ | نَتَفَرْقَعَنَّ | تَتَفَرْقَعَنَّ | تَتَفَرْقَعِنَّ | تَتَفَرْقَعَانِّ | تَتَفَرْقَعُنَّ | تَتَفَرْقَعْنَانِّ | يَتَفَرْقَعَنَّ | تَتَفَرْقَعَنَّ | يَتَفَرْقَعَانِّ | تَتَفَرْقَعَانِّ | يَتَفَرْقَعُنَّ | يَتَفَرْقَعْنَانِّ |
      | فرقع | 2       | أَفْرَنْقِعَنَّ | نَفْرَنْقِعَنَّ | تَفْرَنْقِعَنَّ | تَفْرَنْقِعِنَّ | تَفْرَنْقِعَانِّ | تَفْرَنْقِعُنَّ | تَفْرَنْقِعْنَانِّ | يَفْرَنْقِعَنَّ | تَفْرَنْقِعَنَّ | يَفْرَنْقِعَانِّ | تَفْرَنْقِعَانِّ | يَفْرَنْقِعُنَّ | يَفْرَنْقِعْنَانِّ |
      | قشعر | 1       | أَتَقَشْعَرَنَّ | نَتَقَشْعَرَنَّ | تَتَقَشْعَرَنَّ | تَتَقَشْعَرِنَّ | تَتَقَشْعَرَانِّ | تَتَقَشْعَرُنَّ | تَتَقَشْعَرْنَانِّ | يَتَقَشْعَرَنَّ | تَتَقَشْعَرَنَّ | يَتَقَشْعَرَانِّ | تَتَقَشْعَرَانِّ | يَتَقَشْعَرُنَّ | يَتَقَشْعَرْنَانِّ |
      | قشعر | 3       | أَقْشَعِرَّنَّ  | نَقْشَعِرَّنَّ  | تَقْشَعِرَّنَّ  | تَقْشَعِرِّنَّ  | تَقْشَعِرَّانِّ  | تَقْشَعِرُّنَّ  | تَقْشَعْرِرْنَانِّ | يَقْشَعِرَّنَّ  | تَقْشَعِرَّنَّ  | يَقْشَعِرَّانِّ  | تَقْشَعِرَّانِّ  | يَقْشَعِرُّنَّ  | يَقْشَعْرِرْنَانِّ |
      | كوءد | 3       | أَكْوَئِدَّنَّ  | نَكْوَئِدَّنَّ  | تَكْوَئِدَّنَّ  | تَكْوَئِدِّنَّ  | تَكْوَئِدَّانِّ  | تَكْوَئِدُّنَّ  | تَكْوَأْدِدْنَانِّ | يَكْوَئِدَّنَّ  | تَكْوَئِدَّنَّ  | يَكْوَئِدَّانِّ  | تَكْوَئِدَّانِّ  | يَكْوَئِدُّنَّ  | يَكْوَأْدِدْنَانِّ |
      | كوهد | 3       | أَكْوَهِدَّنَّ  | نَكْوَهِدَّنَّ  | تَكْوَهِدَّنَّ  | تَكْوَهِدِّنَّ  | تَكْوَهِدَّانِّ  | تَكْوَهِدُّنَّ  | تَكْوَهْدِدْنَانِّ | يَكْوَهِدَّنَّ  | تَكْوَهِدَّنَّ  | يَكْوَهِدَّانِّ  | تَكْوَهِدَّانِّ  | يَكْوَهِدُّنَّ  | يَكْوَهْدِدْنَانِّ |
      | مضحن | 3       | أَمْضَحِنَّنَّ  | نَمْضَحِنَّنَّ  | تَمْضَحِنَّنَّ  | تَمْضَحِنِّنَّ  | تَمْضَحِنَّانِّ  | تَمْضَحِنُّنَّ  | تَمْضَحْنِنَّانِّ  | يَمْضَحِنَّنَّ  | تَمْضَحِنَّنَّ  | يَمْضَحِنَّانِّ  | تَمْضَحِنَّانِّ  | يَمْضَحِنُّنَّ  | يَمْضَحْنِنَّانِّ  |
