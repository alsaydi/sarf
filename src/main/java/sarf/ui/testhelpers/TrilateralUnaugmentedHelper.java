package sarf.ui.testhelpers;

import com.google.inject.Inject;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.SystemConstants;
import sarf.Word;
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
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;
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
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrilateralUnaugmentedHelper {
    private final ActivePastConjugator triActivePastConjugator;
    private final PassivePastConjugator triPassivePastConjugator;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator;
    private final PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier;
    private final TrilateralUnaugmentedNouns trilateralUnaugmentedNouns;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final ExaggerationModifier exaggerationModifier;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final TimeAndPlaceConjugator timeAndPlaceConjugator;
    private final TimeAndPlaceModifier timeAndPlaceModifier;
    private final StandardInstrumentalConjugator standardInstrumentalConjugator;
    private final InstrumentalModifier instrumentalModifier;
    private final AssimilateAdjectiveConjugator assimilateConjugator;
    private final AssimilateModifier assimilateModifier;
    private final ElativeNounConjugator elativeConjugator;
    private final ElativeModifier elativeModifier;
    private final TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator;
    private final UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier;
    private final MeemGerundConjugator meemGerundConjugator;
    private final TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier;
    private final TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator;
    private final TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier;
    private final QualityGerundConjugator qualityGerundConjugator;
    private final TrilateralUnaugmentedQualityModifier qualityGerundModifier;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator triUnaugmentedActivePresentConjugator;
    private final UnaugmentedImperativeConjugator unaugmentedImperativeConjugator;
    private final PassivePresentConjugator passivePresentConjugator;

    @Inject
    public TrilateralUnaugmentedHelper(ActivePastConjugator triActivePastConjugator
            , PassivePastConjugator triPassivePastConjugator
            , UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator
            , PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier
            , TrilateralUnaugmentedNouns trilateralUnaugmentedNouns
            , StandardExaggerationConjugator standardExaggerationConjugator
            , ExaggerationModifier exaggerationModifier
            , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
            , TimeAndPlaceConjugator timeAndPlaceConjugator
            , TimeAndPlaceModifier timeAndPlaceModifier
            , StandardInstrumentalConjugator standardInstrumentalConjugator
            , InstrumentalModifier instrumentalModifier
            , AssimilateAdjectiveConjugator assimilateConjugator
            , AssimilateModifier assimilateModifier
            , ElativeNounConjugator elativeConjugator
            , ElativeModifier elativeModifier
            , TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator
            , UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier
            , MeemGerundConjugator meemGerundConjugator
            , TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier
            , TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator
            , TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier
            , QualityGerundConjugator qualityGerundConjugator
            , TrilateralUnaugmentedQualityModifier qualityGerundModifier
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator triUnaugmentedActivePresentConjugator
            , UnaugmentedImperativeConjugator unaugmentedImperativeConjugator
            , PassivePresentConjugator passivePresentConjugator) {
        this.triActivePastConjugator = triActivePastConjugator;
        this.triPassivePastConjugator = triPassivePastConjugator;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.unaugmentedTrilateralPassiveParticipleConjugator = unaugmentedTrilateralPassiveParticipleConjugator;
        this.trilateralUnaugmentedPassiveParticipleModifier = trilateralUnaugmentedPassiveParticipleModifier;
        this.trilateralUnaugmentedNouns = trilateralUnaugmentedNouns;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.exaggerationModifier = exaggerationModifier;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.timeAndPlaceConjugator = timeAndPlaceConjugator;
        this.timeAndPlaceModifier = timeAndPlaceModifier;
        this.standardInstrumentalConjugator = standardInstrumentalConjugator;
        this.instrumentalModifier = instrumentalModifier;
        this.assimilateConjugator = assimilateConjugator;
        this.assimilateModifier = assimilateModifier;
        this.elativeConjugator = elativeConjugator;
        this.elativeModifier = elativeModifier;
        this.trilateralUnaugmentedGerundConjugator = trilateralUnaugmentedGerundConjugator;
        this.unaugmentedTrilateralStandardGerundModifier = unaugmentedTrilateralStandardGerundModifier;
        this.meemGerundConjugator = meemGerundConjugator;
        this.trilateralUnaugmentedMeemModifier = trilateralUnaugmentedMeemModifier;
        this.trilateralUnaugmentedNomenGerundConjugator = trilateralUnaugmentedNomenGerundConjugator;
        this.trilateralUnaugmentedNomenModifier = trilateralUnaugmentedNomenModifier;
        this.qualityGerundConjugator = qualityGerundConjugator;

        this.qualityGerundModifier = qualityGerundModifier;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.triUnaugmentedActivePresentConjugator = triUnaugmentedActivePresentConjugator;
        this.unaugmentedImperativeConjugator = unaugmentedImperativeConjugator;
        this.passivePresentConjugator = passivePresentConjugator;
    }

    public void printTrilateralTree(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        String pastRootText = triActivePastConjugator.createVerb(7, root).toString();
        var conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(pastRootText));
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        String presentRootText = triUnaugmentedActivePresentConjugator.createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(presentRootText));
        conjResult = unaugmentedTrilateralModifier.build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        // System.out.printf("%s %s %s\n", pastRootText, presentRootText, transivity);

        // printActivePastConjugations(root, kov);
        // printActivePresentConjugations(root, kov);
        // printImperativeConjugations(root, kov);
        // printPassivePastConjugations(root, kov);
        // printPassivePresentConjugations(root, kov);
        // printActiveParticiple(root, kov);
        // printPastParticiple(root, kov);
        // printActiveParticipleExaggerated(root, kov);
        // printActiveParticipleExaggeratedNonStandard(root, kov);
        // printTimeAndPlace(root, kov);
        // printInstrumentNouns(root, kov);
        // printAssimilateNouns(root, kov);
        // printElatives(root, kov);
        // printStandardGerund(root, kov);
        printStandardGerund(root, kov);
        try {
            printQualityGerund(root, kov);
        } catch (Exception ignored) {
        }
    }

    private void printActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List<ActivePastVerb> result = triActivePastConjugator.createVerbList(root);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PAST_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        for (Object verb : finalResult) {
            System.out.printf("|%s", verb == null ? "" : verb);
        }
        System.out.println();
    }

    private void printActivePresentConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = triUnaugmentedActivePresentConjugator.createNominativeVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, finalResult);
    }

    private void printImperativeConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = unaugmentedImperativeConjugator.createEmphasizedVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, finalResult);
    }

    private void printPassivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List<? extends Word> result = triPassivePastConjugator.createVerbList(root);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PAST_TENSE, false);
        printFinalResultPipeSeparated(root, conjResult.getFinalResult());
    }

    private void printPassivePresentConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List<? extends Word> result = passivePresentConjugator.createEmphasizedVerbList(root);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, false);
        printFinalResultPipeSeparated(root, conjResult.getFinalResult());
    }

    private void printActiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = new String[]{"فاعل"};
        for (var formula : formulas) {
            var nouns = unaugmentedTrilateralActiveParticipleConjugator.createNounList(root, formula);
            var finalResult = activeParticipleModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult);
        }
    }

    private void printPastParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = new String[]{"مفعول"};
        for (var formula : formulas) {
            var nouns = unaugmentedTrilateralPassiveParticipleConjugator.createNounList(root, formula);
            var finalResult = trilateralUnaugmentedPassiveParticipleModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult);
        }
    }

    private void printActiveParticipleExaggerated(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var standardFormulas = trilateralUnaugmentedNouns.getStandardExaggerations(root);
        for (String formula : standardFormulas) {
            var nouns = standardExaggerationConjugator.createNounList(root, formula);
            var finalResult = exaggerationModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult);
        }
    }

    private void printActiveParticipleExaggeratedNonStandard(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var nonStandardFormulas = trilateralUnaugmentedNouns.getNonStandardExaggerations(root);
        if (nonStandardFormulas == null) {
            return; //some roots don't have exaggerated entries in the database.
        }
        for (String formula : nonStandardFormulas) {
            var nouns = nonStandardExaggerationConjugator.createNounList(root, formula);
            var finalResult = exaggerationModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult, formula);

        }
    }

    private void printTimeAndPlace(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedNouns.getTimeAndPlaces(root);
        if (formulas == null) {
            return;
        }
        for (var formula : formulas) {
            var nouns = timeAndPlaceConjugator.createNounList(root, formula);
            var finalResult = timeAndPlaceModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult, formula);
        }
    }

    private void printInstrumentNouns(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedNouns.getStandardInstrumentals(root);
        if (formulas == null) {
            return;
        }
        for (var formula : formulas) {
            var nouns = standardInstrumentalConjugator.createNounList(root, formula);
            var finalResult = instrumentalModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult, formula);
        }
    }

    private void printAssimilateNouns(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedNouns.getAssimilates(root);
        for (var formula : formulas) {
            var nouns = assimilateConjugator.createNounList(root, formula);
            var finalResult = assimilateModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult, formula);
        }
    }

    private void printElatives(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedNouns.getElatives(root);
        if (formulas == null) {
            return;
        }
        for (var formula : formulas) {
            ElativeSuffixContainer.getInstance().selectAnnexedMode();
            var nouns = elativeConjugator.createNounList(root, formula);
            var finalResult = elativeModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult, formula);
        }
    }

    private void printStandardGerund(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedGerundConjugator.getAppliedFormulaList(root);
        for (var formula : formulas) {
            var rawNouns = trilateralUnaugmentedGerundConjugator.createGerundList(root, formula);
            var conjugationResult = unaugmentedTrilateralStandardGerundModifier.build(root, kov, rawNouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult, formula);

        }
    }

    private void printMeemGerund(UnaugmentedTrilateralRoot root, KindOfVerb kov) throws Exception {
        var formulas = meemGerundConjugator.getAppliedFormulaList(root);
        for (var formula : formulas) {
            var rawNouns = meemGerundConjugator.createGerundList(root, formula);
            var conjugationResult = trilateralUnaugmentedMeemModifier.build(root, kov, rawNouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult, formula);

        }
    }

    private void printNomenGerund(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var formulas = trilateralUnaugmentedNomenGerundConjugator.getAppliedFormulaList(root);
        for (var formula : formulas) {
            var rawNouns = trilateralUnaugmentedNomenGerundConjugator.createGerundList(root, formula);
            var conjugationResult = trilateralUnaugmentedNomenModifier.build(root, kov, rawNouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, conjugationResult, formula);

        }
    }

    private void printQualityGerund(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var rawNouns = qualityGerundConjugator.createGerundList(root, null);
        var conjugationResult = qualityGerundModifier.build(root, kov, rawNouns, null).getFinalResult();
        printFinalResultPipeSeparated(root, conjugationResult, "");
    }

    private String getTransitiveDescription(String type) {
        if (type.equals("م")) return "متعد";
        if (type.equals("ل")) return "لازم";
        if (type.equals("ك")) return "كلاهما";
        throw new IllegalArgumentException("نوع رمز اللزوم و التعدي غير معروف");
    }


    private static void printFinalResultPipeSeparated(UnaugmentedTrilateralRoot root, List finalResult) {
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getConjugation().getValue());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.println();
    }

    private static void printFinalResultPipeSeparated(UnaugmentedTrilateralRoot root, List finalResult, String formula) {
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getConjugation().getValue());
        for (Object word : finalResult) {
            System.out.printf(" %s |", word == null ? "" : word);
        }
        System.out.printf("%s |", formula);
        System.out.println();
    }

    private static List<Word> createEmptyList() {
        return IntStream.range(0, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(a -> Word.empty())
                .collect(Collectors.toList());
    }
}
