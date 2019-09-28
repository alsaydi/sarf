package sarf.noun.trilateral.unaugmented.modifier.timeandplace;

import java.util.*;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;

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
public class Mahmouz {
    private final List<IUnaugmentedTrilateralNounModificationApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
