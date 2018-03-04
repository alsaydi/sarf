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
    private static AssimilateFormulaE2SuffixContainer instance = new AssimilateFormulaE2SuffixContainer();
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

    private AssimilateFormulaE2SuffixContainer() {
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û Ï");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û ÌÛ«‰ˆ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û Ï");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û ÌÛÌ˙‰ˆ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û Ï");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("Û ÌÛÌ˙‰ˆ");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");

        definiteSuffixList.add("");
        definiteSuffixList.add("Û Ï");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û ÌÛ«‰ˆ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û Ï");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û ÌÛÌ˙‰ˆ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û Ï");
        definiteSuffixList.add("");
        definiteSuffixList.add("Û ÌÛÌ˙‰ˆ");
        definiteSuffixList.add("");
        definiteSuffixList.add("");

        annexedSuffixList.add("");
        annexedSuffixList.add("Û Ï");
        annexedSuffixList.add("");
        annexedSuffixList.add("Û ÌÛ«");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("Û Ï");
        annexedSuffixList.add("");
        annexedSuffixList.add("Û ÌÛÌ˙");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ˆ");
        annexedSuffixList.add("Û Ï");
        annexedSuffixList.add("");
        annexedSuffixList.add("Û ÌÛÌ˙");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
    }

    public void selectDefiniteMode() {
        prefix = "«·";
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
