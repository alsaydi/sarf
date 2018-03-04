package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:İÍÕ ÇáÃÌæİ ÍÓÈ ŞÇÆãÉ
 * æåí äİÓ ÇáŞÇÆãÉ ááÃÌæİ ÇáíÇÆí Ãí äİÓ ÇáİÍÕ æÊÎÊáİ ÈÇáÇÓÊÈÏÇáÇÊ             </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafYaeiListedVocalizer extends ListedVocalizer {
    private List appliedRoots = new LinkedList();

    public AbstractAjwafYaeiListedVocalizer() {
        appliedRoots.add("ÈíÊ");
        appliedRoots.add("ÍíÑ");
        appliedRoots.add("Îíá");
        appliedRoots.add("Òíã");
        appliedRoots.add("ÔíÁ");
        appliedRoots.add("ØíØ");
        appliedRoots.add("Úíİ");
        appliedRoots.add("Úíã");
        appliedRoots.add("ÛíÑ");
        appliedRoots.add("äíá");
        appliedRoots.add("äíå");
        appliedRoots.add("åíÁ");
        appliedRoots.add("åíÈ");
        appliedRoots.add("åíÚ");
    }

    protected List getAppliedRoots() {
        return appliedRoots;
    }

    protected int getNoc() {
        return 4;
    }

}
