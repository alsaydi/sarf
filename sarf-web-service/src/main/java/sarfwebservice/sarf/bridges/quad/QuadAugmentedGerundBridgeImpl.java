package sarfwebservice.sarf.bridges.quad;/*
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
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.augmented.QuadrilateralAugmentedGerundConjugator;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.List;

@Service
public class QuadAugmentedGerundBridgeImpl implements QuadAugmentedGerundBridge {

    private final QuadrilateralAugmentedGerundConjugator gerundConjugator;
    private final QuadrilateralStandardModifier standardModifier;
    private final QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator;
    private final AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final SuffixContainerFactory suffixContainerFactory;

    @Autowired
    public QuadAugmentedGerundBridgeImpl(QuadrilateralAugmentedGerundConjugator gerundConjugator
            , QuadrilateralStandardModifier standardModifier
            , QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator
            , QuadrilateralModifier quadrilateralModifier
            , AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , SuffixContainerFactory suffixContainerFactory) {
        this.gerundConjugator = gerundConjugator;
        this.standardModifier = standardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;

        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.suffixContainerFactory = suffixContainerFactory;
    }

    @Override
    public List<DerivedNounConjugation> getStandardGerunds(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey("");

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = gerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var indefinite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = gerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var annexed = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = gerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var definite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getNomenGerunds(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey("");

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = nomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var indefinite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = nomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var annexed = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = nomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var definite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getMeemGerunds(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey("");

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = passiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var indefinite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = passiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var annexed = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = passiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var definite = standardModifier.build(root, formulaNo, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return List.of(derivedNounConjugation);
    }
}
