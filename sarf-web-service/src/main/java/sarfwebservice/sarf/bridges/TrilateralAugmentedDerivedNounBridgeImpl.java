package sarfwebservice.sarf.bridges;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import sarf.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrilateralAugmentedDerivedNounBridgeImpl implements TrilateralAugmentedDerivedNounBridge {

    private static final String إعلال = "إعلال";
    private static final String تصحيح = "تصحيح";
    private final ActiveParticipleModifier activeParticipleModifier;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final SuffixContainerFactory suffixContainerFactory;
    private final AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;
    private final FormulaApplyingChecker vocalizationApplicabilityChecker;// هل الكلمة قابلة للتصحيح إذا توفرت الشروط

    @Autowired
    public TrilateralAugmentedDerivedNounBridgeImpl(ActiveParticipleModifier activeParticipleModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , SuffixContainerFactory suffixContainerFactory
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator, FormulaApplyingChecker vocalizationApplicabilityChecker)
    {
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.suffixContainerFactory = suffixContainerFactory;
        this.augmentedTrilateralActiveParticipleConjugator = augmentedTrilateralActiveParticipleConjugator;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
        this.vocalizationApplicabilityChecker = vocalizationApplicabilityChecker;
    }

    @Override
    public List<DerivedNounConjugation> getActiveParticiples(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo)
    {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if(vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getActiveParticiple(root, kov, formulaNo, إعلال, true));
        }
        derivedNounConjugations.add(getActiveParticiple(root, kov, formulaNo, تصحيح, false));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getActiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo,String key, boolean applyVocalization)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return derivedNounConjugation;
    }
    @Override
    public List<DerivedNounConjugation> getPassiveParticiples(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo)
    {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if(vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getPassiveParticiple(root, kov, formulaNo, إعلال, true));
        }
        derivedNounConjugations.add(getPassiveParticiple(root, kov, formulaNo, تصحيح, false));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getPassiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, String key, boolean applyVocalization)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(key); /* there is only one key */

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return derivedNounConjugation;
    }

    @Override
    public List<DerivedNounConjugation> getTimeAndPlaceNouns(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo){
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if(vocalizationApplicabilityChecker.check(root, formulaNo) == IFormulaApplyingChecker.TWO_STATE) {
            derivedNounConjugations.add(getTimeAndPlaceNoun(root, kov, formulaNo, إعلال, true));
        }
        derivedNounConjugations.add(getTimeAndPlaceNoun(root, kov, formulaNo, تصحيح, false));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getTimeAndPlaceNoun(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo, String key, boolean applyVocalization)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> applyVocalization);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return derivedNounConjugation;
    }
}
