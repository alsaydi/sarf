package sarf.gerund.modifier.quadrilateral;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.*;
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
        when(vocalizer.isApplied(any(ConjugationResult.class))).thenReturn(isApplied);
        when(internalMahmouz.isApplied(any(ConjugationResult.class))).thenReturn(isApplied);
        when(endedMahmouz.isApplied(any(ConjugationResult.class))).thenReturn(isApplied);

        var root = new AugmentedQuadrilateralRoot();
        var kov = KindOfVerb.Salim;
        var formulaNo = 1;
        var conjugations = new ArrayList<Word>();

        var actual = sut.build(root, formulaNo, kov, conjugations);

        assertThat(actual).isNotNull();
        verify(vocalizer, times(1)).isApplied(any(ConjugationResult.class));
        verify(internalMahmouz, times(1)).isApplied(any(ConjugationResult.class));
        verify(endedMahmouz, times(1)).isApplied(any(ConjugationResult.class));

        var times = isApplied ? times(1) : never();
        verify(vocalizer, times).apply(anyList(), any(QuadrilateralRoot.class));
        verify(internalMahmouz, times).apply(anyList(), any(QuadrilateralRoot.class));
        verify(endedMahmouz, times).apply(anyList(), any(QuadrilateralRoot.class));

        verify(nounLamAlefModifier, times(1)).apply(any(ConjugationResult.class));
        verify(nounSunLamModifier, times(1)).apply(any(ConjugationResult.class));
    }
}