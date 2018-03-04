package sarf.noun.trilateral.augmented.modifier;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;

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

    private List modifiers = new LinkedList();


    public Substituter() {
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter1());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter2());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter3());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter4());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter5());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter6());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter7());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter8());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.SpecialSubstituter1());
        modifiers.add(new sarf.noun.trilateral.augmented.modifier.substituter.SpecialSubstituter2());
       }

    public void apply(ConjugationResult conjResult) {
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((TrilateralNounSubstitutionApplier)modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }

}
