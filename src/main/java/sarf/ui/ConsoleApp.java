package sarf.ui;

import com.google.inject.Guice;
import com.google.inject.Inject;
import sarf.*;
import sarf.kov.KovRulesManager;
import sarf.kov.TrilateralKovRule;
import sarf.ui.testhelpers.QuadrilateralAugmentedHelper;
import sarf.ui.testhelpers.QuadrilateralUnaugmentedHelper;
import sarf.ui.testhelpers.TrilateralAugmentedHelper;
import sarf.ui.testhelpers.TrilateralUnaugmentedHelper;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleApp {
    //private final TrilateralAugmentedHelper augmentedTrilateralHelper;
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final TrilateralUnaugmentedHelper trilateralUnaugmentedHelper;
    private final TrilateralAugmentedHelper augmentedTrilateralHelper;
    private final QuadrilateralUnaugmentedHelper quadrilateralUnaugmentedHelper;
    private final QuadrilateralAugmentedHelper quadrilateralAugmentedHelper;

    @Inject
    public ConsoleApp(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , TrilateralUnaugmentedHelper trilateralUnaugmentedHelper
            , TrilateralAugmentedHelper augmentedTrilateralHelper, QuadrilateralUnaugmentedHelper quadrilateralUnaugmentedHelper, QuadrilateralAugmentedHelper quadrilateralAugmentedHelper) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.trilateralUnaugmentedHelper = trilateralUnaugmentedHelper;
        this.augmentedTrilateralHelper = augmentedTrilateralHelper;
        this.quadrilateralUnaugmentedHelper = quadrilateralUnaugmentedHelper;
        this.quadrilateralAugmentedHelper = quadrilateralAugmentedHelper;
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
        //quadrilateralAugmentedHelper.printPastActive(root);
        quadrilateralUnaugmentedHelper.printPastActive(root);
        //quadrilateralUnaugmentedHelper.printPresentActive(root);
        //quadrilateralUnaugmentedHelper.printImperative(root);
        //quadrilateralUnaugmentedHelper.printPassivePast(root);
        //quadrilateralUnaugmentedHelper.printPassivePresent(root);
        //quadrilateralUnaugmentedHelper.printActiveParticiple(root);
        //quadrilateralUnaugmentedHelper.printPassiveParticiple(root);
        //quadrilateralUnaugmentedHelper.printTimeAndPlace(root);
        //quadrilateralUnaugmentedHelper.printGerund(root);
        //quadrilateralUnaugmentedHelper.printNomenGerund(root);
        //quadrilateralUnaugmentedHelper.printMeemGerund(root);
        //quadrilateralAugmentedHelper.printPastActive(root);
        //quadrilateralAugmentedHelper.printPresent(root);
        //quadrilateralAugmentedHelper.printImperative(root);
        //quadrilateralAugmentedHelper.printPassivePast(root);
        //quadrilateralAugmentedHelper.printPassivePresent(root);
        //quadrilateralAugmentedHelper.printActiveParticiple(root);
        //quadrilateralAugmentedHelper.printPassiveParticiple(root);
        //quadrilateralAugmentedHelper.printTimeAndPlace(root);
        //quadrilateralAugmentedHelper.printGerund(root);
        //quadrilateralAugmentedHelper.printMeemGerund(root);
        //quadrilateralAugmentedHelper.printNomenGerund(root);
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
                , "ءبب", "ءنن", "ءبت", "ءبن", "ءبي", "ءتت", "ءتن"
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

        var augmentedRoots = new String[]{
            "ءتي", "ءدي" , "ءجر", "نءد","ءتل", "بيض","ءكل","جءل","ءبن","ءذن","حزو","جءي"
                , "غوي"
                , "دهم"
                , "بلج"
                , "قبل"
                , "ءيس", "صبر", "نتء", "ختو"
                , "نءي", "دخر", "ملح", "شءم","يقظ"
                , "ءسو", "ءسي", "ءضض"
                , "حوي" , "حيي"
                , "كتب"
                , "ورد"
                , "سعي"
                , "ركض"
                , "يبس"
                , "حدي"
                , "نسي"
                , "هيء"
        };

        var qroots = new String[]{
                "دحرج"
                ,"بءدل"
                ,"بلور"
                ,"تلفن"
                ,"تنتن"
                ,"جءجء","حوقل","حيحي"
                ,"دحرج","رهيء","زلزل","سبرت","سيطر","شريف"
                ,"ضوضي","طمءن","غرقء","قلسي","وءوء","وسوس","يءيء","يرنء","يهيه"
                ,"شرءب", "مرءي"
                ,"شيطن", "وشوش"
                ,"بخدن", "حبطء", "حوصل", "سلقي" , "فرقع" , "قشعر" , "كوءد", "كوهد", "مضحن"
        };

        //qroots = new String []{"جءجء"};
        roots = new String[]{"حيحي"};
        var rootsFound = 0;
        for (var root : Stream.concat(Arrays.stream(roots), Arrays.stream(roots)).distinct().collect(Collectors.toList())) {
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
        //augmentedTrilateralHelper.printPresentActiveAugmentedVerbs(rootText);
        //augmentedTrilateralHelper.printImperativeAugmentedVerbs(rootText);
        //augmentedTrilateralHelper.printPassivePast(rootText);
        //augmentedTrilateralHelper.printPassivePresent(rootText);
        //augmentedTrilateralHelper.printActiveParticiple(rootText);
        //augmentedTrilateralHelper.printPassiveParticiple(rootText);
        //augmentedTrilateralHelper.printTimeAndPlace(rootText);
        //augmentedTrilateralHelper.printGerund(rootText);
        //augmentedTrilateralHelper.printNomenGerund(rootText);
       // augmentedTrilateralHelper.printMeemGerund(rootText);
    }

    private static void displayErrorMessage(String message) {
        System.err.printf("%s - %s\n", LocalDateTime.now().toString(), message);
    }
}
