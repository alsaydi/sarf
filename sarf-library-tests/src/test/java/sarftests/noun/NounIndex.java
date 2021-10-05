package sarftests.noun;
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
public enum NounIndex {
    NominativeSingleMasculine (0),
    NominativeSingleFeminine(1),
    NominativeDualMasculine(2),
    NominativeDualFeminine(3),
    NominativePluralMasculine(4),
    NominativePluralFeminine(5),
    AccusativeSingleMasculine (6),
    AccusativeSingleFeminine(7),
    AccusativeDualMasculine(8),
    AccusativeDualFeminine(9),
    AccusativePluralMasculine(10),
    AccusativePluralFeminine(11),
    GenitiveSingleMasculine (12),
    GenitiveSingleFeminine(13),
    GenitiveDualMasculine(14),
    GenitiveDualFeminine(15),
    GenitivePluralMasculine(16),
    GenitivePluralFeminine(17);

    private final int value;
    NounIndex(int value){
        this.value = value;
    }

    public int getValue(){return value;}
}
