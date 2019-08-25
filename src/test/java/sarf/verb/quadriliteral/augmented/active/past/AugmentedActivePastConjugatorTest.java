package sarf.verb.quadriliteral.augmented.active.past;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.junit.jupiter.api.Assertions.*;

class AugmentedActivePastConjugatorTest {

    @InjectMocks
    private AugmentedActivePastConjugator sut;
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
