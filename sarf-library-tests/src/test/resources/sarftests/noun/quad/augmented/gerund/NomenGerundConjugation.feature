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

Feature: تصريف مصدر المرة من الفعل الرباعي المزيد

  Scenario Outline: augmented quadrilateral nomen gerund
    Given an augmented verb
    When the derived noun is from an augmented quad verb is "NomenGerund"
    Then singular masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>"
    And  singular feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>"
    And  dual masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>"
    And  dual feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>"
    And  plural masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>"
    And  plural feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>"
    Examples:
      | verb | formula | m_single_n | f_single_n     | m_dual_n | f_dual_n          | m_plural_n | f_plural_n      | m_single_a | f_single_a     | m_dual_a | f_dual_a           | m_plural_a | f_plural_a      | m_single_g | f_single_g     | m_dual_g | f_dual_g           | m_plural_g | f_plural_g      |
      | دحرج | 1       |            | تَدَحْرُجَةٌ   |          | تَدَحْرُجَتَانِ   |            | تَدَحْرُجَاتٌ   |            | تَدَحْرُجَةً   |          | تَدَحْرُجَتَيْنِ   |            | تَدَحْرُجَاتٍ   |            | تَدَحْرُجَةٍ   |          | تَدَحْرُجَتَيْنِ   |            | تَدَحْرُجَاتٍ   |
      | بلور | 1       |            | تَبَلْوُرَةٌ   |          | تَبَلْوُرَتَانِ   |            | تَبَلْوُرَاتٌ   |            | تَبَلْوُرَةً   |          | تَبَلْوُرَتَيْنِ   |            | تَبَلْوُرَاتٍ   |            | تَبَلْوُرَةٍ   |          | تَبَلْوُرَتَيْنِ   |            | تَبَلْوُرَاتٍ   |
      | جءجء | 1       |            | تَجَأْجُؤَةٌ   |          | تَجَأْجُؤَتَانِ   |            | تَجَأْجُؤَاتٌ   |            | تَجَأْجُؤَةً   |          | تَجَأْجُؤَتَيْنِ   |            | تَجَأْجُؤَاتٍ   |            | تَجَأْجُؤَةٍ   |          | تَجَأْجُؤَتَيْنِ   |            | تَجَأْجُؤَاتٍ   |
      | رهيء | 1       |            | تَرَهْيُؤَةٌ   |          | تَرَهْيُؤَتَانِ   |            | تَرَهْيُؤَاتٌ   |            | تَرَهْيُؤَةً   |          | تَرَهْيُؤَتَيْنِ   |            | تَرَهْيُؤَاتٍ   |            | تَرَهْيُؤَةٍ   |          | تَرَهْيُؤَتَيْنِ   |            | تَرَهْيُؤَاتٍ   |
      | زلزل | 1       |            | تَزَلْزُلَةٌ   |          | تَزَلْزُلَتَانِ   |            | تَزَلْزُلاتٌ    |            | تَزَلْزُلَةً   |          | تَزَلْزُلَتَيْنِ   |            | تَزَلْزُلاتٍ    |            | تَزَلْزُلَةٍ   |          | تَزَلْزُلَتَيْنِ   |            | تَزَلْزُلَاتٍ   |
      | سيطر | 1       |            | تَسَيْطُرَةٌ   |          | تَسَيْطُرَتَانِ   |            | تَسَيْطُرَاتٌ   |            | تَسَيْطُرَةً   |          | تَسَيْطُرَتَيْنِ   |            | تَسَيْطُرَاتٍ   |            | تَسَيْطُرَةٍ   |          | تَسَيْطُرَتَيْنِ   |            | تَسَيْطُرَاتٍ   |
      | طمءن | 1       |            | تَطَمْؤُنَةٌ   |          | تَطَمْؤُنَتَانِ   |            | تَطَمْؤُنَاتٌ   |            | تَطَمْؤُنَةً   |          | تَطَمْؤُنَتَيْنِ   |            | تَطَمْؤُنَاتٍ   |            | تَطَمْؤُنَةٍ   |          | تَطَمْؤُنَتَيْنِ   |            | تَطَمْؤُنَاتٍ   |
      | طمءن | 3       |            | اطْمِئْنَانَةٌ |          | اطْمِئْنَانَتَانِ |            | اطْمِئْنَانَاتٌ |            | اطْمِئْنَانَةً |          | اطْمِئْنَانَتَيْنِ |            | اطْمِئْنَانَاتٍ |            | اطْمِئْنَانَةٍ |          | اطْمِئْنَانَتَيْنِ |            | اطْمِئْنَانَاتٍ |
      | قلسي | 1       |            | تَقَلْسِيَةٌ   |          | تَقَلْسِيَتَانِ   |            | تَقَلْسِيَاتٌ   |            | تَقَلْسِيَةً   |          | تَقَلْسِيَتَيْنِ   |            | تَقَلْسِيَاتٍ   |            | تَقَلْسِيَةٍ   |          | تَقَلْسِيَتَيْنِ   |            | تَقَلْسِيَاتٍ   |
      | شرءب | 3       |            | اشْرِئْبَابَةٌ |          | اشْرِئْبَابَتَانِ |            | اشْرِئْبَابَاتٌ |            | اشْرِئْبَابَةً |          | اشْرِئْبَابَتَيْنِ |            | اشْرِئْبَابَاتٍ |            | اشْرِئْبَابَةٍ |          | اشْرِئْبَابَتَيْنِ |            | اشْرِئْبَابَاتٍ |
      | مرءي | 1       |            | تَمَرْئِيَةٌ   |          | تَمَرْئِيَتَانِ   |            | تَمَرْئِيَاتٌ   |            | تَمَرْئِيَةً   |          | تَمَرْئِيَتَيْنِ   |            | تَمَرْئِيَاتٍ   |            | تَمَرْئِيَةٍ   |          | تَمَرْئِيَتَيْنِ   |            | تَمَرْئِيَاتٍ   |
      | شيطن | 1       |            | تَشَيْطُنَةٌ   |          | تَشَيْطُنَتَانِ   |            | تَشَيْطُنَاتٌ   |            | تَشَيْطُنَةً   |          | تَشَيْطُنَتَيْنِ   |            | تَشَيْطُنَاتٍ   |            | تَشَيْطُنَةٍ   |          | تَشَيْطُنَتَيْنِ   |            | تَشَيْطُنَاتٍ   |
      | وشوش | 1       |            | تَوَشْوُشَةٌ   |          | تَوَشْوُشَتَانِ   |            | تَوَشْوُشَاتٌ   |            | تَوَشْوُشَةً   |          | تَوَشْوُشَتَيْنِ   |            | تَوَشْوُشَاتٍ   |            | تَوَشْوُشَةٍ   |          | تَوَشْوُشَتَيْنِ   |            | تَوَشْوُشَاتٍ   |
      | بخدن | 2       |            | ابْخِنْدَانَةٌ |          | ابْخِنْدَانَتَانِ |            | ابْخِنْدَانَاتٌ |            | ابْخِنْدَانَةً |          | ابْخِنْدَانَتَيْنِ |            | ابْخِنْدَانَاتٍ |            | ابْخِنْدَانَةٍ |          | ابْخِنْدَانَتَيْنِ |            | ابْخِنْدَانَاتٍ |
      | حبطء | 2       |            | احْبِنْطَاءَةٌ |          | احْبِنْطَاءَتَانِ |            | احْبِنْطَاءَاتٌ |            | احْبِنْطَاءَةً |          | احْبِنْطَاءَتَيْنِ |            | احْبِنْطَاءَاتٍ |            | احْبِنْطَاءَةٍ |          | احْبِنْطَاءَتَيْنِ |            | احْبِنْطَاءَاتٍ |
      | حوصل | 2       |            | احْوِنْصَالَةٌ |          | احْوِنْصَالَتَانِ |            | احْوِنْصَالاتٌ  |            | احْوِنْصَالَةً |          | احْوِنْصَالَتَيْنِ |            | احْوِنْصَالاتٍ  |            | احْوِنْصَالَةٍ |          | احْوِنْصَالَتَيْنِ |            | احْوِنْصَالَاتٍ |
      | سلقي | 2       |            | اسْلِنْقَاءَةٌ |          | اسْلِنْقَاءَتَانِ |            | اسْلِنْقَاءَاتٌ |            | اسْلِنْقَاءَةً |          | اسْلِنْقَاءَتَيْنِ |            | اسْلِنْقَاءَاتٍ |            | اسْلِنْقَاءَةٍ |          | اسْلِنْقَاءَتَيْنِ |            | اسْلِنْقَاءَاتٍ |
      | فرقع | 1       |            | تَفَرْقُعَةٌ   |          | تَفَرْقُعَتَانِ   |            | تَفَرْقُعَاتٌ   |            | تَفَرْقُعَةً   |          | تَفَرْقُعَتَيْنِ   |            | تَفَرْقُعَاتٍ   |            | تَفَرْقُعَةٍ   |          | تَفَرْقُعَتَيْنِ   |            | تَفَرْقُعَاتٍ   |
      | فرقع | 2       |            | افْرِنْقَاعَةٌ |          | افْرِنْقَاعَتَانِ |            | افْرِنْقَاعَاتٌ |            | افْرِنْقَاعَةً |          | افْرِنْقَاعَتَيْنِ |            | افْرِنْقَاعَاتٍ |            | افْرِنْقَاعَةٍ |          | افْرِنْقَاعَتَيْنِ |            | افْرِنْقَاعَاتٍ |
      | قشعر | 1       |            | تَقَشْعُرَةٌ   |          | تَقَشْعُرَتَانِ   |            | تَقَشْعُرَاتٌ   |            | تَقَشْعُرَةً   |          | تَقَشْعُرَتَيْنِ   |            | تَقَشْعُرَاتٍ   |            | تَقَشْعُرَةٍ   |          | تَقَشْعُرَتَيْنِ   |            | تَقَشْعُرَاتٍ   |
      | قشعر | 3       |            | اقْشِعْرَارَةٌ |          | اقْشِعْرَارَتَانِ |            | اقْشِعْرَارَاتٌ |            | اقْشِعْرَارَةً |          | اقْشِعْرَارَتَيْنِ |            | اقْشِعْرَارَاتٍ |            | اقْشِعْرَارَةٍ |          | اقْشِعْرَارَتَيْنِ |            | اقْشِعْرَارَاتٍ |
      | كوءد | 3       |            | اكْوِئْدَادَةٌ |          | اكْوِئْدَادَتَانِ |            | اكْوِئْدَادَاتٌ |            | اكْوِئْدَادَةً |          | اكْوِئْدَادَتَيْنِ |            | اكْوِئْدَادَاتٍ |            | اكْوِئْدَادَةٍ |          | اكْوِئْدَادَتَيْنِ |            | اكْوِئْدَادَاتٍ |
      | كوهد | 3       |            | اكْوِهْدَادَةٌ |          | اكْوِهْدَادَتَانِ |            | اكْوِهْدَادَاتٌ |            | اكْوِهْدَادَةً |          | اكْوِهْدَادَتَيْنِ |            | اكْوِهْدَادَاتٍ |            | اكْوِهْدَادَةٍ |          | اكْوِهْدَادَتَيْنِ |            | اكْوِهْدَادَاتٍ |
      | مضحن | 3       |            | امْضِحْنَانَةٌ |          | امْضِحْنَانَتَانِ |            | امْضِحْنَانَاتٌ |            | امْضِحْنَانَةً |          | امْضِحْنَانَتَيْنِ |            | امْضِحْنَانَاتٍ |            | امْضِحْنَانَةٍ |          | امْضِحْنَانَتَيْنِ |            | امْضِحْنَانَاتٍ |
