package sarf;

import java.util.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: يحتوي ضمائر الرفع المنفصلة   </p>
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
        pronouns.add("أنا");
        pronouns.add("نحن");
        pronouns.add("أنتَ");
        pronouns.add("أنتِ");
        pronouns.add("أنتما");
        pronouns.add("أنتم");
        pronouns.add("أنتنَّ");
        pronouns.add("هو");
        pronouns.add("هي");
        pronouns.add("هما(مذ)");
        pronouns.add("هما(مؤ)");
        pronouns.add("هم");
        pronouns.add("هنَّ");
    }

    public static SeparatedPronounsContainer getInstance() {
        return instance;
    }

    public List getPronouns() {
        return pronouns;
    }

}
