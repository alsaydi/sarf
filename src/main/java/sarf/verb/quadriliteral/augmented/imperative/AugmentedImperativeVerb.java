package sarf.verb.quadriliteral.augmented.imperative;

import sarf.verb.quadriliteral.augmented.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AugmentedImperativeVerb {

    protected final AugmentedQuadrilateralRoot root;
    protected final String lastDim;
    protected final String connectedPronoun;

    public AugmentedImperativeVerb(AugmentedQuadrilateralRoot root, String lastDim, String connectedPronoun) {
        this.root = root;
        this.lastDim = lastDim;
        this.connectedPronoun = connectedPronoun;
    }

    public abstract String form();

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public AugmentedQuadrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpr() {
        return lastDim;
    }

    public String toString() {
        return form();
    }
}
