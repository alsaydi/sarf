package sarfwebservice.sarf.bridges.tri;
import java.util.List;

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
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import sarf.verb.trilateral.augmented.passive.present.AbstractAugmentedPresentConjugator;
import sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;

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
    public List<WordPresenter> retrievePastConjugations(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean active, boolean applyVocalization) throws Exception {
        var kov = kovRulesManager.getTrilateralKov(augmentedRoot.getC1(), augmentedRoot.getC2(), augmentedRoot.getC3());
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();
        var verbs = active ? augmentedActivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo())
                : augmentedPassivePastConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                , active, () -> applyVocalization);
        return conjugationResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveNominativePresent(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean active, boolean applyVocalization) throws Exception {
        return active ?
                getWordPresenters(augmentedRoot, formulaNo, augmentedActivePresentConjugator.getNominativeConjugator(), applyVocalization, false):
                getWordPresentersPassive(augmentedRoot, formulaNo, augmentedPassivePresentConjugator.getNominativeConjugator(), applyVocalization, false);
    }

    @Override
    public List<WordPresenter> retrieveAccusativePresent(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean active, boolean applyVocalization) throws Exception {
        return active ?
                getWordPresenters(augmentedRoot, formulaNo, augmentedActivePresentConjugator.getAccusativeConjugator(), applyVocalization, false) :
                getWordPresentersPassive(augmentedRoot, formulaNo, augmentedPassivePresentConjugator.getAccusativeConjugator(), applyVocalization, false);
    }

    @Override
    public List<WordPresenter> retrieveJussivePresent(AugmentedTrilateralRoot augmentedRoot, int formulaNo
            , boolean active, boolean applyVocalization, boolean applyGemination) throws Exception {
        return active ? getWordPresenters(augmentedRoot, formulaNo, augmentedActivePresentConjugator.getJussiveConjugator(), applyVocalization, applyGemination) :
                getWordPresentersPassive(augmentedRoot, formulaNo, augmentedPassivePresentConjugator.getJussiveConjugator(), applyVocalization, applyGemination);
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedPresent(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean active, boolean applyVocalization) throws Exception {
        return active ?
                getWordPresenters(augmentedRoot, formulaNo, augmentedActivePresentConjugator.getEmphasizedConjugator(), applyVocalization, false) :
                getWordPresentersPassive(augmentedRoot, formulaNo, augmentedPassivePresentConjugator.getEmphasizedConjugator(), applyVocalization, false);
    }

    @Override
    public List<WordPresenter> retrieveImperative(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean applyVocalization, boolean applyGemination) throws Exception {
        return getImperativeWordPresenters(augmentedRoot, formulaNo, augmentedImperativeConjugatorFactory.getNotEmphasizedConjugator()
                , applyVocalization, applyGemination, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE);
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(AugmentedTrilateralRoot augmentedRoot, int formulaNo, boolean applyVocalization, boolean applyGemination) throws Exception {
        return getImperativeWordPresenters(augmentedRoot, formulaNo, augmentedImperativeConjugatorFactory.getEmphasizedConjugator()
                , applyVocalization, applyGemination, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE);
    }

    private List<WordPresenter> getWordPresenters(AugmentedTrilateralRoot augmentedRoot, int formulaNo, AugmentedPresentConjugator augmentedPresentConjugator, boolean applyVocalization
    , boolean applyGemination) {
        var kov = kovRulesManager.getTrilateralKov(augmentedRoot.getC1(), augmentedRoot.getC2(), augmentedRoot.getC3());
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                , true, applyGemination ,() -> applyVocalization);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getWordPresentersPassive(AugmentedTrilateralRoot augmentedRoot, int formulaNo, AbstractAugmentedPresentConjugator augmentedPresentConjugator, boolean applyVocalization
    , boolean applyGemination) {
        var kov = kovRulesManager.getTrilateralKov(augmentedRoot.getC1(), augmentedRoot.getC2(), augmentedRoot.getC3());
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedPresentConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                , false,applyGemination, () -> applyVocalization);
        return conjugationResult.getFinalResult();
    }

    private List<WordPresenter> getImperativeWordPresenters(AugmentedTrilateralRoot augmentedRoot, int formulaNo, AugmentedImperativeConjugator augmentedImperativeConjugator
            , boolean applyVocalization, boolean applyGemination, String tense) {
        var kov = kovRulesManager.getTrilateralKov(augmentedRoot.getC1(), augmentedRoot.getC2(), augmentedRoot.getC3());
        var augmentationFormula = augmentedRoot.getAugmentationList().stream()
                .filter(f -> f.getFormulaNo() == formulaNo)
                .findFirst().orElseThrow();

        var verbs = augmentedImperativeConjugator.createVerbList(augmentedRoot, augmentationFormula.getFormulaNo());
        var conjugationResult = augmentedTrilateralModifier.build(augmentedRoot, kov, augmentationFormula.getFormulaNo(), verbs
                , tense, true, applyGemination, () -> applyVocalization);
        return conjugationResult.getFinalResult().stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }
}