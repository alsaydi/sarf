package sarf.gerund.quadrilateral.unaugmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import sarf.SystemConstants;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.text.Collator;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class QuadrilateralUnaugmentedNomenGerundConjugatorTest {
    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralUnaugmentedNomenGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        when(genericNounSuffixContainer.getPrefix()).thenReturn("");
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
    }

    @Test
    void createGerundListTest() {
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('س');
        root.setC2('م');
        root.setC3('ع');
        root.setC4('ل');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();
        //final int[] indexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};

        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        assertThat(actual.stream().filter(g -> collator.compare(g.toString(), "سمعل") == 0).count()).isEqualTo(9);
        verify(genericNounSuffixContainer, times(1)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
    }
}