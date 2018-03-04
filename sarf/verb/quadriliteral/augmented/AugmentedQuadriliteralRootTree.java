package sarf.verb.quadriliteral.augmented;

import java.util.*;

/**
 * <p>Title: ﬁ«∆„… «·Ã–Ê— «·—»«⁄Ì… «·„“Ìœ…   </p>
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
public class AugmentedQuadriliteralRootTree {
    private List roots = new LinkedList();

    public AugmentedQuadriliteralRootTree() {
    }

    public void addRoot(AugmentedQuadriliteralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
