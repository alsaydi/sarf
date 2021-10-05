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

Feature: kind of verb

  Scenario Outline: Kind of Verb
    Given a trilateral unaugmented verb
    When the kind of verb is request
    Then the verb "<verb>" kind is "<kind>"
    Examples:
      | verb | kind                       |
      | سلم  | Salim                      |
      | هدد  | Mudaaf                     |
      | وءي  | Lafeef_Mafrooq_Mahmouz_Ain |
      | ءوي  | Lafeef_Maqroon_Mahmouz_Faa |
      | وقي  | Lafeef_Mafrooq             |
      | شوي  | Lafeef_Maqroon             |
      | ءبي  | Naqis_Yaee_Mahmouz_Faa     |
      | رءي  | Naqis_Yaee_Mahmouz_Ain     |
      | ءسو  | Naqis_Wawi_Mahmouz_Faa     |
      | مءو  | Naqis_Wawi_Mahmouz_Ain     |
      | ءين   | Ajwaf_Yaee_Mahmouz_Faa     |
      | شيء  | Ajwaf_Yaee_Mahmouz_Laam    |
      | ءوب   | Ajwaf_Wawi_Mahmouz_Faa     |
      | بوء  | Ajwaf_Wawi_Mahmouz_Laam    |
      | يسس  | Mithal_Yaee_Mudaaf         |
      | يءس  | Mithal_Yaee_Mahmouz_Ain    |
      | ودد  | Mithal_Wawi_Mudaaf         |
      | وءد  | Mithal_Wawi_Mahmouz_Ain    |
      | وجء  | Mithal_Wawi_Mahmouz_Laam   |
      | ءمم  | Mahmouz_Faa_Mudaaf         |
      | ءثء  | Mahmouz_Faa_Mahmouz_Laam   |
      | رمي  | Naqis_Yaee                 |
      | غزو  | Naqis_Wawi                 |
      | بيع  | Ajwaf_Yaee                 |
      | قوم  | Ajwaf_Wawi                 |
      | يسر  | Mithal_Yaee                |
      | وعد  | Mithal_Wawi                |
      | بدء  | Mahmouz_Laam               |
      | سءل  | Mahmouz_Ain                |
      | ءكل  | Mahmouz_Faa                |
      | مدد  | Mudaaf                     |
      | نصر  | Salim                      |


