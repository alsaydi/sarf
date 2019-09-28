package sarf.noun.trilateral.unaugmented.modifier.activeparticiple;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.NounConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.hamza.*;
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
    private final List modifiers = new LinkedList();
    private final LamMahmouz lamMahmouz = new LamMahmouz();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(lamMahmouz);
    }

    public void apply(NounConjugationResult conjResult) {
        for (Object o : modifiers) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) o;
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
        //خصيصا للفعل أثأ
        if (conjResult.getRoot().getC1() == 'ء' && conjResult.getRoot().getC3() == 'ء')
            lamMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
