package sarf.noun.trilateral.unaugmented.modifier.activeparticiple;

import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza.EinMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza.FaaMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza.LamMahmouz;
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
class Mahmouz {
    private final List<SubstitutionsApplier> modifiers = new ArrayList<>();
    private final LamMahmouz lamMahmouz = new LamMahmouz();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(lamMahmouz);
    }

    public void apply(ConjugationResult conjResult) {
        for (var modifier : modifiers) {
            if (modifier.isApplied(conjResult)) {
                modifier.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
        //خصيصا للفعل أثأ
        if (conjResult.getRoot().getC1() == 'ء' && conjResult.getRoot().getC3() == 'ء')
            lamMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
