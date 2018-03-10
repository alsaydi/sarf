package sarf.verb.trilateral.augmented;

import java.util.*;

/**
 * <p>Title: </p>
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
public class AugmentedTrilateralRootTree {
    private List roots = new LinkedList();

    public AugmentedTrilateralRootTree() {
    }

    public void addRoot(AugmentedTrilateralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
