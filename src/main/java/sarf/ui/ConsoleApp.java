package sarf.ui;

import sarf.KindOfVerb;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.kov.TrilateralKovRule;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleApp {
    public static void main(String[] args) {
        try {
            (new ConsoleApp()).Run();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println(Arrays.toString(ex.getStackTrace()));
            System.exit(1);
        }
    }

    private void Run() throws Exception {
        //@SuppressWarnings("resource")
        //String root = new Scanner(System.in).nextLine();
        String[] roots = new String[]{
                "ءوب", "ءنن", "ءبت", "ءبن", "ءتت"
                , "ءخذ", "ءسي", "ءكل", "ءمم", "ءمر", "ءمل"
                , "بوء", "سكت", "سكن", "غزو", "فوت", "قيم"
                , "لوح", "لكم", "لهو", "مين", "مءي", "مدد"
                , "ملل", "منن", "نسل", "نصر", "هيل", "يمن"
                , "وءي","ءون","ءبت","ءتن","ءتي","ءسر"
                ,"ءلل","ءنن","ءوي","بيع","تمم",
                "جيء","حمل","رمي","شوي","ضرب","طنن"
                ,"ليت","لين","لبس","لوي","ملل",
                "ملح","نءم","وءد","وءي",
                "وتن","ودي","وعد","وقت","وقي"
                ,"ولغ","وهن","يدي","يسس","يسر"
	            , "ءذي","ءسف","ءود","ءيس","بيت"
                ,"بيه","جءي","جون","حور"
                ,"حيي","خوف","خول","خشي"
                ,"دوء","دود","رضو","زيم"
                ,"سءم","سوو","شيء","شوك"
                ,"صوت","طيط","طيع","ظمء"
                ,"عوف","عيم","عضض","عوج","عين",
                "غير","غيد","فرح","قوي","كيد",
                "ميل","ملل","نول",
                "نوم","نوه","نيه","هيء","هيب"
                ,"هيع","هيع","هوء","وءب",
                "وبء","وبه","وتغ","وجع",
                "وجل","وجي","ودد","وذر"
                ,"وسع","وطء","وقع","ولغ"
                ,"وهل","يءس","يدي","يرر","يقظ"
        };

        var rootsFound = 0;
        for (var root : roots) {
            //System.out.println(root);
            if (root.length() == 3) {
                if(processTrilateral(root)) {
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

    private void processQuadrilateral(String root) {

    }

    private boolean processTrilateral(String root) throws Exception {
        AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(root);
        List<UnaugmentedTrilateralRoot> unaugmentedList = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(root);
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

        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        String kovText = rule.getDesc();
        KindOfVerb kov = rule.getKov();

        //System.out.println("نوع الفعل: " + kovText);
        for (UnaugmentedTrilateralRoot root : unaugmentedRoots) {
            printTrilateralTree(root, kov);
            //System.out.println();
        }

//        if(augmentedRoot != null) {
//			for (var formula : augmentedRoot.getAugmentationList()) {
//				System.out.println(formula.getFormulaNo());
//			}
//		}
    }

    private String getTransitiveDescription(String type) {
        if (type.equals("م")) return "متعد";
        if (type.equals("ل")) return "لازم";
        if (type.equals("ك")) return "كلاهما";
        throw new IllegalArgumentException("نوع رمز اللزوم و التعدي غير معروف");
    }

    private void printTrilateralTree(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        String transivity = getTransitiveDescription(root.getTransitive());
        //مع الضمير هو
        //past text formatting
       // System.out.printf("باب تصريف الفعل : %s\n", root.getConjugation());

        String pastRootText = sarf.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerb(7, root).toString();
        List<String> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //present text formatting
        String presentRootText = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        // System.out.printf("%s %s %s\n", pastRootText, presentRootText, transivity);

        // printActivePastConjugations(root, kov);
        // printActivePresentConjugations(root, kov);
        printImperativeConjugations(root, kov);
    }

    private void printActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List<ActivePastVerb> result = sarf.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList(root);
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
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getConjugation().getValue());
        for (Object verb : finalResult) {
            System.out.printf(" %s |", verb  == null ? "" : verb);
        }
        System.out.println("");
    }

    private void printImperativeConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        List result = sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createEmphasizedVerbList(root);
        ConjugationResult conjResult = UnaugmentedTrilateralModifier.getInstance().build(root, kov, result, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
        List finalResult = conjResult.getFinalResult();
        System.out.printf("| %c%c%c | %d |", root.getC1(), root.getC2(), root.getC3(), root.getConjugation().getValue());
        for (Object verb : finalResult) {
            System.out.printf(" %s |", verb  == null ? "" : verb);
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
