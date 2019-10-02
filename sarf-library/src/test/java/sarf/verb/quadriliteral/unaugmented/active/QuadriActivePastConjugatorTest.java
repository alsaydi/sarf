package sarf.verb.quadriliteral.unaugmented.active;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.PastConjugationDataContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class QuadriActivePastConjugatorTest {

    @InjectMocks
    private QuadriActivePastConjugator sut;

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createVerb() {
        var verb = sut.createVerb(0, new UnaugmentedQuadrilateralRoot());

        assertThat(verb).isNotNull();
        verify(pastConjugationDataContainer, times(1)).getLastDpa(0);
        verify(pastConjugationDataContainer, times(1)).getConnectedPronoun(0);
    }

    @Test
    void createVerbList() {
        var actual = sut.createVerbList(new UnaugmentedQuadrilateralRoot());

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
        verify(pastConjugationDataContainer, times(1)).getLastDpa(0);
        verify(pastConjugationDataContainer, times(1)).getConnectedPronoun(0);
    }
}