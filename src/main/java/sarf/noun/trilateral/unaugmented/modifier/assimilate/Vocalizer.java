package sarf.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer.*;
import sarf.verb.trilateral.Substitution.*;
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
    private final List<IUnaugmentedTrilateralNounModificationApplier> modifiers = new ArrayList<>();

    public Vocalizer() {
        modifiers.add(new Vocalizer1());
        modifiers.add(new Vocalizer2());
        modifiers.add(new Vocalizer31());
        modifiers.add(new Vocalizer32());
        modifiers.add(new Vocalizer41());
        modifiers.add(new Vocalizer42());
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
