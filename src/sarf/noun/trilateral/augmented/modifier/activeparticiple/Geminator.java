package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.geminator.*;
import sarf.noun.trilateral.augmented.modifier.geminator.*;
import sarf.verb.trilateral.augmented.*;
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
    private List modifiers = new LinkedList();

    public Geminator() {
        modifiers.add(new Geminator1());
        modifiers.add(new Geminator2());
        modifiers.add(new Geminator3());
    }

    public void apply(ConjugationResult conjResult) {
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IAugmentedTrilateralModifier modifier = (IAugmentedTrilateralModifier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
