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

Feature: trilateral unaugmented roots

  Scenario Outline: trilateral unaugmented roots
    Given a trilateral unaugmented verb
    When I request all roots
    Then for a verb "<root>" all tasareef "<tasareef>" are returned
    Examples:
      | root | tasareef                                                   |
      | سلم  | سَلَمَ يَسْلِمُ متعد,سَلِمَ يَسْلَمُ لازم                  |
      | وعد  | وَعَدَ يَعِدُ كلاهما                                       |
      | سعد  | سَعَدَ يَسْعَدُ كلاهما,سَعِدَ يَسْعَدُ لازم                |
      | دءم  | دَأَمَ يَدْأَمُ متعد                                       |
      | يبس  | يَبِسَ يَيْبَسُ لازم,يَبِسَ يَيْبِسُ لازم                  |
      | وله  | وَلَهَ يَلِهُ لازم,وَلِهَ يَوْلَهُ لازم,وَلِهَ يَلِهُ لازم |
      | قدد  | قَدَّ يَقُدُّ متعد                                         |

