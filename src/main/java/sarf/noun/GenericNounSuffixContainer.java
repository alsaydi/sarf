package sarf.noun;

import com.google.inject.Singleton;

import java.util.*;

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
public class GenericNounSuffixContainer implements INounSuffixContainer {
    //حالة النكرة
    private final List<String> indefiniteSuffixList = new ArrayList<>(18);
    //حالة المعرفة
    private final List<String> definiteSuffixList = new ArrayList<>(18);
    //حالة الاضافة
    private final List<String> annexedSuffixList = new ArrayList<>(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private List<String> currentSuffixList = indefiniteSuffixList;

    public GenericNounSuffixContainer() {
        indefiniteSuffixList.add("ٌ");
        indefiniteSuffixList.add("َةٌ");
        indefiniteSuffixList.add("َانِ");
        indefiniteSuffixList.add("َتَانِ");
        indefiniteSuffixList.add("ُونَ");
        indefiniteSuffixList.add("َاتٌ");
        indefiniteSuffixList.add("ًا");
        indefiniteSuffixList.add("َةً");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َتَيْنِ");
        indefiniteSuffixList.add("ِينَ");
        indefiniteSuffixList.add("َاتٍ");
        indefiniteSuffixList.add("ٍ");
        indefiniteSuffixList.add("َةٍ");
        indefiniteSuffixList.add("َيْنِ");
        indefiniteSuffixList.add("َتَيْنِ");
        indefiniteSuffixList.add("ِينَ");
        indefiniteSuffixList.add("َاتٍ");

        definiteSuffixList.add("ُ");
        definiteSuffixList.add("َةُ");
        definiteSuffixList.add("َانِ");
        definiteSuffixList.add("َتَانِ");
        definiteSuffixList.add("ُونَ");
        definiteSuffixList.add("َاتُ");
        definiteSuffixList.add("َ");
        definiteSuffixList.add("َةَ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َتَيْنِ");
        definiteSuffixList.add("ِينَ");
        definiteSuffixList.add("َاتِ");
        definiteSuffixList.add("ِ");
        definiteSuffixList.add("َةِ");
        definiteSuffixList.add("َيْنِ");
        definiteSuffixList.add("َتَيْنِ");
        definiteSuffixList.add("ِينَ");
        definiteSuffixList.add("َاتِ");


        annexedSuffixList.add("ُ");
        annexedSuffixList.add("َةُ");
        annexedSuffixList.add("َا");
        annexedSuffixList.add("َتَا");
        annexedSuffixList.add("ُو");
        annexedSuffixList.add("َاتُ");
        annexedSuffixList.add("َ");
        annexedSuffixList.add("َةَ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َتَيْ");
        annexedSuffixList.add("ِي");
        annexedSuffixList.add("َاتِ");
        annexedSuffixList.add("ِ");
        annexedSuffixList.add("َةِ");
        annexedSuffixList.add("َيْ");
        annexedSuffixList.add("َتَيْ");
        annexedSuffixList.add("ِي");
        annexedSuffixList.add("َاتِ");

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

    public boolean isInDefiniteMode() {
        return currentSuffixList == indefiniteSuffixList;
    }
}
