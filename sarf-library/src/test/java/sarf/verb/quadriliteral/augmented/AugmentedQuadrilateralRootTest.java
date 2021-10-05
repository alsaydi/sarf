package sarf.verb.quadriliteral.augmented;
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
import sarf.AugmentationFormula;
import sarf.verb.RootLetter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AugmentedQuadrilateralRootTest {

    @Test
    void getCharacters() {
        var sut = new AugmentedQuadrilateralRoot();
        sut.setC1('f');
        sut.setC2('d');
        sut.setC3('c');
        sut.setC4('r');

        assertThat(sut.getCharacters().stream().map(RootLetter::getValue)).containsExactly('f','d','c', 'r');
    }

    @Test
    void addAugmentationFormula() {
        var sut = new AugmentedQuadrilateralRoot();
        assertThat(sut.getAugmentationList()).isEmpty();

        sut.addAugmentationFormula(new AugmentationFormula());

        assertThat(sut.getAugmentationList().size()).isEqualTo(1);
    }

    @Test
    void getAugmentationFormula() {
        var sut = new AugmentedQuadrilateralRoot();
        assertThat(sut.getAugmentationList()).isEmpty();
        var formula = new AugmentationFormula();
        formula.setFormulaNo(1);
        sut.addAugmentationFormula(formula);

        assertThat(sut.getAugmentationFormula(1)).isSameAs(formula);
    }
}