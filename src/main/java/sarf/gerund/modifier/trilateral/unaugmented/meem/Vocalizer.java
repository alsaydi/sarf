package sarf.gerund.modifier.trilateral.unaugmented.meem;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.*;
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
public class Vocalizer {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();
    public Vocalizer() {
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new AjwafListed1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new NakesLafifVocalizer());
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
