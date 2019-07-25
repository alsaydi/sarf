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
    private final List twoStateList = new LinkedList();
    private final List notVocalizedList = new LinkedList();

    public Formula9ApplyingChecker() {
        twoStateList.add("جوب");
        twoStateList.add("جوف");
        twoStateList.add("خول");
        twoStateList.add("روح");
        twoStateList.add("روض");
        twoStateList.add("صوب");

        notVocalizedList.add("ءور");
        notVocalizedList.add("تيس");
        notVocalizedList.add("حوذ");
        notVocalizedList.add("حوس");
        notVocalizedList.add("حوض");
        notVocalizedList.add("فيل");
        notVocalizedList.add("قوس");
        notVocalizedList.add("ليث");
        notVocalizedList.add("نوق");
        notVocalizedList.add("نوك");
    }

    public List getNotVocalizedList() {
        return notVocalizedList;
    }

    public List getTwoStateList() {
        return twoStateList;
    }
}
