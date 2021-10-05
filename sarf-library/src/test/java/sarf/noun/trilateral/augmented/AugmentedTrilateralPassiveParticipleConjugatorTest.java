package sarf.noun.trilateral.augmented;
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
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.trilateral.augmented.passiveparticiple.*;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AugmentedTrilateralPassiveParticipleConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private AugmentedTrilateralPassiveParticipleConjugator sut;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> getCreateNounListArguments() {
        return Stream.of(
                Arguments.of(1, NounFormula1.class),
                Arguments.of(2, NounFormula2.class),
                Arguments.of(3, NounFormula3.class),
                Arguments.of(4, NounFormula4.class),
                Arguments.of(5, NounFormula5.class),
                Arguments.of(6, NounFormula6.class),
                Arguments.of(7, NounFormula7.class),
                Arguments.of(8, NounFormula8.class),
                Arguments.of(9, NounFormula9.class),
                Arguments.of(10, NounFormula10.class),
                Arguments.of(11, NounFormula11.class),
                Arguments.of(12, NounFormula12.class)
        );
    }

    @ParameterizedTest(name = "{0} إسم ثلاثي مزيد مبني للمجهول")
    @MethodSource("getCreateNounListArguments")
    void createNounList(int formula, Class expected) {
        var root = new AugmentedTrilateralRoot();

        var actual = sut.createNounList(root, formula, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        for(var noun : actual){
            assertThat(noun).isInstanceOf(expected);
        }
    }

    @ParameterizedTest(name = "{0} إسم زمان أو مكان ثلاثي مزيد مبني للمجهول")
    @MethodSource("getCreateNounListArguments")
    void createTimeAndPlaceNounList(int formula, Class expected){
        var root = new AugmentedTrilateralRoot();

        var actual = sut.createTimeAndPlaceNounList(root, formula, genericNounSuffixContainer);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);

        var indexesToHaveExpectedClass = List.of(0, 2, 6, 8, 12, 14);
        for(var index : indexesToHaveExpectedClass){
            assertThat(actual.get(index)).isInstanceOf(expected);
        }

        for(var i = 1; i< 18; i++) {
            if (indexesToHaveExpectedClass.contains(i))
                continue;
            assertThat(actual.get(i)).isInstanceOf(AugmentedTrilateralPassiveParticipleConjugator.EmptyAugmentedTrilateralNoun.class);
        }
    }

    @ParameterizedTest(name = "{0} مصدر ميمي من ثلاثي مزيد مبني للمجهول")
    @MethodSource("getCreateNounListArguments")
    void createMeemGerundNounList(int formula, Class expected){
        var root = new AugmentedTrilateralRoot();

        var actual = sut.createMeemGerundNounList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);

        var indexesToHaveExpectedClass = List.of(0, 6, 12);
        for(var index : indexesToHaveExpectedClass){
            assertThat(actual.get(index)).isInstanceOf(expected);
        }

        for(var i = 1; i< 18; i++) {
            if (indexesToHaveExpectedClass.contains(i))
                continue;
            assertThat(actual.get(i)).isInstanceOf(AugmentedTrilateralPassiveParticipleConjugator.EmptyAugmentedTrilateralNoun.class);
        }
    }
}
