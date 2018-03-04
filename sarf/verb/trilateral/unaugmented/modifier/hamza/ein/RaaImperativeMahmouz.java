package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.*;

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
public class RaaImperativeMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List substitutions = new ArrayList();

    public RaaImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("ÇÑúÁó","Ñó"));// EX: (Ñó¡ Ñóíú¡ ÑóíÇ¡ ÑóæúÇ¡ Ñóíúäó¡ Ñóíóäøó¡ Ñóíöäøó¡ ÑóíÇäøö¡ Ñóæõäøó¡ ÑóíúäÇäøö)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        TrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'Ñ' && root.getC2() == 'Á' && root.getC3() == 'í';
    }
}
