package sarf.noun.quadriliteral.augmented;

import sarf.Word;
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
public abstract class AugmentedQuadrilateralNoun extends Word {
    protected final AugmentedQuadrilateralRoot root;
    protected final String suffix;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    protected AugmentedQuadrilateralNoun(AugmentedQuadrilateralRoot root, String suffix, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.root = root;
        this.suffix = suffix;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    protected abstract String form();

    @Override
    public String toString() {
        return genericNounSuffixContainer.getPrefix()+form();
    }
}
