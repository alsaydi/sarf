package sarf.gerund.modifier.quadrilateral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;
import sarf.verb.quadriliteral.QuadriConjugationResult;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class QuadrilateralStandardModifierTest {

    @InjectMocks
    private QuadrilateralStandardModifier sut;

    @Mock
    private NounLamAlefModifier nounLamAlefModifier;
    @Mock
    private NounSunLamModifier nounSunLamModifier;
    @Mock
    private Vocalizer vocalizer;
    @Mock
    private InternalMahmouz internalMahmouz;
    @Mock
    private EndedMahmouz endedMahmouz;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @ParameterizedTest(name= "Quadrilateral Standard Modifier Test {0}")
    @ValueSource(booleans = {true, false})
    void build(boolean isApplied) {
        when(vocalizer.isApplied(any(QuadriConjugationResult.class))).thenReturn(isApplied);
        when(internalMahmouz.isApplied(any(QuadriConjugationResult.class))).thenReturn(isApplied);
        when(endedMahmouz.isApplied(any(QuadriConjugationResult.class))).thenReturn(isApplied);

        var root = new AugmentedQuadrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<String>();

        var actual = sut.build(root, formulaNo, kov, conjugations);

        assertThat(actual).isNotNull();
        verify(vocalizer, times(1)).isApplied(any(QuadriConjugationResult.class));
        verify(internalMahmouz, times(1)).isApplied(any(QuadriConjugationResult.class));
        verify(endedMahmouz, times(1)).isApplied(any(QuadriConjugationResult.class));

        var times = isApplied ? times(1) : never();
        verify(vocalizer, times).apply(anyList(), any(QuadrilateralRoot.class));
        verify(internalMahmouz, times).apply(anyList(), any(QuadrilateralRoot.class));
        verify(endedMahmouz, times).apply(anyList(), any(QuadrilateralRoot.class));

        verify(nounLamAlefModifier, times(1)).apply(any(QuadriConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(QuadriConjugationResult.class));
    }
}