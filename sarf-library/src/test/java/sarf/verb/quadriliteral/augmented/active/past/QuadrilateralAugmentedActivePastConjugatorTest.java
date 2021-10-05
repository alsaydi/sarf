package sarf.verb.quadriliteral.augmented.active.past;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.PastConjugationDataContainer;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb1;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb2;
import sarf.verb.quadriliteral.augmented.active.past.formula.AugmentedPastVerb3;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuadrilateralAugmentedActivePastConjugatorTest {

    @InjectMocks
    private QuadrilateralAugmentedActivePastConjugator sut;
    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    private static Stream<Arguments> getCreateVerbListArguments() {
        return Stream.of(
                Arguments.of(1, AugmentedPastVerb1.class),
                Arguments.of(2, AugmentedPastVerb2.class),
                Arguments.of(3, AugmentedPastVerb3.class)
        );
    }

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest(name = "تصريف الفعل الرباعي المزيد المبني للمعلوم {0}")
    @MethodSource("getCreateVerbListArguments")
    void createVerbList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createVerbList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.PRONOUN_RANGE_END);
        for(var verb: actual){
            assertThat(verb).isInstanceOf(expected);
        }
    }

    @ParameterizedTest(name = "تصريف الفعل الرباعي المزيد المبني للمعلوم {0}")
    @MethodSource("getCreateVerbListArguments")
    void createVerb(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createVerb(root, 0, formula);
        assertThat(actual).isNotNull();
        assertThat(actual).isInstanceOf(expected);
    }
}
