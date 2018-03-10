package sarf.gerund.modifier.trilateral.unaugmented.meem;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer.*;
import sarf.verb.trilateral.Substitution.*;

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


    public Vocalizer() {
        modifiers.add(new Ajwaf1Vocalizer());
        modifiers.add(new AjwafListed1Vocalizer());
        modifiers.add(new Ajwaf2Vocalizer());
        modifiers.add(new NakesLafifVocalizer());
    }

    public void apply(ConjugationResult conjResult) {
         Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}

