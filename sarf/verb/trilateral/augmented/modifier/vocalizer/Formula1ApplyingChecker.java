package sarf.verb.trilateral.augmented.modifier.vocalizer;

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
public class Formula1ApplyingChecker extends IFormulaApplyingChecker{
    private List twoStateList = new LinkedList();
    private List notVocalizedList = new LinkedList();

    public Formula1ApplyingChecker() {
        twoStateList.add("ÌæÏ");
        twoStateList.add("ÍæÔ");
        twoStateList.add("Íæá");
        twoStateList.add("ÎæÕ");
        twoStateList.add("Îæá");
        twoStateList.add("ÏæÁ");
        twoStateList.add("ÑæÍ");
        twoStateList.add("ÑæÏ");
        twoStateList.add("ÑæÖ");
        twoStateList.add("ÓæÏ");
        twoStateList.add("ÓæÛ");
        twoStateList.add("Øæá");
        twoStateList.add("ÚæÑ");
        twoStateList.add("áæË");
        twoStateList.add("äæÁ");
        twoStateList.add("ÈíÖ");
        twoStateList.add("Ííä");
        twoStateList.add("Îíİ");
        twoStateList.add("Îíá");
        twoStateList.add("Îíã");
        twoStateList.add("Ñíİ");
        twoStateList.add("ÚíÑ");
        twoStateList.add("Úíá");
        twoStateList.add("Úíä");
        twoStateList.add("ÛíÈ");
        twoStateList.add("Ûíá");
        twoStateList.add("Ûíã");
        twoStateList.add("ßíÓ");
        twoStateList.add("áíá");
        twoStateList.add("áíä");
        twoStateList.add("äíÁ");
        twoStateList.add("åíÌ");

        notVocalizedList.add("ÍæÈ");
        notVocalizedList.add("ÍæÌ");
        notVocalizedList.add("ÍæĞ");
        notVocalizedList.add("ÒæÌ");
        notVocalizedList.add("Òæß");
        notVocalizedList.add("ÚæÒ");
        notVocalizedList.add("ÚæÕ");
        notVocalizedList.add("Úæã");
        notVocalizedList.add("äæß");
        notVocalizedList.add("åæÌ");
        notVocalizedList.add("Òíä");
        notVocalizedList.add("ÚíÓ");
        notVocalizedList.add("Úíå");
        notVocalizedList.add("İíŞ");
        notVocalizedList.add("åíŞ");
    }

    public List getNotVocalizedList() {
        return notVocalizedList;
    }

    public List getTwoStateList() {
        return twoStateList;
    }
}
