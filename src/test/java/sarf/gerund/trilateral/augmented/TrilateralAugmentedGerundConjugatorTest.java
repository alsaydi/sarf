package sarf.gerund.trilateral.augmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;

import static org.assertj.core.api.Assertions.assertThat;

class TrilateralAugmentedGerundConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @Mock
    private FormulaApplyingChecker formulaApplyingCheckerMock;

    @InjectMocks
    TrilateralAugmentedGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void createGerundList() {
        assertThat(sut).isNotNull();
    }
}