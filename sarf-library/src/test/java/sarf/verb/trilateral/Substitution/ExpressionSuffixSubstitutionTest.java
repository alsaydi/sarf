package sarf.verb.trilateral.Substitution;
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
import org.junit.jupiter.api.Test;
import sarf.Word;
import sarf.WordPresenter;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionSuffixSubstitutionTest {

    @Test
    void nullWord_apply_returnsNull() {
        var sut = new ExpressionSuffixSubstitution("C1", "C1C1");

        var actual = sut.apply(null, new UnaugmentedTrilateralRoot());

        assertNull(actual);
    }

    @Test
    void emptyWord_apply_returnsNull() {
        var sut = new ExpressionSuffixSubstitution("C1", "C1C1");

        var actual = sut.apply(WordPresenter.Empty, new UnaugmentedTrilateralRoot());

        assertNull(actual);
    }

    @Test
    void applyTest() {
        var sut = new ExpressionSuffixSubstitution("C3", "C3C3");

        var root = new UnaugmentedTrilateralRoot();
        root.setC1('ف');
        root.setC2('ع');
        root.setC3('ل');

        var actual = sut.apply(WordPresenter.fromText("تفعل"), root);

        assertEquals(WordPresenter.fromText("تفعلل"), actual);
    }
}