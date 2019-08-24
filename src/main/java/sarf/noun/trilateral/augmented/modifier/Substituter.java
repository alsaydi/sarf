package sarf.noun.trilateral.augmented.modifier;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter1;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter2;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter3;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter4;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter5;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter6;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter7;
import sarf.noun.trilateral.augmented.modifier.substituter.GenericSubstituter8;
import sarf.noun.trilateral.augmented.modifier.substituter.SpecialSubstituter1;
import sarf.noun.trilateral.augmented.modifier.substituter.SpecialSubstituter2;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق الابدال </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Substituter {
    private final List<TrilateralNounSubstitutionApplier> modifiers = new LinkedList<>();

    public Substituter() {
        modifiers.add(new GenericSubstituter1());
        modifiers.add(new GenericSubstituter2());
        modifiers.add(new GenericSubstituter3());
        modifiers.add(new GenericSubstituter4());
        modifiers.add(new GenericSubstituter5());
        modifiers.add(new GenericSubstituter6());
        modifiers.add(new GenericSubstituter7());
        modifiers.add(new GenericSubstituter8());
        modifiers.add(new SpecialSubstituter1());
        modifiers.add(new SpecialSubstituter2());
    }

    public void apply(ConjugationResult conjResult) {
        for (TrilateralNounSubstitutionApplier applier : modifiers) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) applier;
            if (modifier.isApplied(conjResult)) {
                applier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
