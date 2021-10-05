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

Feature: تصريف المصدر الأصلي من الفعل الرباعي المزيد

  Scenario Outline: augmented quadrilateral gerund
    Given an augmented verb
    When the derived noun is from an augmented quad verb is "Gerund"
    Then singular masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>"
    And  singular feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>"
    And  dual masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>"
    And  dual feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>"
    And  plural masculine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>"
    And  plural feminine nouns of the quad verb "<verb>" of formula "<formula>" are nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>"
    Examples:
      | verb | formula | m_single_n   | f_single_n | m_dual_n        | f_dual_n | m_plural_n | f_plural_n      | m_single_a    | f_single_a | m_dual_a         | f_dual_a | m_plural_a | f_plural_a      | m_single_g   | f_single_g | m_dual_g         | f_dual_g | m_plural_g | f_plural_g      |
      | دحرج | 1       | تَدَحْرُجٌ   |            | تَدَحْرُجَانِ   |          |            | تَدَحْرُجَاتٌ   | تَدَحْرُجًا   |            | تَدَحْرُجَيْنِ   |          |            | تَدَحْرُجَاتٍ   | تَدَحْرُجٍ   |            | تَدَحْرُجَيْنِ   |          |            | تَدَحْرُجَاتٍ   |
      | بلور | 1       | تَبَلْوُرٌ   |            | تَبَلْوُرَانِ   |          |            | تَبَلْوُرَاتٌ   | تَبَلْوُرًا   |            | تَبَلْوُرَيْنِ   |          |            | تَبَلْوُرَاتٍ   | تَبَلْوُرٍ   |            | تَبَلْوُرَيْنِ   |          |            | تَبَلْوُرَاتٍ   |
      | جءجء | 1       | تَجَأْجُؤٌ   |            | تَجَأْجُؤَانِ   |          |            | تَجَأْجُؤَاتٌ   | تَجَأْجُؤًا   |            | تَجَأْجُؤَيْنِ   |          |            | تَجَأْجُؤَاتٍ   | تَجَأْجُؤٍ   |            | تَجَأْجُؤَيْنِ   |          |            | تَجَأْجُؤَاتٍ   |
      | رهيء | 1       | تَرَهْيُؤٌ   |            | تَرَهْيُؤَانِ   |          |            | تَرَهْيُؤَاتٌ   | تَرَهْيُؤًا   |            | تَرَهْيُؤَيْنِ   |          |            | تَرَهْيُؤَاتٍ   | تَرَهْيُؤٍ   |            | تَرَهْيُؤَيْنِ   |          |            | تَرَهْيُؤَاتٍ   |
      | زلزل | 1       | تَزَلْزُلٌ   |            | تَزَلْزُلانِ    |          |            | تَزَلْزُلاتٌ    | تَزَلْزُلاً   |            | تَزَلْزُلَيْنِ   |          |            | تَزَلْزُلاتٍ    | تَزَلْزُلٍ   |            | تَزَلْزُلَيْنِ   |          |            | تَزَلْزُلَاتٍ   |
      | سيطر | 1       | تَسَيْطُرٌ   |            | تَسَيْطُرَانِ   |          |            | تَسَيْطُرَاتٌ   | تَسَيْطُرًا   |            | تَسَيْطُرَيْنِ   |          |            | تَسَيْطُرَاتٍ   | تَسَيْطُرٍ   |            | تَسَيْطُرَيْنِ   |          |            | تَسَيْطُرَاتٍ   |
      | طمءن | 1       | تَطَمْؤُنٌ   |            | تَطَمْؤُنَانِ   |          |            | تَطَمْؤُنَاتٌ   | تَطَمْؤُنًا   |            | تَطَمْؤُنَيْنِ   |          |            | تَطَمْؤُنَاتٍ   | تَطَمْؤُنٍ   |            | تَطَمْؤُنَيْنِ   |          |            | تَطَمْؤُنَاتٍ   |
      | طمءن | 3       | اطْمِئْنَانٌ |            | اطْمِئْنَانَانِ |          |            | اطْمِئْنَانَاتٌ | اطْمِئْنَانًا |            | اطْمِئْنَانَيْنِ |          |            | اطْمِئْنَانَاتٍ | اطْمِئْنَانٍ |            | اطْمِئْنَانَيْنِ |          |            | اطْمِئْنَانَاتٍ |
      | قلسي | 1       | تَقَلْسٍ     |            | تَقَلْسِيَانِ   |          |            | تَقَلْسِيَاتٌ   | تَقَلْسِيًا   |            | تَقَلْسِيَيْنِ   |          |            | تَقَلْسِيَاتٍ   | تَقَلْسٍ     |            | تَقَلْسِيَيْنِ   |          |            | تَقَلْسِيَاتٍ   |
      | شرءب | 3       | اشْرِئْبَابٌ |            | اشْرِئْبَابَانِ |          |            | اشْرِئْبَابَاتٌ | اشْرِئْبَابًا |            | اشْرِئْبَابَيْنِ |          |            | اشْرِئْبَابَاتٍ | اشْرِئْبَابٍ |            | اشْرِئْبَابَيْنِ |          |            | اشْرِئْبَابَاتٍ |
      | مرءي | 1       | تَمَرْءٍ     |            | تَمَرْئِيَانِ   |          |            | تَمَرْئِيَاتٌ   | تَمَرْئِيًا   |            | تَمَرْئِيَيْنِ   |          |            | تَمَرْئِيَاتٍ   | تَمَرْءٍ     |            | تَمَرْئِيَيْنِ   |          |            | تَمَرْئِيَاتٍ   |
      | شيطن | 1       | تَشَيْطُنٌ   |            | تَشَيْطُنَانِ   |          |            | تَشَيْطُنَاتٌ   | تَشَيْطُنًا   |            | تَشَيْطُنَيْنِ   |          |            | تَشَيْطُنَاتٍ   | تَشَيْطُنٍ   |            | تَشَيْطُنَيْنِ   |          |            | تَشَيْطُنَاتٍ   |
      | وشوش | 1       | تَوَشْوُشٌ   |            | تَوَشْوُشَانِ   |          |            | تَوَشْوُشَاتٌ   | تَوَشْوُشًا   |            | تَوَشْوُشَيْنِ   |          |            | تَوَشْوُشَاتٍ   | تَوَشْوُشٍ   |            | تَوَشْوُشَيْنِ   |          |            | تَوَشْوُشَاتٍ   |
      | بخدن | 2       | ابْخِنْدَانٌ |            | ابْخِنْدَانَانِ |          |            | ابْخِنْدَانَاتٌ | ابْخِنْدَانًا |            | ابْخِنْدَانَيْنِ |          |            | ابْخِنْدَانَاتٍ | ابْخِنْدَانٍ |            | ابْخِنْدَانَيْنِ |          |            | ابْخِنْدَانَاتٍ |
      | حبطء | 2       | احْبِنْطَاءٌ |            | احْبِنْطَاءَانِ |          |            | احْبِنْطَاءَاتٌ | احْبِنْطَاءً  |            | احْبِنْطَاءَيْنِ |          |            | احْبِنْطَاءَاتٍ | احْبِنْطَاءٍ |            | احْبِنْطَاءَيْنِ |          |            | احْبِنْطَاءَاتٍ |
      | حوصل | 2       | احْوِنْصَالٌ |            | احْوِنْصَالانِ  |          |            | احْوِنْصَالاتٌ  | احْوِنْصَالاً |            | احْوِنْصَالَيْنِ |          |            | احْوِنْصَالاتٍ  | احْوِنْصَالٍ |            | احْوِنْصَالَيْنِ |          |            | احْوِنْصَالَاتٍ |
      | سلقي | 2       | اسْلِنْقَاءٌ |            | اسْلِنْقَاءَانِ |          |            | اسْلِنْقَاءَاتٌ | اسْلِنْقَاءًا |            | اسْلِنْقَاءَيْنِ |          |            | اسْلِنْقَاءَاتٍ | اسْلِنْقَاءٍ |            | اسْلِنْقَاءَيْنِ |          |            | اسْلِنْقَاءَاتٍ |
      | فرقع | 1       | تَفَرْقُعٌ   |            | تَفَرْقُعَانِ   |          |            | تَفَرْقُعَاتٌ   | تَفَرْقُعًا   |            | تَفَرْقُعَيْنِ   |          |            | تَفَرْقُعَاتٍ   | تَفَرْقُعٍ   |            | تَفَرْقُعَيْنِ   |          |            | تَفَرْقُعَاتٍ   |
      | فرقع | 2       | افْرِنْقَاعٌ |            | افْرِنْقَاعَانِ |          |            | افْرِنْقَاعَاتٌ | افْرِنْقَاعًا |            | افْرِنْقَاعَيْنِ |          |            | افْرِنْقَاعَاتٍ | افْرِنْقَاعٍ |            | افْرِنْقَاعَيْنِ |          |            | افْرِنْقَاعَاتٍ |
      | قشعر | 1       | تَقَشْعُرٌ   |            | تَقَشْعُرَانِ   |          |            | تَقَشْعُرَاتٌ   | تَقَشْعُرًا   |            | تَقَشْعُرَيْنِ   |          |            | تَقَشْعُرَاتٍ   | تَقَشْعُرٍ   |            | تَقَشْعُرَيْنِ   |          |            | تَقَشْعُرَاتٍ   |
      | قشعر | 3       | اقْشِعْرَارٌ |            | اقْشِعْرَارَانِ |          |            | اقْشِعْرَارَاتٌ | اقْشِعْرَارًا |            | اقْشِعْرَارَيْنِ |          |            | اقْشِعْرَارَاتٍ | اقْشِعْرَارٍ |            | اقْشِعْرَارَيْنِ |          |            | اقْشِعْرَارَاتٍ |
      | كوءد | 3       | اكْوِئْدَادٌ |            | اكْوِئْدَادَانِ |          |            | اكْوِئْدَادَاتٌ | اكْوِئْدَادًا |            | اكْوِئْدَادَيْنِ |          |            | اكْوِئْدَادَاتٍ | اكْوِئْدَادٍ |            | اكْوِئْدَادَيْنِ |          |            | اكْوِئْدَادَاتٍ |
      | كوهد | 3       | اكْوِهْدَادٌ |            | اكْوِهْدَادَانِ |          |            | اكْوِهْدَادَاتٌ | اكْوِهْدَادًا |            | اكْوِهْدَادَيْنِ |          |            | اكْوِهْدَادَاتٍ | اكْوِهْدَادٍ |            | اكْوِهْدَادَيْنِ |          |            | اكْوِهْدَادَاتٍ |
      | مضحن | 3       | امْضِحْنَانٌ |            | امْضِحْنَانَانِ |          |            | امْضِحْنَانَاتٌ | امْضِحْنَانًا |            | امْضِحْنَانَيْنِ |          |            | امْضِحْنَانَاتٍ | امْضِحْنَانٍ |            | امْضِحْنَانَيْنِ |          |            | امْضِحْنَانَاتٍ |
