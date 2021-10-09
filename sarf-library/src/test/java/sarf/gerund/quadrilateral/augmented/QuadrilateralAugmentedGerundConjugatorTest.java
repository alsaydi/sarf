package sarf.gerund.quadrilateral.augmented;
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
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern1;
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern2;
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern3;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static sarf.SystemConstants.NOUN_POSSIBLE_STATES;


class QuadrilateralAugmentedGerundConjugatorTest {
    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralAugmentedGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> createGerundListTestArguments() {
        return Stream.of(
                Arguments.of(1, GerundPattern1.class),
                Arguments.of(2, GerundPattern2.class),
                Arguments.of(3, GerundPattern3.class)
        );
    }

    @ParameterizedTest(name = "createGerundList test {1}")
    @MethodSource("createGerundListTestArguments")
    void createGerundListTest(int formulaNumber, Class expected) {
        var actual = sut.createGerundList(new AugmentedQuadrilateralRoot(), formulaNumber, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(NOUN_POSSIBLE_STATES);
        assertThat(actual.get(0)).isInstanceOf(expected);
        assertThat(actual.get(2)).isInstanceOf(expected);
        assertThat(actual.get(5)).isInstanceOf(expected);
        assertThat(actual.get(6)).isInstanceOf(expected);
        assertThat(actual.get(8)).isInstanceOf(expected);
        assertThat(actual.get(11)).isInstanceOf(expected);
        assertThat(actual.get(12)).isInstanceOf(expected);
        assertThat(actual.get(14)).isInstanceOf(expected);
        assertThat(actual.get(17)).isInstanceOf(expected);
    }
}
