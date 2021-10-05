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

Feature: augmented quadrilateral verb conjugation in present jussive state
# المضارع المجزوم المبني للمعلوم من الرباعي المزيد
  Scenario Outline: active augmented quadrilateral verb past conjugation in jussive accusative state
    Given an augmented verb
    When the augmented quadrilateral verb is actively conjugated in "Jussive" state
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
      | verb | formula | single_first | plural_first | m_single_second | f_single_second | m_dual_second | m_plural_second | f_plural_second | m_single_third | f_single_third | m_dual_third  | f_dual_third  | m_plural_third | f_plural_third |
      | دحرج | 1       | أَتَدَحْرَجْ | نَتَدَحْرَجْ | تَتَدَحْرَجْ    | تَتَدَحْرَجِي   | تَتَدَحْرَجَا | تَتَدَحْرَجُوا  | تَتَدَحْرَجْنَ  | يَتَدَحْرَجْ   | تَتَدَحْرَجْ   | يَتَدَحْرَجَا | تَتَدَحْرَجَا | يَتَدَحْرَجُوا | يَتَدَحْرَجْنَ |
      | بلور | 1       | أَتَبَلْوَرْ | نَتَبَلْوَرْ | تَتَبَلْوَرْ    | تَتَبَلْوَرِي   | تَتَبَلْوَرَا | تَتَبَلْوَرُوا  | تَتَبَلْوَرْنَ  | يَتَبَلْوَرْ   | تَتَبَلْوَرْ   | يَتَبَلْوَرَا | تَتَبَلْوَرَا | يَتَبَلْوَرُوا | يَتَبَلْوَرْنَ |
      | جءجء | 1       | أَتَجَأْجَأْ | نَتَجَأْجَأْ | تَتَجَأْجَأْ    | تَتَجَأْجَئِي   | تَتَجَأْجَأَا | تَتَجَأْجَؤُوا  | تَتَجَأْجَأْنَ  | يَتَجَأْجَأْ   | تَتَجَأْجَأْ   | يَتَجَأْجَأَا | تَتَجَأْجَأَا | يَتَجَأْجَؤُوا | يَتَجَأْجَأْنَ |
      | رهيء | 1       | أَتَرَهْيَأْ | نَتَرَهْيَأْ | تَتَرَهْيَأْ    | تَتَرَهْيَئِي   | تَتَرَهْيَأَا | تَتَرَهْيَؤُوا  | تَتَرَهْيَأْنَ  | يَتَرَهْيَأْ   | تَتَرَهْيَأْ   | يَتَرَهْيَأَا | تَتَرَهْيَأَا | يَتَرَهْيَؤُوا | يَتَرَهْيَأْنَ |
      | زلزل | 1       | أَتَزَلْزَلْ | نَتَزَلْزَلْ | تَتَزَلْزَلْ    | تَتَزَلْزَلِي   | تَتَزَلْزَلا  | تَتَزَلْزَلُوا  | تَتَزَلْزَلْنَ  | يَتَزَلْزَلْ   | تَتَزَلْزَلْ   | يَتَزَلْزَلا  | تَتَزَلْزَلا  | يَتَزَلْزَلُوا | يَتَزَلْزَلْنَ |
      | سيطر | 1       | أَتَسَيْطَرْ | نَتَسَيْطَرْ | تَتَسَيْطَرْ    | تَتَسَيْطَرِي   | تَتَسَيْطَرَا | تَتَسَيْطَرُوا  | تَتَسَيْطَرْنَ  | يَتَسَيْطَرْ   | تَتَسَيْطَرْ   | يَتَسَيْطَرَا | تَتَسَيْطَرَا | يَتَسَيْطَرُوا | يَتَسَيْطَرْنَ |
      | طمءن | 1       | أَتَطَمْأَنْ | نَتَطَمْأَنْ | تَتَطَمْأَنْ    | تَتَطَمْأَنِي   | تَتَطَمْأَنَا | تَتَطَمْأَنُوا  | تَتَطَمْأَنَّ   | يَتَطَمْأَنْ   | تَتَطَمْأَنْ   | يَتَطَمْأَنَا | تَتَطَمْأَنَا | يَتَطَمْأَنُوا | يَتَطَمْأَنَّ  |
      | طمءن | 3       | أَطْمَئِنَّ  | نَطْمَئِنَّ  | تَطْمَئِنَّ     | تَطْمَئِنِّي    | تَطْمَئِنَّا  | تَطْمَئِنُّوا   | تَطْمَأْنِنَّ   | يَطْمَئِنَّ    | تَطْمَئِنَّ    | يَطْمَئِنَّا  | تَطْمَئِنَّا  | يَطْمَئِنُّوا  | يَطْمَأْنِنَّ  |
      | قلسي | 1       | أَتَقَلْسَ   | نَتَقَلْسَ   | تَتَقَلْسَ      | تَتَقَلْسَيْ    | تَتَقَلْسَيَا | تَتَقَلْسَوْا   | تَتَقَلْسَيْنَ  | يَتَقَلْسَ     | تَتَقَلْسَ     | يَتَقَلْسَيَا | تَتَقَلْسَيَا | يَتَقَلْسَوْا  | يَتَقَلْسَيْنَ |
      | شرءب | 3       | أَشْرَئِبَّ  | نَشْرَئِبَّ  | تَشْرَئِبَّ     | تَشْرَئِبِّي    | تَشْرَئِبَّا  | تَشْرَئِبُّوا   | تَشْرَأْبِبْنَ  | يَشْرَئِبَّ    | تَشْرَئِبَّ    | يَشْرَئِبَّا  | تَشْرَئِبَّا  | يَشْرَئِبُّوا  | يَشْرَأْبِبْنَ |
      | مرءي | 1       | أَتَمَرْأَ   | نَتَمَرْأَ   | تَتَمَرْأَ      | تَتَمَرْأَيْ    | تَتَمَرْأَيَا | تَتَمَرْأَوْا   | تَتَمَرْأَيْنَ  | يَتَمَرْأَ     | تَتَمَرْأَ     | يَتَمَرْأَيَا | تَتَمَرْأَيَا | يَتَمَرْأَوْا  | يَتَمَرْأَيْنَ |
      | شيطن | 1       | أَتَشَيْطَنْ | نَتَشَيْطَنْ | تَتَشَيْطَنْ    | تَتَشَيْطَنِي   | تَتَشَيْطَنَا | تَتَشَيْطَنُوا  | تَتَشَيْطَنَّ   | يَتَشَيْطَنْ   | تَتَشَيْطَنْ   | يَتَشَيْطَنَا | تَتَشَيْطَنَا | يَتَشَيْطَنُوا | يَتَشَيْطَنَّ  |
      | وشوش | 1       | أَتَوَشْوَشْ | نَتَوَشْوَشْ | تَتَوَشْوَشْ    | تَتَوَشْوَشِي   | تَتَوَشْوَشَا | تَتَوَشْوَشُوا  | تَتَوَشْوَشْنَ  | يَتَوَشْوَشْ   | تَتَوَشْوَشْ   | يَتَوَشْوَشَا | تَتَوَشْوَشَا | يَتَوَشْوَشُوا | يَتَوَشْوَشْنَ |
      | بخدن | 2       | أَبْخَنْدِنْ | نَبْخَنْدِنْ | تَبْخَنْدِنْ    | تَبْخَنْدِنِي   | تَبْخَنْدِنَا | تَبْخَنْدِنُوا  | تَبْخَنْدِنَّ   | يَبْخَنْدِنْ   | تَبْخَنْدِنْ   | يَبْخَنْدِنَا | تَبْخَنْدِنَا | يَبْخَنْدِنُوا | يَبْخَنْدِنَّ  |
      | حبطء | 2       | أَحْبَنْطِئْ | نَحْبَنْطِئْ | تَحْبَنْطِئْ    | تَحْبَنْطِئِي   | تَحْبَنْطِئَا | تَحْبَنْطِئُوا  | تَحْبَنْطِئْنَ  | يَحْبَنْطِئْ   | تَحْبَنْطِئْ   | يَحْبَنْطِئَا | تَحْبَنْطِئَا | يَحْبَنْطِئُوا | يَحْبَنْطِئْنَ |
      | حوصل | 2       | أَحْوَنْصِلْ | نَحْوَنْصِلْ | تَحْوَنْصِلْ    | تَحْوَنْصِلِي   | تَحْوَنْصِلا  | تَحْوَنْصِلُوا  | تَحْوَنْصِلْنَ  | يَحْوَنْصِلْ   | تَحْوَنْصِلْ   | يَحْوَنْصِلا  | تَحْوَنْصِلا  | يَحْوَنْصِلُوا | يَحْوَنْصِلْنَ |
      | سلقي | 2       | أَسْلَنْقِ   | نَسْلَنْقِ   | تَسْلَنْقِ      | تَسْلَنْقِي     | تَسْلَنْقِيَا | تَسْلَنْقُوا    | تَسْلَنْقِينَ   | يَسْلَنْقِ     | تَسْلَنْقِ     | يَسْلَنْقِيَا | تَسْلَنْقِيَا | يَسْلَنْقُوا   | يَسْلَنْقِينَ  |
      | فرقع | 1       | أَتَفَرْقَعْ | نَتَفَرْقَعْ | تَتَفَرْقَعْ    | تَتَفَرْقَعِي   | تَتَفَرْقَعَا | تَتَفَرْقَعُوا  | تَتَفَرْقَعْنَ  | يَتَفَرْقَعْ   | تَتَفَرْقَعْ   | يَتَفَرْقَعَا | تَتَفَرْقَعَا | يَتَفَرْقَعُوا | يَتَفَرْقَعْنَ |
      | فرقع | 2       | أَفْرَنْقِعْ | نَفْرَنْقِعْ | تَفْرَنْقِعْ    | تَفْرَنْقِعِي   | تَفْرَنْقِعَا | تَفْرَنْقِعُوا  | تَفْرَنْقِعْنَ  | يَفْرَنْقِعْ   | تَفْرَنْقِعْ   | يَفْرَنْقِعَا | تَفْرَنْقِعَا | يَفْرَنْقِعُوا | يَفْرَنْقِعْنَ |
      | قشعر | 1       | أَتَقَشْعَرْ | نَتَقَشْعَرْ | تَتَقَشْعَرْ    | تَتَقَشْعَرِي   | تَتَقَشْعَرَا | تَتَقَشْعَرُوا  | تَتَقَشْعَرْنَ  | يَتَقَشْعَرْ   | تَتَقَشْعَرْ   | يَتَقَشْعَرَا | تَتَقَشْعَرَا | يَتَقَشْعَرُوا | يَتَقَشْعَرْنَ |
      | قشعر | 3       | أَقْشَعِرَّ  | نَقْشَعِرَّ  | تَقْشَعِرَّ     | تَقْشَعِرِّي    | تَقْشَعِرَّا  | تَقْشَعِرُّوا   | تَقْشَعْرِرْنَ  | يَقْشَعِرَّ    | تَقْشَعِرَّ    | يَقْشَعِرَّا  | تَقْشَعِرَّا  | يَقْشَعِرُّوا  | يَقْشَعْرِرْنَ |
      | كوءد | 3       | أَكْوَئِدَّ  | نَكْوَئِدَّ  | تَكْوَئِدَّ     | تَكْوَئِدِّي    | تَكْوَئِدَّا  | تَكْوَئِدُّوا   | تَكْوَأْدِدْنَ  | يَكْوَئِدَّ    | تَكْوَئِدَّ    | يَكْوَئِدَّا  | تَكْوَئِدَّا  | يَكْوَئِدُّوا  | يَكْوَأْدِدْنَ |
      | كوهد | 3       | أَكْوَهِدَّ  | نَكْوَهِدَّ  | تَكْوَهِدَّ     | تَكْوَهِدِّي    | تَكْوَهِدَّا  | تَكْوَهِدُّوا   | تَكْوَهْدِدْنَ  | يَكْوَهِدَّ    | تَكْوَهِدَّ    | يَكْوَهِدَّا  | تَكْوَهِدَّا  | يَكْوَهِدُّوا  | يَكْوَهْدِدْنَ |
      | مضحن | 3       | أَمْضَحِنَّ  | نَمْضَحِنَّ  | تَمْضَحِنَّ     | تَمْضَحِنِّي    | تَمْضَحِنَّا  | تَمْضَحِنُّوا   | تَمْضَحْنِنَّ   | يَمْضَحِنَّ    | تَمْضَحِنَّ    | يَمْضَحِنَّا  | تَمْضَحِنَّا  | يَمْضَحِنُّوا  | يَمْضَحْنِنَّ  |
