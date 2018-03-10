package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة
 * * وهي نفس القائمة للأجوف الواوي أي نفس الفحص وتختلف بالاستبدالات             </p>
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafWawiListedVocalizer extends ListedVocalizer {
    private List<String> appliedRoots = new LinkedList<String>();

    public AbstractAjwafWawiListedVocalizer() {
        appliedRoots.add("بوه");
        appliedRoots.add("خوف");
        appliedRoots.add("دوء");
        appliedRoots.add("دود");
        appliedRoots.add("دوم");
        appliedRoots.add("شوك");
        appliedRoots.add("صوت");
        appliedRoots.add("طوع");
        appliedRoots.add("كود");
        appliedRoots.add("مول");
        appliedRoots.add("نوم");
        appliedRoots.add("نوه");
        appliedRoots.add("هوع");
    }

    protected List getAppliedRoots() {
        return appliedRoots;
    }

    protected int getNoc() {
        return 4;
    }


}
