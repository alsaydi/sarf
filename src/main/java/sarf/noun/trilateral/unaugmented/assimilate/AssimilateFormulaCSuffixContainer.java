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
public class AssimilateFormulaCSuffixContainer implements INounSuffixContainer{
    private static final AssimilateFormulaCSuffixContainer instance = new AssimilateFormulaCSuffixContainer();
    //حالة النكرة
    private final ArrayList<String>  indefiniteSuffixList = new ArrayList<>(18);
    //حالة المعرفة
    private final ArrayList<String>  definiteSuffixList = new ArrayList<>(18);
    //حالة الاضافة
    private final ArrayList<String>  annexedSuffixList = new ArrayList<>(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private ArrayList<String>  currentSuffixList = indefiniteSuffixList ;

    private AssimilateFormulaCSuffixContainer() {
        indefiniteSuffixList.add("ُ");
        indefiniteSuffixList.add("َاءُ");
        indefiniteSuffixList.add("َانِ");
        indefiniteSuffixList.add("َاوَانِ");
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َاءَ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َاوَيْنِ");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("َ");
        indefiniteSuffixList.add("َاءَ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َاوَيْنِ");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("ٍ");


        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َاءُ");
        definiteSuffixList.add("َانِ");
        definiteSuffixList.add("َاوَانِ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َاءَ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َاوَيْنِ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("َاءِ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َاوَيْنِ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("ِ");



        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َاءُ");
        annexedSuffixList.add("َا");
        annexedSuffixList.add("َاوَا");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َاءَ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َاوَيْ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("َاءِ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َاوَيْ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("ِ");

    }

    public void selectDefiniteMode() {
        prefix = "ال";
        currentSuffixList = definiteSuffixList;
    }

    public void selectInDefiniteMode() {
        prefix = "";
        currentSuffixList = indefiniteSuffixList;
    }

    public void selectAnnexedMode() {
        prefix = "";
        currentSuffixList = annexedSuffixList;
    }

    public static AssimilateFormulaCSuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

}
