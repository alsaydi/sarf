package sarf.verb.trilateral.augmented.passive.past;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.AugmentationFormula;
import sarf.PastConjugationDataContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.passive.past.formula.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AugmentedPassivePastConjugatorTest {
    @InjectMocks
    private AugmentedPassivePastConjugator sut;

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private static Stream<Arguments> getCreateVerbListArguments() {
        return Stream.of(
                Arguments.of(1, AugmentedPastVerb1.class),
                Arguments.of(2, AugmentedPastVerb2.class),
                Arguments.of(3, AugmentedPastVerb3.class),
                Arguments.of(4, AugmentedPastVerb4.class),
                Arguments.of(5, AugmentedPastVerb5.class),
                Arguments.of(6, AugmentedPastVerb6.class),
                Arguments.of(7, AugmentedPastVerb7.class),
                Arguments.of(8, AugmentedPastVerb8.class),
                Arguments.of(9, AugmentedPastVerb9.class),
                Arguments.of(10, AugmentedPastVerb10.class),
                Arguments.of(11, AugmentedPastVerb11.class),
                Arguments.of(12, AugmentedPastVerb12.class)
        );
    }

    @ParameterizedTest(name = "{0} تصريف الفعل الثلاثي المزيد المبني للمجهول")
    @MethodSource("getCreateVerbListArguments")
    void createVerbList(int formula, Class expected) {
        var root = new AugmentedTrilateralRoot();
        var augmentationFormula = new AugmentationFormula();
        augmentationFormula.setFormulaNo(formula);
        root.addAugmentationFormula(augmentationFormula);

        var actual = sut.createVerbList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        for(var verb : actual){
            assertThat(verb).isInstanceOf(expected);
        }
    }

    @ParameterizedTest(name = "{0} تصريف الفعل الثلاثي المزيد المبني للمجهول")
    @MethodSource("getCreateVerbListArguments")
    void createLazzemVerbList(int formula, Class expected) {
        var root = new AugmentedTrilateralRoot();
        var augmentationFormula = new AugmentationFormula();
        augmentationFormula.setFormulaNo(formula);
        augmentationFormula.setTransitive('ل');
        root.addAugmentationFormula(augmentationFormula);

        var actual = sut.createVerbList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        for(var i = 0; i < actual.size(); i++){
            if(i == 7 || i == 8){
                assertThat(actual.get(i)).isInstanceOf(expected);
            }else{
                assertThat(actual.get(i)).isNull();
            }
        }
    }
}
