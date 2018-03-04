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
    //ÍÇáÉ ÇáäßÑÉ
    private ArrayList indefiniteSuffixList = new ArrayList(18);
    //ÍÇáÉ ÇáãÚÑİÉ
    private ArrayList definiteSuffixList = new ArrayList(18);
    //ÍÇáÉ ÇáÇÖÇİÉ
    private ArrayList annexedSuffixList = new ArrayList(18);

    //Êßæä áåÇ ŞíãÉ ÚäÏãÇ Êßæä ÇáÍÇáÉ åí ãÚÑİÉ
    private String prefix = "";
    //íãËá ÇáŞÇÆãÉ ÇáãÎÊÇÑÉ ÊÈÚÇğ ááÍÇáÉ
    private ArrayList currentSuffixList = indefiniteSuffixList ;

    private AssimilateFormulaE1SuffixContainer() {
        indefiniteSuffixList.add("õ");
        indefiniteSuffixList.add("ó Éñ");
        indefiniteSuffixList.add("ó Çäö");
        indefiniteSuffixList.add("ó ÊóÇäö");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("ó");
        indefiniteSuffixList.add("ó Éğ");
        indefiniteSuffixList.add("ó íúäö");
        indefiniteSuffixList.add("ó Êóíúäö");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("ó");
        indefiniteSuffixList.add("ó Éò");
        indefiniteSuffixList.add("ó íúäö");
        indefiniteSuffixList.add("ó Êóíúäö");
        indefiniteSuffixList.add("");
        indefiniteSuffixList.add("");


        definiteSuffixList.add("õ");
        definiteSuffixList.add("ó Éõ");
        definiteSuffixList.add("ó Çäö");
        definiteSuffixList.add("ó ÊóÇäö");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("ó Éó");
        definiteSuffixList.add("ó íúäö");
        definiteSuffixList.add("ó Êóíúäö");
        definiteSuffixList.add("");
        definiteSuffixList.add("");
        definiteSuffixList.add("ö");
        definiteSuffixList.add("ó Éö");
        definiteSuffixList.add("ó íúäö");
        definiteSuffixList.add("ó Êóíúäö");
        definiteSuffixList.add("");
        definiteSuffixList.add("");


        annexedSuffixList.add("õ");
        annexedSuffixList.add("ó Éõ");
        annexedSuffixList.add("ó Ç");
        annexedSuffixList.add("ó ÊóÇ");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ó");
        annexedSuffixList.add("ó Éó");
        annexedSuffixList.add("ó íú");
        annexedSuffixList.add("ó Êóíú");
        annexedSuffixList.add("");
        annexedSuffixList.add("");
        annexedSuffixList.add("ö");
        annexedSuffixList.add("ó Éö");
        annexedSuffixList.add("ó íú");
        annexedSuffixList.add("ó Êóíú");
        annexedSuffixList.add("");
        annexedSuffixList.add("");

    }

    public void selectDefiniteMode() {
        prefix = "Çá";
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
