package sarf.verb.trilateral.unaugmented.modifier;

import sarf.verb.trilateral.unaugmented.*;


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
public interface IUnaugmentedTrilateralModifier {
    public boolean isApplied(ConjugationResult conjugationResult);
}
