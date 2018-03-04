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
    //Õ«·… «·‰ﬂ—…
    private ArrayList indefiniteSuffixList = new ArrayList(18);
    //Õ«·… «·„⁄—›…
    private ArrayList definiteSuffixList = new ArrayList(18);
    //Õ«·… «·«÷«›…
    private ArrayList annexedSuffixList = new ArrayList(18);

    // ﬂÊ‰ ·Â« ﬁÌ„… ⁄‰œ„«  ﬂÊ‰ «·Õ«·… ÂÌ „⁄—›…
    private String prefix = "";
    //Ì„À· «·ﬁ«∆„… «·„Œ «—…  »⁄« ··Õ«·…
    private ArrayList currentSuffixList = indefiniteSuffixList ;

    private StandardTrilateralUnaugmentedSuffixContainer() {
        indefiniteSuffixList.add("Ò");
        indefiniteSuffixList.add("Ò");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("«");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Ú");
        indefiniteSuffixList.add("Ú");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");

        definiteSuffixList.add("ı");
        definiteSuffixList.add("ı");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û");
        definiteSuffixList.add("Û");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("ˆ");
        definiteSuffixList.add("ˆ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");

        annexedSuffixList.add("ı");
        annexedSuffixList.add("ı");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("Û");
        annexedSuffixList.add("Û");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ˆ");
        annexedSuffixList.add("ˆ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
    }

    public void selectDefiniteMode() {
        prefix = "«·";
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
