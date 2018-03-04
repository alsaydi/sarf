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
    private static AssimilateFormulaCSuffixContainer instance = new AssimilateFormulaCSuffixContainer();
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

    private AssimilateFormulaCSuffixContainer() {
        indefiniteSuffixList.add("õ");
        indefiniteSuffixList.add("óÇÁõ");
        indefiniteSuffixList.add("óÇäö");
        indefiniteSuffixList.add("óÇæóÇäö");
        indefiniteSuffixList.add("ñ");
        indefiniteSuffixList.add("ñ");
        indefiniteSuffixList.add("ó");
        indefiniteSuffixList.add("óÇÁó");
        indefiniteSuffixList.add("óíúäö");
        indefiniteSuffixList.add("óÇæóíúäö");
        indefiniteSuffixList.add("ğÇ");
        indefiniteSuffixList.add("ğÇ");
        indefiniteSuffixList.add("ó");
        indefiniteSuffixList.add("óÇÁó");
        indefiniteSuffixList.add("óíúäö");
        indefiniteSuffixList.add("óÇæóíúäö");
        indefiniteSuffixList.add("ò");
        indefiniteSuffixList.add("ò");


        definiteSuffixList.add("õ");
        definiteSuffixList.add("óÇÁõ");
        definiteSuffixList.add("óÇäö");
        definiteSuffixList.add("óÇæóÇäö");
        definiteSuffixList.add("õ");
        definiteSuffixList.add("õ");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("óÇÁó");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óÇæóíúäö");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("ö");
        definiteSuffixList.add("óÇÁö");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óÇæóíúäö");
        definiteSuffixList.add("ö");
        definiteSuffixList.add("ö");



        annexedSuffixList.add("õ");
        annexedSuffixList.add("óÇÁõ");
        annexedSuffixList.add("óÇ");
        annexedSuffixList.add("óÇæóÇ");
        annexedSuffixList.add("õ");
        annexedSuffixList.add("õ");
        annexedSuffixList.add("ó");
        annexedSuffixList.add("óÇÁó");
        annexedSuffixList.add("óíú");
        annexedSuffixList.add("óÇæóíú");
        annexedSuffixList.add("ó");
        annexedSuffixList.add("ó");
        annexedSuffixList.add("ö");
        annexedSuffixList.add("óÇÁö");
        annexedSuffixList.add("óíú");
        annexedSuffixList.add("óÇæóíú");
        annexedSuffixList.add("ö");
        annexedSuffixList.add("ö");

    }

    public void selectDefiniteMode() {
        prefix = "Çá";
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
