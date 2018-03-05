package sarf.verb.trilateral.augmented.modifier;

import sarf.verb.trilateral.augmented.*;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: abstract interface to be implemented from the child classes
 * which will modify the verbs
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public interface IAugmentedTrilateralModifier {
    public boolean isApplied(ConjugationResult conjugationResult);
}
