package sarf;

import java.util.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: íÍÊæí ÖãÇÆÑ ÇáÑİÚ ÇáãäİÕáÉ   </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class SeparatedPronounsContainer {
    private static SeparatedPronounsContainer instance = new SeparatedPronounsContainer();
    private List pronouns = new ArrayList(13);

    private SeparatedPronounsContainer() {
        pronouns.add("ÃäÇ");
        pronouns.add("äÍä");
        pronouns.add("ÃäÊó");
        pronouns.add("ÃäÊö");
        pronouns.add("ÃäÊãÇ");
        pronouns.add("ÃäÊã");
        pronouns.add("ÃäÊäøó");
        pronouns.add("åæ");
        pronouns.add("åí");
        pronouns.add("åãÇ(ãĞ)");
        pronouns.add("åãÇ(ãÄ)");
        pronouns.add("åã");
        pronouns.add("åäøó");
    }

    public static SeparatedPronounsContainer getInstance() {
        return instance;
    }

    public List getPronouns() {
        return pronouns;
    }

}
