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
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.WordPresenter;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.augmented.QuadrilateralAugmentedGerundConjugator;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.quadriliteral.augmented.active.present.QuadriAugmentedPresentConjugator;
import sarf.verb.quadriliteral.augmented.imperative.AbstractAugmentedImperativeConjugator;
import sarf.verb.quadriliteral.augmented.imperative.AugmentedQuadImperativeConjugator;
import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.present.AbstractAugmentedPresentConjugator;
import sarf.verb.quadriliteral.augmented.passive.present.AugmentedQuadPassivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;

import java.util.List;

@Service
public class QuadAugmentedBridgeImpl implements QuadAugmentedBridge {
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator;
    private final QuadriAugmentedPassivePastConjugator passivePastConjugator;
    private final AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final QuadrilateralAugmentedGerundConjugator gerundConjugator;
    private final QuadrilateralStandardModifier standardModifier;
    private final QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator;
    private final AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator;
    private final AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator;


    @Autowired
    public QuadAugmentedBridgeImpl(SarfDictionary sarfDictionary, KovRulesManager kovRulesManager
            , QuadrilateralAugmentedActivePastConjugator quadriActivePastConjugator
            , QuadriAugmentedPassivePastConjugator passivePastConjugator
            , AugmentedQuadrilateralActiveParticipleConjugator activeParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedQuadrilateralPassiveParticipleConjugator passiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralAugmentedGerundConjugator gerundConjugator
            , QuadrilateralStandardModifier standardModifier
            , QuadrilateralAugmentedNomenGerundConjugator nomenGerundConjugator
            , QuadrilateralModifier quadrilateralModifier
            , AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator
            , AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator
            , AugmentedQuadPassivePresentConjugator augmentedQuadPassivePresentConjugator) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.passivePastConjugator = passivePastConjugator;
        this.activeParticipleConjugator = activeParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleConjugator = passiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.standardModifier = standardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.augmentedQuadImperativeConjugator = augmentedQuadImperativeConjugator;
        this.augmentedQuadActivePresentConjugator = augmentedQuadActivePresentConjugator;
        this.augmentedQuadPassivePresentConjugator = augmentedQuadPassivePresentConjugator;
    }

    @Override
    public List<WordPresenter> retrievePastConjugations(String rootLetters, int formulaNo, boolean active) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kovRule = kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();
        var verbs = active ? quadriActivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo())
                : passivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = quadrilateralModifier.build(augmentedRoot, augmentationFormula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PAST_TENSE
                , active, true);
        return conjugationResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveNominativePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedQuadActivePresentConjugator.getNominativeConjugator()):
                getWordPresenters(rootLetters, formulaNo, augmentedQuadPassivePresentConjugator.getNominativeConjugator());
    }

    @Override
    public List<WordPresenter> retrieveAccusativePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedQuadActivePresentConjugator.getAccusativeConjugator()):
                getWordPresenters(rootLetters, formulaNo, augmentedQuadPassivePresentConjugator.getAccusativeConjugator());
    }

    @Override
    public List<WordPresenter> retrieveJussivePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedQuadActivePresentConjugator.getJussiveConjugator()):
                getWordPresenters(rootLetters, formulaNo, augmentedQuadPassivePresentConjugator.getJussiveConjugator());
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedPresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedQuadActivePresentConjugator.getEmphasizedConjugator()):
                getWordPresenters(rootLetters, formulaNo, augmentedQuadPassivePresentConjugator.getEmphasizedConjugator());
    }

    @Override
    public List<WordPresenter> retrieveImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedQuadImperativeConjugator.getNotEmphasizedConjugator());
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedQuadImperativeConjugator.getEmphasizedConjugator());
    }

    private List<WordPresenter> getWordPresenters(String rootLetters, int formulaNo, QuadriAugmentedPresentConjugator quadriAugmentedPresentConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kovRule = kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = quadriAugmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = quadrilateralModifier.build(augmentedRoot, augmentationFormula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE
                , true, true);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getWordPresenters(String rootLetters, int formulaNo, AbstractAugmentedPresentConjugator passiveAugmentedPresentConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kovRule = kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = passiveAugmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = quadrilateralModifier.build(augmentedRoot, augmentationFormula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.PRESENT_TENSE
                , false, true);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getImperativeWordPresenters(String rootLetters, int formulaNo, AbstractAugmentedImperativeConjugator augmentedImperativeConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kovRule = kovRulesManager.getQuadrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2), rootLetters.charAt(3));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedImperativeConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = quadrilateralModifier.build(augmentedRoot, augmentationFormula.getFormulaNo(), kovRule.getKov(), verbs, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE
                , true, true);
        return conjugationResult.getFinalResult().stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }
}