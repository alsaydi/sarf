
package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.vocalizer.*;
import sarf.substitution.SubstitutionsApplier;
import sarf.ConjugationResult;

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
class Vocalizer {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Vocalizer() {
        modifiers.add(new WawiLafifNakes1Vocalizer());
        modifiers.add(new WawiLafifNakes2Vocalizer());
        modifiers.add(new YaeiLafifNakesVocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
