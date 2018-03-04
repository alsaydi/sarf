package sarf.verb.trilateral.unaugmented;

import java.util.*;

/**
 * <p>Title: ﬁ«∆„… «·Ã–Ê— «·À·«ÀÌ… «·„Ã—œ…   </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedTrilateralRootTree {
    private List roots = new LinkedList();

    public UnaugmentedTrilateralRootTree() {
    }

    public void addRoot(UnaugmentedTrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
