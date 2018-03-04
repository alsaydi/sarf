package sarf.verb.trilateral.augmented.modifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public interface AugmentedTrilateralModifierListener {
    //if there are two states for the verb with vocaliztion and without, listners will be notified
    //about this situation to take a decision
    public boolean doSelectVocalization();
}
