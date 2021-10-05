package sarf.gerund.trilateral.augmented;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;

import java.text.Collator;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TrilateralAugmentedGerundConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @Mock
    private FormulaApplyingChecker formulaApplyingCheckerMock;

    @InjectMocks
    TrilateralAugmentedGerundConjugator sut;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
        when(genericNounSuffixContainer.getPrefix()).thenReturn("");
    }

    @Test
    void createGerundList() {
        var root = new AugmentedTrilateralRoot();

        var actual = sut.createGerundList(root, 1);

        assertThat(actual).isNotNull();
    }

    @Test
    void vocalizationApplicableFormula_createGerundList_checksForApplyingVocalization() {
        var formula = 1;
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);

        var verb = "دخل";
        var root = new AugmentedTrilateralRoot();
        root.setC1(verb.charAt(0));
        root.setC2(verb.charAt(1));
        root.setC3(verb.charAt(2));

        when(formulaApplyingCheckerMock.check(root, formula)).thenReturn(IFormulaApplyingChecker.TWO_STATE);
        sut.setListener(formulaNo -> 1);
        sut.setAugmentedTrilateralModifierListener(() -> true);

        var actual = sut.createGerundList(root, formula);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);

        var forms = actual.stream().map(TrilateralAugmentedGerund::toString).collect(Collectors.toList());
        assertThat(forms.get(0)).usingComparator(collator).isEqualTo("إدخال");
    }
}