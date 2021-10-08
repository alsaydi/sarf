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
import sarf.WordPresenter;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.List;

import static sarfwebservice.models.NounConjugations.ACTIVE_PARTICIPLE_KEY_QUAD;
import static sarfwebservice.models.NounConjugations.PASSIVE_PARTICIPLE_KEY_QUAD;

@Service
public class QuadUnaugmentedDerivedNounBridgeImpl implements QuadUnaugmentedDerivedNounBridge {

    private final SuffixContainerFactory suffixContainerFactory;
    private final UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;

    @Autowired
    public QuadUnaugmentedDerivedNounBridgeImpl(SuffixContainerFactory suffixContainerFactory
            , UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier){

        this.suffixContainerFactory = suffixContainerFactory;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
    }

    @Override
    public List<DerivedNounConjugation> getActiveParticiple(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var formulaName = ACTIVE_PARTICIPLE_KEY_QUAD;
        var genericNounSuffixContainer = this.suffixContainerFactory.create();
        genericNounSuffixContainer.selectInDefiniteMode();
        var conjugatedNouns = this.activeParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var indefiniteResult = activeParticipleModifier.build(root, 0, kov, conjugatedNouns);

        genericNounSuffixContainer.selectAnnexedMode();
        conjugatedNouns = this.activeParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var annexedResult = activeParticipleModifier.build(root, 0, kov, conjugatedNouns);

        genericNounSuffixContainer.selectDefiniteMode();
        conjugatedNouns = this.activeParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var definiteResult = activeParticipleModifier.build(root, 0, kov, conjugatedNouns);

        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setIndefiniteNouns(indefiniteResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setAnnexedNouns(annexedResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setDefiniteNouns(definiteResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setKey(formulaName);
        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getPassiveParticiple(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var formulaName = PASSIVE_PARTICIPLE_KEY_QUAD;
        var genericNounSuffixContainer = this.suffixContainerFactory.create();
        genericNounSuffixContainer.selectInDefiniteMode();
        var conjugatedNouns = this.passiveParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var indefiniteResult = passiveParticipleModifier.build(root, 0, kov, conjugatedNouns);

        genericNounSuffixContainer.selectAnnexedMode();
        conjugatedNouns = this.passiveParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var annexedResult = passiveParticipleModifier.build(root, 0, kov, conjugatedNouns);


        genericNounSuffixContainer.selectDefiniteMode();
        conjugatedNouns = this.passiveParticipleConjugator.createNounList(root, genericNounSuffixContainer);
        var definiteResult = passiveParticipleModifier.build(root,0, kov, conjugatedNouns);

        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setIndefiniteNouns(indefiniteResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setAnnexedNouns(annexedResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setDefiniteNouns(definiteResult.getFinalResult().stream().map(WordPresenter::toString).toList());
        derivedNounConjugation.setKey(formulaName);
        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getTimeAndPlaceNouns(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {

            var genericNounSuffixContainer = this.suffixContainerFactory.create();
            genericNounSuffixContainer.selectInDefiniteMode();
            var conjugatedNouns = passiveParticipleConjugator.createTimeAndPlaceNounList(root, genericNounSuffixContainer);
            var indefiniteResult = passiveParticipleModifier.build(root, 0, kov, conjugatedNouns);

            genericNounSuffixContainer.selectAnnexedMode();
            conjugatedNouns = passiveParticipleConjugator.createTimeAndPlaceNounList(root, genericNounSuffixContainer);
            var annexedResult = passiveParticipleModifier.build(root, 0, kov, conjugatedNouns);

            genericNounSuffixContainer.selectDefiniteMode();
            conjugatedNouns = passiveParticipleConjugator.createNounList(root, genericNounSuffixContainer);
            var definiteResult = passiveParticipleModifier.build(root, 0, kov, conjugatedNouns);
            var derivedNounConjugation = new DerivedNounConjugation();
            derivedNounConjugation.setKey("-");
            derivedNounConjugation.setIndefiniteNouns(indefiniteResult.getFinalResult().stream().map(WordPresenter::toString).toList());
            derivedNounConjugation.setAnnexedNouns(annexedResult.getFinalResult().stream().map(WordPresenter::toString).toList());
            derivedNounConjugation.setDefiniteNouns(definiteResult.getFinalResult().stream().map(WordPresenter::toString).toList());

            return List.of(derivedNounConjugation);
    }
}
