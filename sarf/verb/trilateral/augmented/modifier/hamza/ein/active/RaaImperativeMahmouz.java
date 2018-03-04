package sarf.verb.trilateral.augmented.modifier.hamza.ein.active;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
public class RaaImperativeMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new ArrayList();

    public RaaImperativeMahmouz() {

        substitutions.add(new InfixSubstitution("úÁö","ö"));// EX: (ÃóÑö¡ )
        substitutions.add(new InfixSubstitution("úÁõ","õ"));// EX: (ÃóÑõæÇ¡ )

    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        TrilateralRoot root = conjugationResult.getRoot();
        return conjugationResult.getFormulaNo() == 1 && root.getC1() == 'Ñ' && root.getC2() == 'Á' && root.getC3() == 'í';
    }
}
