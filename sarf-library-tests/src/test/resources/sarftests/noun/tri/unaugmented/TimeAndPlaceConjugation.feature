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

Feature: تصريف اسمي الزمان و المكان من الفعل الثلاثي المجرد

  Scenario Outline: unaugmented trilateral time and place nouns
    Given an unaugmented verb
    When the derived noun is "TimeAndPlace" and the root type is "TrilateralUnaugmented"
    Then singular masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_single_n>" and accusative "<m_single_a>" and genitive "<m_single_g>" with formula "<formula>"
    And  singular feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_single_n>" and accusative "<f_single_a>" and genitive "<f_single_g>" with formula "<formula>"
    And  dual masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_dual_n>" and accusative "<m_dual_a>" and genitive "<m_dual_g>" with formula "<formula>"
    And  dual feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_dual_n>" and accusative "<f_dual_a>" and genitive "<f_dual_g>" with formula "<formula>"
    And  plural masculine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<m_plural_n>" and accusative "<m_plural_a>" and genitive "<m_plural_g>" with formula "<formula>"
    And  plural feminine nouns of the verb "<verb>" in conjugation "<conjugation>" are nominative "<f_plural_n>" and accusative "<f_plural_a>" and genitive "<f_plural_g>" with formula "<formula>"
    Examples:
      | verb | conjugation | m_single_n | f_single_n | m_dual_n    | f_dual_n      | m_plural_n | f_plural_n | m_single_a | f_single_a | m_dual_a     | f_dual_a       | m_plural_a | f_plural_a | m_single_g | f_single_g | m_dual_g     | f_dual_g       | m_plural_g | f_plural_g | formula   |
      | ءخذ  | 1           | مَأْخَذٌ   |            | مَأْخَذَانِ |               |            |            | مَأْخَذًا  |            | مَأْخَذَيْنِ |                |            |            | مَأْخَذٍ   |            | مَأْخَذَيْنِ |                |            |            | مَفْعَل   |
      | ءكل  | 1           | مَأْكَلٌ   |            | مَأْكَلانِ  |               |            |            | مَأْكَلاً  |            | مَأْكَلَيْنِ |                |            |            | مَأْكَلٍ   |            | مَأْكَلَيْنِ |                |            |            | مَفْعَل   |
      | ءمن  | 4           | مَأْمَنٌ   |            | مَأْمَنَانِ |               |            |            | مَأْمَنًا  |            | مَأْمَنَيْنِ |                |            |            | مَأْمَنٍ   |            | مَأْمَنَيْنِ |                |            |            | مَفْعَل   |
      | بيت  | 2           | مَبِيتٌ    |            | مَبِيتَانِ  |               |            |            | مَبِيتًا   |            | مَبِيتَيْنِ  |                |            |            | مَبِيتٍ    |            | مَبِيتَيْنِ  |                |            |            | مَفْعِل   |
      | بيع  | 2           | مَبِيعٌ    |            | مَبِيعَانِ  |               |            |            | مَبِيعًا   |            | مَبِيعَيْنِ  |                |            |            | مَبِيعٍ    |            | مَبِيعَيْنِ  |                |            |            | مَفْعِل   |
      | بدء  | 3           | مَبْدَأٌ   |            | مَبْدَآنِ   |               |            |            | مَبْدَأً   |            | مَبْدَأَيْنِ |                |            |            | مَبْدَأٍ   |            | مَبْدَأَيْنِ |                |            |            | مَفْعَل   |
      | سكن  | 1           | مَسْكَنٌ   |            | مَسْكَنَانِ |               |            |            | مَسْكَنًا  |            | مَسْكَنَيْنِ |                |            |            | مَسْكَنٍ   |            | مَسْكَنَيْنِ |                |            |            | مَفْعَل   |
      | عوج  | 1           | مَعَاجٌ    |            | مَعَاجَانِ  |               |            |            | مَعَاجًا   |            | مَعَاجَيْنِ  |                |            |            | مَعَاجٍ    |            | مَعَاجَيْنِ  |                |            |            | مَفْعَل   |
      | فرق  | 1           | مَفْرِقٌ   |            | مَفْرِقَانِ |               |            |            | مَفْرِقًا  |            | مَفْرِقَيْنِ |                |            |            | مَفْرِقٍ   |            | مَفْرِقَيْنِ |                |            |            | مَفْعِل   |
      | لجء  | 3           | مَلْجَأٌ   |            | مَلْجَآنِ   |               |            |            | مَلْجَأً   |            | مَلْجَأَيْنِ |                |            |            | مَلْجَأٍ   |            | مَلْجَأَيْنِ |                |            |            | مَفْعَل   |
      | يسر  | 2           |            | مَيْسَرَةٌ |             | مَيْسَرَتَانِ |            |            |            | مَيْسَرَةً |              | مَيْسَرَتَيْنِ |            |            |            | مَيْسَرَةٍ |              | مَيْسَرَتَيْنِ |            |            | مَفْعَلَة |
      | يمن  | 2           |            | مَيْمَنَةٌ |             | مَيْمَنَتَانِ |            |            |            | مَيْمَنَةً |              | مَيْمَنَتَيْنِ |            |            |            | مَيْمَنَةٍ |              | مَيْمَنَتَيْنِ |            |            | مَفْعَلَة |
      | ضرب  | 2           | مَضْرِبٌ   |            | مَضْرِبَانِ |               |            |            | مَضْرِبًا  |            | مَضْرِبَيْنِ |                |            |            | مَضْرِبٍ   |            | مَضْرِبَيْنِ |                |            |            | مَفْعِل   |
      | قوم  | 1           | مَقَامٌ    |            | مَقَامَانِ  |               |            |            | مَقَامًا   |            | مَقَامَيْنِ  |                |            |            | مَقَامٍ    |            | مَقَامَيْنِ  |                |            |            | مَفْعَل   |
      | قوم  | 1           |            | مَقَامَةٌ  |             | مَقَامَتَانِ  |            |            |            | مَقَامَةً  |              | مَقَامَتَيْنِ  |            |            |            | مَقَامَةٍ  |              | مَقَامَتَيْنِ  |            |            | مَفْعَلَة |
      | قرء  | 3           |            | مَقْرَأَةٌ |             | مَقْرَأَتَانِ |            |            |            | مَقْرَأَةً |              | مَقْرَأَتَيْنِ |            |            |            | مَقْرَأَةٍ |              | مَقْرَأَتَيْنِ |            |            | مَفْعَلَة |
      | وطء  | 3           | مَوْطِئٌ   |            | مَوْطِئَانِ |               |            |            | مَوْطِئًا  |            | مَوْطِئَيْنِ |                |            |            | مَوْطِئٍ   |            | مَوْطِئَيْنِ |                |            |            | مَفْعِل   |
