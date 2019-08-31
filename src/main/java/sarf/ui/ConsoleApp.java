package sarf.ui;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Guice;
import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.SarfDictionary;
import sarf.SarfModule;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.kov.TrilateralKovRule;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;

public class ConsoleApp {
	private final SarfDictionary sarfDictionary;
	private final KovRulesManager kovRulesManager;
	private final ActivePastConjugator triActivePastConjugator;
    private final PassivePastConjugator triPassivePastConjugator;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;

    @Inject
	public ConsoleApp(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , ActivePastConjugator triActivePastConjugator, PassivePastConjugator triPassivePastConjugator, UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator, ActiveParticipleModifier activeParticipleModifier){
		this.sarfDictionary = sarfDictionary;
		this.kovRulesManager = kovRulesManager;
		this.triActivePastConjugator = triActivePastConjugator;
        this.triPassivePastConjugator = triPassivePastConjugator;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
    }

	public static void main(String[] args) {
		try {
			var injector = Guice.createInjector(new SarfModule());
			var mainApp = injector.getInstance(ConsoleApp.class);
			mainApp.run();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			System.err.println(Arrays.toString(ex.getStackTrace()));
			System.exit(1);
		}
	}

	private void processQuadrilateral(String root) {
	}
    private void run() throws Exception {
        //@SuppressWarnings("resource")
        //String root = new Scanner(System.in).nextLine();
        String[] roots = new String[]{
                "ءوب", "ءنن", "ءبت", "ءبن", "ءتت"
                , "ءخذ", "ءسي", "ءكل", "ءمم", "ءمر", "ءمل"
                , "بوء", "سكت", "سكن", "غزو", "فوت", "قيم"
                , "لوح", "لكم", "لهو", "مين", "مءي", "مدد"
                , "ملل", "منن", "نسل", "نصر", "هيل", "يمن"
                , "وءي", "ءون", "ءبت", "ءتن", "ءتي", "ءسر"
                , "ءلل", "ءنن", "ءوي", "بيع", "تمم",
                "جيء", "حمل", "رمي", "شوي", "ضرب", "طنن"
                , "ليت", "لين", "لبس", "لوي", "ملل",
                "ملح", "نءم", "وءد", "وءي",
                "وتن", "ودي", "وعد", "وقت", "وقي"
                , "ولغ", "وهن", "يدي", "يسس", "يسر"
                , "ءذي", "ءسف", "ءود", "ءيس", "بيت"
                , "بيه", "جءي", "جون", "حور"
                , "حيي", "خوف", "خول", "خشي"
                , "دوء", "دود", "رضو", "زيم"
                , "سءم", "سوو", "شيء", "شوك"
                , "صوت", "طيط", "طيع", "ظمء"
                , "عوف", "عيم", "عضض", "عوج", "عين",
                "غير", "غيد", "فرح", "قوي", "كيد",
                "ميل", "ملل", "نول",
                "نوم", "نوه", "نيه", "هيء", "هيب"
                , "هيع", "هيع", "هوء", "وءب",
                "وبء", "وبه", "وتغ", "وجع",
                "وجل", "وجي", "ودد", "وذر"
                , "وسع", "وطء", "وقع", "ولغ"
                , "وهل", "يءس", "يدي", "يرر", "يقظ"
                , "ءبه","ءبي","ءثء","بحح","بخت","بدء"
                ,"ثءر","جءو","خلء","ذءت","رءي","رهن"
                ,"زهو","سءل","سحل","سعي","شءن",
                "لءم","لجء","منع","نءي","وبء",
                "وبه","وجء","وجع","ودع","وسع",
                "وضع","وطء","ولغ","وهب","وهل","ينع"
                ,"ءثل","ءصل","ءمن","ءمو",
                "ءنث","بطء","بلد","بلغ","ثبت"
                ,"ثخن","جرء","حبب","ذبل","سرو","ضءل"
                ,"طول","كرم","لدن","وبء","وجل","ودع","وزن",
                "وشك","وضء","وطء","يتم","يمن"
                ,"حسب","ورث","ولي","وهن","يءس","يبس"
        };
        roots = new String[]{"ملل"};
        var rootsFound = 0;
        for (var root : roots) {
            //System.out.println(root);
            if (root.length() == 3) {
                if (processTrilateral(root)) {
                    rootsFound++;
                }
            } else if (root.length() == 4) {
                processQuadrilateral(root);
            } else {
                System.err.printf("%s ليس جذراً مقبولاً", root);
            }
        }

        System.out.println("Roots " + roots.length + " and processed " + rootsFound);
    }
    private boolean processTrilateral(String root) throws Exception {
        AugmentedTrilateralRoot augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(root);
        List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(root);
        if (augmentedRoot == null && unaugmentedList.isEmpty()) {
            displayErrorMessage(root + ": لم يرد هذا الجذر في قاعدة المعطيات");
            return false;
        }
        displayTrilateral(root, augmentedRoot, unaugmentedList);
        return true;
    }

    private void displayTrilateral(String rootText, AugmentedTrilateralRoot augmentedRoot, List<UnaugmentedTrilateralRoot> unaugmentedRoots) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        TrilateralKovRule rule = kovRulesManager.getTrilateralKovRule(c1, c2, c3);
        String kovText = rule.getDesc();
        KindOfVerb kov = rule.getKov();

        for (UnaugmentedTrilateralRoot root : unaugmentedRoots) {
            printTrilateralTree(root, kov);
        }
    }

    private String getTransitiveDescription(String type) {
        if (type.equals("م")) return "متعد";
        if (type.equals("ل")) return "لازم";
        if (type.equals("ك")) return "كلاهما";
        throw new IllegalArgumentException("نوع رمز اللزوم و التعدي غير معروف");
    }

    private void printTrilateralTree(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        String pastRootText = triActivePastConjugator.createVerb(7, root).toString();
        List<String> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        String presentRootText = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        // System.out.printf("%s %s %s\n", pastRootText, presentRootText, transivity);

        // printActivePastConjugations(root, kov);
        // printActivePresentConjugations(root, kov);
        // printImperativeConjugations(root, kov);
        // printPassivePastConjugations(root, kov);
        // printPassivePresentConjugations(root, kov);
        printActiveParticiple(root, kov);
    }

    private void printActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List<ActivePastVerb> result = triActivePastConjugator.createVerbList(root);
        ConjugationResult conjResult = UnaugmentedTrilateralModifier.getInstance().build(root, kov, result, SystemConstants.PAST_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        for (Object verb : finalResult) {
            System.out.printf("|%s", verb == null ? "" : verb);
        }
        System.out.println();
    }

    private void printActivePresentConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List result = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerbList(root);
        ConjugationResult conjResult = UnaugmentedTrilateralModifier.getInstance().build(root, kov, result, SystemConstants.PRESENT_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, finalResult);
    }

    private void printImperativeConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List result = sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createEmphasizedVerbList(root);
        ConjugationResult conjResult = UnaugmentedTrilateralModifier.getInstance().build(root, kov, result, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, finalResult);
    }

    private void printPassivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = triPassivePastConjugator.createVerbList(root);
        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, result, SystemConstants.PAST_TENSE, false);
        result = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, result);
    }

    private void printPassivePresentConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov){
        var result = sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().createEmphasizedVerbList(root);
        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier
                .UnaugmentedTrilateralModifier.getInstance()
                .build(root, kov, result, SystemConstants.PRESENT_TENSE, false);
        result = conjResult.getFinalResult();
        printFinalResultPipeSeparated(root, result);
    }

    private void printActiveParticiple(UnaugmentedTrilateralRoot root, KindOfVerb kov){
        var formulas = new String[]{"فاعل"};
        for(var formula : formulas) {
            var nouns = unaugmentedTrilateralActiveParticipleConjugator.createNounList(root, formula.toString());
            var finalResult = activeParticipleModifier.build(root, kov, nouns, formula).getFinalResult();
            printFinalResultPipeSeparated(root, finalResult);
        }
    }

    private static void printFinalResultPipeSeparated(UnaugmentedTrilateralRoot root, List finalResult) {
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getConjugation().getValue());
        for (Object verb : finalResult) {
            System.out.printf(" %s |", verb == null ? "" : verb);
        }
        System.out.println("");
    }

    private static void displayErrorMessage(String message) {
        System.err.printf("%s - %s\n", LocalDateTime.now().toString(), message);
    }

    private static List<String> createEmptyList() {
        return IntStream.range(0, 13)
                .mapToObj(a -> "")
                .collect(Collectors.toList());
    }
}
