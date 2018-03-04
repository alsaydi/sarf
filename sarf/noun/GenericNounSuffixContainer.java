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
    private static GenericNounSuffixContainer instance = new GenericNounSuffixContainer();
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

    private GenericNounSuffixContainer() {
        indefiniteSuffixList.add("ñ");
        indefiniteSuffixList.add("óÉñ");
        indefiniteSuffixList.add("óÇäö");
        indefiniteSuffixList.add("óÊóÇäö");
        indefiniteSuffixList.add("õæäó");
        indefiniteSuffixList.add("óÇÊñ");
        indefiniteSuffixList.add("ğÇ");
        indefiniteSuffixList.add("óÉğ");
        indefiniteSuffixList.add("óíúäö");
        indefiniteSuffixList.add("óÊóíúäö");
        indefiniteSuffixList.add("öíäó");
        indefiniteSuffixList.add("óÇÊò");
        indefiniteSuffixList.add("ò");
        indefiniteSuffixList.add("óÉò");
        indefiniteSuffixList.add("óíúäö");
        indefiniteSuffixList.add("óÊóíúäö");
        indefiniteSuffixList.add("öíäó");
        indefiniteSuffixList.add("óÇÊò");

        definiteSuffixList.add("õ");
        definiteSuffixList.add("óÉõ");
        definiteSuffixList.add("óÇäö");
        definiteSuffixList.add("óÊóÇäö");
        definiteSuffixList.add("õæäó");
        definiteSuffixList.add("óÇÊõ");
        definiteSuffixList.add("ó");
        definiteSuffixList.add("óÉó");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óÊóíúäö");
        definiteSuffixList.add("öíäó");
        definiteSuffixList.add("óÇÊö");
        definiteSuffixList.add("ö");
        definiteSuffixList.add("óÉö");
        definiteSuffixList.add("óíúäö");
        definiteSuffixList.add("óÊóíúäö");
        definiteSuffixList.add("öíäó");
        definiteSuffixList.add("óÇÊö");


        annexedSuffixList.add("õ");
        annexedSuffixList.add("óÉõ");
        annexedSuffixList.add("óÇ");
        annexedSuffixList.add("óÊóÇ");
        annexedSuffixList.add("õæ");
        annexedSuffixList.add("óÇÊõ");
        annexedSuffixList.add("ó");
        annexedSuffixList.add("óÉó");
        annexedSuffixList.add("óíú");
        annexedSuffixList.add("óÊóíú");
        annexedSuffixList.add("öí");
        annexedSuffixList.add("óÇÊö");
        annexedSuffixList.add("ö");
        annexedSuffixList.add("óÉö");
        annexedSuffixList.add("óíú");
        annexedSuffixList.add("óÊóíú");
        annexedSuffixList.add("öí");
        annexedSuffixList.add("óÇÊö");

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
