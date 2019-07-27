package sarf.verb.trilateral.augmented.active.past;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.formula.*;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AugmentedActivePastConjugatorTest {

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
        var sut = AugmentedActivePastConjugator.getInstance();

        var actual = sut.createVerb(new AugmentedTrilateralRoot(), pronounIndex, formulaNumber);
        assertThat(actual).isInstanceOf(expected);
    }
}