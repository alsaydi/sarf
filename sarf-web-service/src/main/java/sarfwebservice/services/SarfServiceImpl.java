package sarfwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.*;
import sarf.kov.KovRulesManager;
import sarf.verb.Root;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.TriRootDisplay;

import java.util.ArrayList;
import java.util.List;

@Service
public class SarfServiceImpl implements SarfService {

    private final SarfDictionary sarfDictionary;
    private final Validator sarfValidator;
    private final KovRulesManager kovRulesManager;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final ActivePastConjugator unaugmentedTriActivePastConjugator;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator activePresentConjugator;

    @Autowired
    public SarfServiceImpl(SarfDictionary sarfDictionary
            , Validator sarfValidator
            , KovRulesManager kovRulesManager
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , ActivePastConjugator unaugmentedTriActivePastConjugator
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier, ActivePresentConjugator activePresentConjugator){
        this.sarfDictionary = sarfDictionary;
        this.sarfValidator = sarfValidator;
        this.kovRulesManager = kovRulesManager;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.unaugmentedTriActivePastConjugator = unaugmentedTriActivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.activePresentConjugator = activePresentConjugator;
    }

    public boolean isArabic(String letters){
        return sarfValidator.checkArabicLetters(letters);
    }

    public RootResult getRoots(String rootLetters) {
        try {
            var rootResult = new RootResult();
            var kov = kovRulesManager.getTrilateralKov(rootLetters.charAt(0), rootLetters.charAt(1), rootLetters.charAt(2));
            var conjugationResults = new ArrayList<ConjugationResult>();
            var displays = new ArrayList<TriRootDisplay>();

            var unaugmentedTrilateralRoots = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters);
            for(var root : unaugmentedTrilateralRoots) {
                var display = new TriRootDisplay();
                display.setRoot(root);
                display.setDisplay(conjugateRoot(root, kov));
                displays.add(display);
            }
            var augmentedTrilateralRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var augmentationFormulas =  augmentedTrilateralRoot.getAugmentationList();
            for (var formula : augmentationFormulas) {
                var verbs = augmentedActivePastConjugator.createVerbList(augmentedTrilateralRoot, formula.getFormulaNo());
                var conjugationResult = augmentedTrilateralModifier.build(augmentedTrilateralRoot, kov, formula.getFormulaNo(), verbs, SystemConstants.PAST_TENSE
                        , true, () -> true);
                conjugationResults.add(conjugationResult);
            }
            rootResult.setUnaugmentedRoots(displays);
            rootResult.setConjugationResults(conjugationResults);
            return rootResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String conjugateRoot(UnaugmentedTrilateralRoot root, KindOfVerb kov){
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

        return finalPastVerbText + " "+ finalPresentVerbText;
    }

    private static List<Word> createEmptyList() {
        List<Word> result = new ArrayList<>(13);
        for (int i = 1; i <= 13; i++) {
            result.add(Word.empty());
        }
        return result;
    }

}
