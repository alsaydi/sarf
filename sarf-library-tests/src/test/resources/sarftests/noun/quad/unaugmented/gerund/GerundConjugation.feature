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

Feature: تصريف المصدر الأصلي من الفعل الرباعي المجرد

  Scenario Outline: unaugmented quadrilateral gerund
    Given an unaugmented verb
    When the derived noun is "Gerund" from an unaugmented quadrilateral
    Then singular masculine nouns of the verb "<verb>" nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>"
    And  singular feminine nouns of the verb "<verb>" nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>"
    And  dual masculine nouns of the verb "<verb>" nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>"
    And  dual feminine nouns of the verb "<verb>" nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>"
    And  plural masculine nouns of the verb "<verb>" nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>"
    And  plural feminine nouns of the verb "<verb>" nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>"
    Examples:
      | verb | m_single_n | f_single_n | m_dual_n | f_dual_n      | m_plural_n | f_plural_n  | m_single_a | f_single_a | m_dual_a | f_dual_a       | m_plural_a | f_plural_a  | m_single_g | f_single_g | m_dual_g | f_dual_g       | m_plural_g | f_plural_g  |
      | دحرج |            | دَحْرَجَةٌ |          | دَحْرَجَتَانِ |            | دَحْرَجَاتٌ |            | دَحْرَجَةً |          | دَحْرَجَتَيْنِ |            | دَحْرَجَاتٍ |            | دَحْرَجَةٍ |          | دَحْرَجَتَيْنِ |            | دَحْرَجَاتٍ |
      | بءدل |            | بَأْدَلَةٌ |          | بَأْدَلَتَانِ |            | بَأْدَلاتٌ  |            | بَأْدَلَةً |          | بَأْدَلَتَيْنِ |            | بَأْدَلاتٍ  |            | بَأْدَلَةٍ |          | بَأْدَلَتَيْنِ |            | بَأْدَلَاتٍ |
      | بلور |            | بَلْوَرَةٌ |          | بَلْوَرَتَانِ |            | بَلْوَرَاتٌ |            | بَلْوَرَةً |          | بَلْوَرَتَيْنِ |            | بَلْوَرَاتٍ |            | بَلْوَرَةٍ |          | بَلْوَرَتَيْنِ |            | بَلْوَرَاتٍ |
      | تلفن |            | تَلْفَنَةٌ |          | تَلْفَنَتَانِ |            | تَلْفَنَاتٌ |            | تَلْفَنَةً |          | تَلْفَنَتَيْنِ |            | تَلْفَنَاتٍ |            | تَلْفَنَةٍ |          | تَلْفَنَتَيْنِ |            | تَلْفَنَاتٍ |
      | تنتن |            | تَنْتَنَةٌ |          | تَنْتَنَتَانِ |            | تَنْتَنَاتٌ |            | تَنْتَنَةً |          | تَنْتَنَتَيْنِ |            | تَنْتَنَاتٍ |            | تَنْتَنَةٍ |          | تَنْتَنَتَيْنِ |            | تَنْتَنَاتٍ |
      | جءجء |            | جَأْجَأَةٌ |          | جَأْجَأَتَانِ |            | جَأْجَآتٌ   |            | جَأْجَأَةً |          | جَأْجَأَتَيْنِ |            | جَأْجَآتٍ   |            | جَأْجَأَةٍ |          | جَأْجَأَتَيْنِ |            | جَأْجَآتٍ   |
      | حوقل |            | حَوْقَلَةٌ |          | حَوْقَلَتَانِ |            | حَوْقَلاتٌ  |            | حَوْقَلَةً |          | حَوْقَلَتَيْنِ |            | حَوْقَلاتٍ  |            | حَوْقَلَةٍ |          | حَوْقَلَتَيْنِ |            | حَوْقَلَاتٍ |
      | حيحي |            | حَيْحَاةٌ  |          | حَيْحَاتَانِ  |            | حَيْحَيَاتٌ |            | حَيْحَاةً  |          | حَيْحَاتَيْنِ  |            | حَيْحَيَاتٍ |            | حَيْحَاةٍ  |          | حَيْحَاتَيْنِ  |            | حَيْحَيَاتٍ |
      | رهيء |            | رَهْيَأَةٌ |          | رَهْيَأَتَانِ |            | رَهْيَآتٌ   |            | رَهْيَأَةً |          | رَهْيَأَتَيْنِ |            | رَهْيَآتٍ   |            | رَهْيَأَةٍ |          | رَهْيَأَتَيْنِ |            | رَهْيَآتٍ   |
      | زلزل |            | زَلْزَلَةٌ |          | زَلْزَلَتَانِ |            | زَلْزَلاتٌ  |            | زَلْزَلَةً |          | زَلْزَلَتَيْنِ |            | زَلْزَلاتٍ  |            | زَلْزَلَةٍ |          | زَلْزَلَتَيْنِ |            | زَلْزَلَاتٍ |
      | سبرت |            | سَبْرَتَةٌ |          | سَبْرَتَتَانِ |            | سَبْرَتَاتٌ |            | سَبْرَتَةً |          | سَبْرَتَتَيْنِ |            | سَبْرَتَاتٍ |            | سَبْرَتَةٍ |          | سَبْرَتَتَيْنِ |            | سَبْرَتَاتٍ |
      | سيطر |            | سَيْطَرَةٌ |          | سَيْطَرَتَانِ |            | سَيْطَرَاتٌ |            | سَيْطَرَةً |          | سَيْطَرَتَيْنِ |            | سَيْطَرَاتٍ |            | سَيْطَرَةٍ |          | سَيْطَرَتَيْنِ |            | سَيْطَرَاتٍ |
      | شريف |            | شَرْيَفَةٌ |          | شَرْيَفَتَانِ |            | شَرْيَفَاتٌ |            | شَرْيَفَةً |          | شَرْيَفَتَيْنِ |            | شَرْيَفَاتٍ |            | شَرْيَفَةٍ |          | شَرْيَفَتَيْنِ |            | شَرْيَفَاتٍ |
      | ضوضي |            | ضَوْضَاةٌ  |          | ضَوْضَاتَانِ  |            | ضَوْضَيَاتٌ |            | ضَوْضَاةً  |          | ضَوْضَاتَيْنِ  |            | ضَوْضَيَاتٍ |            | ضَوْضَاةٍ  |          | ضَوْضَاتَيْنِ  |            | ضَوْضَيَاتٍ |
      | طمءن |            | طَمْأَنَةٌ |          | طَمْأَنَتَانِ |            | طَمْأَنَاتٌ |            | طَمْأَنَةً |          | طَمْأَنَتَيْنِ |            | طَمْأَنَاتٍ |            | طَمْأَنَةٍ |          | طَمْأَنَتَيْنِ |            | طَمْأَنَاتٍ |
      | غرقء |            | غَرْقَأَةٌ |          | غَرْقَأَتَانِ |            | غَرْقَآتٌ   |            | غَرْقَأَةً |          | غَرْقَأَتَيْنِ |            | غَرْقَآتٍ   |            | غَرْقَأَةٍ |          | غَرْقَأَتَيْنِ |            | غَرْقَآتٍ   |
      | قلسي |            | قَلْسَاةٌ  |          | قَلْسَاتَانِ  |            | قَلْسَيَاتٌ |            | قَلْسَاةً  |          | قَلْسَاتَيْنِ  |            | قَلْسَيَاتٍ |            | قَلْسَاةٍ  |          | قَلْسَاتَيْنِ  |            | قَلْسَيَاتٍ |
      | وءوء |            | وَأْوَأَةٌ |          | وَأْوَأَتَانِ |            | وَأْوَآتٌ   |            | وَأْوَأَةً |          | وَأْوَأَتَيْنِ |            | وَأْوَآتٍ   |            | وَأْوَأَةٍ |          | وَأْوَأَتَيْنِ |            | وَأْوَآتٍ   |
      | وسوس |            | وَسْوَسَةٌ |          | وَسْوَسَتَانِ |            | وَسْوَسَاتٌ |            | وَسْوَسَةً |          | وَسْوَسَتَيْنِ |            | وَسْوَسَاتٍ |            | وَسْوَسَةٍ |          | وَسْوَسَتَيْنِ |            | وَسْوَسَاتٍ |
      | يءيء |            | يَأْيَأَةٌ |          | يَأْيَأَتَانِ |            | يَأْيَآتٌ   |            | يَأْيَأَةً |          | يَأْيَأَتَيْنِ |            | يَأْيَآتٍ   |            | يَأْيَأَةٍ |          | يَأْيَأَتَيْنِ |            | يَأْيَآتٍ   |
      | يرنء |            | يَرْنَأَةٌ |          | يَرْنَأَتَانِ |            | يَرْنَآتٌ   |            | يَرْنَأَةً |          | يَرْنَأَتَيْنِ |            | يَرْنَآتٍ   |            | يَرْنَأَةٍ |          | يَرْنَأَتَيْنِ |            | يَرْنَآتٍ   |
      | يهيه |            | يَهْيَهَةٌ |          | يَهْيَهَتَانِ |            | يَهْيَهَاتٌ |            | يَهْيَهَةً |          | يَهْيَهَتَيْنِ |            | يَهْيَهَاتٍ |            | يَهْيَهَةٍ |          | يَهْيَهَتَيْنِ |            | يَهْيَهَاتٍ |
