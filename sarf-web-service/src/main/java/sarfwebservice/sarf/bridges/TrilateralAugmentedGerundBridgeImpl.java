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
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrilateralAugmentedGerundBridgeImpl implements TrilateralAugmentedGerundBridge {

    private static final String إعلال = "إعلال";
    private static final String تصحيح = "تصحيح";
    private static final String مفاعلة = "مُفَاعلة";
    private static final String فعال = "فِعال";

    private final TrilateralAugmentedGerundConjugator trilateralAugmentedGerundConjugator;
    private final TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final TrilateralAugmentedNomenGerundConjugator trilateralAugmentedNomenGerundConjugator;
    private final SuffixContainerFactory suffixContainerFactory;
    private final FormulaApplyingChecker vocalizationApplicabilityChecker;// هل الكلمة قابلة للتصحيح إذا توفرت الشروط

    @Autowired
    public TrilateralAugmentedGerundBridgeImpl(TrilateralAugmentedGerundConjugator trilateralAugmentedGerundConjugator
            , TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator /* for meem gerund */
            , PassiveParticipleModifier passiveParticipleModifier /* for meem gerund */
            , TrilateralAugmentedNomenGerundConjugator trilateralAugmentedNomenGerundConjugator
            , SuffixContainerFactory suffixContainerFactory
            , FormulaApplyingChecker formulaApplyingChecker) {

        this.trilateralAugmentedGerundConjugator = trilateralAugmentedGerundConjugator;
        this.trilateralAugmentedStandardModifier = trilateralAugmentedStandardModifier;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.trilateralAugmentedNomenGerundConjugator = trilateralAugmentedNomenGerundConjugator;
        this.suffixContainerFactory = suffixContainerFactory;
        this.vocalizationApplicabilityChecker = formulaApplyingChecker;
    }
    @Override
    public List<DerivedNounConjugation> getStandardGerunds(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if (vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getStandardGerund(root, kov, formulaNo, true, إعلال, false));
            derivedNounConjugations.add(getStandardGerund(root, kov, formulaNo, false, تصحيح, false));
        }
        else {
            var canApplyAlternateForm = trilateralAugmentedGerundConjugator.canApplyAlternateForm(root, formulaNo);
            var key = canApplyAlternateForm ? مفاعلة : "";
            derivedNounConjugations.add(getStandardGerund(root, kov, formulaNo, false, key, false));
            if (canApplyAlternateForm) {
                derivedNounConjugations.add(getStandardGerund(root, kov, formulaNo, false, فعال, true));
            }
        }
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getStandardGerund(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, boolean applyVocalization, String key, boolean applyAlternateFormIfApplicable) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = trilateralAugmentedGerundConjugator.createGerundList(root, formulaNo, applyVocalization, applyAlternateFormIfApplicable, nounSuffixContainer);
        var indefinite = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = trilateralAugmentedGerundConjugator.createGerundList(root, formulaNo,applyVocalization, applyAlternateFormIfApplicable,  nounSuffixContainer);
        var annexed = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = trilateralAugmentedGerundConjugator.createGerundList(root, formulaNo, applyVocalization, applyAlternateFormIfApplicable, nounSuffixContainer);
        var definite = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return derivedNounConjugation;
    }

    @Override
    public List<DerivedNounConjugation> getNomenGerunds(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if(vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getNomenGerund(root, kov, formulaNo, true, إعلال));
        }
        derivedNounConjugations.add(getNomenGerund(root, kov, formulaNo, false, تصحيح));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getNomenGerund(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, boolean applyVocalization, String key) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = trilateralAugmentedNomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var indefinite = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = trilateralAugmentedNomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var annexed = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = trilateralAugmentedNomenGerundConjugator.createGerundList(root, formulaNo, nounSuffixContainer);
        var definite = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return derivedNounConjugation;
    }

    @Override
    public List<DerivedNounConjugation> getMeemGerunds(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if(vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getMeemGerund(root, kov, formulaNo, true, إعلال));
        }
        derivedNounConjugations.add(getMeemGerund(root, kov, formulaNo, false, تصحيح));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getMeemGerund(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, boolean applyVocalization, String key) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = augmentedTrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var indefinite = trilateralAugmentedStandardModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = augmentedTrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var annexed = passiveParticipleModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = augmentedTrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, formulaNo, nounSuffixContainer);
        var definite = passiveParticipleModifier.build(root, kov, formulaNo, conjugatedGerunds, () -> applyVocalization);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return derivedNounConjugation;
    }
}
