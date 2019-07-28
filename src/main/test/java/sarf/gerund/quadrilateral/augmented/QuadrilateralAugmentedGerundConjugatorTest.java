package sarf.gerund.quadrilateral.augmented;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern1;
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern2;
import sarf.gerund.quadrilateral.augmented.pattern.GerundPattern3;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static sarf.SystemConstants.NOUN_POSSIBLE_STATES;


class QuadrilateralAugmentedGerundConjugatorTest {

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
        var sut = QuadriliteralAugmentedGerundConjugator.getInstance();

        var actual = sut.createGerundList(new AugmentedQuadrilateralRoot(), formulaNumber);

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
