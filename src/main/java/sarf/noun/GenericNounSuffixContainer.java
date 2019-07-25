package sarf.noun;

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
public class GenericNounSuffixContainer implements INounSuffixContainer{
    private static final GenericNounSuffixContainer instance = new GenericNounSuffixContainer();
    //حالة النكرة
    private final ArrayList indefiniteSuffixList = new ArrayList(18);
    //حالة المعرفة
    private final ArrayList definiteSuffixList = new ArrayList(18);
    //حالة الاضافة
    private final ArrayList annexedSuffixList = new ArrayList(18);

    //تكون لها قيمة عندما تكون الحالة هي معرفة
    private String prefix = "";
    //يمثل القائمة المختارة تبعاً للحالة
    private ArrayList currentSuffixList = indefiniteSuffixList ;

    private GenericNounSuffixContainer() {
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

    public static GenericNounSuffixContainer getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public String get(int index) {
        return (String) currentSuffixList.get(index);
    }

    public boolean isInDefiniteMode() {
        return currentSuffixList == indefiniteSuffixList;
    }

}
