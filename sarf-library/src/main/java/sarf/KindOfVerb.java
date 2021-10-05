package sarf;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public enum KindOfVerb {
    None(-1), //TODO: change to zero
    Salim(1), /* سالم  -- كتب */
    Mudaaf(2), /* مضعف -- مرّ*/

    Mahmouz_Faa_Mudaaf(3), /* مهموز الفاء المضعف -- أمَّ */
    Mahmouz_Faa_Mahmouz_Laam(4), /* مهموز الفاء مهموز اللام -- أثأ */
    Mahmouz_Faa(5), /* مهموز الفاء -- أكل */
    Mahmouz_Ain(6), /* مهموز العين -- سأل */
    Mahmouz_Laam(7), /* مهموز اللام  -- بدأ */

    Mithal_Wawi_Mudaaf(8), /* مثال واوي مضعف -- ودَّ */
    Mithal_Wawi_Mahmouz_Ain(9), /* مثال واوي مهموز العين -- وأل (بمعنى لجأ) */
    Mithal_Wawi_Mahmouz_Laam(10), /* مثال واوي مهموز اللام -- وجأ */
    Mithal_Wawi(11), /* مثال واوي -- وثب */

    Mithal_Yaee_Mudaaf(12), /* مثال يائي مضعف  -- ير (إذا حميت الشمس على حجر أو شي صلب) */
    Mithal_Yaee_Mahmouz_Ain(13), /* مثال يائي مهموز العين يأس */
    Mithal_Yaee(14), /* مثال يائي -- ينع (نضج) */

    Ajwaf_Wawi_Mahmouz_Faa(15), /* أجوف واوي مهموز الفاء -- أود (بكسر الواو إعوج و بابه طرب) */
    Ajwaf_Wawi_Mahmouz_Laam(16), /* أجوف واوي مهموز اللام -- باء */
    Ajwaf_Wawi(17), /* أجوف واوي -- قام */

    Ajwaf_Yaee_Mahmouz_Faa(18), /* أجوف يائي مهموز الفاء -- آن */
    Ajwaf_Yaee_Mahmouz_Laam(19), /* أجوف يائي مهموز اللام -- شاء */
    Ajwaf_Yaee(20), /* أجوف يائي --  كال */

    Naqis_Wawi_Mahmouz_Faa(21), /* ناقص واوي مهموز الفاء --  أسا */
    Naqis_Wawi_Mahmouz_Ain(22), /* ناقص واوي مهموز العين -- رأى */
    Naqis_Wawi(23), /* ناقص واوي -- سها */

    Naqis_Yaee_Mahmouz_Faa(24), /* ناقص يائي مهموز الفاء -- أبى */
    Naqis_Yaee_Mahmouz_Ain(25), /* ناقص يائي مهموز العين -- رأى */
    Naqis_Yaee(26), /* ناقص يائي -- جرى */

    Lafeef_Maqroon_Mahmouz_Faa(27), /* لفيف مقرون مهموز الفاء -- أوى */
    Lafeef_Maqroon(28), /* لفيف مقرون -- نوى */

    Lafeef_Mafrooq_Mahmouz_Ain(29), /* لفيف مفروق مهموز العين -- وأى */
    Lafeef_Mafrooq(30); /* لفيف مفروق -- وسى ؟ */


    private final int value;
    KindOfVerb(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
