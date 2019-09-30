package sarf.gerund.trilateral.unaugmented;

import java.util.*;

import com.google.inject.Singleton;
import sarf.SystemConstants;
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
@Singleton
public class StandardTrilateralUnaugmentedSuffixContainer implements INounSuffixContainer {
    //حالة النكرة
    private final List<String> indefiniteSuffixList = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
    //حالة المعرفة
    private final List<String> definiteSuffixList = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
    //حالة الاضافة
    private final List<String> annexedSuffixList = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private List<String> currentSuffixList = indefiniteSuffixList;

    public StandardTrilateralUnaugmentedSuffixContainer() {
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

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return currentSuffixList.get(index);
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
