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
public class AssimilateFormulaE1SuffixContainer implements INounSuffixContainer{
    private static AssimilateFormulaE1SuffixContainer instance = new AssimilateFormulaE1SuffixContainer();
    //حالة النكرة
    private ArrayList indefiniteSuffixList = new ArrayList(18);
    //حالة المعرفة
    private ArrayList definiteSuffixList = new ArrayList(18);
    //حالة الاضافة
    private ArrayList annexedSuffixList = new ArrayList(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private ArrayList currentSuffixList = indefiniteSuffixList ;

    private AssimilateFormulaE1SuffixContainer() {
        indefiniteSuffixList.add("ُ");
        indefiniteSuffixList.add("َ ةٌ");
        indefiniteSuffixList.add("َ انِ");
        indefiniteSuffixList.add("َ تَانِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َ ةً");
        indefiniteSuffixList.add("َ يْنِ");
        indefiniteSuffixList.add("َ تَيْنِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َ ةٍ");
        indefiniteSuffixList.add("َ يْنِ");
        indefiniteSuffixList.add("َ تَيْنِ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");


        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َ ةُ");
        definiteSuffixList.add("َ انِ");
        definiteSuffixList.add("َ تَانِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َ ةَ");
        definiteSuffixList.add("َ يْنِ");
        definiteSuffixList.add("َ تَيْنِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("َ ةِ");
        definiteSuffixList.add("َ يْنِ");
        definiteSuffixList.add("َ تَيْنِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");


        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َ ةُ");
        annexedSuffixList.add("َ ا");
        annexedSuffixList.add("َ تَا");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َ ةَ");
        annexedSuffixList.add("َ يْ");
        annexedSuffixList.add("َ تَيْ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("َ ةِ");
        annexedSuffixList.add("َ يْ");
        annexedSuffixList.add("َ تَيْ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");

    }

    public void selectDefiniteMode() {
        prefix = "ال";
        currentSuffixList = definiteSuffixList;

        if (AssimilateFormulaE2SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE2SuffixContainer.getInstance().getDefiniteSuffixList())
            AssimilateFormulaE2SuffixContainer.getInstance().selectDefiniteMode();
    }

    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = indefiniteSuffixList;

        if (AssimilateFormulaE2SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE2SuffixContainer.getInstance().getIndefiniteSuffixList())
            AssimilateFormulaE2SuffixContainer.getInstance().selectInDefiniteMode();
    }

    public void selectAnnexedMode() {
        prefix = "";
        currentSuffixList = annexedSuffixList;

        if (AssimilateFormulaE2SuffixContainer.getInstance().getCurrentSuffixList() != AssimilateFormulaE2SuffixContainer.getInstance().getAnnexedSuffixList())
            AssimilateFormulaE2SuffixContainer.getInstance().selectAnnexedMode();
    }

    public static AssimilateFormulaE1SuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public ArrayList getAnnexedSuffixList() {
        return annexedSuffixList;
    }

    public ArrayList getCurrentSuffixList() {
        return currentSuffixList;
    }

    public ArrayList getDefiniteSuffixList() {
        return definiteSuffixList;
    }

    public ArrayList getIndefiniteSuffixList() {
        return indefiniteSuffixList;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

}
