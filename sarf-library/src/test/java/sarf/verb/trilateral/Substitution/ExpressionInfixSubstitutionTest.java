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
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ExpressionInfixSubstitutionTest {

    @Test
    void wordIsEmptyRegardlessOfRoot_apply_returnsNull() {
        var sut = new ExpressionInfixSubstitution("C2C3", "C3ّ");

        var actual = sut.apply(WordPresenter.Empty, null);

        assertNull(actual);
    }

    @Test
    void wordIsNullRegardlessOfRoot_apply_returnsNull() {
        var sut = new ExpressionInfixSubstitution("C2C3", "C3ّ");

        var actual = sut.apply(null, null);

        assertNull(actual);
    }

    @Test
    void applyTest() {
        var sut = new ExpressionInfixSubstitution("C3C3", "C3ّ");

        var root = new UnaugmentedTrilateralRoot();
        root.setC1('ح');
        root.setC2('ب');
        root.setC3('ب');

        var actual = sut.apply(WordPresenter.fromText("أحبب"), root);

        assertEquals(WordPresenter.fromText("أحبّ"), actual);
    }
}