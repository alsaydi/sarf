package sarf.gerund.modifier.trilateral.unaugmented.quality.geminator;

import java.util.*;

import sarf.noun.*;

import sarf.verb.trilateral.Substitution.*;
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
public class Geminator1 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    final List<Substitution> substitutions = new ArrayList<>();

    public Geminator1() {
        substitutions.add(new InfixSubstitution("ِوْوَ","ِيَّ"));// EX: (سِيَّة)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() =='و' && conjugationResult.getRoot().getC3() == 'و';
    }
}
