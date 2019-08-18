package sarf.noun.quadriliteral.augmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula1;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula2;
import sarf.noun.quadriliteral.augmented.activeparticiple.NounFormula3;
import sarf.noun.trilateral.augmented.activeparticiple.NounFormula4;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class AugmentedQuadrilateralActiveParticipleConjugatorTest {

    @InjectMocks
    private AugmentedQuadrilateralActiveParticipleConjugator sut;

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

    @ParameterizedTest(name = "اسم الفاعل الرباعي المزيد {0}")
    @MethodSource("getCreateNounListArguments")
    void createNounList(int formula, Class expected) {
        var root = new AugmentedQuadrilateralRoot();

        var actual = sut.createNounList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        for(var noun : actual){
            assertThat(noun).isInstanceOf(expected);
        }
    }
}
