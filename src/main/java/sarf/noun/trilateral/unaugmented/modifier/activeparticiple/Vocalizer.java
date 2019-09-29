
package sarf.noun.trilateral.unaugmented.modifier.activeparticiple;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer.*;
import sarf.substitution.SubstitutionsApplier;

import java.util.ArrayList;
import java.util.List;

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
        modifiers.add(new WawiLafifNakesVocalizer());
        modifiers.add(new YaeiLafifNakesVocalizer());
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new Ajwaf3WawiVocalizer());
        modifiers.add(new Ajwaf3WawiListedVocalizer());
        modifiers.add(new Ajwaf3YaeiVocalizer());
        modifiers.add(new Ajwaf3YaeiListedVocalizer());
        modifiers.add(new Ajwaf4Vocalizer());
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
