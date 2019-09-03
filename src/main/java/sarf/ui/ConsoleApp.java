package sarf.ui;

import com.google.inject.Guice;
import com.google.inject.Inject;
import sarf.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarf.kov.KovRulesManager;
import sarf.kov.TrilateralKovRule;
import sarf.noun.TrilateralUnaugmentedNouns;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeSuffixContainer;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.AssimilateModifier;
import sarf.noun.trilateral.unaugmented.modifier.elative.ElativeModifier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarf.ui.testhelpers.AugmentedTrilateralHelper;
import sarf.ui.testhelpers.TrilateralUnaugmentedHelper;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConsoleApp {
    //private final AugmentedTrilateralHelper augmentedTrilateralHelper;
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final TrilateralUnaugmentedHelper trilateralUnaugmentedHelper;

    @Inject
    public ConsoleApp(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , TrilateralUnaugmentedHelper trilateralUnaugmentedHelper) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.trilateralUnaugmentedHelper = trilateralUnaugmentedHelper;
        //this.augmentedTrilateralHelper = augmentedTrilateralHelper;
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
                , "ءبه", "ءبي", "ءثء", "بحح", "بخت", "بدء"
                , "ثءر", "جءو", "خلء", "ذءت", "رءي", "رهن"
                , "زهو", "سءل", "سحل", "سعي", "شءن",
                "لءم", "لجء", "منع", "نءي", "وبء",
                "وبه", "وجء", "وجع", "ودع", "وسع",
                "وضع", "وطء", "ولغ", "وهب", "وهل", "ينع"
                , "ءثل", "ءصل", "ءمن", "ءمو",
                "ءنث", "بطء", "بلد", "بلغ", "ثبت"
                , "ثخن", "جرء", "حبب", "ذبل", "سرو", "ضءل"
                , "طول", "كرم", "لدن", "وبء", "وجل", "ودع", "وزن",
                "وشك", "وضء", "وطء", "يتم", "يمن"
                , "حسب", "ورث", "ولي", "وهن", "يءس", "يبس"
        };
        // roots = new String[]{"ملل"};
        roots = new String[]{
                "ءبب", "ءنن", "ءبت", "ءبن", "ءبي", "ءتت", "ءتن"
                , "ءثء", "ءخذ", "ءذي", "ءسو", "ءكل", "ءلل", "ءمم", "ءمن", "ءمر"
                , "ءمل", "ءمو", "ءنن", "ءود", "ءوي", "بوء", "بيت", "بيع", "بحح"
                , "بدء", "تمم", "ثءر", "جءو", "جءي", "جيء", "جرء", "حور", "رءي", "رضو"
                , "رمي", "روي", "سءل", "سءم", "سعي", "سكت", "سكن", "سوو", "شوي"
                , "صدق", "ضءل", "ضحك", "طلق", "ظمء", "عضض", "علم", "عوج", "غزو"
                , "فرق", "قءم", "لءم", "لوح", "لين", "لجء", "لوي",
                "لكم", "لهء", "مءي", "مدد", "ملل", "منن",
                "نءل", "نءم", "نءم", "نءي", "نسل", "نصر", "هول"
                , "هوء", "وءد", "وءي", "وبء", "وتن", "ودد"
                , "ورث", "وقي", "يءس", "يدي", "يسس", "يسر", "يمن",

        //أسماء الزمان و المكان

                "ءيب", "ءبن"
                , "ءتت", "ءتي", "ءخذ", "ءزر", "ءسو"
                , "ءكل", "ءمم", "ءمر", "ءمل", "بوء", "بدء", "حسب"
                , "حيص", "حمل", "خيط", "رءي", "رجح", "ريق", "رمي", "سير"
                , "سحل", "سكن", "شوي", "ضرب", "عضض", "غزو", "غطي", "قوم"
                , "قرء", "كسو", "لوح", "لبس", "لكم", "لوي", "مءي", "مدد"
                , "ملل", "منن", "نسخ", "نسل", "نصر", "هول", "وءد", "وءي",
                "وسع", "وضء", "وطء", "وقي",
                // الصفة المشبهة
                "تعب", "تلد",
                "جوع", "جدب",
                "جرب", "جرد", "جهم"
                , "حزن", "خشن", "رطب",
                "رغد", "سمج", "طول", "عفف", "غضب", "قلل"
                , "كسل", "كلل", "نزه", "نعس", "هيم", "وله", "يبس"
                , "مرن"
        };

        var elatives = new String[]{
                "جود", "سوء", "شرر", "علو", "قسو", "ءجل", "خير", "طيب", "هدي", "بقي", "خفي", "رجو", "يبس", "غني", "بخل",
                "بطء", "بهو", "جرء", "ذكو", "لءم", "وضء", "علو", "قسو", "جلل"
        };

        var rootsFound = 0;
        for (var root : Stream.concat(Arrays.stream(roots), Arrays.stream(elatives)).distinct().collect(Collectors.toList())) {
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
            trilateralUnaugmentedHelper.printTrilateralTree(root, kov);
        }

        //augmentedTrilateralHelper.printPastActiveAugmentedVerbs(rootText);

    }

    private static void displayErrorMessage(String message) {
        System.err.printf("%s - %s\n", LocalDateTime.now().toString(), message);
    }
}
