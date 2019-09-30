package sarf.verb.quadriliteral.augmented;


import sarf.Word;

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
public abstract class AugmentedPastVerb extends Word {

    protected final AugmentedQuadrilateralRoot root;
    protected final String lastDpa;
    protected final String connectedPronoun;

    protected AugmentedPastVerb(AugmentedQuadrilateralRoot root, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    protected abstract String form();

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public AugmentedQuadrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpa() {
        return lastDpa;
    }

    @Override
    public String toString() {
        return form();
    }
}
