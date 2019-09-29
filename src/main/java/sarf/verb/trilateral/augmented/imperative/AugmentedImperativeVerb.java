package sarf.verb.trilateral.augmented.imperative;

import sarf.Word;
import sarf.verb.trilateral.augmented.*;

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
public abstract class AugmentedImperativeVerb extends Word {

    protected final AugmentedTrilateralRoot root;
    protected final String lastDim;
    protected final String connectedPronoun;

    protected AugmentedImperativeVerb(AugmentedTrilateralRoot root, String lastDim, String connectedPronoun) {
        this.root = root;
        this.lastDim = lastDim;
        this.connectedPronoun = connectedPronoun;
    }

    protected abstract String form();

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public AugmentedTrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpr() {
        return lastDim;
    }

    @Override
    public String toString() {
        return form();
    }
}
