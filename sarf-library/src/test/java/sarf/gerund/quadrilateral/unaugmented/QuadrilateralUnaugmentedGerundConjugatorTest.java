package sarf.gerund.quadrilateral.unaugmented;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class QuadrilateralUnaugmentedGerundConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralUnaugmentedGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void createGerundListTestForm1() {
        sut.setListener(new FakeQuadrilateralGerundFormSelector(1));
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('د');
        root.setC2('ح');
        root.setC3('ر');
        root.setC4('ج');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();

        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        verify(genericNounSuffixContainer, times(9)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
    }

    @Test
    void createGerundListTestForm2() {
        sut.setListener(new FakeQuadrilateralGerundFormSelector(2));
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('ز');
        root.setC2('ل');
        root.setC3('ز');
        root.setC4('ل');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();

        // private final int[] form2IndexList = {1, 3, 6, 7, 9, 12, 13, 15, 18};
        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        verify(genericNounSuffixContainer, times(9)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
    }

    private static class FakeQuadrilateralGerundFormSelector implements QuadrilateralUnaugmentedGerundConjugatorListener {
        private final int form;
        FakeQuadrilateralGerundFormSelector(int form){
            this.form = form;
        }
        @Override
        public int selectFormNo() {
            return form;
        }
    }
}