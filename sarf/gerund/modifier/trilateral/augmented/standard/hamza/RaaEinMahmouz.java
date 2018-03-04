package sarf.gerund.modifier.trilateral.augmented.standard.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;

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
public class RaaEinMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    List substitutions = new LinkedList();

    public RaaEinMahmouz() {
        substitutions.add(new InfixSubstitution("˙¡Û«","Û«"));// EX: (≈—«¡° ≈—«¡…)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == '—' && root.getC2() == '¡' && root.getC3() == 'Ì' && conjugationResult.getFormulaNo() == 1;
    }
}
