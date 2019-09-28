package sarf.noun.trilateral.augmented.modifier.passiveparticiple;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.geminator.*;
import sarf.noun.trilateral.augmented.modifier.geminator.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class Geminator {
    private final List modifiers = new LinkedList();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
    }

    public void apply(ConjugationResult conjResult) {
        for (Object o : modifiers) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
