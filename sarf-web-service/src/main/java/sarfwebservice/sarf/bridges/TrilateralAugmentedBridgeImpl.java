package sarfwebservice.sarf.bridges;

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

import java.util.List;

@Service
public class TrilateralAugmentedBridgeImpl implements TrilateralAugmentedBridge {
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final KovRulesManager kovRulesManager;
    private final AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory;
    private final AugmentedPassivePastConjugator augmentedPassivePastConjugator;
    private final AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final TrilateralAugmentedGerundConjugator gerundConjugator;
    private final TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier;
    private final TrilateralAugmentedNomenGerundConjugator nomenGerundConjugator;

    @Autowired
    public TrilateralAugmentedBridgeImpl(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory
            , AugmentedPassivePastConjugator augmentedPassivePastConjugator
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator
            , PassiveParticipleModifier passiveParticipleModifier
            , TrilateralAugmentedGerundConjugator gerundConjugator
            , TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier
            , TrilateralAugmentedNomenGerundConjugator nomenGerundConjugator) {

        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.augmentedImperativeConjugatorFactory = augmentedImperativeConjugatorFactory;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;
        this.augmentedTrilateralActiveParticipleConjugator = augmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.gerundConjugator = gerundConjugator;
        this.trilateralAugmentedStandardModifier = trilateralAugmentedStandardModifier;
        this.nomenGerundConjugator = nomenGerundConjugator;
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
        return getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getNominativeConjugator(), active);
    }

    @Override
    public List<WordPresenter> retrieveAccusativePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getAccusativeConjugator(), active);
    }

    @Override
    public List<WordPresenter> retrieveJussivePresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getJussiveConjugator(), active);
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedPresent(String rootLetters, int formulaNo, boolean active) throws Exception {
        return getWordPresenters(rootLetters, formulaNo, augmentedActivePresentConjugator.getEmphasizedConjugator(), active);
    }

    @Override
    public List<WordPresenter> retrieveImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedImperativeConjugatorFactory.getNotEmphasizedConjugator());
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(String rootLetters, int formulaNo) throws Exception {
        return getImperativeWordPresenters(rootLetters, formulaNo, augmentedImperativeConjugatorFactory.getEmphasizedConjugator());
    }

    private List<WordPresenter> getWordPresenters(String rootLetters, int formulaNo, AugmentedPresentConjugator augmentedPresentConjugator, boolean active) throws Exception {
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
                , active, () -> true);
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