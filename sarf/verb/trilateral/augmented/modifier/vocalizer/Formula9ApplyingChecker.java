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
public class Formula9ApplyingChecker extends IFormulaApplyingChecker{
    private List twoStateList = new LinkedList();
    private List notVocalizedList = new LinkedList();

    public Formula9ApplyingChecker() {
        twoStateList.add("ÃÊ»");
        twoStateList.add("ÃÊ›");
        twoStateList.add("ŒÊ·");
        twoStateList.add("—ÊÕ");
        twoStateList.add("—Ê÷");
        twoStateList.add("’Ê»");

        notVocalizedList.add("¡Ê—");
        notVocalizedList.add(" Ì”");
        notVocalizedList.add("ÕÊ–");
        notVocalizedList.add("ÕÊ”");
        notVocalizedList.add("ÕÊ÷");
        notVocalizedList.add("›Ì·");
        notVocalizedList.add("ﬁÊ”");
        notVocalizedList.add("·ÌÀ");
        notVocalizedList.add("‰Êﬁ");
        notVocalizedList.add("‰Êﬂ");
    }

    public List getNotVocalizedList() {
        return notVocalizedList;
    }

    public List getTwoStateList() {
        return twoStateList;
    }
}
