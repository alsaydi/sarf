package sarf.noun.quadriliteral.augmented;

import sarf.verb.quadriliteral.augmented.*;
import sarf.noun.GenericNounSuffixContainer;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الأب المشترك للأسماء المشكلة من مصدر  رباعي       </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AugmentedQuadriliteralNoun {
    protected final AugmentedQuadrilateralRoot root;
    protected final String suffix;

    public AugmentedQuadriliteralNoun(AugmentedQuadrilateralRoot root, String suffix) {
        this.root = root;
        this.suffix = suffix;
    }

    public abstract String form();

    public String toString() {
        return GenericNounSuffixContainer.getInstance().getPrefix()+form();
    }
}
