package sarf.verb.trilateral.augmented;

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
public abstract class AugmentedPastVerb {

    protected final AugmentedTrilateralRoot root;
    protected final String lastDpa;
    protected final String connectedPronoun;

    public AugmentedPastVerb(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    public abstract String form();

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpa() {
        return lastDpa;
    }

    public String toString() {
        return form();
    }

}
