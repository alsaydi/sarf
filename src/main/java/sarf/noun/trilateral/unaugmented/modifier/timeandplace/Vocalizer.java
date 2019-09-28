package sarf.noun.trilateral.unaugmented.modifier.timeandplace;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.vocalizer.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Vocalizer {
    private final List modifiers = new LinkedList();

    public Vocalizer() {
        modifiers.add(new ACAjwaf1Vocalizer());
        modifiers.add(new ACAjwaf2Vocalizer());
        modifiers.add(new BAjwafVocalizer());
        modifiers.add(new ALafifNakesVocalizer());
        modifiers.add(new CLafifNakesVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        for (Object o : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
