package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة
 * وهي نفس القائمة للأجوف اليائي أي نفس الفحص وتختلف بالاستبدالات             </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafYaeiListedVocalizer extends ListedVocalizer {
    private List<String> appliedRoots = new LinkedList<String>();

    public AbstractAjwafYaeiListedVocalizer() {
        appliedRoots.add("بيت");
        appliedRoots.add("حير");
        appliedRoots.add("خيل");
        appliedRoots.add("زيم");
        appliedRoots.add("شيء");
        appliedRoots.add("طيط");
        appliedRoots.add("عيف");
        appliedRoots.add("عيم");
        appliedRoots.add("غير");
        appliedRoots.add("نيل");
        appliedRoots.add("نيه");
        appliedRoots.add("هيء");
        appliedRoots.add("هيب");
        appliedRoots.add("هيع");
    }

    protected List getAppliedRoots() {
        return appliedRoots;
    }

    protected int getNoc() {
        return 4;
    }

}
