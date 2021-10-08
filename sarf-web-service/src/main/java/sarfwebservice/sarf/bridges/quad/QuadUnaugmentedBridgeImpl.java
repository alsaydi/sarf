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
import sarf.*;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.QuadUnaugmentedImperativeConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.active.QuadActivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.QuadPassivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.QuadriUnaugmentedPassivePastConjugator;

import java.util.List;

@Service
public class QuadUnaugmentedBridgeImpl implements QuadUnaugmentedBridge {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadriActivePastConjugator quadriActivePastConjugator;
    private final QuadriUnaugmentedPassivePastConjugator quadriPassivePastConjugator;
    private final UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier activeParticipleModifier;
    private final QuadActivePresentConjugator quadActivePresentConjugator;
    private final QuadrilateralModifier quadrilateralModifier;

    private final UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier passiveParticipleModifier;
    private final QuadrilateralUnaugmentedGerundConjugator gerundConjugator;
    private final QuadrilateralStandardModifier standardModifier;
    private final QuadrilateralUnaugmentedNomenGerundConjugator nomenGerundConjugator;
    private final QuadUnaugmentedImperativeConjugator quadUnaugmentedImperativeConjugator;
    private final QuadPassivePresentConjugator quadPassivePresentConjugator;

    @Autowired
    public QuadUnaugmentedBridgeImpl(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadriActivePastConjugator quadriActivePastConjugator
            , QuadriUnaugmentedPassivePastConjugator quadriPassivePastConjugator
            , UnaugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , QuadActivePresentConjugator quadActivePresentConjugator
            , QuadrilateralModifier quadrilateralModifier
            , UnaugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralUnaugmentedGerundConjugator gerundConjugator
            , QuadrilateralStandardModifier standardModifier
            , QuadrilateralUnaugmentedNomenGerundConjugator nomenGerundConjugator
            , QuadUnaugmentedImperativeConjugator quadUnaugmentedImperativeConjugator
            , QuadPassivePresentConjugator quadPassivePresentConjugator) {
        this.sarfDictionary = sarfDictionary;

        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.quadriPassivePastConjugator = quadriPassivePastConjugator;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.quadActivePresentConjugator = quadActivePresentConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.standardModifier = standardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;
        this.quadUnaugmentedImperativeConjugator = quadUnaugmentedImperativeConjugator;
        this.quadPassivePresentConjugator = quadPassivePresentConjugator;
    }

    @Override
    public List<WordPresenter> retrievePastConjugations(UnaugmentedQuadrilateralRoot root, KindOfVerb kov, boolean active){
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = active ? quadriActivePastConjugator.createVerbList(root) : quadriPassivePastConjugator.createVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PAST_TENSE, active, true)
                .getFinalResult();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveNominativePresent(UnaugmentedQuadrilateralRoot root, KindOfVerb kov, boolean active) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = active ? quadActivePresentConjugator.createNominativeVerbList(root) : quadPassivePresentConjugator.createNominativeVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, active, true)
                .getFinalResult();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveAccusativePresent(UnaugmentedQuadrilateralRoot root, KindOfVerb kov, boolean active) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = active ? quadActivePresentConjugator.createAccusativeVerbList(root) : quadPassivePresentConjugator.createAccusativeVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, active, true)
                .getFinalResult();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveJussivePresent(UnaugmentedQuadrilateralRoot root, KindOfVerb kov, boolean active) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = active ? quadActivePresentConjugator.createJussiveVerbList(root) : quadPassivePresentConjugator.createJussiveVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, active, true)
                .getFinalResult();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedPresent(UnaugmentedQuadrilateralRoot root, KindOfVerb kov, boolean active) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = active ? quadActivePresentConjugator.createEmphasizedVerbList(root) : quadPassivePresentConjugator.createEmphasizedVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE, active, true)
                .getFinalResult();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveImperative(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = quadUnaugmentedImperativeConjugator.createVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true)
                .getFinalResult().stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
        return conjugationResult;
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
        var verbs = quadUnaugmentedImperativeConjugator.createEmphasizedVerbList(root);

        var conjugationResult = quadrilateralModifier.build(root, 0,  kovRule.getKov(), verbs, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true)
                .getFinalResult().stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
        return conjugationResult;
    }
}
