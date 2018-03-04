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
    private List roots = new LinkedList();

    public UnaugmentedQuadriliteralRootTree() {
    }

    public void addRoot(UnaugmentedQuadriliteralRoot root) {
        roots.add(root);
    }

    public List getRoots() {
        return roots;
    }
}
