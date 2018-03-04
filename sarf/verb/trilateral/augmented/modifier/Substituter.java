package sarf.verb.trilateral.augmented.modifier;

import java.util.*;
import sarf.verb.trilateral.augmented.*;
import sarf.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:  ÿ»Ìﬁ «·«»œ«· </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Substituter {

    //Õ”» «· Õ·Ì· ›≈‰ «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—  ‘ —ﬂ ›Ì «·«»œ«· ··„⁄·Ê„
    //Ê·ﬂ‰ ··„ÃÂÊ· ÌŒ ·› ›ﬁÿ «·„«÷Ì √„« «·„÷«—⁄ ›ÂÊ ‰›”Â ›Ì «·„⁄·Ê„
    private List activeList = new LinkedList();
    private List passiveList = new LinkedList();


    public Substituter() {
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter1());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter2());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter3());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter4());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter5());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter6());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter7());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter8());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.SpecialSubstituter1());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.SpecialSubstituter2());

        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter1());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter2());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter3());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter4());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter5());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter6());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter7());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter8());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter1());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter2());

    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List modifiers = null;
        if (!active ) {
            modifiers = passiveList;
        }
        else {
            modifiers = activeList;
        }

        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
