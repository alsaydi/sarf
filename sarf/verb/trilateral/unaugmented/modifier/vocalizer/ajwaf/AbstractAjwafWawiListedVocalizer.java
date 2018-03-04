package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:İÍÕ ÇáÃÌæİ ÍÓÈ ŞÇÆãÉ
 * * æåí äİÓ ÇáŞÇÆãÉ ááÃÌæİ ÇáæÇæí Ãí äİÓ ÇáİÍÕ æÊÎÊáİ ÈÇáÇÓÊÈÏÇáÇÊ             </p>
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
    private List appliedRoots = new LinkedList();

    public AbstractAjwafWawiListedVocalizer() {
        appliedRoots.add("Èæå");
        appliedRoots.add("Îæİ");
        appliedRoots.add("ÏæÁ");
        appliedRoots.add("ÏæÏ");
        appliedRoots.add("Ïæã");
        appliedRoots.add("Ôæß");
        appliedRoots.add("ÕæÊ");
        appliedRoots.add("ØæÚ");
        appliedRoots.add("ßæÏ");
        appliedRoots.add("ãæá");
        appliedRoots.add("äæã");
        appliedRoots.add("äæå");
        appliedRoots.add("åæÚ");
    }

    protected List getAppliedRoots() {
        return appliedRoots;
    }

    protected int getNoc() {
        return 4;
    }


}
