package sarf.verb.quadriliteral.augmented;

import java.util.*;

/**
 * <p>Title: قائمة الجذور الرباعية المزيدة   </p>
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
    private final List roots = new LinkedList();

    public AugmentedQuadriliteralRootTree() {
    }

    public void addRoot(AugmentedQuadrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
