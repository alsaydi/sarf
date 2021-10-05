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

Feature: augmented quadrilateral verb conjugation in present nominative state
# المضارع المرفوع المبني للمعلوم من الرباعي المزيد
  Scenario Outline: active augmented quadrilateral verb past conjugation in present nominative state
    Given an augmented verb
    When the augmented quadrilateral verb is actively conjugated in "Nominative" state
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
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second   | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third    | f_dual_third    | m_plural_third  | f_plural_third |
      | دحرج | 1       | أَتَدَحْرَجُ | نَتَدَحْرَجُ | تَتَدَحْرَجُ    | تَتَدَحْرَجِينَ | تَتَدَحْرَجَانِ | تَتَدَحْرَجُونَ | تَتَدَحْرَجْنَ  | يَتَدَحْرَجُ   | تَتَدَحْرَجُ   | يَتَدَحْرَجَانِ | تَتَدَحْرَجَانِ | يَتَدَحْرَجُونَ | يَتَدَحْرَجْنَ |
      | بلور | 1       | أَتَبَلْوَرُ | نَتَبَلْوَرُ | تَتَبَلْوَرُ    | تَتَبَلْوَرِينَ | تَتَبَلْوَرَانِ | تَتَبَلْوَرُونَ | تَتَبَلْوَرْنَ  | يَتَبَلْوَرُ   | تَتَبَلْوَرُ   | يَتَبَلْوَرَانِ | تَتَبَلْوَرَانِ | يَتَبَلْوَرُونَ | يَتَبَلْوَرْنَ |
      | جءجء | 1       | أَتَجَأْجَأُ | نَتَجَأْجَأُ | تَتَجَأْجَأُ    | تَتَجَأْجَئِينَ | تَتَجَأْجَأَانِ | تَتَجَأْجَؤُونَ | تَتَجَأْجَأْنَ  | يَتَجَأْجَأُ   | تَتَجَأْجَأُ   | يَتَجَأْجَأَانِ | تَتَجَأْجَأَانِ | يَتَجَأْجَؤُونَ | يَتَجَأْجَأْنَ |
      | رهيء | 1       | أَتَرَهْيَأُ | نَتَرَهْيَأُ | تَتَرَهْيَأُ    | تَتَرَهْيَئِينَ | تَتَرَهْيَأَانِ | تَتَرَهْيَؤُونَ | تَتَرَهْيَأْنَ  | يَتَرَهْيَأُ   | تَتَرَهْيَأُ   | يَتَرَهْيَأَانِ | تَتَرَهْيَأَانِ | يَتَرَهْيَؤُونَ | يَتَرَهْيَأْنَ |
      | زلزل | 1       | أَتَزَلْزَلُ | نَتَزَلْزَلُ | تَتَزَلْزَلُ    | تَتَزَلْزَلِينَ | تَتَزَلْزَلانِ  | تَتَزَلْزَلُونَ | تَتَزَلْزَلْنَ  | يَتَزَلْزَلُ   | تَتَزَلْزَلُ   | يَتَزَلْزَلانِ  | تَتَزَلْزَلانِ  | يَتَزَلْزَلُونَ | يَتَزَلْزَلْنَ |
      | سيطر | 1       | أَتَسَيْطَرُ | نَتَسَيْطَرُ | تَتَسَيْطَرُ    | تَتَسَيْطَرِينَ | تَتَسَيْطَرَانِ | تَتَسَيْطَرُونَ | تَتَسَيْطَرْنَ  | يَتَسَيْطَرُ   | تَتَسَيْطَرُ   | يَتَسَيْطَرَانِ | تَتَسَيْطَرَانِ | يَتَسَيْطَرُونَ | يَتَسَيْطَرْنَ |
      | طمءن | 1       | أَتَطَمْأَنُ | نَتَطَمْأَنُ | تَتَطَمْأَنُ    | تَتَطَمْأَنِينَ | تَتَطَمْأَنَانِ | تَتَطَمْأَنُونَ | تَتَطَمْأَنَّ   | يَتَطَمْأَنُ   | تَتَطَمْأَنُ   | يَتَطَمْأَنَانِ | تَتَطَمْأَنَانِ | يَتَطَمْأَنُونَ | يَتَطَمْأَنَّ  |
      | طمءن | 3       | أَطْمَئِنُّ  | نَطْمَئِنُّ  | تَطْمَئِنُّ     | تَطْمَئِنِّينَ  | تَطْمَئِنَّانِ  | تَطْمَئِنُّونَ  | تَطْمَأْنِنَّ   | يَطْمَئِنُّ    | تَطْمَئِنُّ    | يَطْمَئِنَّانِ  | تَطْمَئِنَّانِ  | يَطْمَئِنُّونَ  | يَطْمَأْنِنَّ  |
      | قلسي | 1       | أَتَقَلْسَى  | نَتَقَلْسَى  | تَتَقَلْسَى     | تَتَقَلْسَيْنَ  | تَتَقَلْسَيَانِ | تَتَقَلْسَوْنَ  | تَتَقَلْسَيْنَ  | يَتَقَلْسَى    | تَتَقَلْسَى    | يَتَقَلْسَيَانِ | تَتَقَلْسَيَانِ | يَتَقَلْسَوْنَ  | يَتَقَلْسَيْنَ |
      | شرءب | 3       | أَشْرَئِبُّ  | نَشْرَئِبُّ  | تَشْرَئِبُّ     | تَشْرَئِبِّينَ  | تَشْرَئِبَّانِ  | تَشْرَئِبُّونَ  | تَشْرَأْبِبْنَ  | يَشْرَئِبُّ    | تَشْرَئِبُّ    | يَشْرَئِبَّانِ  | تَشْرَئِبَّانِ  | يَشْرَئِبُّونَ  | يَشْرَأْبِبْنَ |
      | مرءي | 1       | أَتَمَرْأَى  | نَتَمَرْأَى  | تَتَمَرْأَى     | تَتَمَرْأَيْنَ  | تَتَمَرْأَيَانِ | تَتَمَرْأَوْنَ  | تَتَمَرْأَيْنَ  | يَتَمَرْأَى    | تَتَمَرْأَى    | يَتَمَرْأَيَانِ | تَتَمَرْأَيَانِ | يَتَمَرْأَوْنَ  | يَتَمَرْأَيْنَ |
      | شيطن | 1       | أَتَشَيْطَنُ | نَتَشَيْطَنُ | تَتَشَيْطَنُ    | تَتَشَيْطَنِينَ | تَتَشَيْطَنَانِ | تَتَشَيْطَنُونَ | تَتَشَيْطَنَّ   | يَتَشَيْطَنُ   | تَتَشَيْطَنُ   | يَتَشَيْطَنَانِ | تَتَشَيْطَنَانِ | يَتَشَيْطَنُونَ | يَتَشَيْطَنَّ  |
      | وشوش | 1       | أَتَوَشْوَشُ | نَتَوَشْوَشُ | تَتَوَشْوَشُ    | تَتَوَشْوَشِينَ | تَتَوَشْوَشَانِ | تَتَوَشْوَشُونَ | تَتَوَشْوَشْنَ  | يَتَوَشْوَشُ   | تَتَوَشْوَشُ   | يَتَوَشْوَشَانِ | تَتَوَشْوَشَانِ | يَتَوَشْوَشُونَ | يَتَوَشْوَشْنَ |
      | بخدن | 2       | أَبْخَنْدِنُ | نَبْخَنْدِنُ | تَبْخَنْدِنُ    | تَبْخَنْدِنِينَ | تَبْخَنْدِنَانِ | تَبْخَنْدِنُونَ | تَبْخَنْدِنَّ   | يَبْخَنْدِنُ   | تَبْخَنْدِنُ   | يَبْخَنْدِنَانِ | تَبْخَنْدِنَانِ | يَبْخَنْدِنُونَ | يَبْخَنْدِنَّ  |
      | حبطء | 2       | أَحْبَنْطِئُ | نَحْبَنْطِئُ | تَحْبَنْطِئُ    | تَحْبَنْطِئِينَ | تَحْبَنْطِئَانِ | تَحْبَنْطِئُونَ | تَحْبَنْطِئْنَ  | يَحْبَنْطِئُ   | تَحْبَنْطِئُ   | يَحْبَنْطِئَانِ | تَحْبَنْطِئَانِ | يَحْبَنْطِئُونَ | يَحْبَنْطِئْنَ |
      | حوصل | 2       | أَحْوَنْصِلُ | نَحْوَنْصِلُ | تَحْوَنْصِلُ    | تَحْوَنْصِلِينَ | تَحْوَنْصِلانِ  | تَحْوَنْصِلُونَ | تَحْوَنْصِلْنَ  | يَحْوَنْصِلُ   | تَحْوَنْصِلُ   | يَحْوَنْصِلانِ  | تَحْوَنْصِلانِ  | يَحْوَنْصِلُونَ | يَحْوَنْصِلْنَ |
      | سلقي | 2       | أَسْلَنْقِي  | نَسْلَنْقِي  | تَسْلَنْقِي     | تَسْلَنْقِينَ   | تَسْلَنْقِيَانِ | تَسْلَنْقُونَ   | تَسْلَنْقِينَ   | يَسْلَنْقِي    | تَسْلَنْقِي    | يَسْلَنْقِيَانِ | تَسْلَنْقِيَانِ | يَسْلَنْقُونَ   | يَسْلَنْقِينَ  |
      | فرقع | 1       | أَتَفَرْقَعُ | نَتَفَرْقَعُ | تَتَفَرْقَعُ    | تَتَفَرْقَعِينَ | تَتَفَرْقَعَانِ | تَتَفَرْقَعُونَ | تَتَفَرْقَعْنَ  | يَتَفَرْقَعُ   | تَتَفَرْقَعُ   | يَتَفَرْقَعَانِ | تَتَفَرْقَعَانِ | يَتَفَرْقَعُونَ | يَتَفَرْقَعْنَ |
      | فرقع | 2       | أَفْرَنْقِعُ | نَفْرَنْقِعُ | تَفْرَنْقِعُ    | تَفْرَنْقِعِينَ | تَفْرَنْقِعَانِ | تَفْرَنْقِعُونَ | تَفْرَنْقِعْنَ  | يَفْرَنْقِعُ   | تَفْرَنْقِعُ   | يَفْرَنْقِعَانِ | تَفْرَنْقِعَانِ | يَفْرَنْقِعُونَ | يَفْرَنْقِعْنَ |
      | قشعر | 1       | أَتَقَشْعَرُ | نَتَقَشْعَرُ | تَتَقَشْعَرُ    | تَتَقَشْعَرِينَ | تَتَقَشْعَرَانِ | تَتَقَشْعَرُونَ | تَتَقَشْعَرْنَ  | يَتَقَشْعَرُ   | تَتَقَشْعَرُ   | يَتَقَشْعَرَانِ | تَتَقَشْعَرَانِ | يَتَقَشْعَرُونَ | يَتَقَشْعَرْنَ |
      | قشعر | 3       | أَقْشَعِرُّ  | نَقْشَعِرُّ  | تَقْشَعِرُّ     | تَقْشَعِرِّينَ  | تَقْشَعِرَّانِ  | تَقْشَعِرُّونَ  | تَقْشَعْرِرْنَ  | يَقْشَعِرُّ    | تَقْشَعِرُّ    | يَقْشَعِرَّانِ  | تَقْشَعِرَّانِ  | يَقْشَعِرُّونَ  | يَقْشَعْرِرْنَ |
      | كوءد | 3       | أَكْوَئِدُّ  | نَكْوَئِدُّ  | تَكْوَئِدُّ     | تَكْوَئِدِّينَ  | تَكْوَئِدَّانِ  | تَكْوَئِدُّونَ  | تَكْوَأْدِدْنَ  | يَكْوَئِدُّ    | تَكْوَئِدُّ    | يَكْوَئِدَّانِ  | تَكْوَئِدَّانِ  | يَكْوَئِدُّونَ  | يَكْوَأْدِدْنَ |
      | كوهد | 3       | أَكْوَهِدُّ  | نَكْوَهِدُّ  | تَكْوَهِدُّ     | تَكْوَهِدِّينَ  | تَكْوَهِدَّانِ  | تَكْوَهِدُّونَ  | تَكْوَهْدِدْنَ  | يَكْوَهِدُّ    | تَكْوَهِدُّ    | يَكْوَهِدَّانِ  | تَكْوَهِدَّانِ  | يَكْوَهِدُّونَ  | يَكْوَهْدِدْنَ |
      | مضحن | 3       | أَمْضَحِنُّ  | نَمْضَحِنُّ  | تَمْضَحِنُّ     | تَمْضَحِنِّينَ  | تَمْضَحِنَّانِ  | تَمْضَحِنُّونَ  | تَمْضَحْنِنَّ   | يَمْضَحِنُّ    | تَمْضَحِنُّ    | يَمْضَحِنَّانِ  | تَمْضَحِنَّانِ  | يَمْضَحِنُّونَ  | يَمْضَحْنِنَّ  |