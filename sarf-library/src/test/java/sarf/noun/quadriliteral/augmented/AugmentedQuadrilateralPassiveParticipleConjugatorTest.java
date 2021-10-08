package sarf.noun.quadriliteral.augmented;
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
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula1;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula2;
import sarf.noun.quadriliteral.augmented.passiveparticiple.NounFormula3;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class AugmentedQuadrilateralPassiveParticipleConjugatorTest {

    @InjectMocks
    private AugmentedQuadrilateralPassiveParticipleConjugator sut;

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
    }

    private static Stream<Arguments> getCreateNounListArguments() {
        return Stream.of(
                Arguments.of(1, NounFormula1.class),
                Arguments.of(2, NounFormula2.class),
                Arguments.of(3, NounFormula3.class)
        );
    }

    @ParameterizedTest(name = "{0} اسم المفعول من الرباعي المزيد")
    @MethodSource("getCreateNounListArguments")
    void createNounList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createNounList(root, formula, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        for(var noun : actual){
            assertThat(noun).isInstanceOf(expected);
        }
    }

    @ParameterizedTest(name = "{0} اسم الزمان و المكان من الرباعي المزيد")
    @MethodSource("getCreateNounListArguments")
    void createTimeAndPlaceNounList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createTimeAndPlaceNounList(root, formula, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);

        var expectedIndexes = new int[]{0, 2, 6, 8, 12, 14};
        for (var index : expectedIndexes) {
            assertThat(actual.get(index)).isInstanceOf(expected);
        }

        var emptyNouns = actual.stream()
                .filter(noun -> !noun.getClass().equals(expected)).collect(Collectors.toList());
        assertThat(emptyNouns.size()).isEqualTo(12);
        emptyNouns.forEach(
                noun -> assertThat(noun).isInstanceOf(AugmentedQuadrilateralPassiveParticipleConjugator.EmptyAugmentedQuadrilateralNoun.class)
        );
    }

    @ParameterizedTest(name = "{0} المصدر الميمي من الرباعي المزيد")
    @MethodSource("getCreateNounListArguments")
    void createMeemGerundNounList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createMeemGerundNounList(root, formula, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);

        var expectedIndexes = new int[]{0, 6, 12};
        for (var index : expectedIndexes) {
            assertThat(actual.get(index)).isInstanceOf(expected);
        }

        var emptyNouns = actual.stream()
                .filter(noun -> !noun.getClass().equals(expected)).collect(Collectors.toList());
        assertThat(emptyNouns.size()).isEqualTo(15);
        emptyNouns.forEach(
                noun -> assertThat(noun).isInstanceOf(AugmentedQuadrilateralPassiveParticipleConjugator.EmptyAugmentedQuadrilateralNoun.class)
        );
    }
}