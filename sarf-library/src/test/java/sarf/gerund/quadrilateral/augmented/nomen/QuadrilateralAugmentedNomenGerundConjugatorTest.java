package sarf.gerund.quadrilateral.augmented.nomen;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern1;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern2;
import sarf.gerund.quadrilateral.augmented.nomen.pattern.GerundPattern3;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralAugmentedNomenGerundConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralAugmentedNomenGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> getCreateGerundListTestArguments() {
        return Stream.of(
                Arguments.of(1, GerundPattern1.class),
                Arguments.of(2, GerundPattern2.class),
                Arguments.of(3, GerundPattern3.class)
        );
    }

    @ParameterizedTest(name = "createGerundListTest for {1}")
    @MethodSource("getCreateGerundListTestArguments")
    void createGerundListTest(int formulaNumber, Class expected) {
        var actual = sut.createGerundList(new AugmentedQuadrilateralRoot(), formulaNumber);

        assertThat(actual).isNotNull();
        assertThat(actual.get(1)).isInstanceOf(expected);
        assertThat(actual.get(3)).isInstanceOf(expected);
        assertThat(actual.get(5)).isInstanceOf(expected);
        assertThat(actual.get(7)).isInstanceOf(expected);
        assertThat(actual.get(9)).isInstanceOf(expected);
        assertThat(actual.get(11)).isInstanceOf(expected);
        assertThat(actual.get(13)).isInstanceOf(expected);
        assertThat(actual.get(15)).isInstanceOf(expected);
        assertThat(actual.get(17)).isInstanceOf(expected);

        assertThat(actual.stream().filter(Objects::isNull).count()).isEqualTo(0);
        assertThat(actual.stream().filter(i -> !expected.isInstance(i)).count()).isEqualTo(9);
    }
}