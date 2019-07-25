package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

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
    final List<Substitution> substitutions = new ArrayList<>();

    public RaaEinMahmouz() {

        substitutions.add(new InfixSubstitution("ْءً","ً"));// EX: (مُرًى، )
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (مُرَيانِ، )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي' && conjugationResult.getFormulaNo() == 1;
    }
}
