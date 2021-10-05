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

Feature: تصريف المصدر الميمي من الفعل الرباعي المجرد

  Scenario Outline: unaugmented quadrilateral meem gerund
    Given an unaugmented verb
    When the derived noun is "MeemGerund" from an unaugmented quadrilateral
    Then singular masculine nouns of the verb "<verb>" nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>"
    And  singular feminine nouns of the verb "<verb>" nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>"
    And  dual masculine nouns of the verb "<verb>" nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>"
    And  dual feminine nouns of the verb "<verb>" nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>"
    And  plural masculine nouns of the verb "<verb>" nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>"
    And  plural feminine nouns of the verb "<verb>" nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>"
    Examples:
      | verb | m_single_n | f_single_n | m_dual_n | f_dual_n | m_plural_n | f_plural_n | m_single_a  | f_single_a | m_dual_a | f_dual_a | m_plural_a | f_plural_a | m_single_g | f_single_g | m_dual_g | f_dual_g | m_plural_g | f_plural_g |
      | دحرج | مُدَحْرَجٌ |            |          |          |            |            | مُدَحْرَجًا |            |          |          |            |            | مُدَحْرَجٍ |            |          |          |            |            |
      | بءدل | مُبَأْدَلٌ |            |          |          |            |            | مُبَأْدَلاً |            |          |          |            |            | مُبَأْدَلٍ |            |          |          |            |            |
      | بلور | مُبَلْوَرٌ |            |          |          |            |            | مُبَلْوَرًا |            |          |          |            |            | مُبَلْوَرٍ |            |          |          |            |            |
      | تلفن | مُتَلْفَنٌ |            |          |          |            |            | مُتَلْفَنًا |            |          |          |            |            | مُتَلْفَنٍ |            |          |          |            |            |
      | تنتن | مُتَنْتَنٌ |            |          |          |            |            | مُتَنْتَنًا |            |          |          |            |            | مُتَنْتَنٍ |            |          |          |            |            |
      | جءجء | مُجَأْجَأٌ |            |          |          |            |            | مُجَأْجَأً  |            |          |          |            |            | مُجَأْجَأٍ |            |          |          |            |            |
      | حوقل | مُحَوْقَلٌ |            |          |          |            |            | مُحَوْقَلاً |            |          |          |            |            | مُحَوْقَلٍ |            |          |          |            |            |
      | حيحي | مُحَيْحًى  |            |          |          |            |            | مُحَيْحًى   |            |          |          |            |            | مُحَيْحًى  |            |          |          |            |            |
      | رهيء | مُرَهْيَأٌ |            |          |          |            |            | مُرَهْيَأً  |            |          |          |            |            | مُرَهْيَأٍ |            |          |          |            |            |
      | زلزل | مُزَلْزَلٌ |            |          |          |            |            | مُزَلْزَلاً |            |          |          |            |            | مُزَلْزَلٍ |            |          |          |            |            |
      | سبرت | مُسَبْرَتٌ |            |          |          |            |            | مُسَبْرَتًا |            |          |          |            |            | مُسَبْرَتٍ |            |          |          |            |            |
      | سيطر | مُسَيْطَرٌ |            |          |          |            |            | مُسَيْطَرًا |            |          |          |            |            | مُسَيْطَرٍ |            |          |          |            |            |
      | شريف | مُشَرْيَفٌ |            |          |          |            |            | مُشَرْيَفًا |            |          |          |            |            | مُشَرْيَفٍ |            |          |          |            |            |
      | ضوضي | مُضَوْضًى  |            |          |          |            |            | مُضَوْضًى   |            |          |          |            |            | مُضَوْضًى  |            |          |          |            |            |
      | طمءن | مُطَمْأَنٌ |            |          |          |            |            | مُطَمْأَنًا |            |          |          |            |            | مُطَمْأَنٍ |            |          |          |            |            |
      | غرقء | مُغَرْقَأٌ |            |          |          |            |            | مُغَرْقَأً  |            |          |          |            |            | مُغَرْقَأٍ |            |          |          |            |            |
      | قلسي | مُقَلْسًى  |            |          |          |            |            | مُقَلْسًى   |            |          |          |            |            | مُقَلْسًى  |            |          |          |            |            |
      | وءوء | مُوَأْوَأٌ |            |          |          |            |            | مُوَأْوَأً  |            |          |          |            |            | مُوَأْوَأٍ |            |          |          |            |            |
      | وسوس | مُوَسْوَسٌ |            |          |          |            |            | مُوَسْوَسًا |            |          |          |            |            | مُوَسْوَسٍ |            |          |          |            |            |
      | يءيء | مُيَأْيَأٌ |            |          |          |            |            | مُيَأْيَأً  |            |          |          |            |            | مُيَأْيَأٍ |            |          |          |            |            |
      | يرنء | مُيَرْنَأٌ |            |          |          |            |            | مُيَرْنَأً  |            |          |          |            |            | مُيَرْنَأٍ |            |          |          |            |            |
      | يهيه | مُيَهْيَهٌ |            |          |          |            |            | مُيَهْيَهًا |            |          |          |            |            | مُيَهْيَهٍ |            |          |          |            |            |
