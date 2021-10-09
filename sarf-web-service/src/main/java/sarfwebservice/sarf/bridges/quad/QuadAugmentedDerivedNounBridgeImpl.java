package sarfwebservice.sarf.bridges.quad;
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
import sarf.SarfDictionary;
import sarf.WordPresenter;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuadAugmentedDerivedNounBridgeImpl implements QuadAugmentedDerivedNounBridge {

    private static final String إعلال = "إعلال";
    private static final String تصحيح = "تصحيح";

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final QuadrilateralStandardModifier standardModifier;
    private final QuadrilateralModifier quadrilateralModifier;
    private final SuffixContainerFactory suffixContainerFactory;

    @Autowired
    public QuadAugmentedDerivedNounBridgeImpl(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralStandardModifier standardModifier
            , QuadrilateralModifier quadrilateralModifier
            , SuffixContainerFactory suffixContainerFactory)
    {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.standardModifier = standardModifier;
        this.quadrilateralModifier = quadrilateralModifier;
        this.suffixContainerFactory = suffixContainerFactory;
    }

    @Override
    public List<DerivedNounConjugation> getActiveParticiples(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey("-");

        nounSuffixContainer.selectInDefiniteMode();
        var result = activeParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = activeParticipleModifier.build(root, formulaNo, kov, result);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = activeParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = activeParticipleModifier.build(root, formulaNo, kov, result);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = activeParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = activeParticipleModifier.build(root, formulaNo, kov, result);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }
    @Override
    public List<DerivedNounConjugation> getPassiveParticiples(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey("-"); /* there is only one key */

        nounSuffixContainer.selectInDefiniteMode();
        var result = passiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = passiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = passiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getTimeAndPlaceNouns(AugmentedQuadrilateralRoot root, KindOfVerb kov, int formulaNo){
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey("-");

        nounSuffixContainer.selectInDefiniteMode();
        var result = passiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = passiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = passiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = passiveParticipleModifier.build(root, formulaNo, kov, result);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }
}
