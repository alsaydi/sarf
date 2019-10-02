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
public class AugmentedQuadrilateralRootTree {
    private final List<AugmentedQuadrilateralRoot> roots = new ArrayList<>();

    public AugmentedQuadrilateralRootTree() {
    }

    public void addRoot(AugmentedQuadrilateralRoot root) {
        roots.add(root);
    }

    public List<AugmentedQuadrilateralRoot> getRoots() {
        return roots;
    }
}
