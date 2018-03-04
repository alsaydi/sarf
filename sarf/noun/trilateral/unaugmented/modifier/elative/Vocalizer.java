package sarf.noun.trilateral.unaugmented.modifier.elative;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
        modifiers.add(new WawiLafifNakesVocalizer());
        modifiers.add(new YaeiLafifNakesVocalizer());
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
