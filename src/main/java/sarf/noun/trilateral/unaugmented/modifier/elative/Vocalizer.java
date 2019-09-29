package sarf.noun.trilateral.unaugmented.modifier.elative;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer.WawiLafifNakesVocalizer;
import sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer.YaeiLafifNakesVocalizer;
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
