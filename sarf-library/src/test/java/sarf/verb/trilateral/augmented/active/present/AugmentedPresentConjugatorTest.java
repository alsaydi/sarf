package sarf.verb.trilateral.augmented.active.present;
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
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.present.formula.*;


import static org.assertj.core.api.Assertions.assertThat;

class AugmentedPresentConjugatorTest {
    private static Stream<Arguments> getCreateVerbListTestArguments() {
        var nominativeConjugator = new AugmentedActivePresentConjugator().getNominativeConjugator();
        var accusativeConjugator = new AugmentedActivePresentConjugator().getAccusativeConjugator();
        var emphasizedConjugator = new AugmentedActivePresentConjugator().getEmphasizedConjugator();
        var jussiveConjugator = new AugmentedActivePresentConjugator().getJussiveConjugator();

        return Stream.of(
                Arguments.of(nominativeConjugator, 1 , AugmentedPresentVerb1.class),
                Arguments.of(nominativeConjugator, 2 , AugmentedPresentVerb2.class),
                Arguments.of(nominativeConjugator, 3 , AugmentedPresentVerb3.class),
                Arguments.of(nominativeConjugator, 4 , AugmentedPresentVerb4.class),
                Arguments.of(nominativeConjugator, 5 , AugmentedPresentVerb5.class),
                Arguments.of(nominativeConjugator, 6 , AugmentedPresentVerb6.class),
                Arguments.of(nominativeConjugator, 7 , AugmentedPresentVerb7.class),
                Arguments.of(nominativeConjugator, 8 , AugmentedPresentVerb8.class),
                Arguments.of(nominativeConjugator, 9 , AugmentedPresentVerb9.class),
                Arguments.of(nominativeConjugator, 10 , AugmentedPresentVerb10.class),
                Arguments.of(nominativeConjugator, 11 , AugmentedPresentVerb11.class),
                Arguments.of(nominativeConjugator, 12 , AugmentedPresentVerb12.class),

                Arguments.of(accusativeConjugator, 1 , AugmentedPresentVerb1.class),
                Arguments.of(accusativeConjugator, 2 , AugmentedPresentVerb2.class),
                Arguments.of(accusativeConjugator, 3 , AugmentedPresentVerb3.class),
                Arguments.of(accusativeConjugator, 4 , AugmentedPresentVerb4.class),
                Arguments.of(accusativeConjugator, 5 , AugmentedPresentVerb5.class),
                Arguments.of(accusativeConjugator, 6 , AugmentedPresentVerb6.class),
                Arguments.of(accusativeConjugator, 7 , AugmentedPresentVerb7.class),
                Arguments.of(accusativeConjugator, 8 , AugmentedPresentVerb8.class),
                Arguments.of(accusativeConjugator, 9 , AugmentedPresentVerb9.class),
                Arguments.of(accusativeConjugator, 10 , AugmentedPresentVerb10.class),
                Arguments.of(accusativeConjugator, 11 , AugmentedPresentVerb11.class),
                Arguments.of(accusativeConjugator, 12 , AugmentedPresentVerb12.class),

                Arguments.of(emphasizedConjugator, 1 , AugmentedPresentVerb1.class),
                Arguments.of(emphasizedConjugator, 2 , AugmentedPresentVerb2.class),
                Arguments.of(emphasizedConjugator, 3 , AugmentedPresentVerb3.class),
                Arguments.of(emphasizedConjugator, 4 , AugmentedPresentVerb4.class),
                Arguments.of(emphasizedConjugator, 5 , AugmentedPresentVerb5.class),
                Arguments.of(emphasizedConjugator, 6 , AugmentedPresentVerb6.class),
                Arguments.of(emphasizedConjugator, 7 , AugmentedPresentVerb7.class),
                Arguments.of(emphasizedConjugator, 8 , AugmentedPresentVerb8.class),
                Arguments.of(emphasizedConjugator, 9 , AugmentedPresentVerb9.class),
                Arguments.of(emphasizedConjugator, 10 , AugmentedPresentVerb10.class),
                Arguments.of(emphasizedConjugator, 11 , AugmentedPresentVerb11.class),
                Arguments.of(emphasizedConjugator, 12 , AugmentedPresentVerb12.class),

                Arguments.of(jussiveConjugator, 1 , AugmentedPresentVerb1.class),
                Arguments.of(jussiveConjugator, 2 , AugmentedPresentVerb2.class),
                Arguments.of(jussiveConjugator, 3 , AugmentedPresentVerb3.class),
                Arguments.of(jussiveConjugator, 4 , AugmentedPresentVerb4.class),
                Arguments.of(jussiveConjugator, 5 , AugmentedPresentVerb5.class),
                Arguments.of(jussiveConjugator, 6 , AugmentedPresentVerb6.class),
                Arguments.of(jussiveConjugator, 7 , AugmentedPresentVerb7.class),
                Arguments.of(jussiveConjugator, 8 , AugmentedPresentVerb8.class),
                Arguments.of(jussiveConjugator, 9 , AugmentedPresentVerb9.class),
                Arguments.of(jussiveConjugator, 10 , AugmentedPresentVerb10.class),
                Arguments.of(jussiveConjugator, 11 , AugmentedPresentVerb11.class),
                Arguments.of(jussiveConjugator, 12 , AugmentedPresentVerb12.class)
        );
    }

    @ParameterizedTest(name = "create verb lis test {index} {2}")
    @MethodSource("getCreateVerbListTestArguments")
    void createVerbListTest(AugmentedPresentConjugator sut, int formulaNo, Class expected) {
        var verbList = sut.createVerbList(new AugmentedTrilateralRoot(), formulaNo);
        assertThat(SystemConstants.PRONOUN_RANGE_END).isEqualTo(13);
        assertThat(verbList.size()).isEqualTo(SystemConstants.PRONOUN_RANGE_END);
        for (var v : verbList) {
            assertThat(v).isInstanceOf(expected);
        }
    }
}
