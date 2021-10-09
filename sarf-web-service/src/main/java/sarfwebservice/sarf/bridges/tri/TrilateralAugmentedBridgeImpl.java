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
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.WordPresenter;
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import sarf.verb.trilateral.augmented.passive.present.AbstractAugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;

import java.util.List;

@Service
public class TrilateralAugmentedBridgeImpl implements TrilateralAugmentedBridge {
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final AugmentedPassivePresentConjugator augmentedPassivePresentConjugator;
    private final KovRulesManager kovRulesManager;
    private final AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory;
    private final AugmentedPassivePastConjugator augmentedPassivePastConjugator;
    
    @Autowired
    public TrilateralAugmentedBridgeImpl(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , AugmentedPassivePresentConjugator augmentedPassivePresentConjugator
            , AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory
            , AugmentedPassivePastConjugator augmentedPassivePastConjugator) {

        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.augmentedPassivePresentConjugator = augmentedPassivePresentConjugator;
        this.augmentedImperativeConjugatorFactory = augmentedImperativeConjugatorFactory;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;
    }

    @Override
    public List<WordPresenter> retrievePastConjugations(String rootLetters, int formulaNo, boolean active) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();
        var verbs = active ? augmentedActivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo())
                : augmentedPassivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                , active, () -> true);
        return conjugationResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveNominativePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getNominativeConjugator()):
                getWordPresentersPassive(rootLetters, formulaNo, augmentedPassivePresentConjugator.getNominativeConjugator());
    }

    @Override
    public List<WordPresenter> retrieveAccusativePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getAccusativeConjugator()) :
                getWordPresentersPassive(rootLetters, formulaNo, augmentedPassivePresentConjugator.getAccusativeConjugator());
    }

    @Override
    public List<WordPresenter> retrieveJussivePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ? getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getJussiveConjugator()) :
                getWordPresentersPassive(rootLetters, formulaNo, augmentedPassivePresentConjugator.getJussiveConjugator());
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedPresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return active ?
                getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getEmphasizedConjugator()) :
                getWordPresentersPassive(rootLetters, formulaNo, augmentedPassivePresentConjugator.getEmphasizedConjugator());
    }

    @Override
    public List<WordPresenter> retrieveImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedImperativeConjugatorFactory.getNotEmphasizedConjugator());
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedImperativeConjugatorFactory.getEmphasizedConjugator());
    }

    private List<WordPresenter> getWordPresenters(String rootLetters, int formulaNo, AugmentedPresentConjugator augmentedPresentConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                , true, () -> true);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getWordPresentersPassive(String rootLetters, int formulaNo, AbstractAugmentedPresentConjugator augmentedPresentConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                , false, () -> true);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getImperativeWordPresenters(String rootLetters, int formulaNo, AugmentedImperativeConjugator augmentedImperativeConjugator) throws Exception {
        var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
        if (augmentedRoot == null) {
            throw new Exception(String.format("%s root was not found.", rootLetters));
        }
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedImperativeConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE
                , true, () -> true);
        return conjugationResult.getFinalResult().stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }
}