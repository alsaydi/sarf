package sarfwebservice.sarf.bridges.tri;
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
import sarf.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarf.noun.TrilateralUnaugmentedNouns;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.AssimilateModifier;
import sarf.noun.trilateral.unaugmented.modifier.elative.ElativeModifier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator;

import java.util.List;

@Service
public class TrilateralUnaugmentedBridgeImpl implements TrilateralUnaugmentedBridge {

    private final ActivePastConjugator triActivePastConjugator;
    private final PassivePastConjugator triPassivePastConjugator;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator triUnaugmentedActivePresentConjugator;
    private final UnaugmentedImperativeConjugator unaugmentedImperativeConjugator;
    private final PassivePresentConjugator passivePresentConjugator;

    @Autowired
    public TrilateralUnaugmentedBridgeImpl(ActivePastConjugator triActivePastConjugator
            , PassivePastConjugator triPassivePastConjugator
            , TrilateralUnaugmentedQualityModifier qualityGerundModifier
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator triUnaugmentedActivePresentConjugator
            , UnaugmentedImperativeConjugator unaugmentedImperativeConjugator
            , PassivePresentConjugator passivePresentConjugator) {
        this.triActivePastConjugator = triActivePastConjugator;
        this.triPassivePastConjugator = triPassivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.triUnaugmentedActivePresentConjugator = triUnaugmentedActivePresentConjugator;
        this.unaugmentedImperativeConjugator = unaugmentedImperativeConjugator;
        this.passivePresentConjugator = passivePresentConjugator;
    }

    @Override
    public List<WordPresenter> retrieveActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active){
        List<? extends Word> result = active ? triActivePastConjugator.createVerbList(root) : triPassivePastConjugator.createVerbList(root);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PAST_TENSE, active);
        var finalResult = conjResult.getFinalResult();
        return  finalResult;
    }

    @Override
    public List<WordPresenter> retrieveActiveNominativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createNominativeVerbList(root)
                : passivePresentConjugator.createNominativeVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveAccusativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createAccusativeVerbList(root):
                passivePresentConjugator.createAccusativeVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveJussivePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createJussiveVerbList(root) :
                passivePresentConjugator.createJussiveVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveEmphasizedPresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createEmphasizedVerbList(root) :
                passivePresentConjugator.createEmphasizedVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = unaugmentedImperativeConjugator.createVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);
        return conjResult.getFinalResult()
                .stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = unaugmentedImperativeConjugator.createEmphasizedVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
        return conjResult.getFinalResult()
                .stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }
}
