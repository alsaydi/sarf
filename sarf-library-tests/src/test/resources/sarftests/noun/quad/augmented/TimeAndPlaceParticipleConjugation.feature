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

Feature: تصريف اسم الزمان و المكان من الفعل الرباعي المزيد

  Scenario Outline: augmented quadrilateral time and place noun
    Given an augmented verb
    When the derived noun is from an augmented quad verb is "TimeAndPlace"
    Then singular masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>"
    And  singular feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>"
    And  dual masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>"
    And  dual feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>"
    And  plural masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>"
    And  plural feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>"
    Examples:
      | verb | formula | m_single_n   | f_single_n | m_dual_n        | f_dual_n | m_plural_n | f_plural_n | m_single_a    | f_single_a | m_dual_a         | f_dual_a | m_plural_a | f_plural_a | m_single_g   | f_single_g | m_dual_g         | f_dual_g | m_plural_g | f_plural_g |
      | دحرج | 1       | مُتَدَحْرَجٌ |            | مُتَدَحْرَجَانِ |          |            |            | مُتَدَحْرَجًا |            | مُتَدَحْرَجَيْنِ |          |            |            | مُتَدَحْرَجٍ |            | مُتَدَحْرَجَيْنِ |          |            |            |
      | بلور | 1       | مُتَبَلْوَرٌ |            | مُتَبَلْوَرَانِ |          |            |            | مُتَبَلْوَرًا |            | مُتَبَلْوَرَيْنِ |          |            |            | مُتَبَلْوَرٍ |            | مُتَبَلْوَرَيْنِ |          |            |            |
      | جءجء | 1       | مُتَجَأْجَأٌ |            | مُتَجَأْجَآنِ   |          |            |            | مُتَجَأْجَأً  |            | مُتَجَأْجَأَيْنِ |          |            |            | مُتَجَأْجَأٍ |            | مُتَجَأْجَأَيْنِ |          |            |            |
      | رهيء | 1       | مُتَرَهْيَأٌ |            | مُتَرَهْيَآنِ   |          |            |            | مُتَرَهْيَأً  |            | مُتَرَهْيَأَيْنِ |          |            |            | مُتَرَهْيَأٍ |            | مُتَرَهْيَأَيْنِ |          |            |            |
      | زلزل | 1       | مُتَزَلْزَلٌ |            | مُتَزَلْزَلانِ  |          |            |            | مُتَزَلْزَلاً |            | مُتَزَلْزَلَيْنِ |          |            |            | مُتَزَلْزَلٍ |            | مُتَزَلْزَلَيْنِ |          |            |            |
      | سيطر | 1       | مُتَسَيْطَرٌ |            | مُتَسَيْطَرَانِ |          |            |            | مُتَسَيْطَرًا |            | مُتَسَيْطَرَيْنِ |          |            |            | مُتَسَيْطَرٍ |            | مُتَسَيْطَرَيْنِ |          |            |            |
      | طمءن | 1       | مُتَطَمْأَنٌ |            | مُتَطَمْأَنَانِ |          |            |            | مُتَطَمْأَنًا |            | مُتَطَمْأَنَيْنِ |          |            |            | مُتَطَمْأَنٍ |            | مُتَطَمْأَنَيْنِ |          |            |            |
      | طمءن | 3       | مُطْمَأَنٌّ  |            | مُطْمَأَنَّانِ  |          |            |            | مُطْمَأَنًّا  |            | مُطْمَأَنَّيْنِ  |          |            |            | مُطْمَأَنٍّ  |            | مُطْمَأَنَّيْنِ  |          |            |            |
      | قلسي | 1       | مُتَقَلْسًى  |            | مُتَقَلْسَيَانِ |          |            |            | مُتَقَلْسًى   |            | مُتَقَلْسَيَيْنِ |          |            |            | مُتَقَلْسًى  |            | مُتَقَلْسَيَيْنِ |          |            |            |
      | شرءب | 3       | مُشْرَأَبٌّ  |            | مُشْرَأَبَّانِ  |          |            |            | مُشْرَأَبًّا  |            | مُشْرَأَبَّيْنِ  |          |            |            | مُشْرَأَبٍّ  |            | مُشْرَأَبَّيْنِ  |          |            |            |
      | مرءي | 1       | مُتَمَرْأًى  |            | مُتَمَرْأَيَانِ |          |            |            | مُتَمَرْأًى   |            | مُتَمَرْأَيَيْنِ |          |            |            | مُتَمَرْأًى  |            | مُتَمَرْأَيَيْنِ |          |            |            |
      | شيطن | 1       | مُتَشَيْطَنٌ |            | مُتَشَيْطَنَانِ |          |            |            | مُتَشَيْطَنًا |            | مُتَشَيْطَنَيْنِ |          |            |            | مُتَشَيْطَنٍ |            | مُتَشَيْطَنَيْنِ |          |            |            |
      | وشوش | 1       | مُتَوَشْوَشٌ |            | مُتَوَشْوَشَانِ |          |            |            | مُتَوَشْوَشًا |            | مُتَوَشْوَشَيْنِ |          |            |            | مُتَوَشْوَشٍ |            | مُتَوَشْوَشَيْنِ |          |            |            |
      | بخدن | 2       | مُبْخَنْدَنٌ |            | مُبْخَنْدَنَانِ |          |            |            | مُبْخَنْدَنًا |            | مُبْخَنْدَنَيْنِ |          |            |            | مُبْخَنْدَنٍ |            | مُبْخَنْدَنَيْنِ |          |            |            |
      | حبطء | 2       | مُحْبَنْطَأٌ |            | مُحْبَنْطَآنِ   |          |            |            | مُحْبَنْطَأً  |            | مُحْبَنْطَأَيْنِ |          |            |            | مُحْبَنْطَأٍ |            | مُحْبَنْطَأَيْنِ |          |            |            |
      | حوصل | 2       | مُحْوَنْصَلٌ |            | مُحْوَنْصَلانِ  |          |            |            | مُحْوَنْصَلاً |            | مُحْوَنْصَلَيْنِ |          |            |            | مُحْوَنْصَلٍ |            | مُحْوَنْصَلَيْنِ |          |            |            |
      | سلقي | 2       | مُسْلَنْقًى  |            | مُسْلَنْقَيَانِ |          |            |            | مُسْلَنْقًى   |            | مُسْلَنْقَيَيْنِ |          |            |            | مُسْلَنْقًى  |            | مُسْلَنْقَيَيْنِ |          |            |            |
      | فرقع | 1       | مُتَفَرْقَعٌ |            | مُتَفَرْقَعَانِ |          |            |            | مُتَفَرْقَعًا |            | مُتَفَرْقَعَيْنِ |          |            |            | مُتَفَرْقَعٍ |            | مُتَفَرْقَعَيْنِ |          |            |            |
      | فرقع | 2       | مُفْرَنْقَعٌ |            | مُفْرَنْقَعَانِ |          |            |            | مُفْرَنْقَعًا |            | مُفْرَنْقَعَيْنِ |          |            |            | مُفْرَنْقَعٍ |            | مُفْرَنْقَعَيْنِ |          |            |            |
      | قشعر | 1       | مُتَقَشْعَرٌ |            | مُتَقَشْعَرَانِ |          |            |            | مُتَقَشْعَرًا |            | مُتَقَشْعَرَيْنِ |          |            |            | مُتَقَشْعَرٍ |            | مُتَقَشْعَرَيْنِ |          |            |            |
      | قشعر | 3       | مُقْشَعَرٌّ  |            | مُقْشَعَرَّانِ  |          |            |            | مُقْشَعَرًّا  |            | مُقْشَعَرَّيْنِ  |          |            |            | مُقْشَعَرٍّ  |            | مُقْشَعَرَّيْنِ  |          |            |            |
      | كوءد | 3       | مُكْوَأَدٌّ  |            | مُكْوَأَدَّانِ  |          |            |            | مُكْوَأَدًّا  |            | مُكْوَأَدَّيْنِ  |          |            |            | مُكْوَأَدٍّ  |            | مُكْوَأَدَّيْنِ  |          |            |            |
      | كوهد | 3       | مُكْوَهَدٌّ  |            | مُكْوَهَدَّانِ  |          |            |            | مُكْوَهَدًّا  |            | مُكْوَهَدَّيْنِ  |          |            |            | مُكْوَهَدٍّ  |            | مُكْوَهَدَّيْنِ  |          |            |            |
      | مضحن | 3       | مُمْضَحَنٌّ  |            | مُمْضَحَنَّانِ  |          |            |            | مُمْضَحَنًّا  |            | مُمْضَحَنَّيْنِ  |          |            |            | مُمْضَحَنٍّ  |            | مُمْضَحَنَّيْنِ  |          |            |            |
