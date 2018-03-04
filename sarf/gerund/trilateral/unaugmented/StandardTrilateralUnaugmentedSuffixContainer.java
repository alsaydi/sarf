package sarf.gerund.trilateral.unaugmented;

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
public class StandardTrilateralUnaugmentedSuffixContainer implements INounSuffixContainer{
    private static StandardTrilateralUnaugmentedSuffixContainer instance = new StandardTrilateralUnaugmentedSuffixContainer();
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

    private StandardTrilateralUnaugmentedSuffixContainer() {
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("ً");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");

        definiteSuffixList.add("ُ");
        definiteSuffixList.add("ُ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");

        annexedSuffixList.add("ُ");
        annexedSuffixList.add("ُ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
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

    public static StandardTrilateralUnaugmentedSuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

    public boolean isAnnexed() {
         return currentSuffixList == annexedSuffixList;
     }

     public boolean isDefinite() {
         return currentSuffixList == definiteSuffixList;
     }

     public boolean isIndefinite() {
         return currentSuffixList == indefiniteSuffixList;
     }

}
