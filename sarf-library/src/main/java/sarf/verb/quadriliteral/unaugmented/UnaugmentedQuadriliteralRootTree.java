package sarf.verb.quadriliteral.unaugmented;

import java.util.*;

/**
 * <p>Title: قائمة الجذور الرباعية المجردة   </p>
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
public class UnaugmentedQuadriliteralRootTree {
    private final List<UnaugmentedQuadrilateralRoot> roots = new ArrayList<>();

    public UnaugmentedQuadriliteralRootTree() {
    }

    public void addRoot(UnaugmentedQuadrilateralRoot root) {
        roots.add(root);
    }

    public List<UnaugmentedQuadrilateralRoot> getRoots() {
        return roots;
    }
}
