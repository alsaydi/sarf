package sarf.verb.trilateral.augmented;

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
public abstract class AugmentedPresentVerb extends Word {

    protected final AugmentedTrilateralRoot root;
    protected final String lastDpr;
    protected final String connectedPronoun;
    //حرف المضارع
    protected final String cp;

    protected AugmentedPresentVerb(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        this.root = root;
        this.cp = cp;
        this.lastDpr = lastDpr;
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
        return lastDpr;
    }

    @Override
    public String toString() {
        return form();
    }

    public String getCp() {
        return cp;
    }

}
