package sarf.verb.trilateral.augmented.active.past;
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
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.formula.*;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AugmentedActivePastConjugatorTest {

    @InjectMocks
    private AugmentedActivePastConjugator sut;

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> getCreateVerbTestParameters() {
        return Stream.of(
                Arguments.of(0, 1, AugmentedPastVerb1.class),
                Arguments.of(0, 2, AugmentedPastVerb2.class),
                Arguments.of(0, 3, AugmentedPastVerb3.class),
                Arguments.of(0, 4, AugmentedPastVerb4.class),
                Arguments.of(0, 5, AugmentedPastVerb5.class),
                Arguments.of(0, 6, AugmentedPastVerb6.class),
                Arguments.of(0, 7, AugmentedPastVerb7.class),
                Arguments.of(0, 8, AugmentedPastVerb8.class),
                Arguments.of(0, 9, AugmentedPastVerb9.class),
                Arguments.of(0, 10, AugmentedPastVerb10.class),
                Arguments.of(0, 11, AugmentedPastVerb11.class),
                Arguments.of(0, 12, AugmentedPastVerb12.class)
        );
    }

    @ParameterizedTest(name = "create verb of type {2}")
    @MethodSource("getCreateVerbTestParameters")
    void createVerb(int pronounIndex, int formulaNumber, Class expected) {
        var actual = sut.createVerb(new AugmentedTrilateralRoot(), pronounIndex, formulaNumber);
        assertThat(actual).isInstanceOf(expected);
    }

    @ParameterizedTest(name = "create verb list of type {2}")
    @MethodSource("getCreateVerbTestParameters")
    void createVerbList(int pronounIndex, int formulaNumber, Class expected) {
        var actual = sut.createVerbList(new AugmentedTrilateralRoot(), formulaNumber);
        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        for(var verb : actual){
            assertThat(verb).isInstanceOf(expected);
        }
    }
}
