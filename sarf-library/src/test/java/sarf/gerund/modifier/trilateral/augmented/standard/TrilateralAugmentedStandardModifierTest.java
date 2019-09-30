package sarf.gerund.modifier.trilateral.augmented.standard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.*;
import sarf.noun.trilateral.augmented.modifier.Substituter;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TrilateralAugmentedStandardModifierTest {
    @InjectMocks
    private TrilateralAugmentedStandardModifier sut;
    @Mock
    private Geminator geminator;
    @Mock
    private Vocalizer vocalizer;
    @Mock
    private Mahmouz mahmouz;
    @Mock
    private Substituter substituter;
    @Mock
    private FormulaApplyingChecker formulaApplyingChecker;
    @Mock
    private NounLamAlefModifier nounLamAlefModifier;
    @Mock
    private NounSunLamModifier nounSunLamModifier;

    @Mock
    AugmentedTrilateralModifierListener augmentedTrilateralModifierListener;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void build() {
        var root = new AugmentedTrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var result = sut.build(root, kov, formulaNo, conjugations, augmentedTrilateralModifierListener);

        assertThat(result).isNotNull();
        verify(substituter, times(1)).apply(any(ConjugationResult.class));
        verify(geminator, times(1)).apply(any(ConjugationResult.class));
        verify(formulaApplyingChecker, times(1)).check(root, formulaNo);
        verify(vocalizer, times(1)).apply(any(ConjugationResult.class));
        verify(mahmouz, times(1)).apply(any(ConjugationResult.class));
        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }

    @Test
    void formulaApplyingCheckerReturnsNotVocalized_build_VocalizationNotApplied() {
        when(formulaApplyingChecker.check(any(AugmentedTrilateralRoot.class), anyInt())).thenReturn(IFormulaApplyingChecker.NOT_VOCALIZED);
        var root = new AugmentedTrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var result = sut.build(root, kov, formulaNo, conjugations, augmentedTrilateralModifierListener);

        assertThat(result).isNotNull();
        verify(substituter, times(1)).apply(any(ConjugationResult.class));
        verify(geminator, times(1)).apply(any(ConjugationResult.class));
        verify(formulaApplyingChecker, times(1)).check(root, formulaNo);
        verify(vocalizer, never()).apply(any(ConjugationResult.class));
        verify(mahmouz, times(1)).apply(any(ConjugationResult.class));
        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }

    @Test
    void formulaApplyingCheckerReturnsTwoStateAndNoListener_build_VocalizationApplied() {
        when(formulaApplyingChecker.check(any(AugmentedTrilateralRoot.class), anyInt())).thenReturn(IFormulaApplyingChecker.TWO_STATE);
        var root = new AugmentedTrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var result = sut.build(root, kov, formulaNo, conjugations, null);

        assertThat(result).isNotNull();
        verify(substituter, times(1)).apply(any(ConjugationResult.class));
        verify(geminator, times(1)).apply(any(ConjugationResult.class));
        verify(formulaApplyingChecker, times(1)).check(root, formulaNo);
        verify(vocalizer, times(1)).apply(any(ConjugationResult.class));
        verify(mahmouz, times(1)).apply(any(ConjugationResult.class));
        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }

    @Test
    void formulaApplyingCheckerReturnsTwoStateAndListenerReturnsTrue_build_VocalizationApplied() {
        when(formulaApplyingChecker.check(any(AugmentedTrilateralRoot.class), anyInt())).thenReturn(IFormulaApplyingChecker.TWO_STATE);
        when(augmentedTrilateralModifierListener.doSelectVocalization()).thenReturn(true);
        var root = new AugmentedTrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var result = sut.build(root, kov, formulaNo, conjugations, augmentedTrilateralModifierListener);

        assertThat(result).isNotNull();
        verify(substituter, times(1)).apply(any(ConjugationResult.class));
        verify(geminator, times(1)).apply(any(ConjugationResult.class));
        verify(formulaApplyingChecker, times(1)).check(root, formulaNo);
        verify(vocalizer, times(1)).apply(any(ConjugationResult.class));
        verify(mahmouz, times(1)).apply(any(ConjugationResult.class));
        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }

    @Test
    void formulaApplyingCheckerReturnsTwoStateAndListenerReturnsFalse_build_VocalizationNotApplied() {
        when(formulaApplyingChecker.check(any(AugmentedTrilateralRoot.class), anyInt())).thenReturn(IFormulaApplyingChecker.TWO_STATE);
        when(augmentedTrilateralModifierListener.doSelectVocalization()).thenReturn(false);
        var root = new AugmentedTrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var result = sut.build(root, kov, formulaNo, conjugations, augmentedTrilateralModifierListener);

        assertThat(result).isNotNull();
        verify(substituter, times(1)).apply(any(ConjugationResult.class));
        verify(geminator, times(1)).apply(any(ConjugationResult.class));
        verify(formulaApplyingChecker, times(1)).check(root, formulaNo);
        verify(vocalizer, never()).apply(any(ConjugationResult.class));
        verify(mahmouz, times(1)).apply(any(ConjugationResult.class));
        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }
}