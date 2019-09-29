package sarf.noun.trilateral.unaugmented.modifier.timeandplace;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza.EinMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza.FaaMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza.LamMahmouz;
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
public class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
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
