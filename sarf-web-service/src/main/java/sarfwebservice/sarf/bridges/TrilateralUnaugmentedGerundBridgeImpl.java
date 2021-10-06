package sarfwebservice.sarf.bridges;/*
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrilateralUnaugmentedGerundBridgeImpl implements TrilateralUnaugmentedGerundBridge {

    private final TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator;
    private final UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier;
    private final MeemGerundConjugator meemGerundConjugator;
    private final TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier;
    private final TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator;
    private final TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier;
    private final QualityGerundConjugator qualityGerundConjugator;
    private final TrilateralUnaugmentedQualityModifier trilateralUnaugmentedQualityModifier;
    private final SuffixContainerFactory suffixContainerFactory;

    @Autowired
    public TrilateralUnaugmentedGerundBridgeImpl(TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator
            , UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier
            , MeemGerundConjugator meemGerundConjugator
            , TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier
            , TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator
            , TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier
            , QualityGerundConjugator qualityGerundConjugator
            , TrilateralUnaugmentedQualityModifier trilateralUnaugmentedQualityModifier
            , SuffixContainerFactory suffixContainerFactory)
    {
        this.trilateralUnaugmentedGerundConjugator = trilateralUnaugmentedGerundConjugator;
        this.unaugmentedTrilateralStandardGerundModifier = unaugmentedTrilateralStandardGerundModifier;
        this.meemGerundConjugator = meemGerundConjugator;
        this.trilateralUnaugmentedMeemModifier = trilateralUnaugmentedMeemModifier;
        this.trilateralUnaugmentedNomenGerundConjugator = trilateralUnaugmentedNomenGerundConjugator;
        this.trilateralUnaugmentedNomenModifier = trilateralUnaugmentedNomenModifier;
        this.qualityGerundConjugator = qualityGerundConjugator;
        this.trilateralUnaugmentedQualityModifier = trilateralUnaugmentedQualityModifier;
        this.suffixContainerFactory = suffixContainerFactory;
    }

    @Override
    public List<DerivedNounConjugation> getStandardGerunds(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        var keys = trilateralUnaugmentedGerundConjugator.getAppliedFormulaList(root);
        for(var key: keys) {
            var derivedNounConjugation = new DerivedNounConjugation();
            var nounSuffixContainer = suffixContainerFactory.createStandardGerund();
            derivedNounConjugation.setKey(key);

            nounSuffixContainer.selectInDefiniteMode();
            var conjugatedGerunds = trilateralUnaugmentedGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var indefinite = unaugmentedTrilateralStandardGerundModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectAnnexedMode();
            conjugatedGerunds = trilateralUnaugmentedGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var annexed = unaugmentedTrilateralStandardGerundModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectDefiniteMode();
            conjugatedGerunds = trilateralUnaugmentedGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var definite = unaugmentedTrilateralStandardGerundModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

            derivedNounConjugations.add(derivedNounConjugation);
        }
        return derivedNounConjugations;
    }

    @Override
    public List<DerivedNounConjugation> getMeemGerunds(UnaugmentedTrilateralRoot root, KindOfVerb kov) throws Exception {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        var keys = meemGerundConjugator.getAppliedFormulaList(root);
        for(var key: keys) {
            var derivedNounConjugation = new DerivedNounConjugation();
            var nounSuffixContainer = suffixContainerFactory.create();
            derivedNounConjugation.setKey(key);

            nounSuffixContainer.selectInDefiniteMode();
            var conjugatedGerunds = meemGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var indefinite = trilateralUnaugmentedMeemModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectAnnexedMode();
            conjugatedGerunds = meemGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var annexed = trilateralUnaugmentedMeemModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectDefiniteMode();
            conjugatedGerunds = meemGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var definite = trilateralUnaugmentedMeemModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

            derivedNounConjugations.add(derivedNounConjugation);
        }
        return derivedNounConjugations;
    }

    @Override
    public List<DerivedNounConjugation> getNomenGerunds(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        var keys = trilateralUnaugmentedNomenGerundConjugator.getAppliedFormulaList(root);
        for(var key: keys) {
            var derivedNounConjugation = new DerivedNounConjugation();
            var nounSuffixContainer = suffixContainerFactory.create();
            derivedNounConjugation.setKey(key);

            nounSuffixContainer.selectInDefiniteMode();
            var conjugatedGerunds = trilateralUnaugmentedNomenGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var indefinite = trilateralUnaugmentedNomenModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectAnnexedMode();
            conjugatedGerunds = trilateralUnaugmentedNomenGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var annexed = trilateralUnaugmentedNomenModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectDefiniteMode();
            conjugatedGerunds = trilateralUnaugmentedNomenGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var definite = trilateralUnaugmentedNomenModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

            derivedNounConjugations.add(derivedNounConjugation);
        }
        return derivedNounConjugations;
    }

    @Override
    public List<DerivedNounConjugation> getQualityGerunds(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        var keys = List.of("فِعْلَة"); //TODO: move this special to the conjugator for consistency.
        for(var key: keys) {
            var derivedNounConjugation = new DerivedNounConjugation();
            var nounSuffixContainer = suffixContainerFactory.create();
            derivedNounConjugation.setKey(key);

            nounSuffixContainer.selectInDefiniteMode();
            var conjugatedGerunds = qualityGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var indefinite = trilateralUnaugmentedQualityModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectAnnexedMode();
            conjugatedGerunds = qualityGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var annexed = trilateralUnaugmentedQualityModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

            nounSuffixContainer.selectDefiniteMode();
            conjugatedGerunds = qualityGerundConjugator.createGerundList(root, key, nounSuffixContainer);
            var definite = trilateralUnaugmentedQualityModifier.build(root, kov, conjugatedGerunds, key);
            derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

            derivedNounConjugations.add(derivedNounConjugation);
        }
        return derivedNounConjugations;
    }
}
