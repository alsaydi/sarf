package sarf.noun.trilateral.augmented.modifier.activeparticiple;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer.*;
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
public class Vocalizer {
    private List modifiers = new LinkedList();

    private PreSeparatedLafifVocalizer preSeparatedLafifVocalizer = new PreSeparatedLafifVocalizer();

    public Vocalizer() {
        modifiers.add(new Mithal1Vocalizer());
        modifiers.add(new Mithal2Vocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new WawiNakesLafifVocalizer());
        modifiers.add(new YaeiNakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        if (preSeparatedLafifVocalizer.isApplied(conjResult))
            preSeparatedLafifVocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());

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
