package sarf.noun.trilateral.unaugmented.assimilate;

import java.util.*;

import sarf.noun.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AssimilateFormulaE2SuffixContainer implements INounSuffixContainer{
    private static final AssimilateFormulaE2SuffixContainer instance = new AssimilateFormulaE2SuffixContainer();
    //حالة النكرة
    private final ArrayList<String>   indefiniteSuffixList = new ArrayList<>(18);
    //حالة المعرفة
    private final ArrayList<String>   definiteSuffixList = new ArrayList<>(18);
    //حالة الاضافة
    private final ArrayList<String>   annexedSuffixList = new ArrayList<>(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private  ArrayList<String>   currentSuffixList = indefiniteSuffixList ;

    private AssimilateFormulaE2SuffixContainer() {
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ ى");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ يَانِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ ى");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ يَيْنِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ ى");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ يَيْنِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");

        definiteSuffixList.add("");
        definiteSuffixList.add("َ ى");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ يَانِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ ى");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ يَيْنِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ ى");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ يَيْنِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");

        annexedSuffixList.add("");
        annexedSuffixList.add("َ ى");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ يَا");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ ى");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ يَيْ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("َ ى");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ يَيْ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
    }

    public void selectDefiniteMode() {
        prefix = "ال";
        currentSuffixList = definiteSuffixList;

        if (AssimilateFormulaE1SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE1SuffixContainer.getInstance().getDefiniteSuffixList())
            AssimilateFormulaE1SuffixContainer.getInstance().selectDefiniteMode();
    }

    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = indefiniteSuffixList;

        if (AssimilateFormulaE1SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE1SuffixContainer.getInstance().getIndefiniteSuffixList())
            AssimilateFormulaE1SuffixContainer.getInstance().selectInDefiniteMode();
    }

    public void selectAnnexedMode() {
        prefix = "";
        currentSuffixList = annexedSuffixList;

        if (AssimilateFormulaE1SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE1SuffixContainer.getInstance().getAnnexedSuffixList())
            AssimilateFormulaE1SuffixContainer.getInstance().selectAnnexedMode();
    }


    public static AssimilateFormulaE2SuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public  ArrayList<String>   getAnnexedSuffixList() {
        return annexedSuffixList;
    }

    public  ArrayList<String>   getCurrentSuffixList() {
        return currentSuffixList;
    }

    public  ArrayList<String>   getDefiniteSuffixList() {
        return definiteSuffixList;
    }

    public  ArrayList<String>   getIndefiniteSuffixList() {
        return indefiniteSuffixList;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

}
