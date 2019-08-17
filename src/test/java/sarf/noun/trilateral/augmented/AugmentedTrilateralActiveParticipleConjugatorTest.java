package sarf.noun.trilateral.augmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula1;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula2;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula3;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula4;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula5;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula6;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula7;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula8;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula9;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula10;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula11;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula12;

import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AugmentedTrilateralActiveParticipleConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private AugmentedTrilateralActiveParticipleConjugator sut;

    @BeforeEach
    void setup(){
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

    @ParameterizedTest(name = "createNounList-اسم الفاعل-{0}")
    @MethodSource("getCreateNounListArguments")
    void createN8unList(int formulaNo, Class expected) {
        var actual = sut.createNounList(new AugmentedTrilateralRoot(), formulaNo);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);

        assertThat(actual).allMatch(Objects::nonNull);
        assertThat(actual).allMatch(e -> e.getClass().equals(expected));
    }
}