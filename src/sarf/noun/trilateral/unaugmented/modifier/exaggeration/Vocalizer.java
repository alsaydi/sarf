package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer.*;
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
        modifiers.add(new AVocalizer());
        modifiers.add(new B1Vocalizer());
        modifiers.add(new B2Vocalizer());
        modifiers.add(new C1Vocalizer());
        modifiers.add(new C2Vocalizer());
        modifiers.add(new C3Vocalizer());
        modifiers.add(new I1Vocalizer());
        modifiers.add(new I2Vocalizer());
        modifiers.add(new JVocalizer());

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
