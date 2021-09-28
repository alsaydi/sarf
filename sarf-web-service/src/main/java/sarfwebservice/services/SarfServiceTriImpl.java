package sarfwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.*;
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarfwebservice.models.ConjugationResultDisplay;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.TriRootDisplay;
import sarfwebservice.models.VerbConjugations;
import sarfwebservice.sarf.bridges.TrilateralUnaugmentedBridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SarfServiceTriImpl extends SarfServiceImpl implements SarfServiceTri {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final ActivePastConjugator unaugmentedTriActivePastConjugator;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator activePresentConjugator;
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final TrilateralUnaugmentedBridge trilateralUnaugmentedBridge;

    @Autowired
    public SarfServiceTriImpl(SarfDictionary sarfDictionary
            , Validator sarfValidator
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , ActivePastConjugator unaugmentedTriActivePastConjugator
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator activePresentConjugator
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , TrilateralUnaugmentedBridge trilateralUnaugmentedBridge) {
        super(sarfValidator);
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.unaugmentedTriActivePastConjugator = unaugmentedTriActivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.activePresentConjugator = activePresentConjugator;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.trilateralUnaugmentedBridge = trilateralUnaugmentedBridge;
    }

    private static List<Word> createEmptyList() {
        List<Word> result = new ArrayList<>(13);
        for (int i = 1; i <= 13; i++) {
            result.add(Word.empty());
        }
        return result;
    }

    @Override
    public List<RootResult> getRoots(String rootLetters) {
        try {
            return processTrilateral(rootLetters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VerbConjugations getActiveVerbConjugationsTri(String rootLetters, boolean augmented, int cclass, int formula) throws Exception {
        if (augmented) {
            return null;
        }
        var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var root = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters).stream()
                .filter(r -> r.getConjugation().getValue() == cclass)
                .findFirst().orElse(null);
        if (root == null) {
            throw new Exception(String.format("Could not find a root with letters %s and class of %d.", rootLetters, cclass));
        }

        var past = this.trilateralUnaugmentedBridge.retrieveActivePastConjugations(root, kov).stream().map(wp -> wp.toString()).toList();
        var nominativePresent = this.trilateralUnaugmentedBridge.retrieveActiveNominativePresent(root, kov).stream().map(wp -> wp.toString()).toList();
        var accusativePresent = this.trilateralUnaugmentedBridge.retrieveActiveAccusativePresent(root, kov).stream().map(wp -> wp.toString()).toList();
        var jussivePresent = this.trilateralUnaugmentedBridge.retrieveActiveJussivePresent(root, kov).stream().map(wp -> wp.toString()).toList();
        var emphasizedPresent = this.trilateralUnaugmentedBridge.retrieveActiveEmphasizedPresent(root, kov).stream().map(wp -> wp.toString()).toList();
        var imperative = this.trilateralUnaugmentedBridge.retrieveImperative(root, kov).stream().map(wp -> wp.toString()).toList();
        var emphasizedImperative = this.trilateralUnaugmentedBridge.retrieveEmphasizedImperative(root, kov).stream().map(wp -> wp.toString()).toList();
        var verbConjugations = new VerbConjugations();
        verbConjugations.setPast(past);
        verbConjugations.setNominativePresent(nominativePresent);
        verbConjugations.setAccusativePresent(accusativePresent);
        verbConjugations.setJussivePresent(jussivePresent);
        verbConjugations.setEmphasizedPresent(emphasizedPresent);
        verbConjugations.setImperative(imperative);
        verbConjugations.setEmphasizedImperative(emphasizedImperative);
        return verbConjugations;
    }

    private String conjugateRoot(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var pastRootText = unaugmentedTriActivePastConjugator.createVerb(7, root);
        List<Word> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        var finalPastVerbText = conjResult.getFinalResult().get(7).toString();

        //present text formatting
        var presentRootText = activePresentConjugator.createNominativeVerb(7, root);
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        var finalPresentVerbText = conjResult.getFinalResult().get(7).toString();

        return finalPastVerbText + " " + finalPresentVerbText;
    }

    private String conjugateAugmentedRoot(int formulaNo, AugmentedTrilateralRoot root, KindOfVerb kov) {
        //مع الضمير هو
        //past text formatting
        var pastRootText = augmentedActivePastConjugator.createVerb(root, 7, formulaNo);
        var conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        ConjugationResult conjResult = augmentedTrilateralModifier.build(root, kov, formulaNo, conjugations, SystemConstants.PAST_TENSE, true, null);
        var finalPastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        var presentRootText = augmentedActivePresentConjugator.getNominativeConjugator().createVerbList(root, formulaNo).get(7);
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = augmentedTrilateralModifier.build(root, kov, formulaNo, conjugations, SystemConstants.PRESENT_TENSE, true, null);
        var finalPresentRootText = conjResult.getFinalResult().get(7).toString();

        return finalPastRootText + " " + finalPresentRootText;
    }

    private List<RootResult> processTrilateral(String root) throws Exception {
        var alefAlternatives = getSarfValidator().getTrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedTrilateralRoot augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(root);
            List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(root);
            if (augmentedRoot == null && unaugmentedList.isEmpty()) {
                return Arrays.asList();
            } else {
                return Arrays.asList(findRootResult(root, unaugmentedList, augmentedRoot));
            }
        }
        //تجريب بدائل الألف
        var resultList = new ArrayList<RootResult>();
        for (String alternativeRoot : alefAlternatives) {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(alternativeRoot);
            var unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(alternativeRoot);

            if (augmentedRoot != null || !unaugmentedList.isEmpty()) {
                resultList.add(findRootResult(alternativeRoot, unaugmentedList, augmentedRoot));
            }
        }
        return resultList;
    }

    private RootResult findRootResult(String rootLetters
            , List<UnaugmentedTrilateralRoot> unaugmentedTrilateralRoots
            , AugmentedTrilateralRoot augmentedTrilateralRoot) throws Exception {
        var rootResult = new RootResult();
        var kovRule = kovRulesManager.getTrilateralKovRule(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
        var kov = kovRule.getKov();
        var conjugationResultDisplays = new ArrayList<ConjugationResultDisplay>();
        var displays = new ArrayList<TriRootDisplay>();

        for (var root : unaugmentedTrilateralRoots) {
            var display = new TriRootDisplay();
            display.setRoot(root);
            display.setDisplay(conjugateRoot(root, kov));
            displays.add(display);
        }
        if (augmentedTrilateralRoot != null) {
            var augmentationFormulas = augmentedTrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedTrilateralRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedTrilateralRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> true);

                var conjugationResultDisplay = new ConjugationResultDisplay();
                conjugationResultDisplay.setConjugationResult(conjugationResult);
                conjugationResultDisplay.setDisplay(conjugateAugmentedRoot(formula.getFormulaNo(), augmentedTrilateralRoot, kov));
                conjugationResultDisplay.setTransitivity(formula.getTransitive());
                conjugationResultDisplays.add(conjugationResultDisplay);
            }
        }
        rootResult.setRoot(rootLetters);
        rootResult.setKindOfVerb(kovRule.getDesc());
        rootResult.setUnaugmentedRoots(displays);
        rootResult.setConjugationResults(conjugationResultDisplays);
        return rootResult;
    }
}
