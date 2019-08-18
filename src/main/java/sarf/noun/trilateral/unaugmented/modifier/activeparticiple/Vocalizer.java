
package sarf.noun.trilateral.unaugmented.modifier.activeparticiple;

import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer.*;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

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
public class Vocalizer {
    private final List<IUnaugmentedTrilateralNounModificationApplier> modifiers = new ArrayList<>();

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
        for (IUnaugmentedTrilateralNounModificationApplier modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
